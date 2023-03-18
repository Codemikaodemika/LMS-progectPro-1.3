package com.company;
public class Point {
    private int x, y;
    Point(int pointX, int pointY){
        setPosition(pointX, pointY);
        this.print();
    }
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void print(){
        System.out.println("Point(" + this.x + ", " + this.y + ")");
    }
    public double distance(Point p){
         return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
    }
}