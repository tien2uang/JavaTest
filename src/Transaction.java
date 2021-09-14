abstract public class Transaction {
    private String accountNumber;
    private Database database;
    private Screen screen;
    public Transaction(String accountNumber,Database database,Screen screen)
    {
        this.accountNumber=accountNumber;
        this.database=database;
        this.screen=screen;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    abstract public  void  execute();

    public Database getDatabase() {
        return database;
    }

    public Screen getScreen() {
        return screen;
    }
}
