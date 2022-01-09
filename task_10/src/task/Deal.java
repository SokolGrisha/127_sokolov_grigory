package task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Deal {
    private String date;
    private String number;
    private HashMap<Integer, PayDoc> paydoc;
    public  Deal(String date, String number){
        this.date = date;
        this.number = number;
    }
}
