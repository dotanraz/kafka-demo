package tswd.kafkademo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tswd.kafkademo.model.Server;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServerRepository extends CrudRepository<Server, Integer> {

    @Query(value = "SELECT * FROM Server", nativeQuery = true)
    Optional<List<Server>> getAllServers();
}
