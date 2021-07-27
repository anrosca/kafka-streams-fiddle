package inc.evil.kafka.vanilla.cpt;

import inc.evil.kafka.streams.avro.cpt.EnrichedInvestmentRecord;
import inc.evil.kafka.streams.avro.cpt.Investment;
import inc.evil.kafka.streams.avro.cpt.InvestmentRecord;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.avro.specific.SpecificRecord;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.*;

import java.util.Map;
import java.util.Properties;

public class CptProcessor {
    interface TopicNames {
        String INVESTMENTS = "investments";
        String INVESTMENT_RECORDS = "investment_records";
        String ENRICHED_INVESTMENTS = "enriched-investments";
    }

    public static void main(String[] args) {
        Properties properties = makeProperties();
        StreamsBuilder builder = new StreamsBuilder();
        Topology topology = buildTopology(builder);
        KafkaStreams kafkaStreams = new KafkaStreams(topology, properties);
        Runtime.getRuntime().addShutdownHook(new Thread(kafkaStreams::close));
        kafkaStreams.start();
    }

    private static Topology buildTopology(StreamsBuilder builder) {
        Serde<Investment> investmentSerde = getSpecificAvroSerde();
        Serde<InvestmentRecord> investmentRecordSerde = getSpecificAvroSerde();
        Serde<EnrichedInvestmentRecord> enrichedInvestmentRecordSerde = getSpecificAvroSerde();

        KTable<Long, Investment> investments = builder.stream(TopicNames.INVESTMENTS, Consumed.with(Serdes.Long(), investmentSerde))
                .selectKey((key, investment) -> investment.getId())
                .toTable(Materialized.with(Serdes.Long(), investmentSerde));
        KTable<Long, InvestmentRecord> investmentRecords = builder.stream(TopicNames.INVESTMENT_RECORDS, Consumed.with(Serdes.Long(), investmentRecordSerde))
                .selectKey((key, record) -> record.getId())
                .toTable(Materialized.with(Serdes.Long(), investmentRecordSerde));

        investmentRecords.join(investments, InvestmentRecord::getInvestmentId, new InvestmentJoiner())
                .toStream()
                .selectKey((key, value) -> value.getId())
                .to(TopicNames.ENRICHED_INVESTMENTS, Produced.with(Serdes.Long(), enrichedInvestmentRecordSerde));
        return builder.build();
    }

    public static class InvestmentJoiner implements ValueJoiner<InvestmentRecord, Investment, EnrichedInvestmentRecord> {

        @Override
        public EnrichedInvestmentRecord apply(InvestmentRecord investmentRecord, Investment investment) {
            return EnrichedInvestmentRecord.newBuilder()
                    .setId(investmentRecord.getId())
                    .setInvestmentDate(investmentRecord.getInvestmentDate())
                    .setAmountBought(investmentRecord.getAmountBought())
                    .setSymbol(investmentRecord.getSymbol())
                    .setUnitPrice(investmentRecord.getUnitPrice())
                    .setSpent(investmentRecord.getSpent())
                    .setInvestmentName(investment.getName())
                    .build();
        }
    }

    private static <T extends SpecificRecord> SpecificAvroSerde<T> getSpecificAvroSerde() {
        final SpecificAvroSerde<T> specificAvroSerde = new SpecificAvroSerde<>();
        specificAvroSerde.configure(Map.of("schema.registry.url", "http://localhost:8081"), false);
        return specificAvroSerde;
    }

    private static Properties makeProperties() {
        Properties properties = new Properties();
        properties.setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "cpt-app");
        properties.setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        properties.setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        properties.setProperty("schema.registry.url", "http://localhost:8081");
        return properties;
    }
}
