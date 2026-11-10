package model;

import java.util.ArrayList;
import java.util.List;

public class Employee extends User{

    public Employee(long id, Name name, Credentials credentials, List<BankAccount> accounts) {
        super(id, name, credentials);
    }

    public Customer lookUp(int id){
        // have to wait until customer list is implemented
        return null; // Throw an error later, about not finding customer account

    }

    public void wireTransfer(AccountNote note, Customer from, Customer to) {

    }

    public void freeze(AccountNote note, Customer target){

    }

    public void unfreeze(AccountNote note, Customer target){

    }

    public static void main(){
        Name n = new Name("John", "Doe");
        Name n2 =  new Name("John2", "Doe2");
        Name en =  new Name("Jane", "Done");
        Credentials cr = new Credentials("John", "Doe");
        Credentials cr2 = new Credentials("2John", "2Doe");
        Credentials adm = new Credentials("admin", "pass");
        Customer c = new Customer(12, n, cr);
        Customer c2 = new Customer(15, n2, cr2);
        BankAccount b1 = new BankAccount(c,1,"checking");
        BankAccount b2 = new BankAccount(c2, 2, "savings");
        List<BankAccount> bankList = new ArrayList<>();
        bankList.add(b1);
        bankList.add(b2);
        Employee e = new Employee(1, en, adm, bankList);
        System.out.println(e.lookUp(12));
    }
}