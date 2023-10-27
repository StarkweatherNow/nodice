package ninja.starkweather.nodice.roll;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class roll {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roll_id;

    @Column(nullable = false)
    private int roll_times;

    @Column(nullable = false)
    private int roll_sides;

    @Column(nullable = false)
    private int roll_modifier;

    @Column(nullable = false)
    private int roll_value;

    @Column(nullable = false)
    private int roll_multiplier;

    public Long getId() {
        return roll_id;
    }

    public void setId(long id){
        this.roll_id = id;
    }

    public int getTimes(){
        return roll_times;
    }

    public void setTimes(int roll_times){
        this.roll_times = roll_times;
    }

}
