package bankAccountApp;

/**
 * @author Ana on 7/24/2020
 */
public class CheckingAcc extends Account {

    int debitCardNumber;
    int debitCardPIN;


    public CheckingAcc(String name, String sSN, double initDeposit){
        super(name, sSN, initDeposit);
        System.out.println("New checking account");
    }
}
