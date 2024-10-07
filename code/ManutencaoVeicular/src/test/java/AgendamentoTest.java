import model.Agendamento;
import model.Cliente;
import model.Servico;
import model.Veiculo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

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
        assertEquals(1, agendamento.getIdAgendamento());
    }

    @Test
    public void testClienteAgendado() {
        assertEquals("Itallo", agendamento.getCliente().getNome());
        assertEquals("italloam123@gmail.com", agendamento.getCliente().getEmail());
        assertEquals("35998195119", agendamento.getCliente().getTelefone());
        assertEquals("11134310676", agendamento.getCliente().getCpf());
    }

    @Test
    public void testVeiculoAgendado() {
        assertEquals("Honda", agendamento.getVeiculo().getMarca());
        assertEquals("Civic", agendamento.getVeiculo().getModelo());
        assertEquals(2024, agendamento.getVeiculo().getAno());
        assertEquals("ABC1D23", agendamento.getVeiculo().getPlaca());
    }

    @Test
    public void testServicoAgendado() {
        assertEquals("Troca de pneu", agendamento.getServico().getDescricao());
        assertEquals(1, agendamento.getServico().getIdServico());
        assertEquals(130.0, agendamento.getServico().getPreco());
    }

    @Test
    public void testDataAgendada() {
        Date expectedDate = new Date(2024,10, 1);
        assertEquals(expectedDate, agendamento.getData());
    }
}
