package ninja.starkweather.nodice.roll;

import org.springframework.data.repository.CrudRepository;

import ninja.starkweather.nodice.roll.roll;

import java.util.List;
import java.util.Optional;

public interface rollRepository extends CrudRepository<roll, Long> {
    List<roll> findByRoll_name(String roll_name);
}
