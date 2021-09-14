import java.util.AbstractCollection;

public class Database {
    private Account[] accounts;
    public Database()
    {
        accounts=new Account[2];
        accounts[0]= new Account("2904",853211,1234.0);
        accounts[1]= new Account("2002",722766,3422.0);
    }
    public Boolean isAccountExist(String userAccountNumber)
    {
        for(Account currentAccount : accounts)
        {
            if(currentAccount.getAccountNumber().equals(userAccountNumber))
            {
                return true;
            }
        }
        return  false;
    }

    public Account getCurrentAccount(String userAccountNumber)
    {
        for(Account account:accounts)
        {
            if(account.getAccountNumber().equals(userAccountNumber))
            {
                return account;

            }
        }
        return null;
    }
    public Boolean authenticateUser(String userAccountNumber,int userPin)
    {
        Boolean check=false;
        Account currentAccount=getCurrentAccount(userAccountNumber);
        if(currentAccount!=null)
        {
            if(currentAccount.validatePIN(userPin))
            {
                check=true;
            }
        }

        return check;
    }

    public double getTotalBalance(String userAccountNumber)
    {
        Account currentAccount=getCurrentAccount(userAccountNumber);
        return currentAccount.getTotalBalance();

    }
    public void debit(String userAccountNumber,double amount)
    {
        getCurrentAccount(userAccountNumber).debit(amount);
    }
    public  void credit(String userAccountNumber,double amount)
    {
        getCurrentAccount(userAccountNumber).credit(amount);
    }
}
