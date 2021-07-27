package inc.evil.kafka.vanilla;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;

import java.util.Properties;

public class StreamTableDualityDemoProcessor {

    public static void main(String[] args) {
        Properties properties = makeProperties();
        StreamsBuilder builder = new StreamsBuilder();
        Topology topology = buildTopology(builder);
        KafkaStreams kafkaStreams = new KafkaStreams(topology, properties);
        Runtime.getRuntime().addShutdownHook(new Thread(kafkaStreams::close));
        kafkaStreams.start();
    }

    private static Topology buildTopology(StreamsBuilder builder) {
//        builder.stream("input-stream", Consumed.with(Serdes.String(), Serdes.String()))
//                .to("output-stream", Produced.with(Serdes.String(), Serdes.String()));
        builder.table("input-stream", Consumed.with(Serdes.String(), Serdes.String()))
                .filter((key, value) -> {
                    System.out.println("!!!!!!!!!!!!!!!!: " + key + " ---------->>  " + value);
                    return true;
                });
        return builder.build();
    }

    private static Properties makeProperties() {
        Properties properties = new Properties();
        properties.setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "duality-app4");
        properties.setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        properties.setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        properties.setProperty("schema.registry.url", "http://localhost:8081");
        return properties;
    }
}
