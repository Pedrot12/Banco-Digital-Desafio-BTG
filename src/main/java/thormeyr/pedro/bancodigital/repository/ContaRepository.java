package thormeyr.pedro.bancodigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thormeyr.pedro.bancodigital.entity.Cliente;
import thormeyr.pedro.bancodigital.entity.Conta;

public interface ContaRepository extends JpaRepository<Conta,Long> {


}
