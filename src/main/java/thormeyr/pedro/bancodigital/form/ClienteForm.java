package thormeyr.pedro.bancodigital.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.br.CPF;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteForm {

    //Verifica se os campos nome estao vazios
    @NotEmpty(message = "Preencha o campo corretamente.")
    private String nome;

    //
    @NotEmpty(message = "Preencha o campo corretamente.")
    private long cpf;

    @NotEmpty(message = "Preencha o campo corretamente.")
    private String cidade;

//    @NotNull(message = "Prencha o campo corretamente.")
//    @Past(message = "Data '${validatedValue}' é inválida.")
//    private LocalDate dataDeNascimento;

}
