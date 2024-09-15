package org.khatep.lovelypets.repositories;

import org.khatep.lovelypets.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}