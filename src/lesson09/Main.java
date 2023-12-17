package lesson09;

import lesson09.MyArrayExceptions.MyArrayDataException;
import lesson09.MyArrayExceptions.MyArraySizeException;

public class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        // Тестовые архивы
        String[][] testArray1 = new String[][] {
                { "1", "2", "3"},
                { "4", "5", "6"}
        };
        String[][] testArray2 = new String[][] {
                { "1", "2", "3", "4"},
                { "4", "2", "6", "7"},
                { "8", "9", "3", "4"},
                { "1", "☼", "1", "1"},
        };
        String[][] testArray3 = new String[][] {
                { "1", "1", "1", "1"},
                { "1", "1", "1", "1"},
                { "1", "1", "1", "1"},
                { "1", "1", "1", "1"},
        };

//        int sum1 = sumOfArray(testArray1);
//        System.out.println("Сумма чисел массива 1 - " + sum1);

        int sum2 = sumOfArray(testArray2);
        System.out.println("Сумма чисел массива 2 - " + sum2);

        int sum3 = sumOfArray(testArray3);
        System.out.println("Сумма чисел массива 3 - " + sum3);

    }

    static private int sumOfArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int result = 0;
        if (array.length != 4) {
            throw new MyArraySizeException(String.format("Количество колонок %d", array.length));
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException(String.format("Количество строк %d", array.length));
            } else {
                for (int j = 0; j < array[i].length; j++) {
                    try {
                        result += Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException exception) {
                        throw new MyArrayDataException(String.format("Ячейка [%d, %d]", i, j));
                    }

                }
            }
            
        }

        return result;
    }
}
