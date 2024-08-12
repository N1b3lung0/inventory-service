package com.n1b3lung0.inventory.controller;

import com.n1b3lung0.inventory.application.finder.InventoryFinder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inventories")
public class InventoryController {

    private final InventoryFinder finder;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> isInStock(@RequestParam String skuCode, @RequestParam Integer quantity) {
        return ResponseEntity.ok(finder.isInStock(skuCode, quantity));
    }
}
