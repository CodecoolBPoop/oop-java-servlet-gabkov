package com.codecool.servlet;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

class ItemStore {
    private static List<Item> availableItems = new ArrayList<>();

    private static List<Item> itemList = new ArrayList<>();

    static void addToAvailable(Item item){
        availableItems.add(item);
    }

    static void add(String itemName){
        for(Item item : availableItems){
            if(item.getName().equals(itemName)){
                itemList.add(item);
            }
        }
    }

    static void remove(String itemName){
        for(Item item : availableItems){
            if(item.getName().equals(itemName)){
                itemList.remove(item);
            }
        }
    }

    static List<Item> getAvailableItems() {
        return availableItems;
    }

    static List<Item> getItemList() {
        return itemList;
    }

    static double getSumPrice(){
        DoubleSummaryStatistics stats = itemList.stream().mapToDouble((x) -> x.getPrice()).summaryStatistics();
        return stats.getSum();
    }
}
