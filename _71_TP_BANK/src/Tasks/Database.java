/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author acer
 */
public class Database {

    void saveToFile(ArrayList<Task> listTask, String fileName) {
        String url = System.getProperty("user.dir");
        try {
            File file = new File(url + fileName);
            file.createNewFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (Task task : listTask) {
                    writer.write(task + "\r\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Cannot write to file! Try again!");
        }
    }

    ArrayList<Task> readFromFile(String fileName) {
        String url = System.getProperty("user.dir");
        ArrayList<Task> listTask = new ArrayList<>();
        try {
            File file = new File(url + fileName);
            String line;
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                while ((line = reader.readLine()) != null) {
                    String[] taskInfo = line.split(",");
                    listTask.add(new Task(Integer.parseInt(taskInfo[0]), Integer.parseInt(taskInfo[1]), taskInfo[2], taskInfo[3], Double.parseDouble(taskInfo[4]), Double.parseDouble(taskInfo[5]), taskInfo[6], taskInfo[7]));
                }
            }
            return listTask;
        } catch (FileNotFoundException ex) {
            return new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Cannot read from file! Try again!");
        }
        return null;
    }

    void saveToFile(int lastId, String fileName) {
        String url = System.getProperty("user.dir");
        try {
            File file = new File(url + fileName);
            file.createNewFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(Integer.toString(lastId) + "\r\n");
            }
        } catch (IOException e) {
            System.out.println("Cannot write to file! Try again!");
        }
    }

    int readLastIdFromFile(String fileName) {
        String url = System.getProperty("user.dir");
        ArrayList<Task> listTask = new ArrayList<>();
        try {
            File file = new File(url + fileName);
            String line;
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                line = reader.readLine();
                return Integer.parseInt(line);
            }
        } catch (NumberFormatException numex) {
            System.out.println("Wrong file format try again!");
        } catch (FileNotFoundException ex) {
            return 0;
        } catch (IOException e) {
            System.out.println("Cannot read from file! Try again!");
        }
        return -1;
    }
}
