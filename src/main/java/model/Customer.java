package model;

import java.util.List;

public class Customer extends User {
    private List<BankAccount> bankAccounts;
    private List<AccountNote> accountNotes;

    public Customer(long id, Name name, Credentials credentials) {
        super(id, name, credentials);
    }

    public List<BankAccount> getAccounts() { return this.bankAccounts; }
    public List<AccountNote> accountNotes() { return this.accountNotes; }


}