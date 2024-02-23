package BIBLIOTECAABC.Service;

import BIBLIOTECAABC.Entity.Autor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AutorService {
    private List<Autor> autores = new ArrayList<>();

    public String save(Autor autor) {
        autores.add(autor);
        return autor.getNome() + " salvo com sucesso";
    }

    public String update(int id, Autor novoAutor) {
        for (Autor autor : autores) {
            if (autor.getId() == id) {
                autores.set(autores.indexOf(autor), novoAutor);
                return novoAutor.getNome() + " atualizado com sucesso";
            }
        }
        return "Autor não encontrado para atualizar";
    }

    public List<Autor> listAll() {
        return autores;
    }

    public Autor findById(int idAutor) {
        for (Autor autor : autores) {
            if (autor.getId() == idAutor) {
                return autor;
            }
        }
        return null;
    }

    public String delete(int idAutor) {
        for (Autor autor : autores) {
            if (autor.getId() == idAutor) {
                autores.remove(autor);
                return "Deletado com sucesso";
            }
        }
        return "Não encontrado para deletar";
    }
}
