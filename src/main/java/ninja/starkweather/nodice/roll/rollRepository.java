package ninja.starkweather.nodice.roll;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface rollRepository extends CrudRepository<roll, Long> {
    List<roll> findByRollID(Long roll_id);
}
