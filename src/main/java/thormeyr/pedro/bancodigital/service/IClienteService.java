package thormeyr.pedro.bancodigital.service;

import thormeyr.pedro.bancodigital.entity.Cliente;
import thormeyr.pedro.bancodigital.form.ClienteForm;


import java.util.List;

public interface IClienteService {

    List<Cliente> listaClientes();

    Cliente criaCliente(ClienteForm novoCliente);


    Cliente buscaCliente(long cpfCliente);

    void apagaCliente(long cpf);

    Cliente atualizaCliente(long cpf,ClienteForm form);
}
