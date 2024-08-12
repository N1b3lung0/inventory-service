package com.n1b3lung0.inventory.infrastructure;

import com.n1b3lung0.inventory.domain.Inventory;
import com.n1b3lung0.inventory.domain.InventoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InventoryJPARepository extends InventoryRepository, JpaRepository<Inventory, UUID> {
}
