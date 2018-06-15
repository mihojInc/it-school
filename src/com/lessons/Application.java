package com.lessons;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    private static WorkWithArray newArray = new WorkWithArray();



  public static void interactionWithUser(Scanner inp){
      while(true){
          for (Commands com : Commands.values()){
              System.out.println(com.getInstruction());
          }
      String result = fromCode(inp);
      if(result.equals("addNumber")){
          System.out.println("Add integer number");
          Integer newNum = inp.nextInt();
          newArray.addNumber(newNum);

      } else if(result.equals("ascOrder")){
          newArray.sortInAsc();
          newArray.show();

      } else if (result.equals("descOrder")){
          newArray.sortInDesc();
          newArray.show();


      } else if (result.equals("clear")){
          newArray.clear();


      } else if (result.equals("exit")){
          System.out.println("Good Bye");
          break;
      } else {
          System.out.println("Try again!");

      }
      }
  }


public static String fromCode(Scanner inpt){
    Scanner input = inpt;
    Integer choose = input.nextInt();
        for (Commands com : Commands.values()) {
            if (choose.equals(com.getCode())) {
                return com.toString();
            }
        } return null;
}


}
