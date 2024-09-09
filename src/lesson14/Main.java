package lesson14;

import java.util.*;

public class Main {
    private static final String TITLE_STRING_1 = "Выбираем из входного массива новый массив, идущий после последней 4";
    private static final String TITLE_STRING_2 = "Проверяем входит ли в состав массива ";
    private static final int searchNumber = 4; // число позицию которого ищем в массиве.
    private static final int[] arrayTest = {1, 2, 4, 4, 2, 3, 4, 1, 7};

    private static final int[] arrayCheck1 = {1, 1, 1, 4, 4, 1, 4, 4};
    private static final int[] arrayCheck2 = {1, 1, 1, 1, 1, 1};
    private static final int[] arrayCheck3 = {4, 4, 4, 4};
    private static final int[] arrayCheck4 = {1, 4, 4, 1, 1, 4, 3};


    public static void main(String[] args) {
        System.out.println(TITLE_STRING_1);
        System.out.println("Входной массив");
        System.out.println(Arrays.toString(arrayTest));
        System.out.printf("Позиция последнего числа \"%d\" в архиве: %d\n", searchNumber, findPositionNumber(arrayTest, searchNumber));
        System.out.println("Выходной массив");
        System.out.println(Arrays.toString(extractNewArray(arrayTest, findPositionNumber(arrayTest, searchNumber))));
        System.out.println("=======================================================");
        System.out.println(Arrays.toString(arrayCheck1) + " -> " + checkArray(arrayCheck1));
        System.out.println(Arrays.toString(arrayCheck2) + " -> " + checkArray(arrayCheck2));
        System.out.println(Arrays.toString(arrayCheck3) + " -> " + checkArray(arrayCheck3));
        System.out.println(Arrays.toString(arrayCheck4) + " -> " + checkArray(arrayCheck4));
    }

    public static int[] extractNewArray(int[] array, int digitPosition) {

        return Arrays.copyOfRange(array, digitPosition + 1, array.length);
    }

    private static int findPositionNumber(int[] array, int searchNumber) {

        int result = -1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == searchNumber ) {
                result = i;
                break;
            }
        }
        if (result == -1) {
            throw new RuntimeException(String.format("Число %d во входящем массиве не найдено", searchNumber));
        }
        return result;
    }

    private static boolean checkArray(int[] array) {
        int count = 0;
        HashMap<Integer, Integer> localMap = new HashMap<>();
        for (int j : array) {
            if (j == 1 || j == 4) {
                localMap.put(j, count++);
            }
        }
        return localMap.size() == 2;
    }

}
