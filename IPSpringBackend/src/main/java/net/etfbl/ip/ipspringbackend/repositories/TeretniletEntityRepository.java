package net.etfbl.ip.ipspringbackend.repositories;

import net.etfbl.ip.ipspringbackend.models.entities.TeretniletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeretniletEntityRepository extends JpaRepository<TeretniletEntity, Integer>
{
}
