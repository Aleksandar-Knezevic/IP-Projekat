package net.etfbl.ip.ipspringbackend.repositories;


import net.etfbl.ip.ipspringbackend.models.entities.RezervacijateretnogletaEntity;
import net.etfbl.ip.ipspringbackend.models.entities.RezervacijateretnogletaEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RezervacijateretnogletaEntityRepository extends JpaRepository<RezervacijateretnogletaEntity, RezervacijateretnogletaEntityPK> {
}
