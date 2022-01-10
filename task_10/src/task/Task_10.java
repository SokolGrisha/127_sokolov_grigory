package task;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

import static task.TypeDoc.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task_10 {
    public static void commands(){
        System.out.println("Список Команд:");
        System.out.println("1. Создать Договр");
        System.out.println("2. Создать Платежное поручение или Банковский ордер");
        System.out.println("3. Найти платежи по номеру договора");
        System.out.println("4. Сумма всех платежей по номеру договора");
        System.out.println("5. Удалить платёж");
        System.out.println("6. Список всех договоров и сумма платежей по ним");
        System.out.println("7. Список Всех платежей");
        System.out.println("8. Повторить список команд");
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
                    String numofdeal = get("Введите номер договора:");
                    if(deals.containsKey(numofdeal)) {
                        int numofdoc = Integer.parseInt(get("Введите номер платежа:"));
                        if(!deals.get(numofdeal).listofdocs().containsKey(numofdoc)) {
                            int income = Integer.parseInt(get("Сумма платежа(в коп.):"));
                            if (income > 0 && income != 0) {
                                String date = get("Дата платежа:");
                                //TODO Сделать проверку по заданию
                                print("Выберите тип платежа:");
                                print("1.Платежное поручение");
                                print("2.Банковский ордер");
                                switch (Integer.parseInt(get("Тип:"))) {
                                    case 1:
                                        deals.get(numofdeal).createpaydoc(income, numofdoc, date, PaymentsDoc);
                                        break;
                                    case 2:
                                        deals.get(numofdeal).createpaydoc(income, numofdoc, date, BankDoc);
                                        break;
                                }
                            }
                            else{
                                print("Неверная сумма платежа");
                            }
                        }
                            else{
                                print("Такой договор уже существует");
                            }
                    }
                    else{
                        print("!!! Такого договра не существует");
                    }
                    break;
                case 3:
                    String num3 = get("Введите номер договора:");
                    if(deals.containsKey(num3)) {
                        print("Дата платежа | Тип платежа | Номер платежа | Сумма патежа(коп.) ");
                        for (PayDoc doc : deals.get(num3).listofdocs()) {
                            print(doc.getDate()+" | "+doc..getType()+" | "+doc.getNumber()+" | "+doc.getIncome());

                        }
                    }
                    else{
                        print("Нет такого договора");
                    }
                    break;
                case 4:
                    String num4 = get("Введите номер договора:");
                    if(deals.containsKey(num4)) {
                        print("Сумма платежей по договору(коп.):"+String.valueOf(deals.get(num4).getSum()));
                    }
                    else{
                        print("Нет такого договора");
                    }
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
                    commands();
                    break;
                default:
                    print("Ошибка ввода");
                    break;
            }
        }
    }
}
