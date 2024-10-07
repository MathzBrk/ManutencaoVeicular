package service;

import model.Agendamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AgendamentoService {

    private List<Agendamento> agendamentos;

    public AgendamentoService() {
        this.agendamentos = new ArrayList<>();
    }

    public void adicionarAgendamento(Agendamento agendamento) {
        try {
            agendamentos.add(agendamento);
            System.out.println("Agendamento adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar agendamento: " + e.getMessage());
        }
    }

    public List<Agendamento> listarAgendamentos() {
        return agendamentos;
    }

    public Optional<Agendamento> buscarAgendamentoPorId(int id) {
        return agendamentos.stream()
                .filter(agendamento -> agendamento.getIdAgendamento() == id)
                .findFirst();
    }

    public void atualizarAgendamento(int id, Agendamento agendamentoAtualizado) {
        Optional<Agendamento> agendamentoOptional = buscarAgendamentoPorId(id);
        if (agendamentoOptional.isPresent()) {
            Agendamento agendamento = agendamentoOptional.get();
            agendamento.setIdAgendamento(agendamentoAtualizado.getIdAgendamento());
            System.out.println("Agendamento atualizado: " + agendamento.getIdAgendamento());
        }
        else {
            System.out.println("Não foi possivel atualizar o agendamento");
        }
    }


    public void removerAgendamento(int id) {
        Optional<Agendamento> agendamentoOptional = buscarAgendamentoPorId(id);
        if (agendamentoOptional.isPresent()) {
            agendamentos.remove(agendamentoOptional.get());
            System.out.println("Agendamento removido.");
        }
        else {
            System.out.println("Agendamento não encontrado");
        }
    }
}

