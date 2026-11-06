package model;

import java.util.List;

public class Customer {
    private final long id;
    private final Name name;
    private List<Account> accounts;

    public Customer(long id, String firstName, String lastName) {
        this.id = id;
        this.name = new Name(firstName, lastName);
    }

    public long getId() { return this.id; }
    public Name getName() { return this.name; }
    public List<Account> getAccounts() { return this.accounts; }
}