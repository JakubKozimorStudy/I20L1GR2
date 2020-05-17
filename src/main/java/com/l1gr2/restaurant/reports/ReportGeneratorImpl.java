package com.l1gr2.restaurant.reports;

import com.l1gr2.restaurant.entity.Dish;
import com.l1gr2.restaurant.entity.Inventory;
import com.l1gr2.restaurant.entity.Orders;
import com.l1gr2.restaurant.entity.Users;
import net.sf.jasperreports.engine.JRException;
import org.springframework.stereotype.Service;
import reports.DishReport;
import reports.InventoryReport;
import reports.OrdersReport;
import reports.UsersReport;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

@Service
public class ReportGeneratorImpl implements ReportGenerator {

    @Override
    public void generateReportUsers(List<Users> users) throws JRException, FileNotFoundException {
        UsersTypeMapper usersTypeMapper = new UsersTypeMapper();
        List<reports.Users> usersToReports = usersTypeMapper.getUsersToReports(users);
        UsersReport usersReport = new UsersReport();
        usersReport.exportReport(usersToReports, new FileInputStream("src\\main\\resources\\report-templates\\users.jrfxml"));
    }

    @Override
    public void generateReportDish(List<Dish> dishes) throws JRException, FileNotFoundException {
        DishTypeMapper dishTypeMapper = new DishTypeMapper();
        List<reports.Dish> dishesToReports = dishTypeMapper.getDishesToReports(dishes);
        DishReport dishReport = new DishReport();
        dishReport.exportReport(dishesToReports, new FileInputStream("src\\main\\resources\\report-templates\\dishes.jrfxml"));
    }

    @Override
    public void generateReportInventory(List<Inventory> inventory) throws JRException, FileNotFoundException {
        InventoryTypeMapper inventoryTypeMapper = new InventoryTypeMapper();
        List<reports.Inventory> inventoryToReports = inventoryTypeMapper.getInventoryToReports(inventory);
        InventoryReport inventoryReport = new InventoryReport();
        inventoryReport.exportReport(inventoryToReports, new FileInputStream("src\\main\\resources\\report-templates\\inventory.jrfxml"));
    }

    @Override
    public void generateReportOrders(List<Orders> orders) throws JRException, FileNotFoundException {
        OrdersTypeMapper ordersTypeMapper = new OrdersTypeMapper();
        List<reports.Orders> ordersToReports = ordersTypeMapper.getOrdersToReports(orders);
        OrdersReport ordersReport = new OrdersReport();
        ordersReport.exportReport(ordersToReports, new FileInputStream("src\\main\\resources\\report-templates\\orders.jrfxml"));
    }
}
