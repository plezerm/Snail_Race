import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Race {
    private final List<Snail> snails;
    private final Random random;
    private String winner;

    public Race() {
        this.snails = new ArrayList<>();
        this.snails.add(new Snail("piros"));
        this.snails.add(new Snail("zöld"));
        this.snails.add(new Snail("kék"));
        this.random = new Random();
        this.winner = null;
    }

    public void runRace() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Válaszd ki, hogy melyik csigára fogadsz!");
        System.out.println("1 - piros, 2 - zöld, 3 - kék: ");
        int bet = scanner.nextInt();

        while (bet < 1 || bet > 3) {
            System.out.println("Érvénytelen választás! Válassz újra!");
            bet = scanner.nextInt();
        }

        String betColor;
        switch (bet) {
            case 1:
                betColor = "piros";
                break;
            case 2:
                betColor = "zöld";
                break;
            case 3:
                betColor = "kék";
                break;
            default:
                betColor = "";
        }

        System.out.println("A fogadásod: " + betColor);

        for (int round = 1; round <= 5; round++) {
            runRound(round);
            System.out.println("---------- Kör vége ----------");
        }

        System.out.println("A nyertes: " + winner);
    }

    private void runRound(int round) {
        // Csigagyorsító kiosztása
        if (random.nextInt(100) < 20) {
            int snailIndex = random.nextInt(3);
            snails.get(snailIndex).boost();
        }

        // Csiga mozgatása és távolság kiírása
        System.out.println("---------- Kör " + round + " ----------");
        for (Snail snail : snails) {
            snail.move();
            System.out.println(snail.getColor() + " csiga távolsága: " + snail.getDistance());
        }

        // Nyertes meghatározása
        determineWinner();
    }

    private void determineWinner() {
        int maxDistance = Integer.MIN_VALUE;
        for (Snail snail : snails) {
            if (snail.getDistance() > maxDistance) {
                maxDistance = snail.getDistance();
                winner = snail.getColor();
            }
        }
    }
}
