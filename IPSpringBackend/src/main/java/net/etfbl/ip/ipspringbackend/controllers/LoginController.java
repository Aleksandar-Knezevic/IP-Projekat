package net.etfbl.ip.ipspringbackend.controllers;

import net.etfbl.ip.ipspringbackend.models.UserModel;
import net.etfbl.ip.ipspringbackend.models.entities.ZaposleniEntity;
import net.etfbl.ip.ipspringbackend.repositories.ZaposleniEntityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@RequestMapping("/login")
public class LoginController {

    private ZaposleniEntityRepository zaposleniEntityRepository;

    public LoginController(ZaposleniEntityRepository zaposleniEntityRepository) {
        this.zaposleniEntityRepository = zaposleniEntityRepository;
    }

    @PostMapping
    public ResponseEntity login(@RequestBody UserModel userModel)
    {
        try
        {
            ZaposleniEntity zaposleni = zaposleniEntityRepository.findByKorisnickoImeAndLozinka(userModel.getUsername(), userModel.getPassword()).get();
            return ResponseEntity.ok(zaposleni);

        }catch (Exception e)
        {
            return ResponseEntity.status(204).body(null);
        }

    }
}
