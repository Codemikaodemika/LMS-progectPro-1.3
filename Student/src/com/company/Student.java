package com.company;

public class Student {
    Student(){
        this.surname = "Иванов " + Integer.toString((int)(Math.random() * 1000));
        this.initials = "И.И. " + Integer.toString((int)(Math.random() * 1000));
        this.groupNumber = (int)(Math.random() * 1000);
        for (int i = 0; i < this.marks.length; i++)
            marks[i] = (int)(Math.random() * 4) + 2;
    }

    public void print(){
        System.out.println("------------------------------------------");
        System.out.println(this.surname + " " + this.initials + " group: " + this.groupNumber);
        for (int mark: this.marks)
            System.out.print(mark + ", ");
        System.out.println();
    }

    String surname;
    String initials;
    int groupNumber;
    int[] marks = new int[5];
}