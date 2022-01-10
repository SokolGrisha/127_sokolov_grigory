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
    public void createpaydoc(int income, int number,String date, TypeDoc type){
        paydoc.put(number,new PayDoc(income,number,date,type));
    }
    public List<Integer> listofdocs() {
        List<Integer> list = new ArrayList();
        for(PaymentDocument paymentDoc : paymentDocuments.values()){
            payments.add(paymentDoc.getSum());
        }
        return paydoc;
    }
    public int getSum(){
        int sum = 0;
        for(Object doc: paydoc.keySet()){
            sum+=paydoc.get(doc).getIncome();
        }
        return sum;
    }
}
