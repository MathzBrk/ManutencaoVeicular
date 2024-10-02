import model.Agendamento;
import model.Cliente;
import model.Servico;
import model.Veiculo;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.util.Date;

public class AgendamentoTest {

    private Agendamento agendamento;

    @BeforeEach
    public void setUp() {
        Veiculo veiculo = new Veiculo("Honda", "Civic", 2024, "ABC1D23");
        Cliente cliente = new Cliente("Itallo", "italloam123@gmail.com", "35998195119", "11134310676");
        Servico servico = new Servico("Troca de pneu", 100.0, 1);
        Date localDate = new Date(2024,10,01);
        agendamento = new Agendamento(1, cliente, veiculo, servico, localDate);
    }



}
