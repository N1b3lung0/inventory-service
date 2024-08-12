package com.n1b3lung0.inventory.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "inventories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public final class Inventory {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private final UUID id;
    @Column(name = "sku_code")
    private final String skuCode;
    @Column(name = "quantity")
    private final Integer quantity;

    public static Inventory create(
            String skuCode,
            Integer quantity
    ) {
        return new Inventory(null, skuCode, quantity);
    }
}
