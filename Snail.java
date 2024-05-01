import java.util.Random;

public class Snail {
    private final String color;
    private int distance;
    private boolean boosted;
    private final Random random;

    public Snail(String color) {
        this.color = color;
        this.distance = 0;
        this.boosted = false;
        this.random = new Random();
    }

    public String getColor() {
        return color;
    }

    public int getDistance() {
        return distance;
    }

    public void move() {
        int steps = random.nextInt(4);
        if (boosted) {
            steps *= 2;
            boosted = false;
        }
        distance += steps;
    }

    public void boost() {
        boosted = true;
    }
}
