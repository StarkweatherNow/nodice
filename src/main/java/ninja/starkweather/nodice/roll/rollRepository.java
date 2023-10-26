package ninja.starkweather.nodice.roll;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface rollRepository extends CrudRepository<roll, Long> {
    List<roll> findByRolls(int rolls);
}
