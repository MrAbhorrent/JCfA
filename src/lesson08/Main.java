package lesson08;

public class Main {
    public static void main(String[] args) {
        Participant[] participants = createParticipats();
        Trap[] traps = createTraps();

        for (Participant participant: participants) {
            for (Trap trap: traps) {
                if (!trap.overcome(participant)) break;
            }

        }
    }

    private static Trap[] createTraps() {
        return new Trap[] {
                new Track(200),
                new Wall(6),
                new Track(300),
                new Track(1_300),
                new Wall(600),
                new Track(3_000)
        };
    }

    private static Participant[] createParticipats() {
        return new Participant[]{
                new Cat("Barsik", 400, 5),
                new Cat("Murzik", 250, 8),
                new Robot("T-800", 42_000, 50),
                new Robot("R2D2", 3_000, 25),
                new Human("Vasechkin", 1_500, 12),
                new Human("Skywalker", 4_500, 70)
        };
    }


}
