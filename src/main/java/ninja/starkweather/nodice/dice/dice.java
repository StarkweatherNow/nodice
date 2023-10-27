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
    private Long dice_id;

    @Column(nullable = false)
    private int dice_sides;

    @Column(nullable = false)
    private int dice_value;

    @Column(nullable = false)
    private String dice_name;

    @Column(nullable = false)
    private String dice_border;

    @Column(nullable = false)
    private String dice_font;    

    @Column(nullable = false)
    private String dice_texture;

    @Column(nullable = false)
    private int dice_borderColor;

    @Column(nullable = false)
    private int dice_fontColor; 

    @Column(nullable = false)
    private int dice_backgroundColor;

    public Long getId() {
        return dice_id;
    }

    public void setId(Long id){
        this.dice_id = id;
    }

    public int getSides() {
        return dice_sides;
    }

    public void setSides(int sides) {
        this.dice_sides = sides;
    }

    public int getValue() {
        return dice_value;
    }

    public void setValue(int value) {
        this.dice_value = value;
    }

    public String getName() {
        return dice_name;
    }

    public void setName(String name) {
        this.dice_name = name;
    }

    public String getBorder() {
        return dice_border;
    }

    public void setBorder(String border) {
        this.dice_border = border;
    }

    public String getFont() {
        return dice_font;
    }

    public void setFont(String font) {
        this.dice_font = font;
    }

    public String getTexture() {
        return dice_texture;
    }

    public void setTexture(String texture) {
        this.dice_texture = texture;
    }

    public int getBorderColor() {
        return dice_borderColor;
    }

    public void setBorderColor(int borderColor) {
        this.dice_borderColor = borderColor;
    }

    public int getFontColor() {
        return dice_fontColor;
    }

    public void setFontColor(int fontColor) {
        this.dice_fontColor = fontColor;
    }

    public int getBackgroundColor() {
        return dice_backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.dice_backgroundColor = backgroundColor;
    }

}
