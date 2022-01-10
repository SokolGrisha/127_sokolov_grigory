package task;

public record PayDoc(int income, int number, String date, TypeDoc type) {

    public int getIncome() {
        return income;
    }

    public String getDate() {
        return date;
    }

    public int getNumber() {
        return number;
    }

    public TypeDoc getType() {
        return type;
    }
}
