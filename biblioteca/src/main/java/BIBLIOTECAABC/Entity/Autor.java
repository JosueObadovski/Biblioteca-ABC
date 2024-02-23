package BIBLIOTECAABC.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Autor {
    private long id;
    private String nome;
    private String cpf;
    private int idade;
}
