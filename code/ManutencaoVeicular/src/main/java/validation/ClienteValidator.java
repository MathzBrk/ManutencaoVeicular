package validation;

import exception.ValidationException;
import model.Cliente;

public class ClienteValidator {
    public static void validar(Cliente cliente) throws ValidationException {
        if (cliente == null) {
            throw new ValidationException("Cliente não pode ser nulo.");
        }
        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            throw new ValidationException("Nome do usuário não pode ser vazio.");
        }
        if (!isValidEmail(cliente.getEmail())) {
            throw new ValidationException("E-mail inválido.");
        }
        validarCpf(cliente.getCpf());
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email != null && email.matches(emailRegex);
    }
    private static void validarCpf(String cpf) throws ValidationException {
        if (cpf == null || cpf.isEmpty()) {
            throw new ValidationException("CPF não pode ser vazio.");
        }

        String cpfNumeros = cpf.replaceAll("\\D", "");

        if (cpfNumeros.length() != 11) {
            throw new ValidationException("CPF deve conter exatamente 11 dígitos.");
        }

    }
}
