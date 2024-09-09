package lesson13;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    private final Semaphore semaphore;
    private boolean tunnelIsFull = false;

    public Tunnel(Semaphore semaphore) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.semaphore = semaphore;
    }

    @Override
    public void go(Car c) {
        try {
            try {
                if (!tunnelIsFull) {
                    semaphore.acquire();
                    System.out.println(c.getName() + " начал этап: " + description);
                    tunnelIsFull = true;
                    Thread.sleep(length / c.getSpeed() * 1000L);
                    System.out.println(c.getName() + " закончил этап: " + description);
                    semaphore.release();
                } else {
                    System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
