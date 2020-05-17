package com.l1gr2.restaurant.reports;

import reports.Inventory;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryTypeMapper {
    public List<Inventory> getInventoryToReports(List<com.l1gr2.restaurant.entity.Inventory> inventory) {
        return inventory.stream()
                .map(inventoryTemp -> new reports.Inventory(inventoryTemp.getProduct_name(), inventoryTemp.getProduct_quantity(), inventoryTemp.getProduct_price()))
                .collect(Collectors.toList());
    }
}
