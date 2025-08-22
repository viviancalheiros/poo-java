package account;

public class Account {
    private int number;
    private String holder;
    private double balance;
    private double withdrawLimit;

    public Account (int number, String holder, double balance, double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public double getBalance () {
        return this.balance;
    }

    public double getWithdrawLimit () {
        return this.withdrawLimit;
    }

    public void setBalance (double balance) {
        this.balance = balance;
    }

    public void withdraw (double amount) {
        if (amount > getWithdrawLimit()) {
            throw new WithdrawException("Withdraw error: The amount exceeds withdraw limit");
        } else if (amount > getBalance()) {
            throw new WithdrawException("Withdraw error: Not enough balance");
        } else {
            setBalance(getBalance()-amount);
            System.out.println("New balance: " + getBalance());
        }
    }

    public void deposit (double amount) {
        if (amount <= 0) {
            throw new DepositException("Invalid value");
        } else {
            setBalance(amount+getBalance());
            System.out.println("New balance: " + getBalance());
        }
    }
}
