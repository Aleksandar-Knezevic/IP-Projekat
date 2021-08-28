package net.etfbl.ip.ipspringbackend.controllers;

import net.etfbl.ip.ipspringbackend.models.entities.PutnickiletEntity;
import net.etfbl.ip.ipspringbackend.repositories.PutnickiletEntityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/putnicki-letovi")
public class PutnickiletController {

    private final PutnickiletEntityRepository putnickiletEntityRepository;

    public PutnickiletController(PutnickiletEntityRepository putnickiletEntityRepository)
    {
        this.putnickiletEntityRepository = putnickiletEntityRepository;
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
    public ResponseEntity create(@RequestBody PutnickiletEntity putnickiletEntity)
    {
        putnickiletEntityRepository.save(putnickiletEntity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity update(@PathVariable int id)
    {
        putnickiletEntityRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
