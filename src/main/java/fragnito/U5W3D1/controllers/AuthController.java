package fragnito.U5W3D1.controllers;

import fragnito.U5W3D1.payloads.AuthDTO;
import fragnito.U5W3D1.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private DipendenteRepository dipendenteRepository;

    @PostMapping("/login")
    public String login(@RequestBody AuthDTO body) {
        return "Token";
    }
}
