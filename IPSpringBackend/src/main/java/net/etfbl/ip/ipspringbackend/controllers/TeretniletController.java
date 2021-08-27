package net.etfbl.ip.ipspringbackend.controllers;

import net.etfbl.ip.ipspringbackend.models.entities.PutnickiletEntity;
import net.etfbl.ip.ipspringbackend.models.entities.TeretniletEntity;
import net.etfbl.ip.ipspringbackend.repositories.PutnickiletEntityRepository;
import net.etfbl.ip.ipspringbackend.repositories.TeretniletEntityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teretni-letovi")
public class TeretniletController {

    private final TeretniletEntityRepository teretniletEntityRepository;

    public TeretniletController(TeretniletEntityRepository teretniletEntityRepository)
    {
        this.teretniletEntityRepository = teretniletEntityRepository;
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
    public ResponseEntity create(@RequestBody TeretniletEntity teretniletEntity)
    {
        teretniletEntityRepository.save(teretniletEntity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity update(@PathVariable int id)
    {
        teretniletEntityRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
