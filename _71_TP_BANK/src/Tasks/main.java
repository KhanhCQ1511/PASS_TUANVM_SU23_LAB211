/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;

import static java.lang.System.exit;

/**
 *
 * @author acer
 */
public class main {

    public static void main(String[] args) {
        Display display = new Display();
        GetData getData = new GetData();
        Database database = new Database();
        Manage manager = new Manage();
        String taskFile = "\\DataBaseTask.txt";
        String lastIdFile = "\\lastId.txt";
        do {
            //Step 1: Display menu
            display.DisplayMenu();
            //Step 2: Select option
            int option = getData.inputInteger("Enter option: ", 1, 4);
            //Step 3: Perform fuction based on the selected option
            switch (option) {
                case 1:
                    int lastId = database.readLastIdFromFile(lastIdFile);
                    manager.addTask(taskFile, lastIdFile, ++lastId);
                    break;
                case 2:
                    manager.deleteTask(taskFile, lastIdFile);
                    break;
                case 3:
                    display.displayTask(taskFile);
                    break;
                case 4:
                    exit(0);
            }

        } while (true);
    }
}
