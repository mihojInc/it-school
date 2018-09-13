package src.main.java.com.lessons;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ATMStatus {
    public  Map<String,Integer> avaialableMoney=new HashMap<String,Integer>();
    public ATMStatus(){
        String dispenserPath = "C:\\Users\\master\\IdeaProjects\\it-school_projectATM\\src\\main\\java\\com\\lessons\\templates\\ATMDispenser.csv";
        String[] cassete = {}; // конвертируем ArrayList в массив
        ArrayList <String> tmpDisp = loadATM(dispenserPath);

        cassete = tmpDisp.toArray(new String[tmpDisp.size()]);


        avaialableMoney.put("500", Integer.parseInt(cassete[0]));
        avaialableMoney.put("100", Integer.parseInt(cassete[1]));
        avaialableMoney.put("50", Integer.parseInt(cassete[2]));
        avaialableMoney.put("10", Integer.parseInt(cassete[3]));


    }
    public  Map<String, Integer> getAvaialableMoney() {
        return this.avaialableMoney;
    }
    public void setAvaialableMoney(Map<String, Integer> avaialableMoney) {
        this.avaialableMoney = avaialableMoney;
    }

    private ArrayList loadATM(String path) {
        String csvFile = path;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String cassete1 = null;
        String cassete2 = null;
        String cassete3 = null;
        String cassete4 = null;
        ArrayList<String> dispenser = new ArrayList<String>(4);

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] banknote = line.split(cvsSplitBy);

                switch (banknote[0]) {

                    case "500UAH":
                        cassete1 = banknote[1];
                        break;
                    case "100UAH":
                        cassete2 = banknote[1];
                        break;
                    case "50UAH":
                        cassete3 = banknote[1];
                        break;
                    case "10UAH":
                        cassete4 = banknote[1];
                        break;

                }

            }
            dispenser.add(cassete1);
            dispenser.add(cassete2);
            dispenser.add(cassete3);
            dispenser.add(cassete4);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return dispenser;
    }


}

