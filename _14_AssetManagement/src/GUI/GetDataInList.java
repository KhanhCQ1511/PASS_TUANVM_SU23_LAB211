package GUI;

import DTO.Asset;
import DTO.Borrow;
import DTO.Request;

import java.util.ArrayList;

public class GetDataInList {
    public int findAssetQuantityByID(ArrayList<Asset> listAsset, String ID){
        //loop use to access the first to the last element of list
        for (Asset asset : listAsset){
            //Check asset ID equals ID
            if (asset.getAssetID().equalsIgnoreCase(ID)){
                return asset.getAssetQuantity();
            }
        }
        return 0;
    }
    public int findBorrowQuantityByID(ArrayList<Borrow> listBorrow, String ID){
        int borrowQuantity=0;
        //loop use to access the first to the last element of list
        for (Borrow borrow : listBorrow){
            //Check assetID equals ID
            if (borrow.getAssetID().equalsIgnoreCase(ID)){
                borrowQuantity+=borrow.getQuantity();
            }
        }
        return borrowQuantity;
    }
    public String findAssetIDByRequestID(ArrayList<Request> list, String ID){
        //loop use to access the first to the last element of list
        for (Request request : list){
            //check id equals request id in list
            if (request.getRID().equalsIgnoreCase(ID)){
                return request.getAssetID();
            }
        }
        return null;
    }
}
