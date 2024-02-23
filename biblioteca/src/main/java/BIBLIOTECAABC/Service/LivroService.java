package BIBLIOTECAABC.Service;

import BIBLIOTECAABC.Entity.Livro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {
    private List<Livro> livros = new ArrayList<>();

    public String save(Livro livro) {
        livros.add(livro);
        return livro.getTitulo() + " salvo com sucesso";
    }

    public String update(long id, Livro novoLivro) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                livros.set(livros.indexOf(livro), novoLivro);
                return novoLivro.getTitulo() + " atualizado com sucesso";
            }
        }
        return "livro nao encontrado para atualizar";
    }

    public List<Livro> listAll() {
        return livros;
    }

    public Livro findById(long idLivro) {
        for (Livro livro : livros) {
            if (livro.getId() == idLivro) {
                return livro;
            }
        }
        return null;
    }

    public String delete(long idLivro) {
        for (Livro livro : livros) {
            if (livro.getId() == idLivro) {
                livros.remove(livro);
                return "deletado com sucesso";
            }
        }
        return "nao encontrado para deletar";
    }
}
