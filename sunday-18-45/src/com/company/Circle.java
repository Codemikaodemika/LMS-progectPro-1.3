package com.company;

public class Circle extends Point{
    private int r;
    Circle(int pointX, int pointY, int radius){
        super(pointX, pointY);
        setRaduis(radius);
        this.print();
    }
    public void setRaduis(int radius){
        if (radius > 0){
            this.r = radius;
        } else {
            System.out.println("Error change raduis...");
        }
    }
    public int getR(){return this.r;}
    public boolean crossing(Circle c){
        return this.getR() + c.getR() <= this.distance(c);
    }
    public void print(){
        System.out.print("Circle, Radius = " + this.r + ", ");
        super.print();
    }
}