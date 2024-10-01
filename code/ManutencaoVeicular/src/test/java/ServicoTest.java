import model.Servico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServicoTest {

    private Servico servico;

    @BeforeEach
    public void setUp() {
        servico = new Servico("Troca de pneu", 100.0, 1);
    }

    @Test
    public void testGetDescricao() {
        assertEquals("Troca de pneu", servico.getDescricao());
    }

    @Test
    public void testGetPreco() {
        assertEquals(100.0, servico.getPreco(), 0.01);
    }

    @Test
    public void testSetPreco() {
        servico.setPreco(130.0);
        assertEquals(130.0, servico.getPreco(), 0.01);
    }

    @Test
    public void testFinalizado() {
        assertFalse(servico.isFinalizado());
        servico.setFinalizado(true);
        assertTrue(servico.isFinalizado());
    }

    @Test
    public void testIdServico() {
        assertEquals(1, servico.getIdServico());
    }
}
