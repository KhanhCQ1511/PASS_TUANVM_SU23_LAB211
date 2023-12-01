package GUI;

import DTO.Asset;
import DTO.Borrow;
import DTO.Request;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StoreData {
    public void storeAssetToFile(String fileName, ArrayList<Asset> listAsset){
        try{
            File file = new File(fileName);
            //Check file is exits
            if (!file.exists()){
                file.createNewFile();
            }
            try(FileWriter fileWriter =  new FileWriter(file)) {
                //loop to access the first to last element of list
                for (Asset asset : listAsset){
                    fileWriter.write(asset.getAssetID()+","+asset.getName()+","+asset.getColor()+","+asset.getPrice()+","
                            +asset.getWeight()+","+asset.getAssetQuantity()+"\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void storeBorrowToFile(String fileName, ArrayList<Borrow> listBorrow){
        try{
            File file = new File(fileName);
            //Check file is exits
            if (!file.exists()){
                file.createNewFile();
            }
            try(FileWriter fileWriter =  new FileWriter(file)) {
                //loop to access the first to last element of list
                for (Borrow borrow : listBorrow){
                    fileWriter.write(borrow.getBID()+","+borrow.getAssetID()+","+borrow.getEmployeeID()+","+borrow.getQuantity()+","
                            +borrow.getBorrowDateTime()+"\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void storeRequestToFile(String fileName, ArrayList<Request> listRequest){
        try{
            File file = new File(fileName);
            //Check file is exits
            if (!file.exists()){
                file.createNewFile();
            }
            try(FileWriter fileWriter =  new FileWriter(file)) {
                //loop to access the first to last element of list
                for (Request request : listRequest){
                    fileWriter.write(request.getRID()+","+request.getAssetID()+","+request.getEmployeeID()+","+request.getQuantity()+","
                            +request.getRequestDateTime()+"\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
