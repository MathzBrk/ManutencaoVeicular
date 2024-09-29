package validation;

import exception.ValidationException;
import model.Agendamento;

import java.time.LocalDate;

public class AgendamentoValidator {

    public static void validar(Agendamento agendamento) throws ValidationException {
        if (agendamento == null)
            throw new ValidationException("Agendamento não pode ser nulo");

        ClienteValidator.validar(agendamento.getCliente());
        VeiculoValidator.validar(agendamento.getVeiculo());
        ServicoValidator.validar(agendamento.getServico());
        validarData(agendamento.getData());
    }

    private static void validarData(LocalDate data) throws ValidationException {
        if (data == null) {
            throw new ValidationException("Data do agendamento não pode ser nula.");
        }
        if (data.isBefore(LocalDate.now())) {
            throw new ValidationException("Data do agendamento não pode ser no passado.");
        }
    }
}
