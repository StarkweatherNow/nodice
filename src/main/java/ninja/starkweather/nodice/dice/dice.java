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

    @Column(nullable = false, unique = true)
    private String dice_name;

    @Column(nullable = false)
    private int dice_sides;

    @Column(nullable = false)
    private int dice_value;

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

    public void setId(Long dice_id){
        this.dice_id = dice_id;
    }

    public int getSides() {
        return dice_sides;
    }

    public void setSides(int dice_sides) {
        this.dice_sides = dice_sides;
    }

    public int getValue() {
        return dice_value;
    }

    public void setValue(int dice_value) {
        this.dice_value = dice_value;
    }

    public String getName() {
        return dice_name;
    }

    public void setName(String dice_name) {
        this.dice_name = dice_name;
    }

    public String getBorder() {
        return dice_border;
    }

    public void setBorder(String dice_border) {
        this.dice_border = dice_border;
    }

    public String getFont() {
        return dice_font;
    }

    public void setFont(String dice_font) {
        this.dice_font = dice_font;
    }

    public String getTexture() {
        return dice_texture;
    }

    public void setTexture(String dice_texture) {
        this.dice_texture = dice_texture;
    }

    public int getBorderColor() {
        return dice_borderColor;
    }

    public void setBorderColor(int dice_borderColor) {
        this.dice_borderColor = dice_borderColor;
    }

    public int getFontColor() {
        return dice_fontColor;
    }

    public void setFontColor(int dice_fontColor) {
        this.dice_fontColor = dice_fontColor;
    }

    public int getBackgroundColor() {
        return dice_backgroundColor;
    }

    public void setBackgroundColor(int dice_backgroundColor) {
        this.dice_backgroundColor = dice_backgroundColor;
    }

}
