package BIBLIOTECAABC.Controller;

import BIBLIOTECAABC.Entity.Editora;
import BIBLIOTECAABC.Service.EditoraService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/editora")
public class EditoraController {

    @Autowired
    private EditoraService editoraService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Editora editora) {
        try {
            String mensagem = editoraService.save(editora);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Ocorreu um erro ao salvar a editora: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Editora editora, @PathVariable int id) {
        try {
            String mensagem = editoraService.update(id, editora);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Ocorreu um erro ao atualizar a editora: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Editora>> listAll() {
        try {
            List<Editora> todasEditoras = editoraService.listAll();
            return new ResponseEntity<>(todasEditoras, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Editora> findById(@PathVariable int id) {
        try {
            Editora editora = editoraService.findById(id);
            if (editora != null) {
                return new ResponseEntity<>(editora, HttpStatus.OK);
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
            String mensagem = editoraService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Ocorreu um erro ao deletar a editora: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
