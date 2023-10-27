package ninja.starkweather.nodice.roll;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface rollRepository extends CrudRepository<roll, Long> {
    List<roll> findByRoll_id(Long roll_id);
    Optional<roll> findByRoll_name(String roll_name);
}
