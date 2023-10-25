package ninja.starkweather.nodice.dice;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface diceRepository extends CrudRepository<dice, Long>{
    List<dice> findBySides(int sides);
}
