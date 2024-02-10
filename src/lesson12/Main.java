package lesson12;

public class Main {

    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        float[] array1 = initArray();
        singleThreadMethod(array1);
        float[] array2 = initArray();
        doubleThreadMethod(array2);
    }

    private static float[] initArray() {
        float[] arr = new float[SIZE];
        for (int i=0; i<SIZE; i++){
            arr[i]=1;
        }
        System.out.println("Исходный массив инициализирован...");
        return arr;
    }

    private static void transformArray(float[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + (float) i / 5) * Math.cos(0.2f + (float) i / 5) * Math.cos(0.4f + (float) i / 2));
        }
    }

    private static void singleThreadMethod(float[] array) {
        long beginTime = System.currentTimeMillis();
        transformArray(array);
        long endTime = System.currentTimeMillis();
        System.out.printf("Время работы (в один поток) = %s\n", (endTime - beginTime));
    }

    private static void doubleThreadMethod(float[] array2) {
        long beginTime = System.currentTimeMillis();
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];
        System.arraycopy(array2, 0, a1, 0, HALF);
        System.arraycopy(array2, HALF, a2, 0, HALF);
        Thread thread1 = new Thread(() -> transformArray(a1));
        Thread thread2 = new Thread(() -> transformArray(a2));
        thread1.start();
        thread2.start();
        try{
            thread1.join();
            thread2.join();
        }
        catch(InterruptedException e){
            System.out.println("Threads has been interrupted");
            System.out.println(e.getMessage());
            return;
        }
        System.arraycopy(a1, 0, array2, 0, HALF);
        System.arraycopy(a2, 0, array2, HALF, HALF);
        long endTime = System.currentTimeMillis();
        System.out.printf("Время работы (в два потока) = %s ms\n", (endTime - beginTime));
    }

}
