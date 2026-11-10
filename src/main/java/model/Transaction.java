package model;

import java.util.Date;

public record Transaction(double amount, Date date, Type type, double balance) {
    public enum Type{
        WITHDRAW,
        DEPOSIT
    }
}