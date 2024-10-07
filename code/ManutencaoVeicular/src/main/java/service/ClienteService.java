package service;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.spi.ToolProvider.findFirst;

public class ClienteService {
    private List<Cliente> clienteList;

    public ClienteService(){
        this.clienteList = new ArrayList<>();
    }
    public void adicionarCliente(Cliente cliente){
        try {
            clienteList.add(cliente);
            System.out.println("Cliente adicionado com sucesso!");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Cliente> consultarTodos(){
        return clienteList;
    }

    public Cliente consultarPorCpf(String cpf) {
        return clienteList.stream()
                .filter(cliente -> cliente.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }
    public Cliente consultarPorEmail(String email) {
        return clienteList.stream()
                .filter(cliente -> cliente.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }
    public void atualizarEmailCliente(String email, String cpf){
        Cliente cliente = consultarPorCpf(cpf);
        if(cliente != null){
            cliente.setEmail(email);
            System.out.println("Email atualizado com sucesso");
        }
        else {
            System.out.println("Cliente não encontrado");
        }
    }

    public void atualizarTelefoneCliente(String telefone, String cpf){
        Cliente cliente = consultarPorCpf(cpf);
        if(cliente != null){
            cliente.setTelefone(telefone);
            System.out.println("Telefone atualizado com sucesso");
        }else{
            System.out.println("Cliente não encontrado");
        }
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


    public void removerClientePorCpf(String cpf) {
        Cliente cliente = consultarPorCpf(cpf);
        clienteList.remove(cliente);
    }

    public void removerClientePorEmail(String email) {
        Cliente cliente = consultarPorEmail(email);
        clienteList.remove(cliente);
    }
}