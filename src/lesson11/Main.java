package lesson11;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private final static Integer[] testArr1 = {1, 2, 3, 4};
    private final static String[] testArr2 = {"Первый", "Второй", "Третий", "Четвертый"};
    public static void main(String[] args) {
        // task 1
        task1();
        System.out.println("================================================================");
        // task 2
        task2();
    }

    private static void task1() {

        System.out.print("Исходное состояние массива :");
        System.out.println(Arrays.toString(testArr1));
        int firstIndex = 1; int secondIndex = 3;
        swapTwoElementsArray(testArr1, firstIndex, secondIndex);
        System.out.printf("Результат работы метода перестановки %d и %d элементов:\n", firstIndex, secondIndex);
        System.out.println(Arrays.toString(testArr1));
        System.out.println("--------------------------------------------------------------");
        System.out.print("Исходное состояние массива :");
        System.out.println(Arrays.toString(testArr2));
        firstIndex = 0; secondIndex = 2;
        swapTwoElementsArray(testArr2, firstIndex, secondIndex);
        System.out.printf("Результат работы метода перестановки %d и %d элементов:\n", firstIndex, secondIndex);
        System.out.println(Arrays.toString(testArr2));
    }

    /**
     *
     * @param modifiableArray - архив в котором необходимо поменять элементы местами
     * @param firstIndex - индекс первого элемента
     * @param secondIndex - индекс второго элемента
     * @param <T> - тип элемента массива
     */
    private static <T> void swapTwoElementsArray(T[] modifiableArray, int firstIndex, int secondIndex) {
        T backupElement = modifiableArray[firstIndex];
        modifiableArray[firstIndex] = modifiableArray[secondIndex];
        modifiableArray[secondIndex] = backupElement;
    }

    private static void task2(){
        ArrayList<Integer> listArr1 = arrayToList(testArr1);
        System.out.print("Результат работы метода конвертации массива в ArrayList:");
        System.out.println(listArr1);
        ArrayList<String> listArr2 = arrayToList(testArr2);
        System.out.print("Результат работы метода конвертации массива в ArrayList:");
        System.out.println(listArr2);
        System.out.println();
    }

    private static <T> ArrayList<T> arrayToList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}
