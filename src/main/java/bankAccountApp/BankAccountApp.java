package bankAccountApp;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Ana on 7/24/2020
 */
public class BankAccountApp {

    public static void main(String[] args){

        List<Account> accounts = new LinkedList<Account>();

        String file = "src/main/resources/NewBankAccounts.csv";

        List<String[]> newCustomers = utilities.CSV.read(file);
        for (String[] customer : newCustomers){
            String name = customer[0];
            String sSN = customer[1];
            String accountType = customer[2];
            double initDeposit = Double.parseDouble(customer[3]);

            if (accountType.equals("Savings")){
                accounts.add(new SavingAcc(name, sSN, initDeposit));
            }
            else if (accountType.equals("Checking")){
                accounts.add(new CheckingAcc(name, sSN, initDeposit));
            }
            else {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        }

        for (Account acc : accounts){
            acc.showInfo();
        }
    }
}
