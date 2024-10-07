package validation;
import exception.ValidationException;
import model.Veiculo;

public class VeiculoValidator {

    // Método principal para validar o veículo
    public static void validar(Veiculo veiculo) throws ValidationException {
        if (veiculo == null) {
            throw new ValidationException("Veículo não pode ser nulo.");
        }
        validarMarca(veiculo.getMarca());
        validarModelo(veiculo.getModelo());
        validarAno(veiculo.getAno());
        validarPlaca(veiculo.getPlaca());
    }

    // Validação da marca do veículo
    private static void validarMarca(String marca) throws ValidationException {
        if (marca == null) {
            throw new ValidationException("Marca do veículo não pode ser vazia.");
        }
        if (marca.length() < 2 || marca.length() > 50) {
            throw new ValidationException("Marca deve ter entre 2 e 50 caracteres.");
        }
    }

    // Validação do modelo do veículo
    private static void validarModelo(String modelo) throws ValidationException {
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new ValidationException("Modelo do veículo não pode ser vazio.");
        }
        if (modelo.length() < 2 || modelo.length() > 50) {
            throw new ValidationException("Modelo deve ter entre 2 e 50 caracteres.");
        }
    }

    // Validação do ano do veículo
    private static void validarAno(int ano) throws ValidationException {
        int anoAtual = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        if (ano < 1886 || ano > anoAtual + 1) {
            // Considera que o primeiro automóvel foi inventado em 1886 e aceita o próximo ano para lançamentos futuros
            throw new ValidationException("Ano do veículo deve estar entre 1886 e " + (anoAtual + 1) + ".");
        }
    }

    // Validação da placa do veículo
    private static void validarPlaca(String placa) throws ValidationException {
        if (placa == null || placa.trim().isEmpty()) {
            throw new ValidationException("Placa do veículo não pode ser vazia.");
        }
        // Adapta para o padrão brasileiro (3 letras + 4 números) ou o novo formato (ABC1D23)
        String placaRegex = "^[A-Z]{3}\\d{4}$|^[A-Z]{3}\\d[A-Z]\\d{2}$";
        if (!placa.matches(placaRegex)) {
            throw new ValidationException("Placa do veículo deve estar no formato válido (AAA1234 ou ABC1D23).");
        }
    }
}
