package net.etfbl.ip.ipspringbackend.controllers;

import net.etfbl.ip.ipspringbackend.models.TeretniLetModel;
import net.etfbl.ip.ipspringbackend.models.entities.TeretniletEntity;
import net.etfbl.ip.ipspringbackend.repositories.DrzavaEntityRepository;
import net.etfbl.ip.ipspringbackend.repositories.GradEntityRepository;
import net.etfbl.ip.ipspringbackend.repositories.TeretniletEntityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/teretni-letovi")
public class TeretniletController {

    private final TeretniletEntityRepository teretniletEntityRepository;
    private final DrzavaEntityRepository drzavaEntityRepository;
    private final GradEntityRepository gradEntityRepository;

    public TeretniletController(TeretniletEntityRepository teretniletEntityRepository, DrzavaEntityRepository drzavaEntityRepository, GradEntityRepository gradEntityRepository)
    {
        this.teretniletEntityRepository = teretniletEntityRepository;
        this.drzavaEntityRepository = drzavaEntityRepository;
        this.gradEntityRepository = gradEntityRepository;
    }

    @GetMapping
    public ResponseEntity<List<TeretniletEntity>> getAll()
    {
        return ResponseEntity.ok(teretniletEntityRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeretniletEntity> getById(@PathVariable int id)
    {
        return ResponseEntity.ok(teretniletEntityRepository.findById(id).get());
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TeretniLetModel teretniLetModel)
    {
        TeretniletEntity teretniletEntity = new TeretniletEntity();
        teretniletEntity.setOpisTereta(null);
        teretniletEntity.setGradByPolazniGrad(gradEntityRepository.findById(teretniLetModel.getPolazniGrad()).get());
        teretniletEntity.setStatus(teretniLetModel.getStatus());
        teretniletEntity.setDrzavaByPolaznaDrzava(drzavaEntityRepository.findById(teretniLetModel.getPolaznaDrzava()).get());
        teretniletEntity.setDrzavaByOdredisnaDrzava(drzavaEntityRepository.findById(teretniLetModel.getOdredisnaDrzava()).get());
        teretniletEntity.setDatumLeta(teretniLetModel.getDatumLeta());
        teretniletEntity.setGradByOdredisniGrad(gradEntityRepository.findById(teretniLetModel.getOdredisniGrad()).get());
        teretniletEntity.setVrijemePolaska(Time.valueOf(LocalTime.parse(teretniLetModel.getVrijemePolaska())));
        teretniletEntity.setVrijemeDolaska(Time.valueOf(LocalTime.parse(teretniLetModel.getVrijemeDolaska())));

        teretniletEntityRepository.saveAndFlush(teretniletEntity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity update(@PathVariable int id)
    {
        teretniletEntityRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
