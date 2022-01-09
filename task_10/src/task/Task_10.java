package task;

import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task_10 {
    public static void main(String[] args) {
        HashMap<Integer, Deal> deals;
        Scanner scan = new Scanner(System.in);
        System.out.print("Список Команд:");
        System.out.print("1. Создать договр");
        System.out.print("2. Создать Платёжный документ");
        System.out.print("3. Найти платежи по номеру договора");
        System.out.print("4. Сумма всех платежей по номеру договора");
        System.out.print("5. Удалить платёж");
        System.out.print("6. Список всех договоров и сумма платежей по ним");
        System.out.print("7. Список Всех платежей");
        System.out.print("Помощь");
        System.out.print("Введите номер команды:");
        if(scan.hasNextInt()){

        }
    }
}
