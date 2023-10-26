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
    private Long id;

    @Column(nullable = false)
    private int times;

    @Column(nullable = false)
    private int sides;

    @Column(nullable = false)
    private int modifier;

    @Column(nullable = false)
    private int value;

    @Column(nullable = false)
    private int rolls;

}
