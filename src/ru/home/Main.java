package ru.home;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Создаем статическое поле с типом UserManager для того чтобы можно было вызывать методы
    // UserManager из статического контекста (из фукнции main()) при работе с программой
    private static UserManager userManager = new UserManager();

    public static void main(String[] args) {
        int choice; // переменная для выбора пунту меню

        Scanner scanner = new Scanner(System.in);
        do {
            printMenu();

            String choiceString = scanner.nextLine();
            choice = Integer.parseInt(choiceString);

            switch (choice) {
                case 1: {
                    System.out.println("Добавление пользователя");
                    System.out.println("Введите имя");
                    String name = scanner.nextLine();
                    System.out.println("Введите телефон");
                    String telephone = scanner.nextLine();
                    System.out.println("Введите дату рождения (ДД.ММ.ГГГГ)");
                    Date birthDay;
                    try {
                        String dateString = scanner.nextLine();
                        birthDay = DateUtil.toDate(dateString);
                    } catch (ParseException e) {
                        System.out.println("Пользователь не создан. Не удалось считать дату");
                        break;
                    }
                    System.out.println(userManager.save(name, telephone, birthDay));
                    break;
                }
                case 2: {
                    System.out.println("Введите id для удаления пользователя:");
                    String userIdString = scanner.nextLine();
                    int userId = Integer.parseInt(userIdString);
                    userManager.delete(userId);
                    break;
                }
                case 3: {
                    System.out.println("Введите имя чтобы выполнить поиск по имени:");
                    String searchingName = scanner.nextLine();

                    List<User> users = userManager.searchByName(searchingName);

                    if (users.isEmpty()) {
                        System.out.println("Ни один пользователь с именем " + searchingName + " не найден");
                        break;
                    }

                    for (User user : users) {
                        System.out.println(user);

                    }
                    break;
                }
                case 4: {
                    System.out.println("Введите дату в формате ДД.ММ.ГГГГ чтобы выполнить поиск по имени:");
                    String dateString;
                    Date birthDay;
                    try {
                        dateString = scanner.nextLine();
                        birthDay = DateUtil.toDate(dateString);
                    } catch (ParseException e) {
                        System.out.println("Не удалось выполнить поиск. Не удалось считать дату");
                        break;
                    }

                    List<User> users = userManager.searchByDate(birthDay);

                    if (users.isEmpty()) {
                        System.out.println("Ни один пользователь с датой рождения " + dateString + " не найден");
                        break;
                    }

                    for (User user : users) {
                        System.out.println(user);

                    }
                    break;
                }
                case 5: {
                    System.out.println("Введите имя чтобы выполнить поиск по телефону:");
                    String telephone = scanner.nextLine();

                    List<User> users = userManager.searchByTelephone(telephone);

                    if (users.isEmpty()) {
                        System.out.println("Ни один пользователь с телефоном " + telephone + " не найден");
                        break;
                    }

                    for (User user : users) {
                        System.out.println(user);

                    }
                    break;
                }
                case 6: {
                    System.out.println("Вывод на экран");
                    for (User user : userManager.getAll()) {
                        System.out.println(user);
                    }
                    break;
                }
            }
        } while (choice != 7); // выходим из программу, когда в choice запишется число 7

    }

    // Функция для вывода меню на экран
    private static void printMenu() {
        String menu = "\n" +
                "1. Добавить пользователя\n" +
                "2. Удалить пользователя\n" +
                "3. Поиск по имени\n" +
                "4. Поиск по дате\n" +
                "5. Поиск по телефону\n" +
                "6. Вывод содержимого\n" +
                "7. Выход\n" +
                "Ваш выбор:";
        System.out.println(menu);
    }
}
