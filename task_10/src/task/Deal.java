package task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Deal {
    private String date;
    private HashMap<Integer, PayDoc> paydoc;
    public  Deal(String date){
        this.date = date;
        paydoc = new HashMap<>();
    }
    public void createpaydoc(int income, int number,String date, TypeDoc type) throws Exception {
        if(!(exsistofdoc(number)&&paydoc.get(number).getType()==type&& Objects.equals(paydoc.get(number).getDate(), date))){
            paydoc.put(number, new PayDoc(income, number, date, type));
        }
        else{
            //TODO выдать ошибку
            throw new Exception("Ошибка договор уже есть");
        }
    }
    public List<PayDoc> listofdocs() {
        List<PayDoc> list = new ArrayList();
        for(PayDoc pay : paydoc.values()){
            list.add(pay);
        }
        return list;
    }
    public int getSum(){
        int sum = 0;
        for(Object doc: paydoc.keySet()){
            sum+=paydoc.get(doc).getIncome();
        }
        return sum;
    }
    public boolean exsistofdoc(int num){
        return paydoc.containsKey(num);
    }
    public void deletedoc(int num, String date){
        if(exsistofdoc(num)&& Objects.equals(paydoc.get(num).getDate(), date)){
            paydoc.remove(num);
        }
        else{
            // TODO выдать ошибку
            String ignore ="ignore";
        }
    }
}
