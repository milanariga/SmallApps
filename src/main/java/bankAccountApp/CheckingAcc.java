package bankAccountApp;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Ana on 7/24/2020
 */
public class CheckingAcc extends Account {

    private String debitCardNumber;
    private int debitCardPIN;


    public CheckingAcc(String name, String sSN, double initDeposit){
        super(name, sSN, initDeposit);
        setDebitCard();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() - 0.25;
    }

    public void setDebitCard(){
        int debitCardNo = (int) (Math.random() * Math.pow(10,12));
        debitCardPIN = (int) (Math.random() * Math.pow(10,4));

        int length = Integer.toString(debitCardNo).length();

        if (length < 12) {
            debitCardNumber =  StringUtils.rightPad(Integer.toString(debitCardNo), 12, "0");
        }
        else {
            debitCardNumber = Integer.toString(debitCardNo);
        }
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println(
                "Checking account features:" +
                "\n Debit Card Number: " + debitCardNumber +
                "\n Debit Card PIN: " + debitCardPIN
        );
    }
}
