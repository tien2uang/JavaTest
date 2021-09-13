import java.util.Scanner;

public class Keypad {
    private Scanner scanner;
    public Keypad()
    {
        scanner= new Scanner(System.in);
    }
    public  String getAccountInput()
    {
        return scanner.nextLine();
    }
    public int getPINInput()
    {
        return scanner.nextInt();
    }
    public int getAmountInput()
    {
        return scanner.nextInt();
    }
}
