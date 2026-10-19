public class Account {
    private String userId;
    private String pin;
    private String accountId;
    private double balance;

    public Account(String userId, String pin, String accountId, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public String getPin() {
        return pin;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
