public class Account {

    private String userId;
    private String pin;
    private double balance;
    private String name;
    public Account(String name,String userId, String pin, double balance) {
        this.name=name;
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getName() {
    return name;
}
}