package thormeyr.pedro.bancodigital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_clientes")
public class Cliente {

    @Id @GeneratedValue
    private long id;

    private long nome;

    @Column(unique = true)
    private long cpf;

    private String cidade;

    @OneToOne()
    private Conta conta;

    private LocalDate dataDeNascimento;

}
