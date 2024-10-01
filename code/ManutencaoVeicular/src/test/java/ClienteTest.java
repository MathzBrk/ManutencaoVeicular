import model.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente("Itallo", "italloam123@gmail.com", "35998195119", "11134310676");
    }

    @Test
    public void testGetNome() {
        assertEquals("Itallo", cliente.getNome());
    }

    @Test
    public void testGetEmail() {
        assertEquals("italloam123@gmail.com", cliente.getEmail());
    }

    @Test
    public void testeGetTelefone() {
        assertEquals("35998195119", cliente.getTelefone());
    }

    @Test
    public void testeGetCpf() {
        assertEquals("11134310676", cliente.getCpf());
    }
}
