package thormeyr.pedro.bancodigital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thormeyr.pedro.bancodigital.entity.Cliente;
import thormeyr.pedro.bancodigital.form.ClienteForm;
import thormeyr.pedro.bancodigital.repository.ClienteRepository;
import thormeyr.pedro.bancodigital.repository.ContaRepository;
import thormeyr.pedro.bancodigital.service.IClienteService;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ContaRepository contaRepository;


    @Autowired
    private ContaServiceImpl contaService;
    @Override
    public List<Cliente> listaClientes(){
        return clienteRepository.findAll();

    }

    @Override
    public Cliente criaCliente(ClienteForm novoCliente) {
        Cliente cliente = new Cliente();
        cliente.setNome(novoCliente.getNome());
        cliente.setCpf(novoCliente.getCpf());
        cliente.setCidade(novoCliente.getCidade());
        contaService.criaConta(cliente);
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente buscaCliente(long cpfCliente) {
        return clienteRepository.findByCpf(cpfCliente);

    }

    @Override
    public void apagaCliente(long cpf) {
        Cliente cliente = clienteRepository.findByCpf(cpf);
        contaService.apagaConta(cliente.getId());
        clienteRepository.deleteById(cliente.getId());
    }

    @Override
    public Cliente atualizaCliente(long cpf,ClienteForm form) {
        Cliente cliente = clienteRepository.findByCpf(cpf);
        cliente.setNome(form.getNome());
        cliente.setCpf(form.getCpf());
        cliente.setCidade(form.getCidade());
        return clienteRepository.save((cliente));

    }
}
