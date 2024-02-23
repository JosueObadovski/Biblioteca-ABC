package BIBLIOTECAABC.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import BIBLIOTECAABC.Entity.Editora;

@Service
public class EditoraService {
    List<Editora> lista = new ArrayList<>();

    public String save(Editora editora) {
        lista.add(editora);
        return editora.getNome() + " adicionada com sucesso";
    }

    public String update(long id, Editora editora) {
        lista = this.listAll();

        if (lista != null) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getId() == id) {
                    lista.set(i, editora);
                    return editora.getNome() + " atualizada com sucesso";
                }
            }
        }

        return "Editora não encontrada para atualizar";
    }

    public List<Editora> listAll() {
    	
    	Editora editora = new Editora(1, "Editora Central", "Av. Principal, 123", "(11) 1234-5678");
        Editora editora2 = new Editora(2, "Editora Nacional", "Rua Principal, 456", "(22) 2345-6789");
        Editora editora3 = new Editora(3, "Editora Popular", "Praça Principal, 789", "(33) 3456-7890");
        
    	lista.add(editora);
    	lista.add(editora2);
    	lista.add(editora3);
    	
    	return lista;
    }

    public Editora findById(long idEditora) {
        lista = this.listAll();

        if (lista != null) 
        	for(int i=0; i<lista.size(); i++) {
				if(lista.get(i).getId() == idEditora) {
					return lista.get(i);
				}
			}
        
		return null;
    }

    public String delete(long idEditora) {
        lista = this.listAll();

        if (lista != null) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getId() == idEditora) {
                	lista.remove(lista.get(i));
                    return "Deletada com sucesso";
                }
            }
        }

        return "Não encontrada para deletar";
    }
}
