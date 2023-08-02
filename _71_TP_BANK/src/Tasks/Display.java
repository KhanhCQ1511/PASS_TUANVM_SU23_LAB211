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
public class Display {

    void DisplayMenu() {
        System.out.println("======== Task program ========");
        System.out.println("\t1. Add Task");
        System.out.println("\t2. Delete task");
        System.out.println("\t3. Display task");
        System.out.println("\t4. exit");
    }

    void displayTask(String fileName) {
        Database database = new Database();
        Manage manager = new Manage();
        ArrayList<Task> listTask = database.readFromFile(fileName);
        System.out.println("----------------------------------------- Task ---------------------------------------");
        System.out.println("ID   Name         Task Type       Date             Time       Assignee        Reviewer");
        for (Task task : listTask) {
            double time = task.getPlanTo() - task.getPlanFrom();
            System.out.printf("%-5d%-13s%-16s%-17s%-12.1f%-15s%-20s\n", task.getID(), task.getRequirementName(), manager.getTaskTypeByID(task.getTaskTypeID()), task.getDate(), time, task.getAssignee(), task.getReviewer());
        }
    }
}
