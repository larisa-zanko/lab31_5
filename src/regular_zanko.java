//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.regex.Pattern;

/*Лабараторная работа №4.
Так как в файле 4.3  и 2.3 (второй подпункт) задания являются практически индентичными. То отправляю программу подходящую как для задания айла 4.3 так и  задания 2а в файл 2.3

 Суть задания заключается в написании валидных регулярных выражений для проверки различных типов строк.
Каждое из девяти заданий связано с конкретным форматом данных, для которого необходимо создать минимальное по размеру регулярное выражение.
Необхомо проверить, является ли строка GUID, MAC-адресом, URL адресом, цветом HTML, датой, E-mail,  IP-адресом, хорошим паролем, шестизначным числом,  номером телефона Беларуси,
числом с плавающей точкой, серией паспорта, номером кредитной карты,HTML.

patterns[]: массив строк, содержащий регулярные выражения для каждой из задач (1-14).
descriptions[]: массив строк, содержащий описания форматов, которые будут проверяться.
                    Структура работы программы.
Используется бесконечный цикл while (true), который предоставляет пользователю возможность многократно выполнять проверки.
Пользователь выбирает номер формата для проверки.
Если введён 0, программа завершает свою работу. Программа проверяет корректность выбора и запрашивает строку для проверки.
В зависимости от выбора пользователя, программа использует Pattern.matches() для проверки введённой строки на соответствие выбранному регулярному выражению.
Результат проверки выводится на экран: программа сообщает, соответствует ли строка формату или нет.

программу на Java, которая будет использовать регулярные выражения для проверки различных форматов данных. Программа должна позволять пользователю многократно проверять строки на соответствие определённым форматам.

Форматы для проверки
Ваша программа должна поддерживать следующие форматы:

GUID: Формат 32-х символов, разделённых дефисами, например 123e4567-e89b-12d3-a456-426614174000.
MAC-адрес: Формат, состоящий из 6 пар шестнадцатеричных цифр, разделённых двоеточиями, например 01:23:45:67:89:AB.
URL: Полный URL, например https://www.example.com.
Цвет в HTML: Формат шестнадцатеричного цвета, например #FFFFFF или #FFF.
Дата: Формат даты в виде YYYY-MM-DD, например 2024-11-26.
E-mail: Стандартный адрес электронной почты, например example@example.com.
IP-адрес: IPv4 адрес, например 192.168.0.1.
Пароль: Должен содержать минимум 8 символов, включая хотя бы одну букву, одну цифру и один специальный символ.
Шестизначное число: Число, состоящее из точно 6 цифр, например 123456.
Номер телефона Беларуси: Формат +375(XX)XXXXXXX, где XX — код города и X — цифры номера.
Число с плавающей точкой: Формат числа с возможной десятичной частью, например 123.45 или -123.45.
Серия паспорта: Формат, например AB123456.
Номер кредитной карты: Формат 16 цифр, например 1234 5678 9012 3456.
HTML: Проверка на наличие тегов HTML.

*/

public class regular_zanko {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Массив регулярных выражений для различных форматов
        String[] patterns = {
                // Задача 1: GUID
                "^(\\{?[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}\\}?)$",
                // Задача 2: MAC-адрес
                "^([0-9a-fA-F]{2}[:-]){5}([0-9a-fA-F]{2})$",
                // Задача 3: URL -адрес
                "^(https?://)?(www\\.)?([a-zA-Z0-9-]+\\.[a-zA-Z]{2,})(:[0-9]{1,5})?(/.*)?$",
                // Задача 4: HTML цвет
                "^#([0-9a-fA-F]{6}|[0-9a-fA-F]{3})$",
                // Задача 5: Дата
                "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(1[6-9][0-9]{2}|[2-9][0-9]{3})$",
                // Задача 6: E-mail
                "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
                // Задача 7: IP адрес
                "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$",
                // Задача 8: Пароль
                "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d_]{8,}$",
                // Задача 9: Шестизначное число
                "^[1-9][0-9]{5}$",
                // Задача 10: Номер телефона Беларуси
                "^(\\+375|375)(29|33|44|25|17)[0-9]{7}$",
                // Задача 11: Число с плавающей точкой
                "^[+-]?\\d*\\.\\d+$",
                // Задача 12: Серия паспорта
                "^[A-Z]{2}\\d{8}$",
                // Задача 13: Номер кредитной карты
                "^(\\d{4} \\d{4} \\d{4} \\d{4})$",
                // Задача 14: HTML
                "^<[^>]+>.*</[^>]+>$"
        };

        // Описание форматов
        String[] descriptions = {
                "GUID",
                "MAC-адрес",
                "URL-адрес",
                "HTML цвет",
                "Дата (dd/mm/yyyy)",
                "E-mail",
                "IP адрес",
                "Надежный пароль",
                "Шестизначное число",
                "Номер телефона Беларуси",
                "Число с плавающей точкой",
                "Серия паспорта",
                "Номер кредитной карты",
                "HTML"
        };

        while (true) {
            System.out.println("Для проверки строки, введите номер соответствующего формата:");
            for (int i = 0; i < descriptions.length; i++) {
                System.out.println((i + 1) + ". " + descriptions[i]);
            }
            System.out.println("0. Выход");

            // Проверка корректного ввода номера формата
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите число.");
                continue;
            }

            if (choice == 0) {
                System.out.println("Выход из программы.");
                break;
            }

            if (choice < 1 || choice > descriptions.length) {
                System.out.println("Некорректный выбор. Пожалуйста, выберите число от 1 до " + descriptions.length + ".");
                continue;
            }

            System.out.println("Введите строку для проверки на " + descriptions[choice - 1] + ":");
            String input = scanner.nextLine();

            // Проверка строки на соответствие регулярному выражению
            boolean matches = Pattern.matches(patterns[choice - 1], input);

            // Вывод результата проверки
            if (matches) {
                System.out.println("Строка соответствует формату " + descriptions[choice - 1] + ".");
            } else {
                System.out.println("Строка не соответствует формату " + descriptions[choice - 1] + ".");
            }
        }
        scanner.close();
    }
}
