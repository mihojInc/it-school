package src.main.java.com.lessons;

import javenue.csv.Csv;

import java.util.Date;

public class CreditCard {
     String cardName;
     String cardHolderName;
     Double cardBalance;
     int cardPin;
     Date cardValidDate;
     int cardBlockField;
     String cardBank;
     String cardHistory;

     public CreditCard() {
          super();
     }

     public CreditCard(String cardName, String cardHolderName, Double cardBalance, int cardPin, Date cardValidDate, int cardBlockField, String cardBank, String cardHistory) {

          this.cardName = cardName;
          this.cardHolderName = cardHolderName;
          this.cardBalance = cardBalance;
          this.cardPin = cardPin;
          this.cardValidDate = cardValidDate;
          this.cardBlockField = cardBlockField;
          this.cardBank = cardBank;
          this.cardHistory = cardHistory;
     }

     @Override
     public String toString() {
          return "CreditCard{" +
                  "cardName='" + cardName + '\'' +
                  ", cardHolderName='" + cardHolderName + '\'' +
                  ", cardBalance=" + cardBalance +
                  ", cardPin=" + cardPin +
                  ", cardValidDate=" + cardValidDate +
                  ", cardBlockField=" + cardBlockField +
                  ", cardBank='" + cardBank + '\'' +
                  ", cardHistory='" + cardHistory + '\'' +
                  '}';
     }

     public String getCardName() {
          return cardName;
     }

     public String getCardHolderName() {
          return cardHolderName;
     }

     public Double getCardBalance() {
          return cardBalance;
     }

     public int getCardPin() {
          return cardPin;
     }

     public Date getCardValidDate() {
          return cardValidDate;
     }

     public int getCardBlockField() {
          return cardBlockField;
     }

     public String getCardBank() {
          return cardBank;
     }

     public String getCardHistory() {
          return cardHistory;
     }

     public static void setNewPin(String pfName, String pName, Double pAmount, int pNewPIN, Date pDate, String pBank){
          String filePath = "C:\\Users\\master\\IdeaProjects\\it-school_projectATM\\src\\main\\java\\com\\lessons\\creditCards\\";
          String filename = filePath+pfName+".csv";
          Csv.Writer writer = new Csv.Writer(filename).delimiter(',');
          writer
                  .value(pName).value(String.valueOf(pAmount)).value(String.valueOf(pNewPIN)).value(Helper.formatDate(pDate)).value("0").value(pBank)
                  .flush()
                  .close();

     }
}
