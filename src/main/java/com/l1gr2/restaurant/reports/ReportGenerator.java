package com.l1gr2.restaurant.reports;

import com.l1gr2.restaurant.entity.Dish;
import com.l1gr2.restaurant.entity.Inventory;
import com.l1gr2.restaurant.entity.Orders;
import com.l1gr2.restaurant.entity.Users;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;
import java.util.List;

public interface ReportGenerator {
    void generateReportUsers(List<Users> users) throws JRException, FileNotFoundException;
    void generateReportDish(List<Dish> users) throws JRException, FileNotFoundException;
    void generateReportInventory(List<Inventory> users) throws JRException, FileNotFoundException;
    void generateReportOrders(List<Orders> users) throws JRException, FileNotFoundException;
}
