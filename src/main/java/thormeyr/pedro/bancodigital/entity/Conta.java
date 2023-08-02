package thormeyr.pedro.bancodigital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_contas")
public class Conta {

    @Id @GeneratedValue
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private long  numeroConta;

    private double saldo;

    private ArrayList<Double> depositos= new ArrayList<Double>();

    private ArrayList<Double> saques= new ArrayList<Double>();

}
