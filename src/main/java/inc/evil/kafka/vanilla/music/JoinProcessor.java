package inc.evil.kafka.vanilla.music;

import inc.evil.kafka.streams.avro.Album;
import inc.evil.kafka.streams.avro.MusicInterest;
import inc.evil.kafka.streams.avro.TrackPurchase;
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
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.kstream.ValueJoiner;

import java.util.Map;
import java.util.Properties;

public class JoinProcessor {
    public static class MusicInterestJoiner implements ValueJoiner<TrackPurchase, Album, MusicInterest> {
        @Override
        public MusicInterest apply(TrackPurchase trackPurchase, Album album) {
            return MusicInterest.newBuilder()
                    .setId(album.getId() + "-" + trackPurchase.getId())
                    .setGenre(album.getGenre())
                    .setArtist(album.getArtist())
                    .build();
        }
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
        Serde<Long> longSerde = getPrimitiveAvroSerde(true);
        Serde<Album> albumSerde = getSpecificAvroSerde();
        Serde<MusicInterest> musicInterestSerde = getSpecificAvroSerde();
        Serde<TrackPurchase> trackPurchaseSerde = getSpecificAvroSerde();
        KTable<Long, Album> albums = builder.table("albums", Consumed.with(longSerde, albumSerde));
        KTable<Long, TrackPurchase> trackPurchases = builder.table("track-purchases", Consumed.with(longSerde, trackPurchaseSerde));
        KTable<Long, MusicInterest> musicInterestKTable = trackPurchases.join(albums, TrackPurchase::getAlbumId, new MusicInterestJoiner());
        musicInterestKTable.toStream().to("music-interest", Produced.with(longSerde, musicInterestSerde));
        return builder.build();
    }

    private static <T extends SpecificRecord> SpecificAvroSerde<T> getSpecificAvroSerde() {
        final SpecificAvroSerde<T> specificAvroSerde = new SpecificAvroSerde<>();
        specificAvroSerde.configure(Map.of("schema.registry.url", "http://localhost:8081"), false);
        return specificAvroSerde;
    }

    @SuppressWarnings("unchecked")
    private static <T> Serde<T> getPrimitiveAvroSerde(boolean isKey) {
        KafkaAvroDeserializer deserializer = new KafkaAvroDeserializer();
        KafkaAvroSerializer serializer = new KafkaAvroSerializer();
        Map<String, String> config = Map.of("schema.registry.url", "http://localhost:8081");
        deserializer.configure(config, isKey);
        serializer.configure(config, isKey);
        return (Serde<T>) Serdes.serdeFrom(serializer, deserializer);
    }

    private static Properties makeProperties() {
        Properties properties = new Properties();
        properties.setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "word-count-app5");
        properties.setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        properties.setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        properties.setProperty("schema.registry.url", "http://localhost:8081");
        return properties;
    }
}
