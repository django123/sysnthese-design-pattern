package org.django.repositories;

import org.django.models.AccountStatut;
import org.django.models.AccountType;
import org.django.models.BankAccount;
import org.django.models.BankDirector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AccountRepositoryImpl implements AccountRepository {

    // mise en place du pattern sigleton 2 façon de faire

    /*
      *ici la première manière de faire
      *
     */
    private static  AccountRepositoryImpl accountRepository;

    private AccountRepositoryImpl(){}
    public  static AccountRepositoryImpl getInstance(){

        if (accountRepository == null){
            System.out.println("Singleton instantiation");
            accountRepository=new AccountRepositoryImpl();
        }
        return  accountRepository;
    }

    /*
     *ici la deuxième manière de faire
     *
     */
/*
 private static final  AccountRepositoryImpl accountRepository;
    static {
        System.out.println("Singleton instantiation");
        accountRepository = new AccountRepositoryImpl();
    }

     public static AccountRepositoryImpl getInstance(){

        return  accountRepository;
    }
 */
    private Map<Long, BankAccount> bankAccountMap = new HashMap<>();
    private long accountsCount=0;
    @Override
    public  BankAccount save(BankAccount bankAccount) {
        Long accountId=++accountsCount;
        bankAccount.setId(accountId);
        bankAccountMap.put(accountId,bankAccount);
        return bankAccount;
    }

    @Override
    public List<BankAccount> findAll() {
        return bankAccountMap.values().stream().toList();
    }

    @Override
    public Optional<BankAccount> findById(Long id) {
        BankAccount account = bankAccountMap.get(id);
       if (account == null)
           Optional.empty();
       return Optional.of(account);
    }

    @Override
    public List<BankAccount> searchAccounts(Predicate<BankAccount> predicate) {
        return bankAccountMap.values().stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public BankAccount update(BankAccount bankAccount) {
        bankAccountMap.put(bankAccount.getId(), bankAccount);
        return bankAccount;
    }

    @Override
    public void deleteById(Long id) {
      bankAccountMap.remove(id);
    }

    public void populateDate(){
        for (int i =0; i <10; i++){

            BankAccount bankAccount = BankDirector.accountBuilder()
                    .balance(1000+Math.random()*90000)
                    .type(Math.random()>0.5? AccountType.SAVING_ACCOUNT:AccountType.CURRENT_ACCOUNT)
                    .status(Math.random()>0.5? AccountStatut.CREATED:AccountStatut.ACTIVATED)
                    .currency(Math.random()>0.5?"FCFA":"USD")
                    .build();
            save(bankAccount);

        }
    }


}
