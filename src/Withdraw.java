import java.awt.*;
import java.security.Key;
import java.util.Scanner;

public class Withdraw extends Transaction{
    public  int amount;
    private Keypad keypad;
    private static final int CANCELED=6;
    private CashDispenser cashDispenser;
    public Withdraw(String accountNumber, Screen screen, Keypad keypad,Database database,CashDispenser cashDispenser)
    {
      super(accountNumber,database,screen);
      this.keypad=keypad;
      this.cashDispenser=cashDispenser;
    }
    public void execute()
    {

        Screen screen= getScreen();
        Database database=getDatabase();
        Boolean cashDispensed=false;
        while (!cashDispensed)
        {
            this.amount = displayMenuOfAmount();
            if (this.amount != CANCELED)
            {
                if(this.amount>=database.getTotalBalance(getAccountNumber()))
                {
                    if(cashDispenser.isSufficientCashAvailable(this.amount))
                    {
                        database.getCurrentAccount(getAccountNumber()).debit(this.amount);
                        cashDispenser.dispenseCash(this.amount);
                        cashDispensed=true;
                    }
                    else
                    {
                        screen.displayLineMessage("Cannot make this transaction now.");
                    }
                }
                else
                {
                    screen.displayLineMessage("Your balance is not enough for this transaction.");
                }
            }
            else {
                screen.displayLineMessage("\nCanceling transaction...");
                return;
            }
        }
        
    }
    private  int displayMenuOfAmount()
    {
        int result;
        Scanner scanner= new Scanner(System.in);
        Screen screen= getScreen();
        int userChoice=0;
        int amounts[]={20,50,100,200};
        while (userChoice==0)
        {
            screen.displayLineMessage( "\nWithdrawal Menu:" );
            screen.displayLineMessage("1. $20");
            screen.displayLineMessage("2. $50");
            screen.displayLineMessage("3. 100");
            screen.displayLineMessage("4. 200");
            screen.displayLineMessage("5. Optional");
            screen.displayLineMessage("6. Cancel transaction");
            screen.displayMessage( "\nChoose a withdrawal amount: " );
            do{
                userChoice=scanner.nextInt();
                if(userChoice>6)
                {
                    screen.displayLineMessage("Invalid input. Please try again");
                }
            }
            while (userChoice>6);
            switch (userChoice)
            {
                case 1:
                case 2:
                case 3:
                case 4:
                    userChoice=amounts[userChoice-1];
                    break;
                case 5:
                    screen.displayLineMessage("Your input must be multiple of 20.");
                    screen.displayLineMessage("Your input: ");
                    do {
                        userChoice = scanner.nextInt();
                        if(userChoice%20!=0)
                        {
                            screen.displayLineMessage("Invalid input. Please try again");
                        }
                    }
                    while(userChoice%20!=0);
            }
        }
        return  userChoice;
    }
}
