package BIBLIOTECAABC.Service;

import BIBLIOTECAABC.Entity.Editora;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EditoraService {
    private List<Editora> editoras = new ArrayList<>();

    public String save(Editora editora) {
        editoras.add(editora);
        return editora.getNome() + " adicionado com sucesso";
    }

    public String update(int id, Editora novaEditora) {
        for (Editora editora : editoras) {
            if (editora.getId() == id) {
                editoras.set(editoras.indexOf(editora), novaEditora);
                return novaEditora.getNome() + " atualizado com sucesso";
            }
        }
        return "editora nao localizada para atualizar";
    }

    public List<Editora> listAll() {
        return editoras;
    }

    public Editora findById(int idEditora) {
        for (Editora editora : editoras) {
            if (editora.getId() == idEditora) {
                return editora;
            }
        }
        return null;
    }

    public String delete(int idEditora) {
        for (Editora editora : editoras) {
            if (editora.getId() == idEditora) {
                editoras.remove(editora);
                return "deletado com sucesso";
            }
        }
        return "nao encontrado para deletar";
    }
}
