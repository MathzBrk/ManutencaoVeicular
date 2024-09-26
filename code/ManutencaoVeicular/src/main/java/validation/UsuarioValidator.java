package validation;

import exception.ValidationException;
import model.Usuario;

public class UsuarioValidator {
    public static void validar(Usuario usuario) throws ValidationException {
        if (usuario == null) {
            throw new ValidationException("Usuário não pode ser nulo.");
        }
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new ValidationException("Nome do usuário não pode ser vazio.");
        }
        if (!isValidEmail(usuario.getEmail())) {
            throw new ValidationException("E-mail inválido.");
        }
        validarCpf(usuario.getCpf());
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email != null && email.matches(emailRegex);
    }
    private static void validarCpf(String cpf) throws ValidationException {
        if (cpf == null || cpf.isEmpty()) {
            throw new ValidationException("CPF não pode ser vazio.");
        }
        // Remove caracteres não numéricos
        String cpfNumeros = cpf.replaceAll("\\D", "");

        // Verifica se o CPF tem exatamente 11 dígitos
        if (cpfNumeros.length() != 11) {
            throw new ValidationException("CPF deve conter exatamente 11 dígitos.");
        }

        // Você pode adicionar validações adicionais aqui, como verificar se todos os dígitos são iguais, etc.
    }
}
