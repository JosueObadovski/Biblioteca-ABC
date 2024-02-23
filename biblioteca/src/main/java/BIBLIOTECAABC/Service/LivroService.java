package BIBLIOTECAABC.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import BIBLIOTECAABC.Entity.Livro;

@Service
public class LivroService {
    List<Livro> lista = new ArrayList<>();
    
    public String save(Livro livro) {
        lista.add(livro);
        return livro.getTitulo() + " salvo com sucesso";
    }

    public String update(long id, Livro livro) {
        lista = this.listAll();

        if (lista != null) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getId() == id) {
                    lista.set(i, livro);
                    return livro.getTitulo() + " atualizado com sucesso";
                }
            }
        }

        return "Livro não encontrado para atualizar";
    }

    public List<Livro> listAll() {
    	
    	Livro Livro = new Livro(1, "978-3-16-148410-0", "Aventuras na Floresta", "Um grupo de exploradores se aventura pela densa floresta em busca de um tesouro perdido.", 2000, 300);
        Livro Livro2 = new Livro(2, "978-3-16-148410-1", "O Segredo do Deserto", "Um arqueólogo descobre um antigo segredo escondido nas areias do deserto.", 1995, 250);
        Livro Livro3 = new Livro(3, "978-3-16-148410-2", "Mistério na Cidade", "Um detetive particular é contratado para solucionar uma série de crimes misteriosos na cidade.", 2010, 350);

    	lista.add(Livro);
    	lista.add(Livro2);
    	lista.add(Livro3);
    	
    	return lista;
    }

    public Livro findById(long idLivro) {
        lista = this.listAll();

        if (lista != null) 
        	for(int i=0; i<lista.size(); i++) {
				if(lista.get(i).getId() == idLivro) {
					return lista.get(i);
				}
			}
        
		return null;
    }
    
    public String delete(long idLivro) {
        lista = this.listAll();

        if (lista != null) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getId() == idLivro) {
                	lista.remove(lista.get(i));
                    return "Deletado com sucesso";
                }
            }
        }

        return "Não encontrado para deletar";
    }
}
