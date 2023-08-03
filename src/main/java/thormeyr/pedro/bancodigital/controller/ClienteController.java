package thormeyr.pedro.bancodigital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import thormeyr.pedro.bancodigital.entity.Cliente;
import thormeyr.pedro.bancodigital.form.ClienteForm;
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
    public Cliente criaCliente(@RequestBody ClienteForm novoCliente){
        return service.criaCliente(novoCliente);
    }


    @PostMapping("/apaga/{cpf}")
    public void apagaCliente(@PathVariable long cpf){
        service.apagaCliente(cpf);}

    @PostMapping("/atualiza/{cpf}")
    public Cliente atualizaCliente(@PathVariable long cpf,@RequestBody ClienteForm form){
        return service.atualizaCliente(cpf,form);
    }

    @GetMapping("/busca/{cpf}")
    public Cliente buscaCliente(@PathVariable long cpf){ return service.buscaCliente(cpf);}




}
