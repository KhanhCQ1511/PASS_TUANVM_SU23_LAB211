
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class VehicleMangement {
    public boolean loadDataFromFile(String fileName){
        display.displayLoadData();
        File file = new File(fileName);
        //Check file exists
        if (!file.exists()){
            System.exit(0);
        } else {
            try{
                Scanner sc = new Scanner(file);
                //loop until stop read file
                while (sc.hasNextLine()){
                    String line = sc.nextLine();
                    String[] part = line.split(",");
                    if (list.contains(part[0])){
                        continue;
                    }
                    String ID = part[0].trim();
                    String name = part[1].trim();
                    String color = part[2].trim();
                    String priceString = part[3].trim();
                    double price = Double.parseDouble(priceString);
                    String brand = part[4].trim();
                    Vehicle newVehicle = new Vehicle(ID,name,color,price,brand);
                    list.add(newVehicle);
                    //Check ID contain keyword "C"
                    if (part[0].contains("C")){
                        String carID = part[0].trim();
                        String carName = part[1].trim();
                        String carColor = part[2].trim();
                        String carPriceString = part[3].trim();
                        double carPrice = Double.parseDouble(carPriceString);
                        String carBrand = part[4].trim();
                        String carType = part[5].trim();
                        String carYearOfManufacture = part[6].trim();
                        Car newCar = new Car(carID,carName,carColor,carPrice,carBrand,carType,carYearOfManufacture);
                        listCar.add(newCar);
                    }
                    //Check ID contain keyword "M"
                    if (part[0].contains("M")){
                        String motoID = part[0].trim();
                        String motoName = part[1].trim();
                        String motoColor = part[2].trim();
                        String motoPriceString = part[3].trim();
                        double motoPrice = Double.parseDouble(motoPriceString);
                        String motoBrand = part[4].trim();
                        String motoSpeedString = part[5].trim();
                        double motoSpeed = Double.parseDouble(motoSpeedString);
                        String motoLicense = part[6].trim();
                        Motorbike newMoto = new Motorbike(motoID,motoName,motoColor,motoPrice,motoBrand,motoSpeed,motoLicense);
                        listMoto.add(newMoto);
                    }
                }
                sc.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
    public void addVehicle(){
        display.displayAdd();
        String newID = Inputter.getInputString("Enter new vehicle ID: ","^[CM][0-9.]+$");
        boolean idExist = false;
        //loop use to access the first to the last element of lists
        for (Vehicle vehicle : list){
            //Check input id equal id in list
            if (vehicle.getId().equalsIgnoreCase(newID)){
                System.out.println("Vehicle with id "+newID+" already exist");
                idExist=true;
                break;
            }
        }
        //Check idExist is not false
        if (!idExist){
            String name = Inputter.getInputString("Enter name of new vehicle: ","");
            String color = Inputter.getInputString("Enter color of new vehicle: ","");
            double price = Inputter.getInputDouble("Enter price of new vehicle: ");
            String brand = Inputter.getInputString("Enter brand of new vehicle: ","");
            //Check newID contain C
            if (newID.contains("C")){
                String type = Inputter.getInputString("Enter type of new car: ","");
                String yearOfManufacture = Inputter.getInputString("Enter year of manufacture: ","");
                Car newCar = new Car(newID,name,color,price,brand,type,yearOfManufacture);
                listCar.add(newCar);
                System.out.println("Add vehicle successfully!");
                System.out.println();
            }
            //Check newID contain V
            if (newID.contains("M")){
                double speed = Inputter.getInputDouble("Enter speed of new motor: ");
                String license = Inputter.getInputString("Enter license of new motor: ","");
                Motorbike newMotor = new Motorbike(newID,name,color,price,brand,speed,license);
                listMoto.add(newMotor);
                System.out.println("Add vehicle successfully!");
                System.out.println();
            }
            Vehicle newVehicle = new Vehicle(newID,name,color,price,brand);
            list.add(newVehicle);
        }
        System.out.println("---------- List Of Vehicle ----------");
        System.out.println("List Of Car:");
        System.out.printf("%-20s%-30s%-20s%-20s%-20s%-20s%-20s","ID","Name","Color","Price","Brand","Type","Year Of Manufacture");
        System.out.println();
        //loop use to access the first to last element of list
        for (Car car : listCar){
            System.out.println(car);
        }
        System.out.println("List Of Vehicle:");
        System.out.printf("%-20s%-30s%-20s%-20s%-20s%-20s%-20s","ID","Name","Color","Price","Brand","Speed","License");
        System.out.println();
        //loop use to access the first to last element of list
        for (Motorbike moto : listMoto){
            System.out.println(moto);
        }
    }
    public void updateVehicle(){
        display.displayUpdate();
        String updateID = Inputter.getInputString("Enter vehicle ID you want to update: ","^[CM][0-9.]+$");
        boolean found = false;
        //loop use to access the first to last element of list
        for (Vehicle vehicle : list){
            //Check updateID equals id in list
            if (vehicle.getId().equalsIgnoreCase(updateID)){
                found=true;
                String newID = Inputter.getInputString("Enter new ID for update: ","^[CM][0-9.]+$");
                // Check newID equals other id in lists
                if (!vehicle.getId().equalsIgnoreCase(newID)){
                    boolean idExist = false;
                    //Loop use to access the first to last element of lists
                    for (Vehicle ve : list){
                        //check newID equals id in list
                        if (ve.getId().equalsIgnoreCase(newID)){
                            System.out.println("Vehicle with new id "+newID+" already exists");
                            idExist=true;
                            break;
                        }
                    }
                    //Check idExist
                    if (idExist){
                        continue;
                    }
                }
                //^(Y|N)$: must be input Y or N
                String confirmUpdate = Inputter.getInputString("Do you want to update information (Y/N): ", "^(Y|N)$");
                //Check confirmUpdate equal Y
                if (confirmUpdate.equalsIgnoreCase("Y")){
                    String newName = Inputter.getInputString("Enter new name for vehicle: ","");
                    String newColor = Inputter.getInputString("Enter new color for vehicle: ","");
                    double newPrice = Inputter.getInputDouble("Enter new price for vehicle: ");
                    String newBrand = Inputter.getInputString("Enter new brand for vehicle: ","");
                    vehicle.setName(newName);
                    vehicle.setColor(newColor);
                    vehicle.setPrice(newPrice);
                    vehicle.setBrand(newBrand);
                    //Check newID contain keyword
                    if (newID.contains("C")){
                        //loop use to access the first to the last element of listCar
                        for (Car car : listCar){
                            String newType = Inputter.getInputString("Enter new type of vehicle: ","");
                            String newYearOfManufacture = Inputter.getInputString("Enter new year of manufacture: ","");
                            car.setId(newID);
                            car.setName(newName);
                            car.setColor(newColor);
                            car.setPrice(newPrice);
                            car.setBrand(newBrand);
                            car.setType(newType);
                            car.setYearOfManufacture(newYearOfManufacture);
                        }
                        System.out.println("Update successfully!");
                    }
                    //Check newID contain keyword
                    if (newID.contains("M")){
                        //loop use to access the first to the last element of listMoto
                        for (Motorbike moto : listMoto){
                            double newSpeed = Inputter.getInputDouble("Enter new speed for vehicle: ");
                            String newLicense = Inputter.getInputString("Enter new license for vehicle: ","");
                            moto.setId(newID);
                            moto.setName(newName);
                            moto.setColor(newColor);
                            moto.setPrice(newPrice);
                            moto.setBrand(newBrand);
                            moto.setSpeed(newSpeed);
                            moto.setLicense(newLicense);
                        }
                        System.out.println("Update successfully!");
                    }
                }
                vehicle.setId(newID);
                //loop use to update first to last element of lists
                for (Car car : listCar) {
                    //check vehicle ID equals carID
                    if (car.getId().equalsIgnoreCase(updateID)){
                        car.setId(newID);
                    }
                }
                //loop use to access the first to last element of lists
                for (Motorbike moto : listMoto) {
                    //Check vehicle ID equals motoID
                    if (moto.getId().equalsIgnoreCase(updateID)) {
                        moto.setId(newID);
                    }
                }
                break;
            }
        }
        //Check found is false
        if (!found){
            System.out.println("Vehicle not found!");
        }
        System.out.println("---------- List Of Vehicle ----------");
        System.out.println("List Of Car:");
        System.out.printf("%-20s%-30s%-20s%-20s%-20s%-20s%-20s","ID","Name","Color","Price","Brand","Type","Year Of Manufacture");
        System.out.println();
        //loop use to access the first to last element of list
        for (Car car : listCar){
            System.out.println(car);
        }
        System.out.println("List Of Vehicle:");
        System.out.printf("%-20s%-30s%-20s%-20s%-20s%-20s%-20s","ID","Name","Color","Price","Brand","Speed","License");
        System.out.println();
        //loop use to access the first to last element of list
        for (Motorbike moto : listMoto){
            System.out.println(moto);
        }
    }
    public void deleteVehicle(){
        display.displayDelete();
        String deleteID = Inputter.getInputString("Enter vehicle id you want to delete: ","^[CM][0-9.]+$");
        boolean found = false;
        //loop use to access the first to last element of list
        for (Vehicle vehicle : list){
            //Check newID contain keyword
            if (deleteID.contains("C")){
                //loop use to access the first to the last element of listCar
                for (Car car : listCar){
                    //Check deleteID equals id in list
                    if (car.getId().equalsIgnoreCase(deleteID) && vehicle.getId().contains(deleteID)){
                        listCar.remove(car);
                        list.remove(vehicle);
                        System.out.println("Vehicle delete successfully!");
                        found=true;
                    }
                }
            }
            //Check newID contain keyword
            if (deleteID.contains("M")){
                //loop use to access the first to last element of listMoto
                for (Motorbike moto : listMoto){
                    //Check deleteID equals id in listMoto
                    if (moto.getId().equalsIgnoreCase(deleteID) && vehicle.getId().contains(deleteID)){
                        listMoto.remove(moto);
                        list.remove(vehicle);
                        System.out.println("Vehicle delete successfully!");
                        found=true;
                    }
                }
            }
        }
        //Check found is false
        if(!found){
            System.out.println("Vehicle not found!");
        }
        System.out.println("---------- List Of Vehicle ----------");
        System.out.println("List Of Car:");
        System.out.printf("%-20s%-30s%-20s%-20s%-20s%-20s%-20s","ID","Name","Color","Price","Brand","Type","Year Of Manufacture");
        System.out.println();
        //loop use to access the first to last element of list
        for (Car car : listCar){
            System.out.println(car);
        }
        System.out.println("List Of Vehicle:");
        System.out.printf("%-20s%-30s%-20s%-20s%-20s%-20s%-20s","ID","Name","Color","Price","Brand","Speed","License");
        System.out.println();
        //loop use to access the first to last element of list
        for (Motorbike moto : listMoto){
            System.out.println(moto);
        }
    }
    public void searchVehicle(){
        display.displaySearch();
        display.displaySearchMenu();
        int choice = Inputter.getInputInt("Enter option you want to choose: ");
        switch (choice){
            //Search by name
            case 1 ->{
                String searchName = Inputter.getInputString("Enter name vehicle you want to search: ","");
                //loop use to access the first to last element of list
                for (Car car : listCar ){
                    //Check searchName equals name in lists
                    if (searchName.equalsIgnoreCase(car.getName())){
                        System.out.println("List Of Car:");
                        System.out.printf("%-20s%-30s%-20s%-20s%-20s%-20s%-20s","ID","Name","Color","Price","Brand","Type","Year Of Manufacture");
                        System.out.println();
                        System.out.println(car);
                    }
                }
                //loop use to access the first to the last element of lists
                for (Motorbike moto : listMoto){
                    //Check searchName equals in lists
                    if (searchName.equalsIgnoreCase(moto.getName())){
                        System.out.println("List Of Vehicle:");
                        System.out.printf("%-20s%-30s%-20s%-20s%-20s%-20s%-20s","ID","Name","Color","Price","Brand","Speed","License");
                        System.out.println();
                        System.out.println(moto);
                    }
                }
            }
            //Search by id
            case 2->{
                String searchID = Inputter.getInputString("Enter vehicle id you want to search: ","^[CM][0-9.]+$");
                //Check searchID contain keyword
                if (searchID.contains("C")){
                    ArrayList<Car> listSearchCar = new ArrayList<>();
                    //loop access the first to last element of listCar
                    for (Car car : listCar){
                        //Check name contains in search name
                        if (searchID.toUpperCase().contains(car.getId().toUpperCase())){
                            listSearchCar.add(car);
                        }
                    }
                    //Check listSearchCar is empty
                    if (listSearchCar.isEmpty()){
                        System.out.println("Vehicle not found!");
                    } else {
                        System.out.println("List Of Car:");
                        System.out.printf("%-20s%-30s%-20s%-20s%-20s%-20s%-20s","ID","Name","Color","Price","Brand","Type","Year Of Manufacture");
                        System.out.println();
                        //Loop used to access from the first element to the last element of list. After each of these loop end, an element is sorted
                        for (int i = 0; i < listCar.size(); i++) {
                            //Loop used to access from the first unsorted element to the element before the last sorted element.
                            for (int j = 0; j < listCar.size() - i - 1; j++) {
                                //compare two contiguous salaries
                                if (listCar.get(j).getId().compareToIgnoreCase(listCar.get(j + 1).getId())<0) {
                                    Car temp = listCar.get(j);
                                    listCar.set(j, listCar.get(j + 1));
                                    listCar.set(j + 1, temp);
                                }
                            }
                        }
                        //loop use to access the first to last element of list
                        for (Car car : listSearchCar){
                            System.out.println(car);
                        }
                    }
                }
                //Check searchID contain keyword M
                if (searchID.contains("M")){
                    ArrayList<Motorbike> listSearchMoto = new ArrayList<>();
                    //loop access the first to last element of listCar
                    for (Motorbike moto : listMoto){
                        //Check name contains in search name
                        if (searchID.toUpperCase().contains(moto.getId().toUpperCase())){
                            listSearchMoto.add(moto);
                        }
                    }
                    //Check listSearchCar is empty
                    if (listSearchMoto.isEmpty()){
                        System.out.println("Vehicle not found!");
                    } else {
                        System.out.println("List Of Vehicle:");
                        System.out.printf("%-20s%-30s%-20s%-20s%-20s%-20s%-20s","ID","Name","Color","Price","Brand","Speed","License");
                        System.out.println();
                        //Loop used to access from the first element to the last element of list. After each of these loop end, an element is sorted
                        for (int i = 0; i < listMoto.size(); i++) {
                            //Loop used to access from the first unsorted element to the element before the last sorted element.
                            for (int j = 0; j < listMoto.size() - i - 1; j++) {
                                //compare two contiguous salaries
                                if (listMoto.get(j).getId().compareToIgnoreCase(listMoto.get(j + 1).getId())<0) {
                                    Motorbike temp = listMoto.get(j);
                                    listMoto.set(j, listMoto.get(j + 1));
                                    listMoto.set(j + 1, temp);
                                }
                            }
                        }
                        //loop use to access the first to last element of list
                        for (Motorbike moto : listSearchMoto){
                            System.out.println(moto);
                        }
                    }
                }
            }
        }
    }
    public void showListVehicle(){
        display.displayShow();
        display.displayShowMenu();
        int choice = Inputter.getInputInt("Enter option you want to choose: ");
        switch (choice){
            //Show all
            case 1 ->{
                System.out.println("---------- List Of Vehicle ----------");
                System.out.println("List Of Car:");
                System.out.printf("%-20s%-30s%-20s%-20s%-20s%-20s%-20s","ID","Name","Color","Price","Brand","Type","Year Of Manufacture");
                System.out.println();
                //loop use to access the first to last element of list
                for (Car car : listCar){
                    System.out.println(car);
                }
                System.out.println("List Of Vehicle:");
                System.out.printf("%-20s%-30s%-20s%-20s%-20s%-20s%-20s","ID","Name","Color","Price","Brand","Speed","License");
                System.out.println();
                //loop use to access the first to last element of list
                for (Motorbike moto : listMoto){
                    System.out.println(moto);
                }
            }
            //Show all descending by price
            case 2->{
                System.out.println("---------- List Of Vehicle ----------");
                System.out.println("List Of Car:");
                System.out.printf("%-20s%-30s%-20s%-20s%-20s%-20s%-20s","ID","Name","Color","Price","Brand","Type","Year Of Manufacture");
                System.out.println();
                //Loop used to access from the first element to the last element of list. After each of these loop end, an element is sorted
                for (int i = 0; i < listCar.size(); i++) {
                    //Loop used to access from the first unsorted element to the element before the last sorted element.
                    for (int j = 0; j < listCar.size() - i - 1; j++) {
                        //compare two contiguous salaries
                        if (listCar.get(j).getId().compareToIgnoreCase(listCar.get(j + 1).getId())<0) {
                            Car temp = listCar.get(j);
                            listCar.set(j, listCar.get(j + 1));
                            listCar.set(j + 1, temp);
                        }
                    }
                }
                //loop use to access the first to last element of list
                for (Car car : listCar){
                    System.out.println(car);
                }
                System.out.println("List Of Vehicle:");
                System.out.printf("%-20s%-30s%-20s%-20s%-20s%-20s%-20s","ID","Name","Color","Price","Brand","Speed","License");
                System.out.println();
                //Loop used to access from the first element to the last element of list. After each of these loop end, an element is sorted
                for (int i = 0; i < listMoto.size(); i++) {
                    //Loop used to access from the first unsorted element to the element before the last sorted element.
                    for (int j = 0; j < listMoto.size() - i - 1; j++) {
                        //compare two contiguous salaries
                        if (listMoto.get(j).getId().compareToIgnoreCase(listMoto.get(j + 1).getId())<0) {
                            Motorbike temp = listMoto.get(j);
                            listMoto.set(j, listMoto.get(j + 1));
                            listMoto.set(j + 1, temp);
                        }
                    }
                }
                //loop use to access the first to last element of list
                for (Motorbike moto : listMoto){
                    System.out.println(moto);
                }
            }
        }
    }
    public boolean storeDataToFile(String fileName){
        boolean check = false;
        try{
            File file = new File(fileName);
            //check file exists
            if (!file.exists()){
                check = file.createNewFile();
            }
            try(FileWriter fileWriter = new FileWriter(file)){
                //loop use to access the first to last element of list
                for (Car car : listCar){
                    fileWriter.write(car.toString()+"\n");
                }
                //loop use to access the first to last element of list
                for (Motorbike motorbike : listMoto){
                    fileWriter.write(motorbike.toString()+"\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return check;
    }
    private static final ArrayList<Vehicle> list = new ArrayList<>();
    private static final ArrayList<Car> listCar = new ArrayList<>();
    private static final ArrayList<Motorbike> listMoto = new ArrayList<>();
    private static final Display display = new Display();
}
