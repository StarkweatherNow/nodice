package ninja.starkweather.nodice.dice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class dice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long diceId;

    @Column(nullable = false, unique = true)
    private String diceName;

    @Column(nullable = false)
    private int diceSides;

    @Column(nullable = false)
    private int diceValue;

    @Column(nullable = false)
    private String diceBorder;

    @Column(nullable = false)
    private String diceFont;    

    @Column(nullable = false)
    private String diceTexture;

    @Column(nullable = false)
    private int diceBorderColor;

    @Column(nullable = false)
    private int diceFontColor; 

    @Column(nullable = false)
    private int diceBackgroundColor;

    public Long getDiceId() {
        return diceId;
    }

    public void setDiceId(int i){
        this.diceId = i;
    }

    public int getSides() {
        return diceSides;
    }

    public void setSides(int diceSides) {
        this.diceSides = diceSides;
    }

    public int getValue() {
        return diceValue;
    }

    public void setValue(int diceValue) {
        this.diceValue = diceValue;
    }

    public String getName() {
        return diceName;
    }

    public void setName(String diceName) {
        this.diceName = diceName;
    }

    public String getBorder() {
        return diceBorder;
    }

    public void setBorder(String diceBorder) {
        this.diceBorder = diceBorder;
    }

    public String getFont() {
        return diceFont;
    }

    public void setFont(String diceFont) {
        this.diceFont = diceFont;
    }

    public String getTexture() {
        return diceTexture;
    }

    public void setTexture(String diceTexture) {
        this.diceTexture = diceTexture;
    }

    public int getBorderColor() {
        return diceBorderColor;
    }

    public void setBorderColor(int diceBorderColor) {
        this.diceBorderColor = diceBorderColor;
    }

    public int getFontColor() {
        return diceFontColor;
    }

    public void setFontColor(int diceFontColor) {
        this.diceFontColor = diceFontColor;
    }

    public int getBackgroundColor() {
        return diceBackgroundColor;
    }

    public void setBackgroundColor(int diceBackgroundColor) {
        this.diceBackgroundColor = diceBackgroundColor;
    }

}
