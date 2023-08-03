package thormeyr.pedro.bancodigital.service;

import thormeyr.pedro.bancodigital.entity.Cliente;
import thormeyr.pedro.bancodigital.entity.Conta;
import thormeyr.pedro.bancodigital.form.ClienteForm;

import java.util.List;

public interface IContaService {

    Conta criaConta(Cliente cliente);

    List<Conta> listaConta();

    Conta buscaConta(long id);

    Conta sacarValor(long id, Double valor);

    Conta depositarValor(long id, Double valor);

    List<Double> listaSaques(long id);

    List<Double> listaDepositos(long id);

    void apagaConta(long id);
}
