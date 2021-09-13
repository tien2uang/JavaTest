public class Account {
    private String accountNumber;
    private int pin;

    private double totalBalance;
    public Account(String accountNumber,int pin,double totalBalance)
    {
        this.accountNumber=accountNumber;
        this.pin=pin;

        this.totalBalance=totalBalance;
    }
    public Boolean validatePIN(int _pin)
    {
        if(this.pin==_pin)
        {
            return  true;
        }
        else return false;
    }

    public void credit(double amount)
    {
        this.totalBalance+=amount;
    }
    public  void debit(double amount)
    {
        this.totalBalance-=amount;

    }
    public double getTotalBalance() {
        return totalBalance;
    }
}
