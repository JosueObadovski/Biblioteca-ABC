package BIBLIOTECAABC.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BIBLIOTECAABC.Entity.Livro;
import BIBLIOTECAABC.Repository.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public String save(Livro livro) {
        this.livroRepository.save(livro);
        return livro.getTitulo() + " salvo com sucesso";
    }

    public String update(long id, Livro livro) {
        if (this.livroRepository.existsById(id)) {
            livro.setId(id);
            this.livroRepository.save(livro);
            return livro.getTitulo() + " atualizado com sucesso";
        } else {
            return "Livro não encontrado para atualizar";
        }
    }

    public List<Livro> listAll() {
        return this.livroRepository.findAll();
    }

    public Livro findById(long idLivro) {
        return this.livroRepository.findById(idLivro).orElse(null);
    }

    public String delete(long idLivro) {
        if (this.livroRepository.existsById(idLivro)) {
            this.livroRepository.deleteById(idLivro);
            return "Deletado com sucesso";
        } else {
            return "Não encontrado para deletar";
        }
    }
}
