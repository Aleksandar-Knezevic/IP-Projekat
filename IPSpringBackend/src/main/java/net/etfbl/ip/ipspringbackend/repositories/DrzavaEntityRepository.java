package net.etfbl.ip.ipspringbackend.repositories;

import net.etfbl.ip.ipspringbackend.models.entities.DrzavaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrzavaEntityRepository extends JpaRepository<DrzavaEntity, Integer> {
}
