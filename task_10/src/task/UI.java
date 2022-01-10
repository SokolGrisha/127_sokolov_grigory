package task;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

import static task.TypeDoc.*;

public class UI {
    public static String type(TypeDoc type){
        if(type==PaymentsDoc){
            return "Платежное поручение";
        }
        else{
            return "Банковский ордер";
        }
    }
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
    public static void main(String[] args) {
        MangerOfDeals deals = new MangerOfDeals();
        commands();
        while (true) {
            switch (get("Введите номер команды (8 - повторить список команд):")) {
                case "1" -> {
                    String num = get("Введите номер договора:");
                    String date = get("Введите дату заключения договора:");
                    try {
                        deals.careatedeal(date, num);
                    } catch (Exception e) {
                        print(e.getMessage());
                    }
                    print("Договор #" + num + " с датой заключения " + date + " создан");
                }
                case "2" -> {
                    String number_of_deal = get("Введите номер договора:");
                    int number_of_doc = Integer.parseInt(get("Введите номер платежа:"));
                    int income = Integer.parseInt(get("Сумма платежа(коп.):"));
                    String date2 = get("Дата платежа:");
                    print("Выберите тип платежа:");
                    print("1.Платежное поручение");
                    print("2.Банковский ордер");
                    switch (get("Тип:")) {
                        case "1":
                            try {
                                deals.create_pay_doc(number_of_deal, income, number_of_doc, date2, PaymentsDoc);
                            } catch (Exception e) {
                                print(e.getMessage());
                            }
                            break;
                        case "2":
                            try {
                                deals.create_pay_doc(number_of_deal, income, number_of_doc, date2, BankDoc);
                            } catch (Exception e) {
                                print(e.getMessage());
                            }
                            break;
                        default:
                            print("Ошибка ввода");
                            break;
                        break;
                        case "3":
                            String num3 = get("Введите номер договора:");
                            if (deals.containsKey(num3) && !deals.get(num3).list_of_docs().isEmpty()) {
                                print("Дата платежа | Тип платежа | Номер платежа | Сумма патежа(коп.) ");
                                for (PayDoc doc : deals.get(num3).list_of_docs()) {
                                    print(doc.getDate() + " | " + type(doc.getType()) + " | " + doc.getNumber() + " | " + doc.getIncome());

                                }
                            } else {
                                print("Нет такого договора");
                            }
                            break;
                        case "4":
                            String num4 = get("Введите номер договора:");
                            if (deals.containsKey(num4)) {
                                print("Сумма платежей по договору(коп.):" + deals.get(num4).getSum());
                            } else {
                                print("Нет такого договора");
                            }
                            break;
                        case "5":
                            String num5 = get("Введите номер договора:");
                            if (deals.containsKey(num5)) {
                                int number_of_doc = Integer.parseInt(get("Введите номер платежа:"));
                                String date = get("Введите дату платежа:");
                                try {
                                    deals.get(num5).delete_doc(number_of_doc, date);
                                } catch (Exception e) {
                                    print(e.getMessage());
                                }
                                print("Платеж удален");
                            } else {
                                print("Нет такого договора");
                            }
                            break;
                        case "6":
                            print("Номер договора | Сумма платежей по договору(коп)");
                            for (String deal : deals.keySet()) {
                                print(deal + " | " + deals.get(deal).getSum());
                            }
                            break;
                        case "7":
                            for (String deal : deals.keySet()) {
                                if (!deals.get(deal).list_of_docs().isEmpty()) {
                                    print("Номер договора | Дата платежа | Тип платежа | Номер платежа | Сумма патежа(коп.) ");
                                    for (PayDoc doc : deals.get(deal).list_of_docs()) {
                                        print(deal + " | " + doc.getDate() + " | " + type(doc.getType()) + " | " + doc.getNumber() + " | " + doc.getIncome());

                                    }
                                }
                            }
                            break;
                        case "8":
                            commands();
                            break;
                        default:
                            print("Ошибка ввода");
                            break;
                    }
                }
            }
    }
}
