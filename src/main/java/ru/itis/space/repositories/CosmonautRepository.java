package ru.itis.space.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.space.entires.models.DatabaseRecord;

public interface CosmonautRepository extends JpaRepository<DatabaseRecord, Long> {
}
