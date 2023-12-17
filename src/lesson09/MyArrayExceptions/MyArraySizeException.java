package lesson09.MyArrayExceptions;

public class MyArraySizeException extends Exception {

    public MyArraySizeException(String message) {
        super("Размер массива не соответствует требуемому (4х4).\n" + message);
    }
}
