package fragnito.U5W3D1.repositories;

import fragnito.U5W3D1.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {
    @Query("SELECT p FROM Prenotazione p WHERE p.dipendente.id = :id AND p.viaggio.data = :data")
    List<Prenotazione> filterPrenotazioniByUserAndData(int id, LocalDate data);
}
