package model;

public class Account {

    private final Customer customer;
    private enum Type {
        CHECKING,
        SAVINGS
    }
    private Type type;
    private double balance;

    public Account(Customer customer, String type) {
        this.customer = customer;
        switch (type) {
            case "checking":
                this.type = Type.CHECKING;
            case "savings":
                this.type = Type.SAVINGS;
            default:
                throw new IllegalArgumentException("account %s is not valid: should be either 'checking' or 'savings'");
        }
    }
}