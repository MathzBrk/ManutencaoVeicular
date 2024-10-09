package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Veiculo;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class VeiculoService {
    private List<Veiculo> veiculos = new ArrayList<>();
    private final String filePath = "veiculos.json";
    private final Gson gson;

    public VeiculoService() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        carregarVeiculos();
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        try {
            veiculos.add(veiculo);
            salvarVeiculos(); // Salva os veículos após adicionar
            System.out.println("Veículo adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar veículo: " + e.getMessage());
        }
    }

    public List<Veiculo> listarVeiculos() {
        return veiculos;
    }

    public Veiculo buscarVeiculo(String placa) {
        return veiculos.stream()
                .filter(v -> v.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);
    }

    public Veiculo atualizarVeiculo(String placa, Veiculo veiculoAtualizado) {
        Veiculo veiculo = buscarVeiculo(placa);
        if (veiculo != null) {
            veiculo.setMarca(veiculoAtualizado.getMarca());
            veiculo.setModelo(veiculoAtualizado.getModelo());
            veiculo.setAno(veiculoAtualizado.getAno());
            salvarVeiculos(); // Salva os veículos após a atualização
            return veiculo;
        }
        return null;
    }

    public void removerVeiculo(String placa) {
        Veiculo veiculo = buscarVeiculo(placa);
        if (veiculo != null) {
            veiculos.remove(veiculo);
            salvarVeiculos(); // Salva os veículos após a remoção
            System.out.println("Veículo removido com sucesso!");
        } else {
            System.out.println("Veículo não encontrado!");
        }
    }

    private void salvarVeiculos() {
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(veiculos, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar veículos: " + e.getMessage());
        }
    }

    private void carregarVeiculos() {
        try (Reader reader = new FileReader(filePath)) {
            Type veiculoListType = new TypeToken<List<Veiculo>>() {}.getType();
            veiculos = gson.fromJson(reader, veiculoListType);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de veículos não encontrado. Um novo será criado.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar veículos: " + e.getMessage());
        }
    }
}
