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
        agendamentos.add(agendamento);
        System.out.println("Agendamento adicionado: " + agendamento.getIdAgendamento());
    }

    public List<Agendamento> listarAgendamentos() {
        return agendamentos;
    }

    public Optional<Agendamento> buscarAgendamentoPorId(int id) {
        return agendamentos.stream()
                .filter(agendamento -> agendamento.getIdAgendamento() == id)
                .findFirst();
    }

    public boolean atualizarAgendamento(int id, Agendamento agendamentoAtualizado) {
        Optional<Agendamento> agendamentoOptional = buscarAgendamentoPorId(id);
        if (agendamentoOptional.isPresent()) {
            Agendamento agendamento = agendamentoOptional.get();
            agendamento.setIdAgendamento(agendamentoAtualizado.getIdAgendamento());
            System.out.println("Agendamento atualizado: " + agendamento.getIdAgendamento());
            return true;
        }
        return false;
    }


    public boolean removerAgendamento(int id) {
        Optional<Agendamento> agendamentoOptional = buscarAgendamentoPorId(id);
        if (agendamentoOptional.isPresent()) {
            agendamentos.remove(agendamentoOptional.get());
            System.out.println("Agendamento removido.");
            return true;
        }
        return false;
    }
}

