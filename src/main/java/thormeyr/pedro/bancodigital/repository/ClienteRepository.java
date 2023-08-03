package thormeyr.pedro.bancodigital.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import thormeyr.pedro.bancodigital.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
