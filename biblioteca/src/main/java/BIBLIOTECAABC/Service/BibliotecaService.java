package BIBLIOTECAABC.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import BIBLIOTECAABC.Entity.Biblioteca;

@Service
public class BibliotecaService {
    List<Biblioteca> lista = new ArrayList<>();

    public String save(Biblioteca biblioteca) {
        lista.add(biblioteca);
        return biblioteca.getNome() + " salva com sucesso";
    }

    public String update(long id, Biblioteca biblioteca) {
        lista = this.listAll();

        if (lista != null) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getId() == id) {
                    lista.set(i, biblioteca);
                    return biblioteca.getNome() + " atualizada com sucesso";
                }
            }
        }

        return "Biblioteca não encontrada para atualizar";
    }

    public List<Biblioteca> listAll() {
    	
    	Biblioteca biblioteca = new Biblioteca(1, "Biblioteca Central", "(11) 1234-5678");
    	Biblioteca biblioteca2 = new Biblioteca(2, "Biblioteca Municipal", "(21) 9876-5432");
    	Biblioteca biblioteca3 = new Biblioteca(3, "Biblioteca Pública", "(31) 5555-5555");
    	
    	lista.add(biblioteca);
    	lista.add(biblioteca2);
    	lista.add(biblioteca3);
    	
    	return lista;
    }

    public Biblioteca findById(long idBiblioteca) {
        lista = this.listAll();

        if (lista != null) 
        	for(int i=0; i<lista.size(); i++) {
				if(lista.get(i).getId() == idBiblioteca) {
					return lista.get(i);
				}
			}
        
		return null;
    }

    public String delete(long idBiblioteca) {
        lista = this.listAll();

        if (lista != null) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getId() == idBiblioteca) {
                	lista.remove(lista.get(i));
                    return "Deletada com sucesso";
                }
            }
        }

        return "Não encontrada para deletar";
    }
}
