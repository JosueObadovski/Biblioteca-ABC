package BIBLIOTECAABC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import BIBLIOTECAABC.Entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
