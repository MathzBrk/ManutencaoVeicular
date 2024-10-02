
import model.Veiculo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VeiculoTest {

    private Veiculo veiculo;

    @BeforeEach
    public void setUp() {
        veiculo = new Veiculo("Honda", "Civic", 2024, "ABC1D23");
    }

    @Test
    public void testGetMarca() {
        assertEquals("Honda", veiculo.getMarca());
    }

    @Test
    public void testGetModelo() {
        assertEquals("Civic", veiculo.getModelo());
    }

    @Test
    public void testGetAno() {
        assertEquals(2024, veiculo.getAno());
    }

    @Test
    public void testGetPlaca() {
        assertEquals("ABC1D23", veiculo.getPlaca());
    }

}
