package com.l1gr2.restaurant.reports;

import com.l1gr2.restaurant.repository.DishRepository;
import com.l1gr2.restaurant.repository.OrdersRepository;
import com.l1gr2.restaurant.repository.ProductsRepository;
import com.l1gr2.restaurant.repository.UsersRepository;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;


@Service
public class ReportService {

    UsersRepository usersRepository;
    ReportGenerator reportGenerator;
    DishRepository dishRepository;
    OrdersRepository ordersRepository;
    ProductsRepository productsRepository;

    @Autowired
    public ReportService(UsersRepository usersRepository, ReportGenerator reportGenerator, DishRepository dishRepository, OrdersRepository ordersRepository, ProductsRepository productsRepository) {
        this.usersRepository = usersRepository;
        this.reportGenerator = reportGenerator;
        this.dishRepository = dishRepository;
        this.ordersRepository = ordersRepository;
        this.productsRepository = productsRepository;
    }

    public void usersReport() throws FileNotFoundException, JRException {
        reportGenerator.generateReportUsers(usersRepository.findAll());
    }
    public void dishReport() throws FileNotFoundException, JRException {
        reportGenerator.generateReportDish(dishRepository.findAll());
    }
    public void inventoryReport() throws FileNotFoundException, JRException {
        reportGenerator.generateReportInventory(productsRepository.findAll());
    }
    public void ordersReport() throws FileNotFoundException, JRException {
        reportGenerator.generateReportOrders(ordersRepository.findAll());
    }

}
