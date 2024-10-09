package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Servico;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServicoService {

    private List<Servico> servicos;
    private final String filePath = "servicos.json";
    private final Gson gson;
    Scanner scanner = new Scanner(System.in);

    public ServicoService() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.servicos = new ArrayList<>();
        adicionarServico(new Servico("Troca de óleo", 150.0));
        adicionarServico(new Servico("Alinhamento e balanceamento", 120.0));
        adicionarServico(new Servico("Revisão completa", 300.0));
        carregarServicos();
    }

    public void adicionarServico(Servico servico) {
        try {
            servicos.add(servico);
            salvarServicos(); // Salva os serviços após adicionar
            System.out.println("Serviço adicionado: " + servico.getDescricao() + " ID: " + servico.getIdServico());
        } catch (Exception e) {
            System.out.println("Erro ao adicionar serviço: " + e.getMessage());
        }
    }

    public void listarServicos() {
        for (Servico servico : servicos) {
            System.out.println("Descrição: " + servico.getDescricao());
            System.out.println("Id: " + servico.getIdServico());
        }
    }

    public Servico buscarServicoPorId(int id) {
        return servicos.stream()
                .filter(servico -> servico.getIdServico() == id)
                .findFirst()
                .orElse(null);
    }

    public void atualizarStatusServico(int id) {
        Servico servico = buscarServicoPorId(id);
        if (servico != null) {
            System.out.println("Você deseja marcar o serviço como: 1-finalizado 2-não finalizado");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                servico.setFinalizado(true);
                System.out.println("Status alterado com sucesso!");
            } else if (opcao == 2) {
                servico.setFinalizado(false);
                System.out.println("Status alterado com sucesso!");
            } else {
                System.out.println("Opção inválida! Por favor, selecione 1 ou 2.");
            }
            salvarServicos(); // Salva os serviços após a atualização do status
        } else {
            System.out.println("Serviço não encontrado!!!");
        }
    }

    public void atualizarPrecoServico(int id, double preco) {
        Servico servico = buscarServicoPorId(id);
        if (servico != null) {
            servico.setPreco(preco);
            salvarServicos();
            System.out.println("Preço atualizado com sucesso!");
        } else {
            System.out.println("Serviço com ID " + id + " não encontrado. Não foi possível atualizar o preço.");
        }
    }


    public void removerServico(int id) {
        Servico servico = buscarServicoPorId(id);
        if (servico != null) {
            servicos.remove(servico);
            salvarServicos(); // Salva os serviços após a remoção
            System.out.println("Serviço removido.");
        } else {
            System.out.println("Serviço não encontrado");
        }
    }

    private void salvarServicos() {
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(servicos, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar serviços: " + e.getMessage());
        }
    }

    private void carregarServicos() {
        try (Reader reader = new FileReader(filePath)) {
            Type servicoListType = new TypeToken<List<Servico>>() {}.getType();
            servicos = gson.fromJson(reader, servicoListType);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de serviços não encontrado. Um novo será criado.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar serviços: " + e.getMessage());
        }
    }
}
