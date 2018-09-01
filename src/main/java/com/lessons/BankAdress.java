package src.main.java.com.lessons;

public enum BankAdress {
    CREDIT_AGRICOLE("Credit_Agricole", "50 avenue Jean Jaurès 92 120 Montrouge","+44(904) 567-899"),
   AMERICAN_EXPRESS("American_Express", "World Financial Center, 200 Vesey Street\n" +
           "New York, NY 10285","+1 (702) 322-520"),
    BANK_OF_AMERICA("Bank_of_America","901 East Cary Street\n" +
            "Richmond, VA 23219", "+1 (506) 453-778");

    private String bankName;
    private String bankAdress;
    private String bankPhone;

    BankAdress(String bankName, String bankAdress, String bankPhone) {
        this.bankName = bankName;
        this.bankAdress = bankAdress;
        this.bankPhone = bankPhone;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBankAdress() {
        return bankAdress;
    }

    public String getBankPhone() {
        return bankPhone;
    }
}
