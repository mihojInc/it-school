package com.lessons;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Interaction {

    public static void interaction(Scanner scanner){
          boolean direction = createListOfTasks(scanner);
          if(direction == false){return;}
          changeListOfTasks(scanner);
          DateTime day = setDateTimeForPlanning(scanner);
          setSchedule(day,scanner);
          System.out.println("ok");
    }

    private static boolean createListOfTasks(Scanner scanner){
        boolean allIsRight = true;
        String choice = null;
        boolean isRight = false;
        System.out.println("Before we start make sure that you fill the file inpet.txt");
        System.out.println("with correct information about your day tasks in the form");
        System.out.println("description of the task - amounts of minutes for its completion");
        while (!isRight) {
            System.out.println("if file is not filled or it is incorrect type <quit> else type <next>");
            if (scanner.hasNextLine()) {
                choice = scanner.nextLine();
                if (choice.equals("next")) {
                    System.out.println("Good choice");
                    isRight = Planner.createTaskList();
                } else if (choice.equals("quit")) {
                    isRight = true;
                    allIsRight = false;
                } else {
                    System.out.println("You don't enter anything or input is incorerct.Please make your choice!");
                }
            }
        }
        return allIsRight;
    }

    private static void changeListOfTasks(Scanner scanner){
        String choice = null;
        String typeOfChanges = null;
        String newDescription = null;
        int taskToChange = 0;
        int newInterval = 0;
        while(true){
            Planner.showTaskList();
        System.out.println("If all is right enter <yes> and if you want change smth enter <no>");
        if(scanner.hasNextLine()){
            choice = scanner.nextLine();
            if(choice.equals("yes")){return;
            }else if(choice.equals("no")){
                System.out.println("Enter number of task to change");
                if(scanner.hasNextInt()){
                    taskToChange = scanner.nextInt();
                    scanner.nextLine();
                    if(taskToChange >= 0 && taskToChange < Planner.getTaskList().size()){
                        System.out.println("If you want change the description enter <d>,");
                        System.out.println("If you want change amounts of pomodoros enter <t>");
                        if(scanner.hasNextLine()){
                            typeOfChanges = scanner.nextLine();
                            if(typeOfChanges.equals("d")){
                                System.out.println("Enter description");
                                if(scanner.hasNextLine()){
                                    newDescription = scanner.nextLine();
                                }
                                Planner.getTaskList().get(taskToChange).changeTask(newDescription);
                            }else if (typeOfChanges.equals("t")){
                                System.out.println("Enter new amounts of pomodoros");
                                if(scanner.hasNextInt()){
                                    newInterval = scanner.nextInt();
                                    scanner.nextLine();
                                }
                                Planner.getTaskList().get(taskToChange).changeTask(newInterval);
                            }else {
                                System.out.println("Incorrect input.Try again");
                            }
                        }
                    }else {
                        System.out.println("Incorrect number of task. Try again");
                    }

                }
            } else {
                System.out.println("Incorrect input.Try again");
            }
        }
        }

    }

    private static DateTime setDateTimeForPlanning(Scanner scanner){
        int[] dates = new int[7];
        String[] forConsole = {"year", "month", "day", "startHour", "startMinutes", "endHour", "endMinutes" };
        for(int i = 0; i < 7; i++){
            System.out.println("Enter the " + forConsole[i]);
            if(scanner.hasNextInt()){
                dates[i] = scanner.nextInt();
                scanner.nextLine();
            }
        }
        DateTime start = new DateTime(dates[0],dates[1],dates[2],dates[3],dates[4]);
        DateTime end = new DateTime(dates[0],dates[1],dates[2],dates[5],dates[6]);
        Planner.setTimeIntervals(start,end);
        return start;
    }

    private static void setSchedule(DateTime day, Scanner scanner){
        boolean isEnd = true;
        String choice = null;
        DateTimeFormatter test1 = DateTimeFormat.forPattern("hh:mm a");
        DateTimeFormatter nameOfDay = DateTimeFormat.forPattern("dd-MM-YYYY");
        DateTimeFormatter newDataTime = DateTimeFormat.forPattern("dd-MM-YYYY hh:mm a");
        String dayName = nameOfDay.print(day);
        String dateToParse = dayName + " ";
        DateTime constrainedTime = null;
        String constrainedDescription = null;
        LinkedHashMap<DateTime,String> ex = Planner.applyPomodoroTechnique();
        Planner.showSchedule(ex,day);
        while( isEnd){
            System.out.println("Now if you want add some constraints to the plan enter <add>");
            System.out.println("If all is OK enter <print>");
            if(scanner.hasNextLine()){
                choice = scanner.nextLine();
                if(choice.equals("print")){
                    isEnd = false;
                }else if(choice.equals("add")){
                    System.out.println("Enter reserved time interval in form:  hh:mm a");
                    if(scanner.hasNextLine()){
                        dateToParse+=scanner.nextLine();
                        try{
                        constrainedTime = newDataTime.parseDateTime(dateToParse);
                        }catch (IllegalArgumentException exception){
                            System.out.println("You enter time in incorrect format");
                            continue;
                        }
                    }
                    System.out.println("Enter description");
                    if(scanner.hasNextLine()){
                        constrainedDescription = scanner.nextLine();
                    }
                    Planner.setConstraints(constrainedTime,constrainedDescription);
                    //some code here
                }else {
                    System.out.println("Incorrect input. Try add constraints again!!!"); 
                }
                
            }
        }
        Planner.addTasksOnGrid();
        FileWorking.write(Planner.getSchedule(),day);
    }
}
