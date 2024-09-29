package validation;

import exception.ValidationException;
import model.Servico;

public class ServicoValidator {

    public static void validar(Servico servico) throws ValidationException {
        if (servico == null)
            throw new ValidationException("O serviço não pode ser nulo");


        if(servico.getDescricao() == null || servico.getDescricao().trim().equals(""))
            throw new ValidationException("A descrição do serviço não pode estar vazia");


        if(servico.getPreco() <= 0)
            throw  new ValidationException("O preço do serviço deve ser maior do que zero");


        if(servico.getIdServico() < 0)
            throw  new ValidationException("O ID do serviço deve ser um número positivo");
    }

}
