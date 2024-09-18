package org.khatep.lovelypets.repositories;

import org.khatep.lovelypets.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
