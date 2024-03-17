package lesson10;

import java.util.*;

public class Main {

    private static String incomingString = "Pascal Регулярные выражения — тема, котёрую  поздно  котёрую, даже ^" +
            " однако тема выражения потом. Однако Java Pascal с  обработкой текстовой информации. Информации потом котЁрую";

    public static void main(String[] args) {

        System.out.println("Задача 1.");
        System.out.println("Входная срока: \n" + incomingString);

        String[] stringArrayList = stringLowerToArray(incomingString);
        printFrequencyWords(stringArrayList);

        System.out.println("=============================================================================");
        System.out.println("Задача 2. Телефонный справочник");

        PhoneBook phoneBook = new PhoneBook();
        // заполняем справочник данными
        phoneBook.add("Петров", "+7 (911) 322-22-23");
        phoneBook.add("Иванов", "+7 (911) 444-44-44");
        phoneBook.add("Петров", "+7 (911) 322-22-23");
        phoneBook.add("Сидоров", "+7 (911) 555-55-55");
        phoneBook.add("Андреев", "+7 (911) 666-69-69");
        phoneBook.add("Петров", "+7 (911) 772-27-72");
        phoneBook.add("Иванов", "+7 (911) 802-08-02");
        phoneBook.add("Петров", "+7 (911) 999-09-90");
        // запрашиваем результаты
        phoneBook.get("Петров");
        phoneBook.get("Змеинский");
        phoneBook.get("Иванов");
        phoneBook.get("Сидоров");
        phoneBook.get("Андреев");

    }

    private static String[] stringLowerToArray(String string) {
        String analyzedData = incomingString
                .replaceAll("[^A-Za-zА-ЯЁа-яё0-9 ]", " ")
                .toLowerCase()
                .replaceAll("[\\s]{2,}", " ");
        return analyzedData.split(" ");
    }

    // Вывод уникальных слов и сколько раз эти слова встречаются в тексте
    private static void printFrequencyWords(String[] array) {

        List<String> asList = Arrays.asList(array);
        Set<String> mySet = new HashSet<>(asList);
        for(String s: mySet){
            System.out.println(s + " " + Collections.frequency(asList,s));
        }
    }
}
