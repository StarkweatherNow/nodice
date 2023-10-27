package ninja.starkweather.nodice.roll;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface rollRepository extends CrudRepository<roll, Long> {
    List<roll> findByRoll_id(Long roll_id);
}
