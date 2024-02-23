package BIBLIOTECAABC.Controller;

import BIBLIOTECAABC.Entity.Autor;
import BIBLIOTECAABC.Service.AutorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Autor autor) {
        try {
            String mensagem = autorService.save(autor);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Ocorreu um erro ao salvar o autor: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Autor autor, @PathVariable int id) {
        try {
            String mensagem = autorService.update(id, autor);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Ocorreu um erro ao atualizar o autor: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Autor>> listAll() {
        try {
            List<Autor> todosAutores = autorService.listAll();
            return new ResponseEntity<>(todosAutores, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Autor> findById(@PathVariable int id) {
        try {
            Autor autor = autorService.findById(id);
            if (autor != null) {
                return new ResponseEntity<>(autor, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        try {
            String mensagem = autorService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Ocorreu um erro ao deletar o autor: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
