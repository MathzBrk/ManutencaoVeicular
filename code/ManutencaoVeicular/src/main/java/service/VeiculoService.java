package service;

import model.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoService {
    private List<Veiculo> veiculos = new ArrayList<>();

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
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

    // Corrigido: Atualiza o veículo diretamente ou retorna null se não encontrar
    public Veiculo atualizarVeiculo(String placa, Veiculo veiculoAtualizado) {
        Veiculo veiculo = buscarVeiculo(placa);
        if (veiculo != null) {
            veiculo.setMarca(veiculoAtualizado.getMarca());
            veiculo.setModelo(veiculoAtualizado.getModelo());
            veiculo.setAno(veiculoAtualizado.getAno());
            return veiculo; // Retorna o veículo atualizado
        }
        return null;
    }

    public void removerVeiculo(String placa) {
        Veiculo veiculo = buscarVeiculo(placa);
        if (veiculo != null) {
            veiculos.remove(veiculo);
            System.out.println("Veiculo removido com sucesso!");
        } else {
            System.out.println("Veiculo não encontrado!");
        }
    }
}
