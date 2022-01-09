package task;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

import static task.TypeDoc.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task_10 {
    public  static void createPayDocs(Deal deals,TypeDoc type){
        get("Введите номер договора:");
        if(Objects.equals(type,PaymentsDoc)){
            print("Введите номер поручения:");
        }
        else{
            print("Введите номер ордера:");
        }
        String numofdoc = input();

    }
    public static void commands(){
        System.out.println("Список Команд:");
        System.out.println("1. Создать Договр");
        System.out.println("2. Создать Платежное поручение");
        System.out.println("3. Создать Банковский ордер");
        System.out.println("4. Найти платежи по номеру договора");
        System.out.println("5. Сумма всех платежей по номеру договора");
        System.out.println("6. Удалить платёж");
        System.out.println("7. Список всех договоров и сумма платежей по ним");
        System.out.println("8. Список Всех платежей");
        System.out.println("9. Повторить список команд");
    }
    public static void print(String a){
        System.out.println(a);
    }
    public static String get(String a){
        System.out.print(a);
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }
    public static String input(){
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }
    public static void main(String[] args) {
        HashMap<String, Deal> deals;
        deals = new HashMap<>();
        commands();
        while (true) {
            switch (Integer.parseInt(get("Введите номер команды:"))) {
                case 1:
                    String num = get("Введите номер договора:");
                    if(!deals.containsKey(num)&& !Objects.equals(num, "")) {
                        String date = get("Введите дату заключения договора:");
                        deals.put(num,new Deal(date));
                        print("Договор #" + num + " с датой заключения " + date + " создан");
                    }
                    else{
                        print("!!! Ошибка !!!");
                        print("Договор с таким номером уже создан или номер договора не введен");
                    }
                    break;
                case 2:
                    print("Введите номер договора:");
                    break;
                case 3:
                    print("Введите номер договора:");
                    break;
                case 4:
                    print("Введите номер договора:");
                    break;
                case 5:
                    print("Введите номер договора:");
                    break;
                case 6:
                    print("Введите номер договора:");
                    break;
                case 7:
                    print("Введите номер договора:");
                    break;
                case 8:
                    print("Введите номер договора:");
                    break;
                case 9:
                    commands();
                    break;
            }
        }
    }
}
