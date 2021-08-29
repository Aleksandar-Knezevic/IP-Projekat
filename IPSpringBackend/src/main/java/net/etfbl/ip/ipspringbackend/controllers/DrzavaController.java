package net.etfbl.ip.ipspringbackend.controllers;

import net.etfbl.ip.ipspringbackend.models.entities.DrzavaEntity;
import net.etfbl.ip.ipspringbackend.models.entities.GradEntity;
import net.etfbl.ip.ipspringbackend.repositories.DrzavaEntityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/drzave")
public class DrzavaController {

    private final DrzavaEntityRepository drzavaEntityRepository;

    public DrzavaController(DrzavaEntityRepository drzavaEntityRepository) {
        this.drzavaEntityRepository = drzavaEntityRepository;
    }

    @GetMapping
    public ResponseEntity<List<DrzavaEntity>> getAll()
    {
        return ResponseEntity.ok(drzavaEntityRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<GradEntity>> getAllCities(@PathVariable int id){
        return ResponseEntity.ok(drzavaEntityRepository.findById(id).get().getGradsById());
    }
}
