package DTO;

public class Asset {
    private String assetID;
    private String name;
    private String color;
    private double price;
    private double weight;
    private int assetQuantity;

    public Asset() {
    }

    public Asset(String assetID) {
        this.assetID = assetID;
    }

    public Asset(String assetID, String name, String color, double price, double weight, int assetQuantity){
        this.assetID = assetID;
        this.name = name;
        this.color = color;
        this.price = price;
        this.weight = weight;
        this.assetQuantity = assetQuantity;
    }

    public String getAssetID() {
        return assetID;
    }

    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAssetQuantity() {
        return assetQuantity;
    }

    public void setAssetQuantity(int assetQuantity) {
        this.assetQuantity = assetQuantity;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-20s%-20s%-20.2f%-20.2f%-20d",getAssetID(),getName(),getColor(),getPrice(),getWeight(),getAssetQuantity());
    }
}
