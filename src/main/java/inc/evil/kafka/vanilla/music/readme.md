# Kafka streams join demo

### Listen to music interests

```bash
$ /mnt/c/Tools/confluent-6.0.1/bin/kafka-avro-console-consumer --bootstrap-server localhost:9092 --topic music-interest --from-beginning | jq
```

### Produce albums

```bash
$ /mnt/c/Tools/confluent-6.0.1/bin/kafka-avro-console-producer --bootstrap-server localhost:9092 --topic albums --property parse.key=true \
  --property key.schema='{"type":"long"}' --property key.separator=: --property value.schema="$(< album.avsc)"
```
and then type

```text
5:{"id": 5, "title": "Physical Graffiti", "artist": "Led Zeppelin", "genre": "Rock"}
6:{"id": 6, "title": "Highway to Hell",   "artist": "AC/DC", "genre": "Rock"}
7:{"id": 7, "title": "Radio", "artist": "LL Cool J",  "genre": "Hip hop"}
8:{"id": 8, "title": "King of Rock", "artist": "Run-D.M.C", "genre": "Rap rock"}
```

### Produce track purchases

```bash
$ /mnt/c/Tools/confluent-6.0.1/bin/kafka-avro-console-producer --bootstrap-server localhost:9092 --topic track-purchases --property parse.key=true \
  --property key.schema='{"type":"long"}' --property key.separator=: --property value.schema="$(< track-purchase.avsc)"
```

and then type

```text
100:{"id": 100, "album_id": 5, "song_title": "Houses Of The Holy", "price": 0.99}
101:{"id": 101, "album_id": 8, "song_title": "King Of Rock", "price": 0.99}
102:{"id": 102, "album_id": 6, "song_title": "Shot Down In Flames", "price": 0.99}
103:{"id": 103, "album_id": 7, "song_title": "Rock The Bells", "price": 0.99}
104:{"id": 104, "album_id": 8, "song_title": "Can You Rock It Like This", "price": 0.99}
105:{"id": 105, "album_id": 6, "song_title": "Highway To Hell", "price": 0.99}
106:{"id": 106, "album_id": 5, "song_title": "Kashmir", "price": 0.99}
```