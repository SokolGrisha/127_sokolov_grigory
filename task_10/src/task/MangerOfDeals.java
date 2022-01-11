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
                throw new Exception("Ошибка попытка добавить договор с пустым номером");
            }
        }
        else{
            throw new Exception("Ошибка попытка добавить договор с уже существующим номером");
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
    public List<PayDoc> list_of_all_docs() {
        List<PayDoc> list = new ArrayList();
        for (String deal : list_of_numbers_deals()) {
            list.addAll(deals.get(deal).list_of_docs());
        }
        return list;
    }
    public List<Integer> list_of_all_docs_income(){
        List<Integer> list = new ArrayList();
        for (PayDoc paydocs: list_of_all_docs()) {
            list.add(paydocs.getIncome());
        }
        return list;
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
            throw new Exception("Ошибка попытка удалить несуществующий платеж");
        }
    }
    private Set<String> list_of_numbers_deals(){
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
    public HashMap<String, Deal> getDeals() {
        return deals;
    }
    public int getDealsCount(){
        return deals.size();
    }
    public HashMap<String, Integer> deals_and_paymonts(){
        HashMap<String, Integer> list = new HashMap<>();
        for (String deal : list_of_numbers_deals()) {
            list.put(deal, deals.get(deal).getSum());
        }
        return list;
    }
}
