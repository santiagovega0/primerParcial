package mutantes.model;

import jakarta.persistence.*; // Importa las anotaciones de JPA
import lombok.Data; // Lombok para generar automáticamente getters, setters y otros métodos
import lombok.NoArgsConstructor; // Lombok para crear un constructor sin argumentos

@Entity
@Table(name = "dna_records")
@Data
@NoArgsConstructor
public class DnaRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String dna;

    @Column(nullable = false)
    private Boolean isMutant;
}
