package com.lessons;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Planner {

    private static List<Task> taskList;
    private static LinkedList<DateTime> timeLinkedList;
    private static LinkedHashMap<DateTime, String> schedule;

    public static boolean createTaskList() {
        List<String> test = new ArrayList<>();
        test = FileWorking.readMyFile();
        if (checkData(test) == true) {
            taskList = new ArrayList<>();
            int i = 0;
            for (String str : test) {
                Task newTask = new Task();
                for (String newstr : str.split("-")) {
                    i++;
                    if (i % 2 == 1) {
                        newTask.setTaskDescription(newstr);
                    } else {
                        newTask.setAmountsOfPomodoros(Double.parseDouble(newstr));
                    }

                }
                taskList.add(newTask);
            }
            return true;
        } else {
                System.out.println("Input is incorrect. Check it and try again");
                return false;
            }

    }

    /**
     * @param dataForCheking - it's list read from file with task
     * @return true if tasks written in the form : task - time in minutes
     */
    public static boolean checkData(List<String> dataForCheking) {
        boolean isValid = false;
        String test = dataForCheking.stream().collect(Collectors.joining("\n"));
        Matcher matcher1 = Pattern.compile("(([a-zA-z\\s\\\\]){1,}(\\-)([0-9\\s\\\\]{1,}))").matcher(test);
        int matches = 0;
        while (matcher1.find()) {
            matches++;
        }
        if (matches == dataForCheking.size()) {
            isValid = true;
        }
        return isValid;
    }

    public static void showTaskList() {
        int i = 0;
        for (Task tsk : taskList) {
            System.out.print(i + ":");
            tsk.seeTask();
            i++;
        }
    }


    public static LinkedList<DateTime> setTimeIntervals(DateTime start, DateTime end) {
        timeLinkedList = new LinkedList<>();
        DateTime current = start;
        timeLinkedList.add(start);
        int i = 1;
        while (current.compareTo(end) < 0) {
            DateTime current1 = current.plusMinutes(30);
            if (current1.compareTo(end) > 0) {
                break;
            }
            current = current.plusMinutes(25);
            if (i % 4 == 0) {
                current = current.plusMinutes(15);
            } else {
                current = current.plusMinutes(5);
            }
            timeLinkedList.add(current);
            i++;
        }
        return timeLinkedList;
    }

    public static LinkedHashMap<DateTime, String> applyPomodoroTechnique() {
        schedule = new LinkedHashMap<>();
//        int taskNum = 0;
//        int pomodoros = 1;
        for (DateTime dt : timeLinkedList
                ) {
            schedule.put(dt, null);
        }

        return schedule;
    }

    public static LinkedHashMap<DateTime, String> setConstraints(DateTime time, String description){
       schedule.replace(time,description);
        return schedule;
    }

    public static void addTasksOnGrid(){
        int taskNum = 0;
        int pomodoros = 1;
        Set set = schedule.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<DateTime, String> item = (Map.Entry) iterator.next();
            if(taskNum==taskList.size()){break;}
            if(!(item.getValue()==null)){continue;}
            item.setValue(taskList.get(taskNum).getTaskDescription());
            if(pomodoros == taskList.get(taskNum).getAmountsOfPomodoros()){
                taskNum++;
                pomodoros = 0;
            }
            pomodoros++;
        }
    }






    public static LinkedHashMap<DateTime, String> getSchedule() {
        return schedule;
    }

    public static List<Task> getTaskList() {
        return taskList;
    }

    public static LinkedList<DateTime> getTimeLinkedList() {
        return timeLinkedList;
    }

    public static void showSchedule(LinkedHashMap<DateTime, String> apply, DateTime day){
        DateTimeFormatter test = DateTimeFormat.forPattern("dd-MM-YYYY");
        DateTimeFormatter test1 = DateTimeFormat.forPattern("hh:mm a");
        System.out.println(test.print(day));
        Set set = apply.entrySet();
       Iterator iterator = set.iterator();
       while (iterator.hasNext()) {
         Map.Entry<DateTime,String> item = (Map.Entry) iterator.next();
           System.out.println(test1.print(item.getKey())+ " : " + item.getValue());
     }
    }
}