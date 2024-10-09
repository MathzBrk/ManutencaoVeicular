package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Cliente;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private List<Cliente> clientes;
    private final String filePath = "clientes.json"; // Caminho do arquivo JSON

    public ClienteService() {
        this.clientes = carregarClientes(); // Carrega clientes ao iniciar o serviço
    }

    public void adicionarCliente(Cliente cliente) {
        try {
            clientes.add(cliente);
            salvarClientes();
        } catch (Exception e) {
            System.out.println("Erro ao adicionar cliente: " + e.getMessage());
        }
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    private void salvarClientes() {
        try (Writer writer = new FileWriter(filePath)) {
            Gson gson = new Gson();
            gson.toJson(clientes, writer); // Converte a lista de clientes em JSON e grava no arquivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Cliente> carregarClientes() {
        try (Reader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            Type clienteListType = new TypeToken<List<Cliente>>() {}.getType();
            return gson.fromJson(reader, clienteListType); // Lê o arquivo JSON e converte para lista de clientes
        } catch (FileNotFoundException e) {
            return new ArrayList<>(); // Retorna uma lista vazia se o arquivo não for encontrado
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Cliente consultarPorCpf(String cpf) {
        return clientes.stream()
                .filter(cliente -> cliente.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    public void atualizarClientePorCpf(String cpf, String novoNome, String novoEmail, String novoTelefone) {
        Cliente cliente = consultarPorCpf(cpf);
        if (cliente != null) {
            if (!novoNome.isEmpty()) {
                cliente.setNome(novoNome);
            }
            if (!novoEmail.isEmpty()) {
                cliente.setEmail(novoEmail);
            }
            if (!novoTelefone.isEmpty()) {
                cliente.setTelefone(novoTelefone);
            }
            System.out.println("Cliente atualizado com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void listarClientes(){
        for (Cliente cliente : clientes) {
            System.out.println("CPF cliente: " + cliente.getCpf());
        }
    }


    public void removerClientePorCpf(String cpf) {
        Cliente cliente = consultarPorCpf(cpf);
        try{
            clientes.remove(cliente);
            System.out.println("Cliente removido com sucesso");
        } catch (Exception e){
            System.out.println("Erro ao remover cliente: " + e.getMessage());
        }
    }
}
