package lesson12;

import java.util.Arrays;

public class Main {

    static final int SIZE = 10_000_000;
    static final int HALF_SIZE = SIZE / 2;

    public static void main(String[] args) {
        float[] array1 = initArray();
        System.out.println("Исходный массив инициализирован...");
        singleThreadMethod(array1);
        float[] array2 = initArray();
        System.out.println("Исходный массив инициализирован...");
        doubleThreadMethod(array2);
        System.out.println("Arrays are equals = " + Arrays.equals(array1, array2));
    }

    private static float[] initArray() {
        float[] result = new float[SIZE];
        Arrays.fill(result, 1.0f);
        return result;
    }

    private static float calculate(float value, int index) {
        return (float)(value * Math.sin(0.2f + (float) index / 5) * Math.cos(0.2f + (float) index / 5) * Math.cos(0.4f + (float) index / 2));
    }

    private static void transformArray(float[] array, int offset) {
        for (int i = 0; i < array.length; i++) {
            array[i] = calculate(array[i], i + offset);
        }
    }

    private static void singleThreadMethod(float[] array) {
        long beginTime = System.currentTimeMillis();
        transformArray(array, 0);
        long endTime = System.currentTimeMillis();
        System.out.printf("Время работы (в один поток) = %s\n", (endTime - beginTime));
    }

    private static void doubleThreadMethod(float[] array2) {
        long beginTime = System.currentTimeMillis();
        float[] a1 = new float[HALF_SIZE];
        float[] a2 = new float[HALF_SIZE];
        System.arraycopy(array2, 0, a1, 0, HALF_SIZE);
        System.arraycopy(array2, HALF_SIZE, a2, 0, HALF_SIZE);
        Thread thread1 = new Thread(() -> transformArray(a1, 0));
        Thread thread2 = new Thread(() -> transformArray(a2, HALF_SIZE));
        thread1.start();
        thread2.start();
        try{
            thread1.join();
            thread2.join();
        } catch(InterruptedException e){
            System.out.println("Threads has been interrupted");
            e.printStackTrace();
            return;
        }
        System.arraycopy(a1, 0, array2, 0, HALF_SIZE);
        System.arraycopy(a2, 0, array2, HALF_SIZE, HALF_SIZE);
        long endTime = System.currentTimeMillis();
        System.out.printf("Время работы (в два потока) = %s ms\n", (endTime - beginTime));
    }

}
