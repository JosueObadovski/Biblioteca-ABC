package BIBLIOTECAABC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BIBLIOTECAABC.Entity.Biblioteca;
import BIBLIOTECAABC.Service.BibliotecaService;

@RestController
@RequestMapping("/api/biblioteca")
public class BibliotecaController {

    @Autowired
    private BibliotecaService bibliotecaService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Biblioteca biblioteca) {
        try {
            String mensagem = bibliotecaService.save(biblioteca);
            return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("Ocorreu um erro ao salvar a biblioteca: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Biblioteca biblioteca, @PathVariable int id) {
        try {
            String mensagem = bibliotecaService.update(id, biblioteca);
            return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("Ocorreu um erro ao atualizar a biblioteca: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Biblioteca>> listAll() {
        try {
            List<Biblioteca> lista = bibliotecaService.listAll();
            return new ResponseEntity<>(lista, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{idBiblioteca}")
    public ResponseEntity<Biblioteca> findById(@PathVariable long idBiblioteca) {
        try {
            Biblioteca biblioteca = this.bibliotecaService.findById(idBiblioteca);
            return new ResponseEntity<>(biblioteca, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{idBiblioteca}")
    public ResponseEntity<String> delete(@PathVariable long idBiblioteca) {
        try {
            String mensagem = this.bibliotecaService.delete(idBiblioteca);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Ocorreu um erro ao deletar a biblioteca: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
