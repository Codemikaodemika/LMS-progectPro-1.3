package com.company;

public class Cylinder extends Circle{
    private int height;
    Cylinder(int pointX, int pointY, int raduis, int height){
        super(pointX, pointY, raduis);
        setHeight(height);
        this.print();
    }
    public void setHeight(int height){
        if (height > 0){
            this.height = height;
        } else {
            System.out.println("Error change height...");
        }
    }
    public void print(){
        System.out.print("Cylinder, height = " + this.height + ", ");
        super.print();
    }
}
