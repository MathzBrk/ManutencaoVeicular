import model.Agendamento;
import model.Cliente;
import model.Servico;
import model.Veiculo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AgendamentoTest {

    private Agendamento agendamento;

    @BeforeEach
    public void setUp() {
        Veiculo veiculo = new Veiculo("Honda", "Civic", 2024, "ABC1D23");
        Cliente cliente = new Cliente("Itallo", "italloam123@gmail.com", "35998195119", "11134310676");
        Servico servico = new Servico("Troca de pneu", 100.0);
        LocalDate localDate = LocalDate.of(2024, 10, 1);
        agendamento = new Agendamento(cliente, veiculo, servico, localDate);
    }

    @Test
    public void testAgendamentoCriadoCorretamente() {
        assertNotNull(agendamento);
    }

    @Test
    public void testClienteAgendado() {
        String expectedNome = "Itallo";
        String actualNome = agendamento.getCliente().getNome();
        assertEquals(expectedNome, actualNome);
    }

    @Test
    public void testVeiculoAgendado() {
    }

    @Test
    public void testServicoAgendado() {
    }

    @Test
    public void testDataAgendada() {
        LocalDate expectedDate = LocalDate.of(2024, 10, 1);
        assertEquals(expectedDate, agendamento.getData());
    }
}