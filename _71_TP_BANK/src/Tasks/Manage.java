/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;

import java.util.ArrayList;

/**
 *
 * @author acer
 */
public class Manage {

    void addTask(String taskFile, String lastIdFile, int id) {
        GetData getData = new GetData();
        Database database = new Database();
        ArrayList<Task> listTask = database.readFromFile(taskFile);
        System.out.println("------------Add Task---------------");
        String requireName = getData.inputString("Requirement Name: ");
        int taskTypeId = getData.inputInteger("Task Type: ", 1, 4);
        String date = getData.DateInput();
        double from = getData.DoubleInput("From: ", 8.0, 17.0);
        double to = getData.DoubleInput("To: ", from + 0.5, 17.5);
        String assignee = getData.inputString("Assignee: ");
        String reviewer = getData.inputString("Reviewer: ");
        if (checkInsertInTime(listTask, date, assignee, from, to)) {
            System.out.println("Cannot add task(already have tasks at time)! try again!");
            return;
        }
        listTask.add(new Task(id, taskTypeId, requireName, date, from, to, assignee, reviewer));
        database.saveToFile(listTask, taskFile);
        database.saveToFile(id, lastIdFile);
    }

    void deleteTask(String fileName, String lastIdFile) {
        GetData getData = new GetData();
        Database database = new Database();
        ArrayList<Task> listTask = database.readFromFile(fileName);
        System.out.println("---------Del Task------");
        int idToDelete = getData.inputInteger("ID: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        //check existed id in list
        if (checkExistedID(listTask, idToDelete)) {
            Task taskForDelete = getTaskByID(listTask, idToDelete);
            listTask.remove(taskForDelete);
           // resetTaskId(listTask);
            database.saveToFile(listTask, fileName);
            //database.saveToFile(listTask.get(listTask.size()-1).getID(), lastIdFile);
            System.out.println("Delete successfully!");
        } else {
            System.out.println("Delete fail because ID not exist! Try again!");
        }
    }

    private boolean checkInsertInTime(ArrayList<Task> listTask, String date, String assignee, double from, double to) {
        //loop used to access each task in list
        for (Task task : listTask) {
            //compare date and assignee with task's one
            if (date.equals(task.getDate()) && assignee.equals(task.getAssignee())) {
                //check insert  in time
                if (task.getPlanFrom() <= from && from < task.getPlanTo() || task.getPlanFrom() < to && to <= task.getPlanTo()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkExistedID(ArrayList<Task> listTask, int idToDelete) {
        //loop used to access all task in listTask
        for (Task task : listTask) {
            //comapre id with task's one
            if (idToDelete == task.getID()) {
                return true;
            }
        }
        return false;
    }

    private Task getTaskByID(ArrayList<Task> listTask, int idToDelete) {
        //loop used to access all task in listTask
        for (Task task : listTask) {
            //compare id with task's one
            if (idToDelete == task.getID()) {
                return task;
            }
        }
        return null;
    }

    public String getTaskTypeByID(int taskTypeID) {
        //check value of taskTypeId
        switch (taskTypeID) {
            case 1:
                return "Code";
            case 2:
                return "Test";
            case 3:
                return "Design";
            default:
                return "Review";
        }
    }
    /*private void resetTaskId(ArrayList<Task> listTask) {
       
         for ( int i = 0; i < listTask.size(); i++) {
            listTask.get(i).setID(i + 1);
           
        }
    }*/
}
