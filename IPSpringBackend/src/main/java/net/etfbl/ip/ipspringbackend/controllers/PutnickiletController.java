package net.etfbl.ip.ipspringbackend.controllers;

import net.etfbl.ip.ipspringbackend.models.PutnickiLetModel;
import net.etfbl.ip.ipspringbackend.models.entities.PutnickiletEntity;
import net.etfbl.ip.ipspringbackend.repositories.DrzavaEntityRepository;
import net.etfbl.ip.ipspringbackend.repositories.GradEntityRepository;
import net.etfbl.ip.ipspringbackend.repositories.PutnickiletEntityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/putnicki-letovi")
public class PutnickiletController {

    private final PutnickiletEntityRepository putnickiletEntityRepository;
    private final DrzavaEntityRepository drzavaEntityRepository;
    private final GradEntityRepository gradEntityRepository;

    public PutnickiletController(PutnickiletEntityRepository putnickiletEntityRepository, DrzavaEntityRepository drzavaEntityRepository, GradEntityRepository gradEntityRepository)
    {
        this.putnickiletEntityRepository = putnickiletEntityRepository;
        this.drzavaEntityRepository = drzavaEntityRepository;
        this.gradEntityRepository = gradEntityRepository;
    }

    @GetMapping
    public ResponseEntity<List<PutnickiletEntity>> getAll()
    {
        return ResponseEntity.ok(putnickiletEntityRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PutnickiletEntity> getById(@PathVariable int id)
    {
        return ResponseEntity.ok(putnickiletEntityRepository.findById(id).get());
    }

    @PostMapping
    public ResponseEntity create(@RequestBody PutnickiLetModel putnickiLetModel)
    {
        PutnickiletEntity putnickiletEntity = new PutnickiletEntity();
        putnickiletEntity.setGradByPolazniGrad(gradEntityRepository.findById(putnickiLetModel.getPolazniGrad()).get());
        putnickiletEntity.setStatus(putnickiLetModel.getStatus());
        putnickiletEntity.setDrzavaByPolaznaDrzava(drzavaEntityRepository.findById(putnickiLetModel.getPolaznaDrzava()).get());
        putnickiletEntity.setDrzavaByOdredisnaDrzava(drzavaEntityRepository.findById(putnickiLetModel.getOdredisnaDrzava()).get());
        putnickiletEntity.setBrojMjesta(putnickiLetModel.getBrojMjesta());
        putnickiletEntity.setDatumLeta(putnickiLetModel.getDatumLeta());
        putnickiletEntity.setGradByOdredisniGrad(gradEntityRepository.findById(putnickiLetModel.getOdredisniGrad()).get());
        putnickiletEntity.setBrojSlobodnihMjesta(putnickiLetModel.getBrojMjesta());
        putnickiletEntity.setVrijemePolaska(Time.valueOf(LocalTime.parse(putnickiLetModel.getVrijemePolaska())));
        putnickiletEntity.setVrijemeDolaska(Time.valueOf(LocalTime.parse(putnickiLetModel.getVrijemeDolaska())));
        putnickiletEntityRepository.saveAndFlush(putnickiletEntity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity update(@PathVariable int id)
    {
        putnickiletEntityRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
