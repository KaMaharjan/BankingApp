package model;

import java.util.Date;

public record Transaction(double amount, Date date, String type, double balance) {}