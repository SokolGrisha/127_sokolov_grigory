package task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PayDoc {
    private int income;
    private int number;
    private String date;
    private TypeDoc type;
    public PayDoc(int income,int number,String date,TypeDoc type){
        this.income=income;
        this.number=number;
        this.date=date;
        this.type=type;
    }
    public int getIncome(){
        return income;
    }
}
