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
        clienteList.add(cliente);
    }

    public List<Cliente> consultarTodos(){
        return clienteList;
    }

    public Optional<Cliente> consultarPorCpf(String cpf) {
        return clienteList.stream()
                .filter(cliente -> cliente.getCpf().equals(cpf))
                .findFirst();
    }
    public Optional<Cliente> consultarPorEmail(String email) {
        return clienteList.stream()
                .filter(cliente -> cliente.getEmail().equals(email))
                .findFirst();
    }
    public void atualizarEmailCliente(String email, String cpf){
        Optional<Cliente> cliente = consultarPorCpf(cpf);
        if(cliente.isPresent()){
            cliente.get().setEmail(email);
            System.out.println("Email atualizado com sucesso");
        }
        else {
            System.out.println("Cliente não encontrado");
        }
    }

    public void atualizarTelefoneCliente(String telefone, String cpf){
        Optional<Cliente> cliente = consultarPorCpf(cpf);
        if(cliente.isPresent()){
            cliente.get().setTelefone(telefone);
            System.out.println("Telefone atualizado com sucesso");
        }else{
            System.out.println("Cliente não encontrado");
        }
    }

    public void removerClientePorCpf(String cpf) {
        consultarPorCpf(cpf).ifPresent(clienteList::remove);
    }

    public void removerClientePorEmail(String email) {
        consultarPorEmail(email).ifPresent(clienteList::remove);
    }
}