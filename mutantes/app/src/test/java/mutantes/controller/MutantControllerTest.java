package mutantes.controller;

import org.junit.jupiter.api.Test; // Importa la anotación Test
import org.springframework.beans.factory.annotation.Autowired; // Importa la anotación Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc; // Importa la configuración de MockMvc
import org.springframework.boot.test.context.SpringBootTest; // Importa la anotación SpringBootTest
import org.springframework.http.MediaType; // Importa MediaType para definir tipos de contenido
import org.springframework.test.web.servlet.MockMvc; // Importa MockMvc para realizar pruebas de controladores
import org.springframework.test.context.ActiveProfiles; // Importa ActiveProfiles

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post; // Importa el método para construir solicitudes POST
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status; // Importa el método para verificar el estado de la respuesta

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class MutantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testIsMutant_HorizontalMatch() throws Exception {
        mockMvc.perform(post("/mutant")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"dna\": [\"ATGCGA\", \"CGGTGC\", \"TAAAAA\", \"AGAAGG\",\"CTCCTA\",\"TCACTG\"]}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testIsMutant_VerticalMatch() throws Exception {
        mockMvc.perform(post("/mutant")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"dna\": [\"CAGTGC\",\"TAATGT\",\"AAGAGG\", \"CACCTA\", \"TCACTG\"]}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testIsMutant_DiagonalMatch() throws Exception {
        mockMvc.perform(post("/mutant")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"dna\": [\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testIsNotMutant() throws Exception {
        mockMvc.perform(post("/mutant")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"dna\": [\"ATGCGC\", \"CAGTAC\", \"TTAGTA\", \"AGCTGG\", \"TCAGTA\", \"TCACTC\"]}"))
                .andExpect(status().isForbidden());
    }
}
