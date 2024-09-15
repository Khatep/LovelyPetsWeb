package org.khatep.lovelypets.repositories;

import org.khatep.lovelypets.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}