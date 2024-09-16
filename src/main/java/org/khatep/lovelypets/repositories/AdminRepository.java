package org.khatep.lovelypets.repositories;

import org.khatep.lovelypets.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}