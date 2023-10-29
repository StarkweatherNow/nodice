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
    private Long rollId;
    
    @Column(nullable = false, unique = true)
    private String rollName;

    @Column(nullable = false)
    private int rollTimes;

    @Column(nullable = false)
    private int rollSides;

    @Column(nullable = false)
    private int rollModifier;

    @Column(nullable = false)
    private int rollValue;

    @Column(nullable = false)
    private int rollMultiplier;

    public Long getId() {
        return rollId;
    }

    public void setId(long rollId){
        this.rollId = rollId;
    }

    public int getTimes(){
        return rollTimes;
    }

    public void setTimes(int rollTimes){
        this.rollTimes = rollTimes;
    }

}
