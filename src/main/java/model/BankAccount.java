package model;

public class BankAccount {
    private enum Type {
        CHECKING,
        SAVINGS
    }

    private final Customer customer;
    private final Type type;
    private double balance;
    private List<Transaction> transactionHistory;
    public boolean isFrozen;

    public BankAccount(Customer customer, String type) {
        this.customer = customer;
        this.type = switch (type) {
            case "checking" -> Type.CHECKING;
            case "savings" -> Type.SAVINGS;
            default ->
                throw new IllegalArgumentException("account %s is not valid: should be either 'checking' or 'savings'");
        };
    }

    public Customer getCustomer() {
        return customer;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}