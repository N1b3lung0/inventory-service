package com.n1b3lung0.inventory.domain;

public interface InventoryRepository {
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, Integer quantity);
}
