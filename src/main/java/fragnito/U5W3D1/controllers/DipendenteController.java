package fragnito.U5W3D1.controllers;

import fragnito.U5W3D1.entities.Dipendente;
import fragnito.U5W3D1.exceptions.Validation;
import fragnito.U5W3D1.payloads.NewDipendenteDTO;
import fragnito.U5W3D1.payloads.RespDTO;
import fragnito.U5W3D1.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {
    @Autowired
    private DipendenteService dipendenteService;

    @Autowired
    private Validation validation;

    @GetMapping
    public List<Dipendente> getAllDipendenti() {
        return this.dipendenteService.getAllDipendenti();
    }

    @GetMapping("/{dipendenteId}")
    public Dipendente getDipendenteById(@PathVariable int dipendenteId) {
        return this.dipendenteService.getDipendenteById(dipendenteId);
    }

    @PutMapping("/{dipendenteId}")
    public RespDTO putDipendente(@PathVariable int dipendenteId, @RequestBody @Validated NewDipendenteDTO body, BindingResult validation) {
        this.validation.validate(validation);
        Dipendente updatedDipendente = this.dipendenteService.updateDipendente(dipendenteId, body);
        return new RespDTO(updatedDipendente.getId());
    }

    @DeleteMapping("/{dipendenteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDipendente(@PathVariable int dipendenteId) {
        this.dipendenteService.deleteDipendente(dipendenteId);
    }

    @PostMapping("/{dipendenteId}/avatar")
    public void uploadAvatar(@PathVariable int dipendenteId, @RequestParam("avatar") MultipartFile img) throws IOException {
        this.dipendenteService.uploadImage(dipendenteId, img);
    }
}
