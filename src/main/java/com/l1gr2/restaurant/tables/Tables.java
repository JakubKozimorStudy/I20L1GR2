package com.l1gr2.restaurant.tables;

import com.l1gr2.restaurant.entity.Dish;

import java.util.ArrayList;
import java.util.List;

public class Tables {

    public static int actualTable;

    public static List<Dish> table1 = new ArrayList<>();
    public static List<Dish> table2 = new ArrayList<>();
    public static List<Dish> table3 = new ArrayList<>();
    public static List<Dish> table4 = new ArrayList<>();
    public static List<Dish> table5 = new ArrayList<>();
    public static List<Dish> table6 = new ArrayList<>();
    public static List<Dish> table7 = new ArrayList<>();
    public static List<Dish> table8 = new ArrayList<>();
    public static List<Dish> table9 = new ArrayList<>();


    public static List<Dish> getActualTable(){
        switch(actualTable){
            case 1: return table1;
            case 2: return table2;
            case 3: return table3;
            case 4: return table4;
            case 5: return table5;
            case 6: return table6;
            case 7: return table7;
            case 8: return table8;
            case 9: return table9;
            default: return table1;
        }
    }
}
