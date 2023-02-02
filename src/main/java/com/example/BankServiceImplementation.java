package com.example;

public class BankServiceImplementation implements BankService {
    private int payment;
    @Override
    public void pay(String id, double amount) {
        this.payment++;
    }
    public int getPayment() {
        return payment;
    }
    public void setPayment(int payment) {
        this.payment = payment;
    }
}
