package com.lessons;

public class Task {
    String taskDescription;
    int amountsOfPomodoros;

    public Task() {}
    public Task(String taskDescription, double interval) {
        this.taskDescription = taskDescription;
        double intermediate = interval/25;
        this.amountsOfPomodoros = (int)Math.ceil(intermediate);
    }

    public void seeTask(){
        System.out.println("Task is <" + taskDescription + ">. It will take approximately " + amountsOfPomodoros + " Pomodoros!");
    }

    public void changeTask(String newTaskDescription){
        this.taskDescription = newTaskDescription;
    }
    public void changeTask(int newAmountsOfPomodoros){
        this.amountsOfPomodoros = newAmountsOfPomodoros;
    }
    public void changeTask(String newTaskDescription, int newAmountsOfPomodoros){
        this.taskDescription = newTaskDescription;
        this.amountsOfPomodoros = newAmountsOfPomodoros;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public int getAmountsOfPomodoros() {
        return amountsOfPomodoros;
    }

    public void setAmountsOfPomodoros(double interval) {
        this.amountsOfPomodoros = (int)Math.ceil(interval/25);
    }
}
