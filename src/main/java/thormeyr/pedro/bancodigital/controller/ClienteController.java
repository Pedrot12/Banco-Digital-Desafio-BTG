package thormeyr.pedro.bancodigital.controller;

import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Mostra todos os clientes cadastrados")
    @GetMapping
    public List<Cliente> listaClientes(){
        return service.listaClientes();
    }

    @Operation(summary = "Cadastra um novo cliente")
    @PostMapping
    public Cliente criaCliente(@RequestBody ClienteForm novoCliente){
        return service.criaCliente(novoCliente);
    }

    @Operation(summary = "Apaga um cliente pelo seu cpf")
    @PostMapping("/apaga/{cpf}")
    public void apagaCliente(@PathVariable long cpf){
        service.apagaCliente(cpf);}

    @Operation(summary = "Atualiza o cadastro de um cliente")
    @PostMapping("/atualiza/{cpf}")
    public Cliente atualizaCliente(@PathVariable long cpf,@RequestBody ClienteForm form){
        return service.atualizaCliente(cpf,form);
    }
    @Operation(summary = "Busca um cliente pelo cpf")
    @GetMapping("/busca/{cpf}")
    public Cliente buscaCliente(@PathVariable long cpf){ return service.buscaCliente(cpf);}




}
