package fragnito.U5W3D1.repositories;

import fragnito.U5W3D1.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente, Integer> {
    boolean existsByEmail(String email);
}
