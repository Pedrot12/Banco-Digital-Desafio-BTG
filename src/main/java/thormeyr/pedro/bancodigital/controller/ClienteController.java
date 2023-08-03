package thormeyr.pedro.bancodigital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import thormeyr.pedro.bancodigital.entity.Cliente;
import thormeyr.pedro.bancodigital.service.impl.ClienteServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl service;

    @GetMapping
    public List<Cliente> listaClientes(){
        return service.listaClientes();
    }

    @PostMapping
    public Cliente criaCliente(@RequestBody Cliente novoCliente){
        return service.criaCliente(novoCliente);
    }
}
