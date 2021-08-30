package net.etfbl.ip.ipspringbackend.controllers;

import net.etfbl.ip.ipspringbackend.models.MailResponseModel;
import net.etfbl.ip.ipspringbackend.models.entities.PorukaEntity;
import net.etfbl.ip.ipspringbackend.repositories.PorukaEntityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin()
@RequestMapping("/poruke")
public class PorukaController {

    private final PorukaEntityRepository porukaEntityRepository;
    private final JavaMailSender emailSender;

    public PorukaController(PorukaEntityRepository porukaEntityRepository, JavaMailSender emailSender)
    {
        this.porukaEntityRepository = porukaEntityRepository;
        this.emailSender = emailSender;
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

    @PostMapping("/respond")
    public ResponseEntity respondToMail(@RequestBody MailResponseModel model)
    {
        try
        {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("snisafechat2021@gmail.com");
            helper.setTo(model.getEmail());
            helper.setSubject("Odgovor");
            helper.setText(model.getBody());
            emailSender.send(message);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return ResponseEntity.ok().build();
    }




}
