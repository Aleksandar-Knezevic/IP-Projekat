package net.etfbl.ip.ipspringbackend.repositories;

import net.etfbl.ip.ipspringbackend.models.entities.ZaposleniEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ZaposleniEntityRepository extends JpaRepository<ZaposleniEntity, Integer> {

    Optional<ZaposleniEntity> findByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka);
}
