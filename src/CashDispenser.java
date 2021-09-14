public class CashDispenser {
    private int count =500;
    public Boolean isSufficientCashAvailable(double amount)
    {
        if(amount/20<count)
            return true;
        else
            return false;

    }
    public void dispenseCash(double amount)
    {
        count -=amount/20;

    }
}
