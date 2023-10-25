package ninja.starkweather.nodice.dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import ninja.starkweather.nodice.DiceNotFoundException;
import ninja.starkweather.nodice.DiceIdMismatchException;

@RestController
@RequestMapping("/api/dice")
public class diceController {
    @Autowired
    private diceRepository diceRepository;

    @GetMapping
    public Iterable<dice> getDice() {
        return diceRepository.findAll();
    }

    @GetMapping("/{id}")
    public dice getDiceById(@PathVariable Long id) {
        return diceRepository.findById(id)
        .orElseThrow(DiceNotFoundException::new);
    }


    @PutMapping("/{id}")
    public dice updateDice(@RequestBody dice dice, @PathVariable Long id) {
        if (dice.getId() != id) {
            throw new DiceIdMismatchException();
        }
        diceRepository.findById(id)
        .orElseThrow(DiceNotFoundException::new);
        return diceRepository.save(dice);
    }
}
