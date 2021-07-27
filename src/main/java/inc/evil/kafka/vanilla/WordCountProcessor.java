package inc.evil.kafka.vanilla;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Produced;

import java.util.Arrays;
import java.util.Properties;

public class WordCountProcessor {
    public static void main(String[] args) {
        Properties properties = makeProperties();
        StreamsBuilder builder = new StreamsBuilder();
        KTable<String, Long> wordCounts = builder.stream("words-input", Consumed.with(Serdes.String(), Serdes.String()))
                .flatMapValues(line -> Arrays.asList(line.split("\\W+")))
                .groupBy((key, value) -> value)
                .count();
        wordCounts.toStream()
                .to("word-counts", Produced.with(Serdes.String(), Serdes.Long()));
        KafkaStreams kafkaStreams = new KafkaStreams(builder.build(), properties);
        Runtime.getRuntime().addShutdownHook(new Thread(kafkaStreams::close));
        kafkaStreams.start();
    }

    private static Properties makeProperties() {
        Properties properties = new Properties();
        properties.setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "word-count-app1");
        properties.setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        properties.setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return properties;
    }
}
