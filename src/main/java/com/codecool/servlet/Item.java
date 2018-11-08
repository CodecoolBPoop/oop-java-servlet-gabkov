package com.codecool.servlet;

public class Item {
    private static int id = 0;

    private int itemId;
    private String name;
    private double price;

    Item(String name, double price){
        this.itemId = ++id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}
