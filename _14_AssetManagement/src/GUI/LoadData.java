package GUI;

import DTO.Asset;
import DTO.Borrow;
import DTO.Employee;
import DTO.Request;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class LoadData {
    public void loadDataFromEmployee(String url, ArrayList<Employee> listEmployee){
        //Employee file
        File file = new File(url);
        //check file is exist
        if (!file.exists()){
            System.exit(0);
        } else {
            try{
                Scanner sc = new Scanner(file);
                //loop until stop read file
                while (sc.hasNextLine()){
                    String line  = sc.nextLine();
                    String[] part = line.split(",");
                    //Check list contain
                    if (listEmployee.contains(part[0])){
                        continue;
                    }
                    String employeeID = part[0].trim();
                    String name = part[1].trim();
                    String birthdate = part[2].trim();
                    SimpleDateFormat format =  new SimpleDateFormat("dd/MM/yyyy");
                    Date birth = format.parse(birthdate);
                    String role = part[3].trim();
                    String sex = part[4].trim();
                    String password = part[5].trim();
                    Employee newEmployee =  new Employee(employeeID,name,birth,role,sex,password);
                    listEmployee.add(newEmployee);
                }
            } catch (FileNotFoundException | ParseException e) {
                e.printStackTrace();
            }
        }
    }
    public void loadDataFromAsset(String url, ArrayList<Asset> listAsset){
        //Asset File
        File file1 =  new File(url);
        //check file is exist
        if (!file1.exists()){
            System.exit(0);
        } else {
            try {
                Scanner scanner =  new Scanner(file1);
                //loop until stop read file
                while(scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    String[] part = line.split(",");
                    //Check list contain
                    if (listAsset.contains(part[0])){
                        continue;
                    }
                    String assetID = part[0].trim();
                    String name = part[1].trim();
                    String color = part[2].trim();
                    double price = Double.parseDouble(part[3].trim());
                    double weight = Double.parseDouble(part[4].trim());
                    int quantity = Integer.parseInt(part[5].trim());
                    Asset newAsset = new Asset(assetID,name,color,price,weight,quantity);
                    listAsset.add(newAsset);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    public void loadDataFromBorrow(String url, ArrayList<Borrow> listBorrow){
        //Borrow file
        File file2 =  new File(url);
        //check file is exist
        if (!file2.exists()){
            System.exit(0);
        } else {
            try {
                Scanner scanner =  new Scanner(file2);
                //loop until stop read file
                while(scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    String[] part = line.split(",");
                    //Check list contain
                    if (listBorrow.contains(part[0])){
                        continue;
                    }
                    String bID = part[0].trim();
                    String assetID = part[1].trim();
                    String employeeID = part[2].trim();
                    int quantity = Integer.parseInt(part[3].trim());
                    String borrowDateTime = part[4].trim();
                    Borrow newBorrow = new Borrow(bID,assetID,employeeID,quantity,borrowDateTime);
                    listBorrow.add(newBorrow);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    public void loadDataFromRequest(String url, ArrayList<Request> listRequest){
        //Borrow file
        File file3 =  new File(url);
        //check file is exist
        if (!file3.exists()){
            System.exit(0);
        } else {
            try {
                Scanner scanner =  new Scanner(file3);
                //loop until stop read file
                while(scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    String[] part = line.split(",");
                    //Check list contain
                    if (listRequest.contains(part[0])){
                        continue;
                    }
                    String rID = part[0].trim();
                    String assetID = part[1].trim();
                    String employeeID = part[2].trim();
                    int quantity = Integer.parseInt(part[3].trim());
                    String requestDateTime = part[4].trim();
                    Request newRequest = new Request(rID,assetID,employeeID,quantity,requestDateTime);
                    listRequest.add(newRequest);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
