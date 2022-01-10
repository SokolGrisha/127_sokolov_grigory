package task;

import java.util.*;

public class MangerOfDeals {

    private final HashMap<String, Deal> deals;
    public MangerOfDeals(){
        deals = new HashMap<>();
    }
    public void create_deal(String date, String number) throws Exception {
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
                throw new Exception((e.getMessage()));
            }
        }
        else{
            throw new Exception("Ошибка договор с таким номером не существует");
        }
    }
    public List<PayDoc> list_of_docs(String number) throws Exception{
        if(deals.containsKey(number)) {
            return deals.get(number).list_of_docs();
        }
        else{
            throw new Exception("Ошибка договор с таким номером не существует");
        }
    }
    public int getSum(String number) throws Exception{
        if(deals.containsKey(number)) {
            return deals.get(number).getSum();
        }
        else{
            throw new Exception("Ошибка договор с таким номером не существует");
        }
    }
    public void delete_doc(String number_of_deal, int num_of_dec, String date) throws Exception{
        if(deals.containsKey(number_of_deal)) {
            try {
                deals.get(number_of_deal).delete_doc(num_of_dec, date);
            }
            catch (Exception e) {
                throw new Exception((e.getMessage()));
            }
        }
        else{
            throw new Exception("Ошибка договор с таким номером не существует");
        }
    }
    public Set<String> list_of_numbers_deals(){
        return deals.keySet();
    }
    public boolean isEmpty(String number) throws Exception{
        if(deals.containsKey(number)) {
            return deals.get(number).list_of_docs().isEmpty();
        }
        else{
            throw new Exception("Ошибка договор с таким номером не существует");
        }
    }

}
