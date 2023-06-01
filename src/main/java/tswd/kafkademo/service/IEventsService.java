package tswd.kafkademo.service;

public interface IEventsService {
    void produceEventToKafka(String message);

}
