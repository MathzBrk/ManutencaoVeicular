package service;

import model.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VeiculoService {
    private List<Veiculo> veiculos = new ArrayList<>();

    // Create
    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    // Read
    public List<Veiculo> listarVeiculos() {
        return veiculos;
    }

    public Optional<Veiculo> buscarVeiculo(String placa) {
        return veiculos.stream().filter(v -> v.getPlaca().equalsIgnoreCase(placa)).findFirst();
    }

    // Update
    public Optional<Veiculo> atualizarVeiculo(String placa, Veiculo veiculoAtualizado) {
        Optional<Veiculo> veiculoOpt = buscarVeiculo(placa);
        if (veiculoOpt.isPresent()) {
            Veiculo veiculo = veiculoOpt.get();
            veiculo.setMarca(veiculoAtualizado.getMarca());
            veiculo.setModelo(veiculoAtualizado.getModelo());
            veiculo.setAno(veiculoAtualizado.getAno());
            return Optional.of(veiculo);
        }
        return Optional.empty();
    }

    // Delete
    public boolean removerVeiculo(String placa) {
        return veiculos.removeIf(v -> v.getPlaca().equalsIgnoreCase(placa));
    }

}
