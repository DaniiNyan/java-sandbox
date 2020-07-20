package com.daniinyan.kafkapoc;

import java.util.Arrays;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class ConsumerApp {

  public static void main(String[] args) {

    // set properties
    Properties props = new Properties();
    props.put("bootstrap.servers", "localhost:9092");
    props.put("group.id", "test");
    props.put("enable.auto.commit", "true");
    props.put("auto.commit.interval.ms", "1000");
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

    // create consumer
    KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

    // subscribe to topics topic1 and topic2
    consumer.subscribe(Arrays.asList("topic1", "topic2"));

    while (true) {
      ConsumerRecords<String, String> records = consumer.poll(100);

      //print all received messages
      for (ConsumerRecord<String, String> record : records)
        System.out.printf("value = %s%n", record.value());
    }
  }

}
