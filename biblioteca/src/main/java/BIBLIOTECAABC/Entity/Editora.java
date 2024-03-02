package BIBLIOTECAABC.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Editora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "O nome não pode ser nulo.")
    private String nome;

    @NotNull(message = "O endereço não pode ser nulo.")
    private String endereco;

    @NotNull(message = "O telefone não pode ser nulo.")
    private String telefone;

    @OneToMany(mappedBy = "editora", cascade = CascadeType.ALL)
    private List<Livro> livros;
}
