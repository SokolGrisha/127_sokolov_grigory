package task;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import static task.TypeDoc.*;

public class MangerOfDeals {
    public static void print(String a){
        System.out.println(a);
    }
    private final HashMap<String, Deal> deals;
    public MangerOfDeals(){
        deals = new HashMap<>();
    }
    public void careatedeal(String date, String number) throws Exception {
        if(!deals.containsKey(number)) {
            if (!Objects.equals(number, "") && !Objects.equals(date, "")) {
                deals.put(number, new Deal(date, number));
            } else {
                throw new Exception("Ошибка неверный номер договора");
            }
        }
        else{
            throw new Exception("Ошибка договор с таким номером уже создан");
        }
    }
    public void create_pay_doc(String number_of_deal, int income, int number, String date, TypeDoc type) throws Exception {
        if(deals.containsKey(number_of_deal)) {
            try {
                deals.get(number_of_deal).create_pay_doc(income, number, date, type);
            }
            catch (Exception e) {
                throw new Exception((e.getMessage());
            }
        }
        else{
            throw new Exception("Ошибка договор с таким номером не существует");
        }
    }

}
