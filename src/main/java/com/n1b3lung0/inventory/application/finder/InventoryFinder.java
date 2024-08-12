package com.n1b3lung0.inventory.application.finder;

import com.n1b3lung0.inventory.domain.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryFinder {

    private final InventoryRepository repository;
    public boolean isInStock(String skuCode, Integer quantity) {
        return repository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
    }
}
