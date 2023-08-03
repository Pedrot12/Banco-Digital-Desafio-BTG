package thormeyr.pedro.bancodigital.service.impl;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thormeyr.pedro.bancodigital.entity.Cliente;
import thormeyr.pedro.bancodigital.entity.Conta;
import thormeyr.pedro.bancodigital.repository.ClienteRepository;
import thormeyr.pedro.bancodigital.repository.ContaRepository;
import thormeyr.pedro.bancodigital.service.IContaService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContaServiceImpl implements IContaService {

    @Autowired
    private ContaRepository contaRepository;


    @Override
    public Conta criaConta(Cliente cliente) {
        Conta novaConta = new Conta();
        novaConta.setSaldo(0);
        novaConta.setCliente(cliente);
        return contaRepository.save(novaConta);
    }

    @Override
    public List<Conta> listaConta() {
        return contaRepository.findAll();
    }

    @Override
    public Conta buscaConta(long id) {
        return contaRepository.findById(id).get();
    }

    @Override
    public Conta sacarValor(long id, Double valor) {
        Conta conta = contaRepository.findById(id).get();
        Double saldoAtual = conta.getSaldo();
        ArrayList<Double> saques =  conta.getSaques();
        if(saldoAtual>=valor){
            conta.setSaldo(saldoAtual-valor);
            saques.add(valor);
            conta.setSaques(saques);
        }
        else{
            System.out.println("Saldo Insulficiente");
        }
        return contaRepository.save(conta);
    }

    public Conta depositarValor(long id, Double valor) {
        Conta conta = contaRepository.findById(id).get();
        Double saldoAtual = conta.getSaldo();
        ArrayList<Double> depositos =  conta.getDepositos();
        conta.setSaldo(saldoAtual+valor);
        depositos.add(valor);
        conta.setDepositos(depositos);
        return contaRepository.save(conta);
    }

    @Override
    public List<Double> listaSaques(long id) {
        Conta conta = contaRepository.findById(id).get();
        return conta.getSaques();
    }

    @Override
    public List<Double> listaDepositos(long id) {
        Conta conta = contaRepository.findById(id).get();
        return conta.getDepositos();
    }

    @Override
    public void apagaConta(long id) {
        contaRepository.deleteById(id);
    }
}
