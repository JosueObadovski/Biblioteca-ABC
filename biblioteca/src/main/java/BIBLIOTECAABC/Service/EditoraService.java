package BIBLIOTECAABC.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BIBLIOTECAABC.Entity.Editora;
import BIBLIOTECAABC.Repository.EditoraRepository;

@Service
public class EditoraService {

    @Autowired
    private EditoraRepository editoraRepository;

    public String save(Editora editora) {
        this.editoraRepository.save(editora);
        return editora.getNome() + " adicionada com sucesso";
    }

    public String update(long id, Editora editora) {
        editora.setId(id);
        this.editoraRepository.save(editora);
        return editora.getNome() + " atualizada com sucesso";
    }

    public List<Editora> listAll() {
        return this.editoraRepository.findAll();
    }

    public Editora findById(long idEditora) {
        return this.editoraRepository.findById(idEditora).orElse(null);
    }

    public String delete(long idEditora) {
        this.editoraRepository.deleteById(idEditora);
        return "Deletada com sucesso";
    }
}
