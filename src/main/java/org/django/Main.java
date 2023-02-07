package org.django;


import org.django.models.*;

import org.django.repositories.AccountRepositoryImpl;
import org.django.utils.JsonSerializer;

import java.util.List;



public class Main {
    public static void main(String[] args) {
        JsonSerializer<BankAccount> bankAccountJsonSerializer=new JsonSerializer<>();
        AccountRepositoryImpl  accountRepository = AccountRepositoryImpl.getInstance();
        accountRepository.populateDate();
        List<BankAccount>bankAccounts = accountRepository.searchAccounts(bankAccount ->
                (bankAccount.getStatut().equals(AccountStatut.ACTIVATED)) && bankAccount.getBalance()>1000);
        bankAccounts.stream()
                    .map(bankAccountJsonSerializer::toJson)
                    .forEach(System.out::println);

        System.out.println("==============================");
            BankAccount byId = accountRepository.findById(1L).orElse(null);
            if (byId !=null)
                System.out.println(bankAccountJsonSerializer.toJson(byId));
        System.out.println("==============================");

        Person person = Person.builder()
                .lastName("Enzo")
                .firstName("Kenza")
                .build();

        Student student = PersonDirector.studentBuilder()
                .address("2 Mail Alexandre Fleming ")
                .phone("0745667688")
                .age(31)
                .build();
        System.out.println(student);

/*        (Student) */
    }
}