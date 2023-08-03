package thormeyr.pedro.bancodigital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thormeyr.pedro.bancodigital.entity.Cliente;
import thormeyr.pedro.bancodigital.repository.ClienteRepository;
import thormeyr.pedro.bancodigital.service.IClienteService;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteRepository repository;
    @Override
    public List<Cliente> listaClientes(){
        return repository.findAll();

    }

    @Override
    public Cliente criaCliente(Cliente novoCliente) {
        Cliente cliente = new Cliente();
        cliente.setNome(novoCliente.getNome());
        cliente.setCpf(novoCliente.getCpf());
        cliente.setDataDeNascimento(novoCliente.getDataDeNascimento());
        cliente.setCidade(novoCliente.getCidade());

        return repository.save(cliente);
    }
}
