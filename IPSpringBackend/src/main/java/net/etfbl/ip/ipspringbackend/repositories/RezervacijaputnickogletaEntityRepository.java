package net.etfbl.ip.ipspringbackend.repositories;


import net.etfbl.ip.ipspringbackend.models.entities.RezervacijaputnickogletaEntity;
import net.etfbl.ip.ipspringbackend.models.entities.RezervacijaputnickogletaEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RezervacijaputnickogletaEntityRepository extends JpaRepository<RezervacijaputnickogletaEntity, RezervacijaputnickogletaEntityPK> {
}
