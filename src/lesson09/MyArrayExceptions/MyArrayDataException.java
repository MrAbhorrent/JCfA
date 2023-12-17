package lesson09.MyArrayExceptions;

public class MyArrayDataException extends Exception {

    public MyArrayDataException(String message) {
        super("Ошибка преобразования строки в число.\n" + message);
    }
}
