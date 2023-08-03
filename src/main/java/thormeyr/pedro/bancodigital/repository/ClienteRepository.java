package thormeyr.pedro.bancodigital.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import thormeyr.pedro.bancodigital.entity.Cliente;
import thormeyr.pedro.bancodigital.form.ClienteForm;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    Cliente findByCpf(long cpf);

}
