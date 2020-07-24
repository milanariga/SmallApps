package bankAccountApp;

/**
 * @author Ana on 7/24/2020
 */
public class SavingAcc extends Account {

    int safetyDepostBoxID;
    int safetyDepositBoxKey;

    public SavingAcc(String name, String sSN, double initDeposit){
        super(name, sSN, initDeposit);
        System.out.println("New checking account");
    }
}
