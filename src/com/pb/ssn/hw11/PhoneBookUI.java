package com.pb.ssn.hw11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PhoneBookUI {
    private static final PhoneBook pb = new PhoneBook();
    private static String path_to_pb;

    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("src/com/pb/ssn/hw11/PhoneBook.properties");
            Properties prop = new Properties();
            try {
                prop.load(reader);
            } catch (FileNotFoundException fnf_ex) {
                System.out.println("Файл настроек (PhoneBook.properties) не найден");
            } catch (IOException e) {
                e.printStackTrace();
            }

            path_to_pb = prop.getProperty("path_to_phone_book");

            File f = new File(path_to_pb);
            if (f.exists()) {
                openPhoneBook(path_to_pb);
            } else {
                System.out.println("Файл '" + path_to_pb + "' не найден");
                createPhoneBook();
            }
            screenPhoneBook(pb.getPersons());
            mainMenu();

            // автосохранение на диск при завершении работы
            savePhoneBook(path_to_pb);
        } catch (FileNotFoundException fnf_ex) {
            System.out.println("Файл настроек (PhoneBook.properties) не найден");
        }
    }

    private static void mainMenu() {
        Scanner scan = new Scanner(System.in);

        boolean flg_next_step = true;
        do {
            System.out.println("ОСНОВНОЕ МЕНЮ");
            System.out.println("=======================================================");
            System.out.println("1 - Добавить карточку");
            System.out.println("2 - Удалить карточку");
            System.out.println("3 - Найти карточку");
            System.out.println("4 - Вывод всех карточек с сортировкой");
            System.out.println("5 - Редактировать карточку");
            System.out.println("6 - Сохранить на диск текущую телефонную книгу");
            System.out.println("-------------------------------------------------------");
            System.out.println("0 - Закрыть телефоную книгу");
            System.out.println("-------------------------------------------------------");
            System.out.print("ваш выбор --==>> ");
            int answer = scan.nextInt();

            switch (answer) {
                case 0:
                    flg_next_step = false;
                    break;
                case 1:
                    addNewPerson();
                    break;
                case 2:
                    screenPhoneBook(pb.getPersons());
                    deletePerson();
                    break;
                case 3:
                    findPersonMenu();
                    break;
                case 4:
                    sortedListPersonsMenu();
                    break;
                case 5:
                    editPersonMenu();
                    break;
                case 6:
                    savePhoneBook(path_to_pb);
                    break;
                default:
                    System.out.println("Такого пункта в меню нет. Попробуйте еще");
            }
        } while (flg_next_step);
    }

    private static void openPhoneBook(String path_to_file_pb) {
        try {
            pb.loadBook(path_to_file_pb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void savePhoneBook (String path_to_file_pb) {
        try {
            pb.saveBook(path_to_file_pb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createPhoneBook() {
        Scanner scan = new Scanner(System.in);
        char answer = ' ';

        System.out.println("Ваша телефонная книга сейчас пустая");
        
        while (answer != 'Y' && answer != 'y' && answer != 'N' && answer != 'n') {
            System.out.print("Хотите завести первую запись? (Y/N) : ");
            answer = scan.next().charAt(0);
        }

        if (answer == 'Y' || answer == 'y') {
            addNewPerson();
        }
    }

    private static void screenPhoneBook(ArrayList<Person> person) {
        System.out.println();
        if (person.isEmpty()) {
            System.out.println();
            System.out.println("--== ДАННЫХ НЕ НАЙДЕННО ==--");
            System.out.println();
        } else {
            for (int i = 0; i <= person.size() - 1; i++) {
                System.out.println(i + ": " + person.get(i).toString());
            }
        }
        System.out.println();
    }

    private static void screenPerson(Person person) {
        System.out.println("1).        Ф.И.О. : " + person.getFio());
        System.out.println("2). День рождения : " + person.getBirthDay().toString());
        System.out.println("3).        Адресс : " + person.getAddress());
        System.out.println("4).      Телефоны : " + person.getPhones().toString());
        System.out.println("-------------------");
        System.out.println("Последнее редактирование : " + person.getLastEdit().toString());
    }

    private static void screenPhones(ArrayList<String> phones) {
        for (int i=0; i<=phones.size()-1; i++) {
            System.out.println(i + "). " + phones.get(i));
        }
    }

    private static void addNewPerson() {
        Scanner scan = new Scanner(System.in);
        Person person = new Person();

        System.out.print("--==>> Введите Ф.И.О. : ");
        person.setFio(scan.nextLine());

        System.out.print("--==>> Введите дату рождения (dd.MM.yyyy) : ");
        person.setBirthDay(LocalDate.parse(scan.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy")));

        System.out.print("--==>> Введите адресс : ");
        person.setAddress(scan.nextLine());

        System.out.println("--==>> Введите телефон / телефоны <<==-- ");
        boolean flg_next_step = true;
        do {
            System.out.print("----====>>>> введите номер (для выхода введите 0): ");
            String tmp = scan.nextLine();

            if (tmp.equals("0")) {
                flg_next_step = false;
            } else {
                person.getPhones().add(tmp);
            }
        } while (flg_next_step);

        person.setLastEdit(LocalDateTime.now());

        pb.addPerson(person);
    }

    private static void deletePerson() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите номер карточки для удаления: ");
        int answer = scan.nextInt();

        pb.delRecord(answer);
    }

    private static void findPersonMenu() {
        Scanner scan = new Scanner(System.in);

        boolean flg_next_step = true;
        do {
            System.out.println();
            System.out.println("Укажите поле по которому необходимо провести поиск");
            System.out.println("==================================================");
            System.out.println("1 - Ф.И.О.");
            System.out.println("2 - Дата рождения");
            System.out.println("------------------");
            System.out.println("0 - Возврат в меню");
            System.out.println("------------------");
            System.out.print("--==>> ");
            int answer = scan.nextInt();

            switch (answer) {
                case 0:
                    flg_next_step = false;
                    break;
                case 1:
                    screenPhoneBook(findPersonFIO());

                    System.out.print("Для возврата в основное меню нажмите клавишу 0 : ");
                    scan.next();

                    flg_next_step = false;
                    break;
                case 2:
                    screenPhoneBook(findPersonBirthDay());

                    System.out.print("Для возврата в основное меню нажмите клавишу 0 : ");
                    scan.next();

                    flg_next_step = false;
                    break;
                default:
                    System.out.print("Такого пункта в меню нет. Попробуйте еще");
            }
        } while (flg_next_step);
    }

    private static void editPersonMenu() {
        Scanner scan = new Scanner(System.in);

        System.out.println();
        screenPhoneBook(pb.getPersons());
        System.out.println();
        System.out.print("Введите номер карточки для изменения : ");
        int answer = scan.nextInt();

        editPerson(pb.getPersons().get(answer));
    }

    private static void editPerson(Person person) {
        boolean flg_next_step = true;
        do {
            Scanner scan = new Scanner(System.in);

            System.out.println();
            screenPerson(person);
            System.out.println();
            System.out.println("Определите поле которое вы хотите изменить");
            System.out.println("==========================================");
            System.out.println("1 - Ф.И.О.");
            System.out.println("2 - Дата рождения");
            System.out.println("3 - Адрес");
            System.out.println("4 - Телефон / телефоны");
            System.out.println("------------------------------------------");
            System.out.println("0 - Выйти в основное меню");
            System.out.println("------------------------------------------");
            System.out.print("--==>> ");
            int answer = scan.nextInt();

            Scanner scanCardField = new Scanner(System.in);
            switch (answer) {
                case 0:
                    flg_next_step = false;
                    break;
                case 1:
                    System.out.println();
                    System.out.print("--==>> Введите Ф.И.О. : ");
                    person.setFio(scanCardField.nextLine());
                    break;
                case 2:
                    System.out.println();
                    System.out.print("--==>> Введите дату рождения (dd.MM.yyyy) : ");
                    person.setBirthDay(LocalDate.parse(scanCardField.next(), DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                    break;
                case 3:
                    System.out.println();
                    System.out.print("--==>> Введите адресс : ");
                    person.setAddress(scanCardField.nextLine());
                    break;
                case 4:
                    System.out.println();
                    System.out.println("--==>> Редактироание телефонов");
                    System.out.println("1 - изменить");
                    System.out.println("2 - удалить");
                    System.out.println("3 - добавить");
                    System.out.println("------------------------------");
                    System.out.print("--==>> ");
                    int menu = scan.nextInt();

                    int idPhoneNumber;
                    switch (menu) {
                        case 1:
                            System.out.println();
                            screenPhones(person.getPhones());
                            System.out.print("--==>> Определите номер для иззменения : ");
                            idPhoneNumber = scan.nextInt();
                            System.out.println();
                            System.out.print("--==>> Введите номер : ");
                            person.getPhones().set(idPhoneNumber, scanCardField.nextLine());
                            break;
                        case 2:
                            System.out.println();
                            screenPhones(person.getPhones());
                            System.out.print("--==>> Определите номер для удаления : ");
                            idPhoneNumber = scan.nextInt();
                            person.getPhones().remove(idPhoneNumber);
                            break;
                        case 3:
                            System.out.println();
                            System.out.print("--==>> Введите номер : ");
                            person.getPhones().add(scanCardField.nextLine());
                            break;
                        default:
                            System.out.print("Такого пункта в меню нет. Попробуйте еще");
                    }

                    break;
                default:
                    System.out.println("Такого поля в карточке нет. Попробуйте еще");
            }

            if (answer != 0) {
                person.setLastEdit(LocalDateTime.now());
            }
        } while (flg_next_step);
    }

//    private static ArrayList<Person> findPersonFIO() {
//        ArrayList<Person> newList = new ArrayList<>();
//        Scanner scan = new Scanner(System.in);
//
//        System.out.print("Введите Ф.И.О. : ");
//        String answer = scan.nextLine();
//
//        for (Person p : pb.getPersons()) {
//            String str1;
//            String str2;
//            if (p.getFio().length() >= answer.length()) {
//                str1 = p.getFio().substring(0, answer.length());
//                str2 = answer;
//            } else {
//                str2 = answer.substring(0, p.getFio().length());
//                str1 = p.getFio();
//            }
//
//            if (str1.equalsIgnoreCase(str2)) {
//                newList.add(p);
//            }
//        }
//
//        return newList;
//    }

    private static ArrayList<Person> findPersonFIO() {
        ArrayList<Person> newList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите Ф.И.О. : ");
        String answer = scan.nextLine();

        pb.getPersons().stream().filter(p -> {
                                                String str1;
                                                String str2;
                                                if (p.getFio().length() >= answer.length()) {
                                                    str1 = p.getFio().substring(0, answer.length());
                                                    str2 = answer;
                                                } else {
                                                    str2 = answer.substring(0, p.getFio().length());
                                                    str1 = p.getFio();
                                                }
                                                return str1.equalsIgnoreCase(str2);
                                             })
                                .forEach(p -> newList.add(p));

        return newList;
    }

//    private static ArrayList<Person> findPersonBirthDay() {
//        ArrayList<Person> newList = new ArrayList<>();
//        Scanner scan = new Scanner(System.in);
//
//        System.out.print("Введите дату рождения (dd.MM.yyyy) : ");
//        LocalDate answer = LocalDate.parse(scan.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//
//        for (Person p : pb.getPersons()) {
//            if (p.getBirthDay().isEqual(answer)) {
//                newList.add(p);
//            }
//        }
//
//        return newList;
//    }

    private static ArrayList<Person> findPersonBirthDay() {
        ArrayList<Person> newList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите дату рождения (dd.MM.yyyy) : ");
        LocalDate answer = LocalDate.parse(scan.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        pb.getPersons().stream().filter(p -> p.getBirthDay().isEqual(answer))
                                .forEach(p -> newList.add(p));

        return newList;
    }

    private static void sortedListPersonsMenu() {
        Scanner scan = new Scanner(System.in);

        boolean flg_next_step = true;
        do {
            System.out.println();
            System.out.println("Укажите поле по которому необходимо провести сортировку");
            System.out.println("=======================================================");
            System.out.println("1 - Ф.И.О.");
            System.out.println("2 - Дата рождения");
            System.out.println("------------------");
            System.out.println("0 - Возврат в меню");
            System.out.println("------------------");
            System.out.print("--==>> ");
            int answer = scan.nextInt();

            switch (answer) {
                case 0:
                    flg_next_step = false;
                    break;
                case 1:
                    System.out.println();
                    pb.getPersons().sort(Comparator.comparing(Person::getFio));
                    pb.getPersons().forEach(person -> System.out.println(person.toString()));

                    System.out.println();
                    System.out.print("Для возврата в основное меню нажмите клавишу 0 : ");
                    scan.next();

                    flg_next_step = false;
                    break;
                case 2:
                    System.out.println();
                    pb.getPersons().sort(Comparator.comparing(Person::getBirthDay));
                    pb.getPersons().forEach(person -> System.out.println(person.toString()));

                    System.out.println();
                    System.out.print("Для возврата в основное меню нажмите клавишу 0 : ");
                    scan.next();

                    flg_next_step = false;
                    break;
                default:
                    System.out.print("Такого пункта в меню нет. Попробуйте еще");
            }
        } while (flg_next_step);
    }
}
