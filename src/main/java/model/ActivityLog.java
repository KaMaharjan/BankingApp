package model;

import java.util.LinkedList;
import java.sql.Timestamp;

public class ActivityLog {
    LinkedList<Node> activityLog = new LinkedList<>();
    private static class Node{
        int ID;
        String details;
        String activity;
        Timestamp date;
        actionType actionType;
        public Node(int ID, String details, String activity, Timestamp date, actionType actionType){
            this.ID = ID;
            this.details = details;
            this.activity = activity;
            this.date = date;
            this.actionType = actionType;
        };
        @Override
        public String toString(){
            return ID + " | " + actionType + " | " + activity + " | " + details + " | " + date;
        }
    }

    public void autoActivity(){ // STILL NEED

    }

    public void logActivity(int ID, String details, String activity, Timestamp date, actionType actionType){
        activityLog.add(new Node(ID, details, activity, date, actionType));
    }

    public void displayLog(){
        StringBuilder sb = new StringBuilder();
        for(Node n: activityLog){
            sb.append("[");
            sb.append(n.toString());
            sb.append("]\n");
        }
        System.out.println(sb.toString());
    }

    public enum actionType{
        WIRE,
        FREEZE,
        UNFREEZE,
        CREATE,
        VIEW,
    }

    public void filter(actionType actionType){
        System.out.println("Filtering for " +  actionType + ".");
        StringBuilder sb = new StringBuilder();
        for(Node n : activityLog){
            if(n.actionType == actionType){
                sb.append("[");
                sb.append(n.toString());
                sb.append("]\n");
            }
        }
        if(sb.isEmpty()){
            System.out.println("No results showed.\n");
            return;
        }
        System.out.println(sb.toString());
    }

    public void filter(int id){
        System.out.println("Filtering for ID: " + id + ".");
        StringBuilder sb = new StringBuilder();
        for(Node n : activityLog){
            if(n.ID == id){
                sb.append("[");
                sb.append(n.toString());
                sb.append("]\n");
            }
        }
        if(sb.isEmpty()){
            System.out.println("No results showed.\n");
            return;
        }
        System.out.println(sb.toString());
    }

    public void filter(String date){
        System.out.println("Filtering for date: " + date + ".");
        StringBuilder sb = new StringBuilder();
        for(Node n : activityLog){
            if(n.date.equals(date)){
                sb.append("[");
                sb.append(n.toString());
                sb.append("]\n");
            }
        }
        if(sb.isEmpty()){
            System.out.println("No results showed.\n");
            return;
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args){
        ActivityLog log = new ActivityLog();
        Timestamp time = new Timestamp(System.currentTimeMillis());
        log.logActivity(12, "bought stuff", "activity here", time, actionType.WIRE);
        log.logActivity(14, "sold stuff", "activity here", time, actionType.WIRE);
        log.logActivity(14, "looking at stuff", "activity here", time, actionType.VIEW);
        log.displayLog();
        log.filter(actionType.VIEW);
        log.filter(actionType.WIRE);
        log.filter(actionType.CREATE);
        log.filter(12);
        log.filter("1-20-1997");
    }
}