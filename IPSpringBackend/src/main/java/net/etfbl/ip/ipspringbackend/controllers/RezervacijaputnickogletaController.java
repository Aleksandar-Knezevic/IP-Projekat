package net.etfbl.ip.ipspringbackend.controllers;

import net.etfbl.ip.ipspringbackend.models.RezervacijaKeyModel;
import net.etfbl.ip.ipspringbackend.models.entities.PutnickiletEntity;
import net.etfbl.ip.ipspringbackend.models.entities.RezervacijaputnickogletaEntity;
import net.etfbl.ip.ipspringbackend.models.entities.RezervacijaputnickogletaEntityPK;
import net.etfbl.ip.ipspringbackend.repositories.PutnickiletEntityRepository;
import net.etfbl.ip.ipspringbackend.repositories.RezervacijaputnickogletaEntityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin()
@RequestMapping("putnicke-rezervacije")
public class RezervacijaputnickogletaController {

    private final RezervacijaputnickogletaEntityRepository rezervacijaputnickogletaEntityRepository;
    private final PutnickiletEntityRepository putnickiletEntityRepository;

    public RezervacijaputnickogletaController(RezervacijaputnickogletaEntityRepository rezervacijaputnickogletaEntityRepository, PutnickiletEntityRepository putnickiletEntityRepository) {
        this.rezervacijaputnickogletaEntityRepository = rezervacijaputnickogletaEntityRepository;
        this.putnickiletEntityRepository = putnickiletEntityRepository;
    }

    @GetMapping
    public ResponseEntity<List<RezervacijaputnickogletaEntity>> getAll()
    {
        return ResponseEntity.ok(rezervacijaputnickogletaEntityRepository.findAll());
    }

    @GetMapping("/{status}")
    public ResponseEntity<List<RezervacijaputnickogletaEntity>> getByStatus(@PathVariable String status)
    {
        return ResponseEntity.ok(rezervacijaputnickogletaEntityRepository.findAll().stream().filter(e -> e.getStatus().equals(status)).collect(Collectors.toList()));
    }

    @PutMapping("/accept")
    public ResponseEntity accept(@RequestBody RezervacijaKeyModel model)
    {
        RezervacijaputnickogletaEntity rezervacijaputnickogletaEntity = rezervacijaputnickogletaEntityRepository.getOne(new RezervacijaputnickogletaEntityPK(model.getLetId(), model.getKorisnikId()));
        rezervacijaputnickogletaEntity.setStatus("Prihvacena");
        rezervacijaputnickogletaEntity.setRazlogPonistavanja(null);
        rezervacijaputnickogletaEntityRepository.save(rezervacijaputnickogletaEntity);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/decline")
    public ResponseEntity decline(@RequestBody RezervacijaKeyModel model)
    {
        RezervacijaputnickogletaEntity rezervacijaputnickogletaEntity = rezervacijaputnickogletaEntityRepository.getOne(new RezervacijaputnickogletaEntityPK(model.getLetId(), model.getKorisnikId()));
        rezervacijaputnickogletaEntity.setStatus("Ponistena");
        rezervacijaputnickogletaEntity.setRazlogPonistavanja(model.getRazlogPonistavanja());
        PutnickiletEntity pl = putnickiletEntityRepository.getOne(rezervacijaputnickogletaEntity.getPutnickiLetId());
        pl.setBrojSlobodnihMjesta(pl.getBrojSlobodnihMjesta()+rezervacijaputnickogletaEntity.getBrojMjesta());
        putnickiletEntityRepository.save(pl);
        rezervacijaputnickogletaEntityRepository.save(rezervacijaputnickogletaEntity);

        return ResponseEntity.ok().build();
    }
}
