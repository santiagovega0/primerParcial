package mutantes.repository;

import mutantes.model.DnaRecord; // Asegúrate de importar la entidad DnaRecord
import org.springframework.data.jpa.repository.JpaRepository; // Importa la interfaz JpaRepository

public interface DnaRecordRepository extends JpaRepository<DnaRecord, Long> {
    boolean existsByDna(String dna);

    long countByIsMutant(boolean isMutant);
}
