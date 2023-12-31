package ninja.starkweather.nodice.dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ninja.starkweather.nodice.dice.dice;
import ninja.starkweather.nodice.dice.diceRepository;
import ninja.starkweather.nodice.dice.DiceIdMismatchException;
import ninja.starkweather.nodice.dice.DiceNotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dice")
public class diceController {
    
    @Autowired
    private diceRepository diceRepository;

    @GetMapping
    public Iterable<dice> findAll() {
        return diceRepository.findAll();
    }

    @GetMapping("/{id}")
    public dice findOne(@PathVariable long id) {
        return diceRepository.findById(id)
          .orElseThrow(DiceNotFoundException::new);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public dice create(@RequestBody dice dice) {
        return diceRepository.save(dice);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        diceRepository.findById(id)
          .orElseThrow(DiceNotFoundException::new);
        diceRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public dice updateDice(@RequestBody dice dice, @PathVariable Long id) {
        if (dice.getDiceId() != id) {
          throw new DiceIdMismatchException();
        }
        diceRepository.findById(id)
          .orElseThrow(DiceNotFoundException::new);
        return diceRepository.save(dice);
    }
    
}
