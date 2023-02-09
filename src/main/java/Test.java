import org.django.models.AccountStatut;
import org.django.models.AccountType;
import org.django.models.BankAccount;


public class Test {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
              bankAccount.setId(1L);
              bankAccount.setBalance(70000);
              bankAccount.setCurrency("FCFA");
              bankAccount.setType(AccountType.CURRENT_ACCOUNT);
              bankAccount.setStatut(AccountStatut.CREATED);

        BankAccount bankAccount2 = bankAccount.clone();
        System.out.println(bankAccount);
        System.out.println(bankAccount2);
    }


}
