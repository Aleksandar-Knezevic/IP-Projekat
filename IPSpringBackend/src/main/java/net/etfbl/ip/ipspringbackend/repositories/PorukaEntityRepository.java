package net.etfbl.ip.ipspringbackend.repositories;


import net.etfbl.ip.ipspringbackend.models.entities.PorukaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PorukaEntityRepository extends JpaRepository<PorukaEntity, Integer> {

}
