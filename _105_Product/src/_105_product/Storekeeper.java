/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _105_product;

/**
 *
 * @author khanh
 */
public class Storekeeper {
    private int storekeeperID;
    private String storekeeperName;

    public Storekeeper() {
    }

    public Storekeeper(int storekeeperID, String storekeeperName) {
        this.storekeeperID = storekeeperID;
        this.storekeeperName = storekeeperName;
    }
    
    public Storekeeper(Storekeeper other) {
        this.storekeeperID = other.storekeeperID;
        this.storekeeperName = other.storekeeperName;
    }

    public int getStorekeeperID() {
        return storekeeperID;
    }

    public void setStorekeeperID(int storekeeperID) {
        this.storekeeperID = storekeeperID;
    }

    public String getStorekeeperName() {
        return storekeeperName;
    }

    public void setStorekeeperName(String storekeeperName) {
        this.storekeeperName = storekeeperName;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-20s", storekeeperID,storekeeperName);
    }
    
}
