package ninja.starkweather.nodice.dice;

public class dice {
    private int sides;
    private int value;

    public dice(int sides) {
        this.sides = sides;
        this.value = 0;
    }

    public int roll() {
        this.value = (int) (Math.random() * this.sides) + 1;
        return this.value;
    }

    public int getValue() {
        return this.value;
    }

    public int getSides() {
        return this.sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }
}
