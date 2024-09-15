package org.khatep.lovelypets.repositories;

import org.khatep.lovelypets.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
