public class Account {
    private String accountNumber;
    private int pin;
    private double availableBalance;
    private double totalBalance;
    public Boolean validatePIN()
    {
        return  true;
    }

    public void credit()
    {

    }
    public  void debit()
    {

    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public double getTotalBalance() {
        return totalBalance;
    }
}
