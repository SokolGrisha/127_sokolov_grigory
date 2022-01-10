package task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Deal {
    private String date;
    private final HashMap<Integer, PayDoc> pay_doc;
    public  Deal(String date){
        this.date = date;
        pay_doc = new HashMap<>();
    }
    public void create_pay_doc(int income, int number, String date, TypeDoc type) throws Exception {
        if(!(exists_of_doc(number)&& pay_doc.get(number).getType()==type&& Objects.equals(pay_doc.get(number).getDate(), date))){
            pay_doc.put(number, new PayDoc(income, number, date, type));
        }
        else{
            throw new Exception("Ошибка договор уже есть");
        }
    }
    public List<PayDoc> list_of_docs() {
        List<PayDoc> list = new ArrayList();
        list.addAll(pay_doc.values());
        return list;
    }
    public int getSum(){
        int sum = 0;
        for(Object doc: pay_doc.keySet()){
            sum+= pay_doc.get(doc).getIncome();
        }
        return sum;
    }
    public boolean exists_of_doc(int num){
        return pay_doc.containsKey(num);
    }
    public void delete_doc(int num, String date) throws Exception {
        if(exists_of_doc(num)&& Objects.equals(pay_doc.get(num).getDate(), date)){
            pay_doc.remove(num);
        }
        else{
            throw new Exception("Ошибка нет такого платежа");
        }
    }
}
