package DTO;

import java.util.Date;

public class Employee {
    private String employID;
    private String name;
    private Date birthdate;
    private String role;
    private String sex;
    private String password;

    public Employee() {
    }

    public Employee(String employID, String name, Date birthdate, String role, String sex, String password) {
        this.employID = employID;
        this.name = name;
        this.birthdate = birthdate;
        this.role = role;
        this.sex = sex;
        this.password = password;
    }

    public String getEmployID() {
        return employID;
    }

    public void setEmployID(String employID) {
        this.employID = employID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
