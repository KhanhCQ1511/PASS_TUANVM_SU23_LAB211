package GUI;

import DTO.Asset;
import DTO.Borrow;
import DTO.Employee;
import DTO.Request;

import java.util.ArrayList;

public class AssetManagement {
    public void loadDataFromFile() {
        loadData.loadDataFromEmployee("D:\\PASS TUANVM SU23\\PASS_TUANVM_SU23\\_14_AssetManagement\\src\\FILE\\employee.dat", listEmployee);
        loadData.loadDataFromAsset("D:\\PASS TUANVM SU23\\PASS_TUANVM_SU23\\_14_AssetManagement\\src\\FILE\\the asset.dat", listAsset);
        loadData.loadDataFromBorrow("D:\\PASS TUANVM SU23\\PASS_TUANVM_SU23\\_14_AssetManagement\\src\\FILE\\borrow.dat", listBorrow);
        loadData.loadDataFromRequest("D:\\PASS TUANVM SU23\\PASS_TUANVM_SU23\\_14_AssetManagement\\src\\FILE\\request.dat", listRequest);
    }

    public boolean loginProgram() {
        display.displayLogin();
        // Enter employee ID and password manually
        String enteredEmployeeID = Inputter.getInputString("Enter employee ID: ", "");
        String enteredPassword = Inputter.getInputString("Enter password: ", "");
        // Check if entered credentials match any employee in the list
        boolean loginSuccessful = false;
        //loop access the first to the last element of listEmployee
        for (Employee employee : listEmployee) {
            //check EmployeeID and password valid
            if (enteredEmployeeID.equalsIgnoreCase(employee.getEmployID()) &&
                    enteredPassword.equals(employee.getPassword())) {
                loginSuccessful = true;
                break;
            }
        }
        //Check login successfully
        if (loginSuccessful) {
            System.out.println("LOGIN SUCCESSFULLY!");
            return true;
        } else {
            System.out.println("ERROR EMPLOYEE ID OR PASSWORD!");
            return false;
        }
    }

    public void searchAssetByName() {
        display.displaySearch();
        String assetName = Inputter.getInputString("Enter asset want to search: ", "");
        System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s","AssetID","name","color","price","weight","quantity");
        System.out.println();
        //loop access the first to the last element of list Asset
        for (Asset asset : listAsset) {
            //Check assetName valid
            if (assetName.equalsIgnoreCase(asset.getName())) {
                System.out.println(asset);
            }
        }
    }

    public void createNewAsset() {
        display.displayCreate();
        String newAssetID = Inputter.getInputString("Enter new asset ID: ", "");
        boolean idExist = false;
        //loop to access the first to last element of array
        for (Asset asset : listAsset) {
            //check newAssetID equals ID in list
            if (asset.getAssetID().equalsIgnoreCase(newAssetID)) {
                System.out.println("Asset with id " + newAssetID + " already exist!");
                idExist = true;
                break;
            }
        }
        //check idExist is not false
        if (!idExist) {
            String name = Inputter.getInputString("Enter new asset name: ", "");
            String color = Inputter.getInputString("Enter new asset color: ", "");
            double price = Inputter.getInputDouble("Enter new asset price: ");
            double weight = Inputter.getInputDouble("Enter new asset weight: ");
            int quantity = Inputter.getInputInt("Enter new asset quantity: ");
            Asset newAsset = new Asset(newAssetID, name, color, price, weight, quantity);
            listAsset.add(newAsset);
            System.out.println("Adđ asset successfully!");
            //Save to file
            storeData.storeAssetToFile("D:\\PASS TUANVM SU23\\PASS_TUANVM_SU23\\_14_AssetManagement\\src\\FILE\\the asset.dat", listAsset);
        }
    }

