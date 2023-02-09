package org.django.models;

public class BankAccount implements Cloneable{

    private Long id;
    private double balance;
    private String currency;
    private AccountType type;
    private AccountStatut statut;

    public BankAccount() {
    }

    public BankAccount(Long id, double balance, String currency, AccountType type, AccountStatut statut) {
        this.id = id;
        this.balance = balance;
        this.currency = currency;
        this.type = type;
        this.statut = statut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public AccountStatut getStatut() {
        return statut;
    }

    public void setStatut(AccountStatut statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", type=" + type +
                ", statut=" + statut +
                '}';
    }

    public static AccountBuilder builder(){
        return new AccountBuilder();
    }

    @Override
    public BankAccount clone() {
        try {
            BankAccount clone = (BankAccount) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static  class AccountBuilder {
        private final BankAccount bankAccount = new BankAccount();


        public AccountBuilder accountId(Long accountId){
            bankAccount.id=accountId;
            return this;
        }

        public AccountBuilder currency(String currency){
            bankAccount.currency=currency;
            return this;
        }

        public AccountBuilder balance(double balance){
            bankAccount.balance=balance;
            return this;
        }

        public AccountBuilder status(AccountStatut status){
            bankAccount.statut=status;
            return this;
        }

        public AccountBuilder type(AccountType type){
            bankAccount.type=type;
            return this;
        }

        public BankAccount build(){
            return this.bankAccount;
        }
    }
}
