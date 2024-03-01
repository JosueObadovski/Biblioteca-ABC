package BIBLIOTECAABC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import BIBLIOTECAABC.Entity.Biblioteca;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {
}
