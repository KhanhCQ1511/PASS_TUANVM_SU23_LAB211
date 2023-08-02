/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _105_product;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author khanh
 */
public class Product{

    private int productId;
    private String productName;
    private String location;
    private int price;
    private Date expiryDate;
    private Date dateOfManufacture;
    private String category;
    private Storekeeper storekeeper;
    private Date receiptDate;

    public Product() {
    }

    public Product(int productId, String productName, String location, int price,
            Date expiryDate, Date dateOfManufacture, String category, Storekeeper storekeeper, Date receiptDate) {
        this.productId = productId;
        this.productName = productName;
        this.location = location;
        this.price = price;
        this.expiryDate = expiryDate;
        this.dateOfManufacture = dateOfManufacture;
        this.category = category;
        this.storekeeper = storekeeper;
        this.receiptDate = receiptDate;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufature(Date dateOfManufature) {
        this.dateOfManufacture = dateOfManufature;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Storekeeper getStorekeeper() {
        return storekeeper;
    }

    public void setStorekeeper(Storekeeper storekeeper) {
        this.storekeeper = storekeeper;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }
    
    Storekeeper st = new Storekeeper();
    
    @Override
    public String toString() {
        Format fomatter = new SimpleDateFormat("dd/MM/yyyy");
        String newExpiryDate = fomatter.format(this.expiryDate);
        String newDateOfManufacture = fomatter.format(this.dateOfManufacture);
        String newReceiptDate = fomatter.format(this.receiptDate);
        return String.format("%-20d%-20s%-20s%-20d%-20s%-25s%-20s%-20s%-20s%-20s",
                productId, productName, location, price, newExpiryDate, newDateOfManufacture,category,st.getStorekeeperID(),
                st.getStorekeeperName() , newReceiptDate);
    }

}
