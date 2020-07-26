package bankAccountApp;

import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

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
    String checkDigits = "00";
    String bankAccountNumber;
    static int index = 10001;


    public Account(String name, String sSN, double initDeposit){
        this.name =name;
        this.sSN = sSN;
        this.balance = initDeposit;

        System.out.println("Name: " + name + "\nSSN: " + sSN + "\nBalance: " + initDeposit);

        index++;
        this.accountNumber = setAccountNumber();
        System.out.print("New account: " + accountNumber);

    }

    private String setAccountNumber(){
        createBankAccount();

        checkDigits = createCheckDigits(countryCode, bankAccountNumber, bankCode, index);
        int checkDigLength = checkDigits.length();
        if (checkDigLength < 2){
            checkDigits = StringUtils.leftPad(checkDigits, 2, "0");
        }

        String account = countryCode + checkDigits + bankCode + index + bankAccountNumber;

        return account;
    }

    private String createBankAccount(){
        int bankAccount = (int) (Math.random() * Math.pow(10,8));
        int length = Integer.toString(bankAccount).length();

        if (length < 8) {
            bankAccountNumber = StringUtils.leftPad(Integer.toString(bankAccount), 8, "0");
        }
        else {
            bankAccountNumber = Integer.toString(bankAccount);
        }
        return bankAccountNumber;
    }

    private String createCheckDigits(String countryCode, String bankAccountNo, String bankCode, int index){
        String moderatedAccount;
        String moderatedCountryCode = convertLettersToDigits(countryCode);
        String moderatedBankCode = convertLettersToDigits(bankCode);
        moderatedAccount = moderatedBankCode + Integer.toString(index) + bankAccountNo + moderatedCountryCode + "00";
        //System.out.println(moderatedAccount);

        Long firstAccountNumber = Long.parseLong(moderatedAccount.substring(0,15));
        Long firstMod = firstAccountNumber % 97;
        Long secondAccountNumber = Long.parseLong(Long.toString(firstMod) + moderatedAccount.substring(15,27));
        Long mod = secondAccountNumber % 97;

        return Long.toString(mod);
    }


    private String convertLettersToDigits (String letters){
        Map<String, String> letterToDigit = new HashMap<String, String>();
        letterToDigit.put("A", "10");
        letterToDigit.put("B", "11");
        letterToDigit.put("C", "12");
        letterToDigit.put("D", "13");
        letterToDigit.put("E", "14");
        letterToDigit.put("F", "15");
        letterToDigit.put("G", "16");
        letterToDigit.put("H", "17");
        letterToDigit.put("I", "18");
        letterToDigit.put("J", "19");
        letterToDigit.put("K", "20");
        letterToDigit.put("L", "21");
        letterToDigit.put("M", "22");
        letterToDigit.put("N", "23");
        letterToDigit.put("O", "24");
        letterToDigit.put("P", "25");
        letterToDigit.put("Q", "26");
        letterToDigit.put("R", "27");
        letterToDigit.put("S", "28");
        letterToDigit.put("T", "29");
        letterToDigit.put("U", "30");
        letterToDigit.put("V", "31");
        letterToDigit.put("W", "32");
        letterToDigit.put("X", "33");
        letterToDigit.put("Y", "34");
        letterToDigit.put("Z", "35");

        int length = letters.length();
        String resultNum = "";
        String checkLetter;
        for (int i = 0; i < length; i++) {
            checkLetter = letters.substring(i,i+1);
            resultNum = resultNum + letterToDigit.get(checkLetter);
        }
        return resultNum;
    }

}
