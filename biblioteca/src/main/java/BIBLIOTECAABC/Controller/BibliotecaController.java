package BIBLIOTECAABC.Controller;

import BIBLIOTECAABC.Entity.Biblioteca;
import BIBLIOTECAABC.Service.BibliotecaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/biblioteca")
public class BibliotecaController {

    @Autowired
    private BibliotecaService bibliotecaService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Biblioteca biblioteca) {
        try {
            String mensagem = bibliotecaService.save(biblioteca);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Ocorreu um erro ao salvar a biblioteca: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Biblioteca biblioteca, @PathVariable int id) {
        try {
            String mensagem = bibliotecaService.update(id, biblioteca);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Ocorreu um erro ao atualizar a biblioteca: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Biblioteca>> listAll() {
        try {
            List<Biblioteca> todasBibliotecas = bibliotecaService.listAll();
            return new ResponseEntity<>(todasBibliotecas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Biblioteca> findById(@PathVariable int id) {
        try {
            Biblioteca biblioteca = bibliotecaService.findById(id);
            if (biblioteca != null) {
                return new ResponseEntity<>(biblioteca, HttpStatus.OK);
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
            String mensagem = bibliotecaService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Ocorreu um erro ao deletar a biblioteca: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
