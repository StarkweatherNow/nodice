package ninja.starkweather.nodice.roll;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface rollRepository extends CrudRepository<roll, Long> {
    List<roll> findByRollId(Long rollId);
    Optional<roll> findByRollName(String rollName);
}
