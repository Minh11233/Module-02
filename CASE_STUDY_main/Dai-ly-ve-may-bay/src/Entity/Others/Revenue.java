package Entity.Others;

public class Revenue {
    private String buyDate;
    private String income;

    public Revenue(String buyDate, String income) {
        this.buyDate = buyDate;
        this.income = income;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public String getIncome() {
        return income;
    }
}
