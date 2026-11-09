package model;

import java.util.List;
import java.util.ArrayList;

public class BankAccount {
    public enum Type {
        CHECKING, SAVINGS
    }
    public enum Status {
        ACTIVE, FROZEN, CLOSED
    }
    public final Type type;
    public Status status;

    private final Customer customer;
    private final long id;
    private double balance;
    private List<Transaction> transactionHistory;

    public BankAccount(Customer customer, long id, String type) {
        this.customer = customer;
        this.id = id;
        this.type = switch (type) {
            case "checking" -> Type.CHECKING;
            case "savings" -> Type.SAVINGS;
            default ->
                throw new IllegalArgumentException("account %s is not valid: should be either 'checking' or 'savings'");
        };
        status = Status.ACTIVE;
        balance = 0;
        transactionHistory = new ArrayList<>();
    }

    public Customer getCustomer() { return customer; }

    public long getId() { return id; }

    public double getBalance() { return balance; }

    public void setBalance(double balance) { this.balance = balance; }

    public List<Transaction> getTransactionHistory() { return transactionHistory; }

    public void deposit(double money, BankAccount target){
        target.setBalance(target.getBalance() + money);
    }
    public void withdraw(double money, BankAccount target){
        if(0 < (target.getBalance() - money)){ // implement overdraft prevention
            // do something, print/error?
            return;
        }
        target.setBalance(target.getBalance() - money);
    }
    public void transfer(BankAccount source, BankAccount target, double amount){
        withdraw(amount, source);
        deposit(amount, target);
    }
}