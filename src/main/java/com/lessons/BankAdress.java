package src.main.java.com.lessons;

public enum BankAdress {
    CREDIT_AGRICOLE("Credit_Agricole", "50 avenue Jean Jaurès 92 120 Montrouge"),
   AMERICAN_EXPRESS("American_Express", "World Financial Center, 200 Vesey Street\n" +
           "New York, NY 10285"),
    BANK_OF_AMERICA("Bank_of_America","901 East Cary Street\n" +
            "Richmond, VA 23219");

    private String bankName;
    private String bankAdress;

    BankAdress(String bankName, String bankAdress) {
        this.bankName = bankName;
        this.bankAdress = bankAdress;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBankAdress() {
        return bankAdress;
    }


}
