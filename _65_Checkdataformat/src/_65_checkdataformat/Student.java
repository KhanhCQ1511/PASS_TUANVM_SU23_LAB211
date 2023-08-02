/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _65_checkdataformat;

/**
 *
 * @author khanh
 */
public class Student {
    private String name;
    private String classes;
    private double maths;
    private double chemistry;
    private double physics;
    private double average;
    private String type;

    public Student() {
    }

    public Student(String name, String classes, double maths, double chemistry, double physics, double average, String type) {
        this.name = name;
        this.classes = classes;
        this.maths = maths;
        this.chemistry = chemistry;
        this.physics = physics;
        this.average = average;
        this.type = type;
    }
    public Student(String name, String classes, double maths, double chemistry, double physics) {
        this.name = name;
        this.classes = classes;
        this.maths = maths;
        this.chemistry = chemistry;
        this.physics = physics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public double getMaths() {
        return maths;
    }

    public void setMaths(double maths) {
        this.maths = maths;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    public double getPhysics() {
        return physics;
    }

    public void setPhysics(double physics) {
        this.physics = physics;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
