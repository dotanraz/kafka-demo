package tswd.kafkademo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer implements IKafkaProducer {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    String topic = "topic1";

//    public KafkaProducer (KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }

    public void sendMessage(String message) {
        this.kafkaTemplate.send(this.topic, message);
    }


}
