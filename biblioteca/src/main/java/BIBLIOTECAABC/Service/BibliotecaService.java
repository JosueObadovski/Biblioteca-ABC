package BIBLIOTECAABC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import BIBLIOTECAABC.Entity.Biblioteca;
import BIBLIOTECAABC.Repository.BibliotecaRepository;

@Service
public class BibliotecaService {

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    public String save(Biblioteca biblioteca) {
        this.bibliotecaRepository.save(biblioteca);
        return biblioteca.getNome() + " salva com sucesso";
    }

    public String update(long id, Biblioteca biblioteca) {
        biblioteca.setId(id);
        this.bibliotecaRepository.save(biblioteca);
        return biblioteca.getNome() + " atualizada com sucesso";
    }

    public List<Biblioteca> listAll() {
        return this.bibliotecaRepository.findAll();
    }

    public Biblioteca findById(long idBiblioteca) {
        return this.bibliotecaRepository.findById(idBiblioteca).orElse(null);
    }

    public String delete(long idBiblioteca) {
        this.bibliotecaRepository.deleteById(idBiblioteca);
        return "Deletada com sucesso";
    }
}
