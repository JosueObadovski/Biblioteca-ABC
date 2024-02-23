package BIBLIOTECAABC.Controller;

import BIBLIOTECAABC.Entity.Livro;
import BIBLIOTECAABC.Service.LivroService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Livro livro) {
        try {
            String mensagem = livroService.save(livro);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Ocorreu um erro ao salvar o livro: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Livro livro, @PathVariable long id) {
        try {
            String mensagem = livroService.update(id, livro);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Ocorreu um erro ao atualizar o livro: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Livro>> listAll() {
        try {
            List<Livro> todosLivros = livroService.listAll();
            return new ResponseEntity<>(todosLivros, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Livro> findById(@PathVariable long id) {
        try {
            Livro livro = livroService.findById(id);
            if (livro != null) {
                return new ResponseEntity<>(livro, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
           
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        try {
            String mensagem = livroService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Ocorreu um erro ao deletar o livro: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
