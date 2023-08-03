package thormeyr.pedro.bancodigital.service;

import thormeyr.pedro.bancodigital.entity.Cliente;


import java.util.List;

public interface IClienteService {

    List<Cliente> listaClientes();

    Cliente criaCliente(Cliente novoCliente);


}
