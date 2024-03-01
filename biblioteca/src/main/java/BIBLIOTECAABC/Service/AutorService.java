package BIBLIOTECAABC.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BIBLIOTECAABC.Entity.Autor;
import BIBLIOTECAABC.Repository.AutorRepository;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public String save(Autor autor) {
        this.autorRepository.save(autor);
        return autor.getNome() + " salvo com sucesso";
    }

    public String update(long id, Autor autor) {
        autor.setId(id);
        this.autorRepository.save(autor);
        return "Autor atualizado com sucesso";
    }

    public List<Autor> listAll(){
        return this.autorRepository.findAll();
    }

    public Autor findById(long idAutor) {
        return this.autorRepository.findById(idAutor).orElse(null);
    }

    public String delete(long idAutor) {
        if (this.autorRepository.existsById(idAutor)) {
            this.autorRepository.deleteById(idAutor);
            return "Deletado com sucesso";
        } else {
            return "Não encontrado para deletar";
        }
    }
}
