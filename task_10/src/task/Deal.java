package task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Deal {
    private String date;
    private HashMap<Integer, PayDoc> paydoc;
    public  Deal(String date){
        this.date = date;
        paydoc = new HashMap<>();
    }
    public void createpaydoc(int income, int number, TypeDoc type){
        paydoc.put(number,new PayDoc(income,number,date,type));
    }

}
