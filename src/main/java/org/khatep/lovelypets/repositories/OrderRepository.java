package org.khatep.lovelypets.repositories;

import org.khatep.lovelypets.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}