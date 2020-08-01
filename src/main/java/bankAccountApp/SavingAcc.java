package bankAccountApp;

/**
 * @author Ana on 7/24/2020
 */
public class SavingAcc extends Account {

    int safetyDepositBoxID;
    int safetyDepositBoxKey;

    public SavingAcc(String name, String sSN, double initDeposit){
        super(name, sSN, initDeposit);
        setSafetyDepositBox();
    }

    private void setSafetyDepositBox(){
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10,3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10,4));
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println(
                "Saving account features:" +
                "\n Safety Deposit Box ID: " + safetyDepositBoxID +
                "\n Safety Deposit Box Key: " + safetyDepositBoxKey
        );
    }
}
