package model;

import java.util.Arrays;
import java.util.LinkedList;

public class ActivityLog {
    LinkedList<Node> activityLog = new LinkedList<>();
    private static class Node{
        int ID;
        String activity;
        String date;
        String actionType;
        public Node(int ID, String activity, String date, String actionType){
            this.ID = ID;
            this.activity = activity;
            this.date = date;
            this.actionType = actionType;
        };
        @Override
        public String toString(){
            return ID + " | " + activity + " | " + date + " | " + actionType;
        }
    }

    public void logActivity(int ID, String activity, String date, String actionType){
        Node n = new Node(ID, activity, date, actionType);
        activityLog.add(n);
    }

    public void displayLog(){
        System.out.print(activityLog.toString());
    }
    public void filter(){

    }

    public static void main(String[] args){
        System.out.println("Hello World");
        ActivityLog log = new ActivityLog();
        log.logActivity(12, "bought stuff", "1-12-1997", "Finance");
        log.displayLog();
    }
}