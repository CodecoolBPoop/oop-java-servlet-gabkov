package com.codecool.servlet;

class Item {
    private static int id = 0;
    private int itemId;
    private String name;
    private double price;

    Item(String name, double price){
        this.itemId = ++id;
        this.name = name;
        this.price = price;
    }

    String getName() {
        return name;
    }

    double getPrice() {
        return price;
    }

}
