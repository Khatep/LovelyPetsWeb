package org.khatep.lovelypets.repositories;

import org.khatep.lovelypets.models.ActionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionLogRepository extends JpaRepository<ActionLog, Long> {
}