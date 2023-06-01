package tswd.kafkademo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tswd.kafkademo.kafka.IKafkaProducer;

@Service
public class EventsService implements IEventsService {

    @Autowired
    IKafkaProducer kafkaProducer;

    @KafkaListener(topics = "topic1")
    public void getEventsFromKafka(String in) {
        System.out.println("getEventsFromKafka: " + in);
    }

    public void produceEventToKafka(String message) {
        kafkaProducer.sendMessage(message);
    }

}
