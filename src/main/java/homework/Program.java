package homework;

import java.util.*;

public class Program {

    public static HashMap<String, ArrayList<String>> phoneBook;
    public static void main(String[] args) {

        phoneBook = new HashMap<>();

        String[] phonenumbers = {
                "Андреев Андрей:123-45-67",
                "Борисов Борис:123-45-68",
                "Васильев Василий:123-45-69",
                "Гаврилов Гавриил:123-45-70",
                "Данилов Даниил:123-45-71",
                "Егоров Егор:123-45-72",
                "Ефимов Ефим:123-45-73",
                "Иванов Иван:123-45-74",
                "Ильин Илья:123-45-75",
                "Кириллов Кирилл:123-45-76",
                "Королев Константин:123-45-77",
                "Кузьмин Кузьма:123-45-78",
                "Лебедев Лев:123-45-79",
                "Максимов Максим:123-45-80",
                "Гаврилов Гавриил:123-45-91",
                "Данилов Даниил:123-45-92",
                "Егоров Егор:123-45-93",
                "Ефимов Ефим:123-45-94",
                "Иванов Иван:123-45-95",
                "Ильин Илья:123-45-96",
                "Кириллов Кирилл:123-45-97",
                "Королев Константин:123-45-98",
                "Кузьмин Кузьма:123-45-99",
                "Лебедев Лев:123-45-74",
                "Максимов Максим:123-45-53",
                "Кузьмин Кузьма:214-45-99",
                "Лебедев Лев:215-45-74",
                "Максимов Максим:223-45-53"


                //...
        };

        bookForming(phonenumbers);
        bookShowSorting(phoneBook);

    }

    public static void bookForming(String[] sources){

        for (String record : sources){
            String[] recordParts = record.split(":");
            String abonent = recordParts[0];
            String phoneNumber = recordParts[1];
            if (phoneBook.containsKey(abonent)){
                phoneBook.get(abonent).add(phoneNumber);
            }
            else {
                ArrayList<String> list = new ArrayList<>();
                list.add(phoneNumber);
                phoneBook.put(abonent, list);
            }
        }
    }

    public static void bookShowSorting(HashMap<String, ArrayList<String>> phones){

        TreeMap<Integer, HashMap<String, ArrayList<String>>> sortedAbonents = new TreeMap<>(Collections.reverseOrder());

//        System.out.println(phones);

        for (String item : phones.keySet()) {
            Integer phonesCount = phones.get(item).size();
            HashMap<String, ArrayList<String>> tempMap = new HashMap<>();
            tempMap.put(item, phones.get(item));
            if (sortedAbonents.containsKey(phonesCount)) {
                sortedAbonents.get(phonesCount).put(item, phones.get(item));
            }
            else {
                sortedAbonents.put(phonesCount, tempMap);
            }
        }

//        System.out.println(sortedAbonents);

        for (Map.Entry<Integer, HashMap<String, ArrayList<String>>> element : sortedAbonents.entrySet()){
//            System.out.printf("%d место - средний балл %.2f\n", counter, element.getKey());
            for (Map.Entry<String, ArrayList<String>> item : element.getValue().entrySet()){
                System.out.printf("Абонент: %s%n", item.getKey());
                for(String list : item.getValue()){
                    System.out.printf("         %s%n", list);
                }
            }
        }
    }

}
