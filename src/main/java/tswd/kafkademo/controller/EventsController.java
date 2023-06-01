package tswd.kafkademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tswd.kafkademo.model.Server;
import tswd.kafkademo.repository.ServerRepository;
import tswd.kafkademo.service.IEventsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class EventsController {

    @Autowired
    IEventsService eventsService;

    @Autowired
    ServerRepository serverRepository;

    @PostMapping(path = "/event")
    public void produceEvent(@RequestParam String message) {
        System.out.println("produceEvent: " + message);
        eventsService.produceEventToKafka(message);
        Server server = new Server("192.168.1.43", "linux", "ubuntu");
        serverRepository.save(server);

        Optional<List<Server>> allServers = serverRepository.getAllServers();
        List<Server> servers = allServers.get();
        servers.forEach(server1 -> {
            System.out.println(server1.toString());
        });
    }

}
