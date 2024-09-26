package service;

import model.Servico;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiceManutencao {

    private List<Servico> servicos;

    public ServiceManutencao() {
        this.servicos = new ArrayList<>();
    }

    // CREATE - Adicionar um novo serviço
    public void adicionarServico(Servico servico) {
        servicos.add(servico);
        System.out.println("Serviço adicionado: " + servico.getDescricao());
    }

    // READ - Listar todos os serviços
    public List<Servico> listarServicos() {
        return servicos;
    }

    // READ - Buscar um serviço por ID
    public Optional<Servico> buscarServicoPorId(int id) {
        return servicos.stream()
                .filter(servico -> servico.getIdServico() == id)
                .findFirst();
    }

    // UPDATE - Atualizar um serviço existente
    public boolean atualizarServico(int id, Servico servicoAtualizado) {
        Optional<Servico> servicoOptional = buscarServicoPorId(id);
        if (servicoOptional.isPresent()) {
            Servico servico = servicoOptional.get();
            servico.setDescricao(servicoAtualizado.getDescricao());
            System.out.println("Serviço atualizado: " + servico.getDescricao());
            return true;
        }
        return false;
    }

    // DELETE - Remover um serviço
    public boolean removerServico(int id) {
        Optional<Servico> servicoOptional = buscarServicoPorId(id);
        if (servicoOptional.isPresent()) {
            servicos.remove(servicoOptional.get());
            System.out.println("Serviço removido.");
            return true;
        }
        return false;
    }
}

