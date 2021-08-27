package net.etfbl.ip.ipspringbackend.repositories;

import net.etfbl.ip.ipspringbackend.models.entities.PutnickiletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;

@Repository
public interface PutnickiletEntityRepository extends JpaRepository<PutnickiletEntity, Integer> {


}
