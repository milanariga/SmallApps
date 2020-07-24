package bankAccountApp;

/**
 * @author Ana on 7/24/2020
 */
public abstract class Account implements IntRate{

    String name;
    String sSN;
    String accountNumber;
    double balance;
    double rate;

    final String countryCode = "LV";
    final String bankCode = "BANK";
    int checkDigits = 00;
    String bankAccountNumber;
    static int index = 10001;


    public Account(String name, String sSN, double initDeposit){
        this.name =name;
        this.sSN = sSN;
        this.balance = initDeposit;

        System.out.println("Name: " + name + "\nSSN: " + sSN + "\nBalance: " + initDeposit);
        System.out.print("New account: ");

        index++;
        this.accountNumber = setAccountNumber();
    }

    private String setAccountNumber(){
        bankAccountNumber = createBankAccount();
        System.out.println("Random Num: " + bankAccountNumber);
        String check = Integer.toString(checkDigits);
        //System.out.println("Check number: " + check);
        String account = countryCode + Integer.toString(checkDigits) + bankCode + index + bankAccountNumber;
        System.out.println(account);

        return "1";
    }

    private String createBankAccount(){
        int bankAccount = (int) (Math.random() * Math.pow(10,5));
        int length = Integer.toString(bankAccount).length();
        if (length < 8) {
            //bankAccountNumber = org.apache.common.lang.StringUtils.leftPad(bankAccount, 8, "0");
            bankAccountNumber = String.format("%03d", bankAccount);
            //StringUtils.leftPad(Integer.toString(bankAccount), 8, '0');
        }
        System.out.println("length" + length);
        return bankAccountNumber;
    }

}
