package net.etfbl.ip.ipspringbackend.controllers;

import net.etfbl.ip.ipspringbackend.models.RezervacijaKeyModel;
import net.etfbl.ip.ipspringbackend.models.entities.RezervacijateretnogletaEntity;
import net.etfbl.ip.ipspringbackend.models.entities.RezervacijateretnogletaEntityPK;
import net.etfbl.ip.ipspringbackend.repositories.RezervacijateretnogletaEntityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teretne-rezervacije")
public class RezervacijateretnogletaController {

    private final RezervacijateretnogletaEntityRepository rezervacijateretnogletaEntityRepository;

    public RezervacijateretnogletaController(RezervacijateretnogletaEntityRepository rezervacijateretnogletaEntityRepository) {
        this.rezervacijateretnogletaEntityRepository = rezervacijateretnogletaEntityRepository;
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
        rezervacijateretnogletaEntity.setStatus("Odobrena");
        rezervacijateretnogletaEntityRepository.save(rezervacijateretnogletaEntity);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/decline")
    public ResponseEntity decline(@RequestBody RezervacijaKeyModel rezervacijaKeyModel)
    {
        RezervacijateretnogletaEntity rezervacijateretnogletaEntity = rezervacijateretnogletaEntityRepository.getOne(new RezervacijateretnogletaEntityPK(rezervacijaKeyModel.getKorisnikId(), rezervacijaKeyModel.getLetId()));
        rezervacijateretnogletaEntity.setStatus("Odbijena");
        rezervacijateretnogletaEntity.setRazlogPonistavanja(rezervacijaKeyModel.getRazlogPonistavanja());
        rezervacijateretnogletaEntityRepository.save(rezervacijateretnogletaEntity);
        return ResponseEntity.ok().build();
    }
}
