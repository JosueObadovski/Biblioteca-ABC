package BIBLIOTECAABC.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import BIBLIOTECAABC.Entity.Autor;

@Service
public class AutorService {
    List<Autor> lista = new ArrayList<>();

    public String save(Autor autor) {
        lista.add(autor);
        return autor.getNome() + " salvo com sucesso";
    }

    public String update(long id, Autor autor) {
        lista = this.listAll();

        if (lista != null) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getId() == id) {
                    lista.set(i, autor);
                    return autor.getNome() + " atualizado com sucesso";
                }
            }
        }

        return "Autor não encontrado para atualizar";
    }

    public List<Autor> listAll() {
    	
        Autor Autor = new Autor(1, "João Silva", "123.456.789-00", 30);
        Autor Autor2 = new Autor(2, "Maria Santos", "987.654.321-00", 35);
        Autor Autor3 = new Autor(3, "Pedro Oliveira", "555.666.777-00", 40);
        
    	lista.add(Autor);
    	lista.add(Autor2);
    	lista.add(Autor3);
    	
    	return lista;
    }

    public Autor findById(long idAutor) {
        lista = this.listAll();

        if (lista != null) 
			for(int i=0; i<lista.size(); i++) {
				if(lista.get(i).getId() == idAutor) {
					return lista.get(i);
				}
			}
        
		return null;
    }

    public String delete(long idAutor) {
        lista = this.listAll();

        if (lista != null) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getId() == idAutor) {
                	lista.remove(lista.get(i));
                    return "Deletado com sucesso";
                }
            }
        }

        return "Não encontrado para deletar";
    }
}
