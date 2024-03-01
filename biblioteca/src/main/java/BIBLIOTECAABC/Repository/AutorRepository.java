package BIBLIOTECAABC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BIBLIOTECAABC.Entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
