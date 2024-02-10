package lesson10;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {

    private final HashMap<String, ArrayList<String>> items;

    public PhoneBook() {
        this.items = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
        // Новый контакт создается в том случае если номер который введен не существует
        if (items.get(surname) != null) {
            if (!items.get(surname).contains(phoneNumber)) {
                items.get(surname).add(phoneNumber);
            }
        } else {
            ArrayList<String> arr = new ArrayList<>();
            arr.add(phoneNumber);
            items.put(surname, arr);
        }
    }

    public void get(String surname) {
        if (items.get(surname) != null) {
            String format = "|%1$-20.18s| контактный телефон(ы): ";
            System.out.format(format, surname);
            System.out.println(items.get(surname));
        } else {
            System.out.println("--->  Такого  пользователя нет в справочнике");
        }

    }

}
