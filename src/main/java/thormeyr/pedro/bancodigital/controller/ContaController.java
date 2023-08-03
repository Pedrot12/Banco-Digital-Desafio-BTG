package thormeyr.pedro.bancodigital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import thormeyr.pedro.bancodigital.entity.Cliente;
import thormeyr.pedro.bancodigital.entity.Conta;
import thormeyr.pedro.bancodigital.service.impl.ContaServiceImpl;

import java.util.List;


@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaServiceImpl service;

    @PostMapping
    public Conta criaConta(@RequestBody Cliente cliente){
        return service.criaConta(cliente);
    }
    @GetMapping
    public List<Conta> listaConta(){ return service.listaConta();}

    @GetMapping("/busca/{id}")
    public Conta buscaConta(@PathVariable long id){ return service.buscaConta(id);}

    @PostMapping("/sacar/{id}/{valor}")
    public Conta sacarValor(@PathVariable("id") long id, @PathVariable("valor") Double valor){
        return service.sacarValor(id,valor);
    }

    @PostMapping("/depositar/{id}/{valor}")
    public Conta depositarValor(@PathVariable("id") long id, @PathVariable("valor") Double valor){
        return service.depositarValor(id,valor);
    }

    @GetMapping("/saques/{id}")
    public List<Double> listaSaques(@PathVariable long id){
        return service.listaSaques(id);
    }

    @GetMapping("/depositos/{id}")
    public List<Double> listaDepositos(@PathVariable long id){
        return service.listaDepositos(id);
    }

    @PostMapping("/apaga/{id}")
    public void apagaConta(@PathVariable long id){ service.apagaConta(id);}






}
