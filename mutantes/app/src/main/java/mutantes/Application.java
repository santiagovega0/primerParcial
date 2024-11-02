package mutantes;

import org.springframework.boot.autoconfigure.domain.EntityScan; // Importa la anotación EntityScan
import org.springframework.boot.SpringApplication; // Importa la clase SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication; // Importa la anotación SpringBootApplication

@SpringBootApplication
@EntityScan(basePackages = "mutantes.model")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
