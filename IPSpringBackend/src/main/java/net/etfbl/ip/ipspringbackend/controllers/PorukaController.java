package net.etfbl.ip.ipspringbackend.controllers;

import com.mysql.cj.util.StringUtils;
import net.etfbl.ip.ipspringbackend.models.entities.PorukaEntity;
import net.etfbl.ip.ipspringbackend.repositories.PorukaEntityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/poruke")
public class PorukaController {

    private final PorukaEntityRepository porukaEntityRepository;

    public PorukaController(PorukaEntityRepository porukaEntityRepository)
    {
        this.porukaEntityRepository = porukaEntityRepository;
    }

    @GetMapping
    public ResponseEntity<List<PorukaEntity>> getAll()
    {
        return ResponseEntity.ok(porukaEntityRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PorukaEntity> getById(@PathVariable int id)
    {
        return ResponseEntity.ok(porukaEntityRepository.findById(id).get());
    }

    @GetMapping("/unread")
    public ResponseEntity<List<PorukaEntity>> getUnread()
    {
        return ResponseEntity.ok(porukaEntityRepository.findAll().stream().filter(e -> e.getStatus().equals("Neprocitana")).collect(Collectors.toList()));
    }

    @PutMapping("/mark-as-read/{id}")
    public ResponseEntity markAsRead(@PathVariable int id)
    {
        PorukaEntity porukaEntity = porukaEntityRepository.getOne(id);
        porukaEntity.setStatus("Procitana");
        porukaEntityRepository.save(porukaEntity);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/search")
    public ResponseEntity<List<PorukaEntity>> searchByContent(@RequestBody String content)
    {
        return ResponseEntity.ok(porukaEntityRepository
                             .findAll()
                             .stream()
                             .filter(e -> e.getSadrzaj().toLowerCase().contains(content.toLowerCase()))
                             .collect(Collectors.toList()));
    }




}
