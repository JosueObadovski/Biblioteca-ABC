package BIBLIOTECAABC.Service;

import BIBLIOTECAABC.Entity.Biblioteca;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BibliotecaService {
    private List<Biblioteca> bibliotecas = new ArrayList<>();

    public String save(Biblioteca biblioteca) {
        bibliotecas.add(biblioteca);
        return biblioteca.getNome() + " salva com sucesso";
    }

    public String update(int id, Biblioteca novaBiblioteca) {
        for (Biblioteca biblioteca : bibliotecas) {
            if (biblioteca.getId() == id) {
                bibliotecas.set(bibliotecas.indexOf(biblioteca), novaBiblioteca);
                return novaBiblioteca.getNome() + " atualizada com sucesso";
            }
        }
        return "Biblioteca não encontrada para atualizar";
    }

    public List<Biblioteca> listAll() {
        return bibliotecas;
    }

    public Biblioteca findById(int idBiblioteca) {
        for (Biblioteca biblioteca : bibliotecas) {
            if (biblioteca.getId() == idBiblioteca) {
                return biblioteca;
            }
        }
        return null;
    }

    public String delete(int idBiblioteca) {
        for (Biblioteca biblioteca : bibliotecas) {
            if (biblioteca.getId() == idBiblioteca) {
                bibliotecas.remove(biblioteca);
                return "Deletada com sucesso";
            }
        }
        return "Não encontrada para deletar";
    }
}
