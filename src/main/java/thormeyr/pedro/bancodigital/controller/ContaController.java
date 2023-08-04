package thormeyr.pedro.bancodigital.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

    @Hidden
    @PostMapping
    public Conta criaConta(@Parameter(hidden = true) @RequestBody Cliente cliente){
        return service.criaConta(cliente);
    }

    @Operation(summary = "Lista todas as contas")
    @GetMapping
    public List<Conta> listaConta(){ return service.listaConta();}

    @Operation(summary = "Busca uma conta pelo numero da conta")
    @GetMapping("/busca/{numeroConta}")
    public Conta buscaConta(@PathVariable long numeroConta){ return service.buscaConta(numeroConta);}

    @Operation(summary = "Saca o valor de uma conta")
    @PostMapping("/sacar/{numeroConta}/{valor}")
    public Conta sacarValor(@Parameter(name = "numeroConta") @PathVariable("numeroConta") long numeroConta,@Parameter(name = "valor") @PathVariable("valor") Double valor){
        return service.sacarValor(numeroConta,valor);
    }

    @Operation(summary = "Deposita o valor em uma conta")
    @PostMapping("/depositar/{numeroConta}/{valor}")
    public Conta depositarValor(@Parameter(name = "numeroConta") @PathVariable("numeroConta") long numeroConta,@Parameter(name = "valor") @PathVariable("valor") Double valor){
        return service.depositarValor(numeroConta,valor);
    }

    @Operation(summary = "Apresentas as movimentações de saques em uma conta")
    @GetMapping("/saques/{numeroConta}")
    public List<Double> listaSaques(@PathVariable long numeroConta){
        return service.listaSaques(numeroConta);
    }

    @Operation(summary = "Apresentas as movimentações de depósitos em uma conta")
    @GetMapping("/depositos/{numeroConta}")
    public List<Double> listaDepositos(@PathVariable long numeroConta){
        return service.listaDepositos(numeroConta);
    }

    @Hidden
    @PostMapping("/apaga/{numeroConta}")
    public void apagaConta(@Parameter(hidden = true) @PathVariable long numeroConta){ service.apagaConta(numeroConta);}






}
