public class TaskDemo {
    public int subtask1_if(int var1, int var2) {
        // Вычислить максимум из чисел var1, var2
        if(var1 > var2) {
            return var1;
        }
        else {
            return var2;
        }
    }

    public String subtask2_switch(int val) {
        // Если val 1, 2 или 3, то вернуть его текстовое представление. Иначе вернуть пустую строку
        String result = "";
        switch (val) {
            case 1:
                result = "Один";
                break;
            case 2:
                result = "Два";
                break;
            case 3:
                result = "Три";
                break;
        }
        return result;
    }

    public boolean Test(){
        return !(1>1);
    }
}
