package net.etfbl.ip.ipspringbackend.controllers;

import net.etfbl.ip.ipspringbackend.models.RezervacijaKeyModel;
import net.etfbl.ip.ipspringbackend.models.entities.PutnickiletEntity;
import net.etfbl.ip.ipspringbackend.models.entities.RezervacijateretnogletaEntity;
import net.etfbl.ip.ipspringbackend.models.entities.RezervacijateretnogletaEntityPK;
import net.etfbl.ip.ipspringbackend.models.entities.TeretniletEntity;
import net.etfbl.ip.ipspringbackend.repositories.RezervacijateretnogletaEntityRepository;
import net.etfbl.ip.ipspringbackend.repositories.TeretniletEntityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin()
@RequestMapping("/teretne-rezervacije")
public class RezervacijateretnogletaController {

    private final RezervacijateretnogletaEntityRepository rezervacijateretnogletaEntityRepository;
    private final TeretniletEntityRepository teretniletEntityRepository;

    public RezervacijateretnogletaController(RezervacijateretnogletaEntityRepository rezervacijateretnogletaEntityRepository, TeretniletEntityRepository teretniletEntityRepository) {
        this.rezervacijateretnogletaEntityRepository = rezervacijateretnogletaEntityRepository;
        this.teretniletEntityRepository = teretniletEntityRepository;
    }

    @GetMapping
    public ResponseEntity<List<RezervacijateretnogletaEntity>> getAll()
    {
        return ResponseEntity.ok(rezervacijateretnogletaEntityRepository.findAll());
    }

    @GetMapping("/{status}")
    public ResponseEntity<List<RezervacijateretnogletaEntity>> getByStatus(@PathVariable String status)
    {
        return ResponseEntity.ok(rezervacijateretnogletaEntityRepository.findAll().stream().filter(e -> e.getStatus().equals(status)).collect(Collectors.toList()));
    }

    @PutMapping("/accept")
    public ResponseEntity accept(@RequestBody RezervacijaKeyModel rezervacijaKeyModel)
    {
        RezervacijateretnogletaEntity rezervacijateretnogletaEntity = rezervacijateretnogletaEntityRepository.getOne(new RezervacijateretnogletaEntityPK(rezervacijaKeyModel.getKorisnikId(), rezervacijaKeyModel.getLetId()));
        rezervacijateretnogletaEntity.setStatus("Prihvacena");
        rezervacijateretnogletaEntityRepository.save(rezervacijateretnogletaEntity);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/decline")
    public ResponseEntity decline(@RequestBody RezervacijaKeyModel rezervacijaKeyModel)
    {
        RezervacijateretnogletaEntity rezervacijateretnogletaEntity = rezervacijateretnogletaEntityRepository.getOne(new RezervacijateretnogletaEntityPK(rezervacijaKeyModel.getKorisnikId(), rezervacijaKeyModel.getLetId()));
        rezervacijateretnogletaEntity.setStatus("Ponistena");
        rezervacijateretnogletaEntity.setRazlogPonistavanja(rezervacijaKeyModel.getRazlogPonistavanja());
        TeretniletEntity tl = teretniletEntityRepository.getOne(rezervacijateretnogletaEntity.getTeretniLetId());
        tl.setOpisTereta(null);
        teretniletEntityRepository.save(tl);
        rezervacijateretnogletaEntityRepository.save(rezervacijateretnogletaEntity);
        return ResponseEntity.ok().build();
    }
}
