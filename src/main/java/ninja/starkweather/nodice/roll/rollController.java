package ninja.starkweather.nodice.roll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roll")
public class rollController {
    
    @Autowired
    private rollRepository rollRepository;

    @GetMapping
    public Iterable<roll> findAll() {
        return rollRepository.findAll();
    }

    @GetMapping("/{id}")
    public roll get(@PathVariable Long id) {
        return rollRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("roll not found with id: " + id));
    }

    @PutMapping("/{id}")
    public roll update(@RequestBody roll roll, @PathVariable Long id) {
        if (!roll.getId().equals(id)) {
            throw new RuntimeException("roll ID does not match!");
        }
        roll existingRoll = rollRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("roll not found with id: " + id));
        existingRoll.setRoll(roll.getRoll());
        return rollRepository.save(existingRoll);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        rollRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("roll not found with id: " + id));
        rollRepository.deleteById(id);
    }
}
