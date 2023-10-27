package ninja.starkweather.nodice.dice;

import org.springframework.data.repository.CrudRepository;

import ninja.starkweather.nodice.dice.dice;

import java.util.List;
import java.util.Optional;

public interface diceRepository extends CrudRepository<dice, Long>{
    List<dice> findByDice_id(Long dice_id);
    Optional<dice> findByDice_name(String dice_name);
}