    public void updateAssetInfo() {
        display.displayUpdate();
        String updateAssetID = Inputter.getInputString("Enter update asset ID: ", "");
        boolean found = false;
        //loop use to access the first to last element of list
        for (Asset asset : listAsset) {
            //Check update asset ID equals ID in list
            if (asset.getAssetID().equalsIgnoreCase(updateAssetID)) {
                found = true;
                String newAssetID = Inputter.getInputString("Enter new asset ID for update: ", "");
                //Check new asset ID equals other ID in list
                if (!asset.getAssetID().equalsIgnoreCase(newAssetID)) {
                    boolean idExist = false;
                    //loop use to access the first to the last element of lists
                    for (Asset asset1 : listAsset) {
                        //Check new asset ID equals id in list
                        if (asset1.getAssetID().equalsIgnoreCase(newAssetID)) {
                            System.out.println("Asset with new ID " + newAssetID + " already exist");
                            idExist = true;
                            break;
                        }
                    }
                    //Check id exist
                    if (idExist) {
                        continue;
                    }
                }
                //Confirm update information
                String confirmUpdate = Inputter.getInputString("Do you want to update asset information?(Y/N): ", "^(Y|N)$");
                //Check confirm update equals Y
                if (confirmUpdate.equalsIgnoreCase("Y")) {
                    String newAssetName = Inputter.getInputString("Enter new asset name for update: ", "");
                    String newAssetColor = Inputter.getInputString("Enter new asset color for  update: ", "");
                    double newAssetPrice = Inputter.getInputDouble("Enter new asset price for update: ");
                    double newAssetWeight = Inputter.getInputDouble("Enter new asset weight for update:  ");
                    int newAssetQuantity = Inputter.getInputInt("Enter new asset quantity for update: ");
                    asset.setName(newAssetName);
                    asset.setColor(newAssetColor);
                    asset.setPrice(newAssetPrice);
                    asset.setWeight(newAssetWeight);
                    asset.setAssetQuantity(newAssetQuantity);
                }
                asset.setAssetID(newAssetID);
                System.out.println("Update successfully!");
            }
        }
        //check found is false
        if (!found) {
            System.out.println("Asset does not exist!");
        }
        //Save to file
        storeData.storeAssetToFile("D:\\PASS TUANVM SU23\\PASS_TUANVM_SU23\\_14_AssetManagement\\src\\FILE\\the asset.dat", listAsset);
    }

    public void approveRequestEmployee() {
        String assetID = "";
        int assetQuantity = 0;
        int borrowQuantity = 0;
        int requestQuantity = 0;
        int inventoryAsset = 0;
        String employeeID = "";
        String requestDateTime = "";
        int newAssetQuantity = 0;
        display.displayApprove();
        System.out.format("%-20s%-20s%-20s%-20s%-20s", "bID", "assetID", "employeeID", "quantity", "requestDateTime");
        System.out.println();
        //loop use to access the first to the last element of list
        for (Borrow borrow : listBorrow) {
            System.out.println(borrow.toString());
        }
        String requestID = Inputter.getInputString("Enter request ID want to approve: ", "");
        for (Request request : listRequest) {
            //Check request ID equals ID in list request
            if (request.getRID().equalsIgnoreCase(requestID)) {
                assetID = getDataInList.findAssetIDByRequestID(listRequest, requestID);
                borrowQuantity += getDataInList.findBorrowQuantityByID(listBorrow, assetID);
                requestQuantity = request.getQuantity();
                employeeID = request.getEmployeeID();
                requestDateTime = request.getRequestDateTime();
            }
        }
        assetQuantity = getDataInList.findAssetQuantityByID(listAsset,assetID);
        //Inventory Asset
        inventoryAsset = assetQuantity -  borrowQuantity;
        //Check inventory asset bigger than quantity request
        if (inventoryAsset>=requestQuantity){
            String borrowID = Inputter.getInputString("Enter new borrow ID: ","");
            Borrow newBorrow = new Borrow(borrowID,assetID,employeeID,borrowQuantity,requestDateTime);
            listBorrow.add(newBorrow);
            storeData.storeBorrowToFile("D:\\PASS TUANVM SU23\\PASS_TUANVM_SU23\\_14_AssetManagement\\src\\FILE\\borrow.dat",listBorrow);
            Request oldRequest = new Request(requestID,assetID,employeeID,requestQuantity,requestDateTime);
            listRequest.remove(oldRequest);
            storeData.storeRequestToFile("D:\\PASS TUANVM SU23\\PASS_TUANVM_SU23\\_14_AssetManagement\\src\\FILE\\request.dat",listRequest);
            newAssetQuantity = assetQuantity - requestQuantity;
            //loop use to access the first to the last element of list
            for (Asset asset : listAsset){
                //Check asset id equals assetID
                if (asset.getAssetID().equalsIgnoreCase(assetID)){
                    asset.setAssetQuantity(newAssetQuantity);
                }
            }
            storeData.storeAssetToFile("D:\\PASS TUANVM SU23\\PASS_TUANVM_SU23\\_14_AssetManagement\\src\\FILE\\the asset.dat",listAsset);
            System.out.println("Borrow successfully!");
        } else {
            System.out.println("The assets have run out");
        }
    }

    public void showListOfBorrowAsset() {
        System.out.format("%-20s%-20s%-20s%-20s%-20s", "bID", "assetID", "employeeID", "quantity", "requestDateTime");
        System.out.println();
        //loop  use to access the first to the last element of list
        for (Borrow borrow : listBorrow){
            System.out.println(borrow.toString());
        }
    }
    private final Display display = new Display();
    private final StoreData storeData = new StoreData();
    private final LoadData loadData = new LoadData();
    private final GetDataInList getDataInList = new GetDataInList();
    private final ArrayList<Employee> listEmployee = new ArrayList<>();
    private final ArrayList<Asset> listAsset = new ArrayList<>();
    private final ArrayList<Borrow> listBorrow = new ArrayList<>();
    private final ArrayList<Request> listRequest = new ArrayList<>();
}
