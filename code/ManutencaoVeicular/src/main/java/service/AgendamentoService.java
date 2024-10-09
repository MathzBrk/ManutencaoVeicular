package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Agendamento;
import model.LocalDateAdapter;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AgendamentoService {

    private List<Agendamento> agendamentos;
    private final String filePath = "agendamentos.json";
    private final Gson gson;

    public AgendamentoService() {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setPrettyPrinting()
                .create();
        this.agendamentos = new ArrayList<>();
        carregarAgendamentos();
    }

    public void adicionarAgendamento(Agendamento agendamento) {
        try {
            agendamentos.add(agendamento);
            salvarAgendamentos(); // Salva os agendamentos após adicionar
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
            salvarAgendamentos(); // Salva os agendamentos após a atualização
            System.out.println("Agendamento atualizado: " + agendamento.getIdAgendamento());
        } else {
            System.out.println("Não foi possível atualizar o agendamento");
        }
    }

    public void removerAgendamento(int id) {
        Optional<Agendamento> agendamentoOptional = buscarAgendamentoPorId(id);
        if (agendamentoOptional.isPresent()) {
            agendamentos.remove(agendamentoOptional.get());
            salvarAgendamentos(); // Salva os agendamentos após a remoção
            System.out.println("Agendamento removido.");
        } else {
            System.out.println("Agendamento não encontrado");
        }
    }

    private void salvarAgendamentos() {
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(agendamentos, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar agendamentos: " + e.getMessage());
        }
    }

    private void carregarAgendamentos() {
        try (Reader reader = new FileReader(filePath)) {
            Type agendamentoListType = new TypeToken<List<Agendamento>>() {}.getType();
            agendamentos = gson.fromJson(reader, agendamentoListType);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de agendamentos não encontrado. Um novo será criado.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar agendamentos: " + e.getMessage());
        }
    }
}
