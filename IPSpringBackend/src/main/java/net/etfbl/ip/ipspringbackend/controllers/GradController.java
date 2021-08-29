package net.etfbl.ip.ipspringbackend.controllers;

import net.etfbl.ip.ipspringbackend.models.entities.GradEntity;
import net.etfbl.ip.ipspringbackend.repositories.GradEntityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@RequestMapping("/gradovi")
public class GradController {

    private final GradEntityRepository gradEntityRepository;

    public GradController(GradEntityRepository gradEntityRepository) {
        this.gradEntityRepository = gradEntityRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GradEntity> getById(@PathVariable int id)
    {
        return ResponseEntity.ok(gradEntityRepository.findById(id).get());
    }
}
