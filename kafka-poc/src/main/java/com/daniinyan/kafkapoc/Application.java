package com.daniinyan.kafkapoc;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Application {

  public static void main(String[] args) {

    // set properties
    Properties properties = new Properties();
    properties.put("bootstrap.servers", "localhost:9092");
    properties.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
    properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

    // create producer
    Producer<Integer, String> producer = new KafkaProducer<Integer, String>(properties);

    // send messages
    for (int i = 0; i < 10; i++) {
      ProducerRecord producerRecord = new ProducerRecord<Integer, String>("test-topic", i, "Test " + i);
      producer.send(producerRecord);
    }

    // close producer
    producer.close();
  }

}
