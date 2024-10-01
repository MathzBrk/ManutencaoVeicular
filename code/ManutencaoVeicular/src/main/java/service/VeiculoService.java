package service;

import model.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VeiculoService {
    private List<Veiculo> veiculos = new ArrayList<>();

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public List<Veiculo> listarVeiculos() {
        return veiculos;
    }

    public Optional<Veiculo> buscarVeiculo(String placa) {
        return veiculos.stream().filter(v -> v.getPlaca().equalsIgnoreCase(placa)).findFirst();
    }

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

    public void removerVeiculo(String placa) {
        Optional<Veiculo> veiculo = buscarVeiculo(placa);
        if (veiculo.isPresent()) {
            veiculos.remove(veiculo.get());
            System.out.println("Veiculo removido com sucesso!");
        }else{
            System.out.println("Veiculo não encontrado!");
        }

    }

}
