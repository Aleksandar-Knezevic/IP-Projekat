package net.etfbl.ip.ipspringbackend.repositories;

import net.etfbl.ip.ipspringbackend.models.entities.GradEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradEntityRepository extends JpaRepository<GradEntity, Integer> {
}
