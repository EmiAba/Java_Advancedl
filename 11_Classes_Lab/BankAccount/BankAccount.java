package F11_Classes_Lab.BankAccount;

public class BankAccount {
    private static double interestRate = 0.02;
    private static int accountCounts = 0;

    private int id; //incremenitra za vseki nov acount
    private double balance;


    public BankAccount() {
        accountCounts++;
        this.id = accountCounts;
        this.balance = 0.0;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }


    public void deposit(double money) {
        this.balance+=money;

    }

    public  double getInterestRate(int year) {
        return year*interestRate*this.balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //•	setInterestRate(double interest): void (static)
    //•	getInterest(int Years): double
    //•	deposit(double amount): void


}
