package fragnito.U5W3D1.services;

import fragnito.U5W3D1.entities.Dipendente;
import fragnito.U5W3D1.exceptions.UnauthorizedException;
import fragnito.U5W3D1.payloads.AuthDTO;
import fragnito.U5W3D1.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private JWTTools jwtTools;

    @Autowired
    private DipendenteService dipendenteService;

    public String generateToken(AuthDTO body) {
        Dipendente found = this.dipendenteService.findByEmail(body.email());
        if (found.getPassword().equals(body.password())) return jwtTools.createToken(found);
        else throw new UnauthorizedException("Credenziali errate");
    }
}
