package com.codecool.servlet;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class ItemStore {
    private static List<Item> availableItems = new ArrayList<>();

    private static List<Item> itemList = new ArrayList<>();

    public static void addToAvailable(Item item){
        availableItems.add(item);
    }

    public static void add(Item item){
        itemList.add(item);
    }

    public static void remove(Item item){
        itemList.remove(item);
    }

    public static List<Item> getAvailableItems() {
        return availableItems;
    }

    public static List<Item> getItemList() {
        return itemList;
    }

    public static double getSumPrice(){
        DoubleSummaryStatistics stats = itemList.stream().mapToDouble((x) -> x.getPrice()).summaryStatistics();
        return stats.getSum();
    }
}
