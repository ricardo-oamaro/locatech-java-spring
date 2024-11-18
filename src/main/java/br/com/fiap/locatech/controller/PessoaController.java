package br.com.fiap.locatech.controller;

import br.com.fiap.locatech.entities.Pessoa;
import br.com.fiap.locatech.services.PessoaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private static final Logger logger = LoggerFactory.getLogger(PessoaController.class);

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAllPessoas(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ){
        logger.info("/pessoas");
        var pessoas = this.pessoaService.findAll(page, size);
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> findPessoaById(
            @PathVariable("id") Long id
    ){
        logger.info("/pessoas" + id);
        var pessoa = this.pessoaService.findPessoaById(id);
        return ResponseEntity.ok(Optional.ofNullable(pessoa));
    }

    @PostMapping
    public ResponseEntity<Void> savePessoa(
            @RequestBody Pessoa pessoa
    ){
        logger.info("POST -> /pessoa");
        this.pessoaService.save(pessoa);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePessoa(
            @PathVariable("id") Long id,
            @RequestBody Pessoa pessoa
    ){
        logger.info("PUT -> /pessoa" + id);
        this.pessoaService.update(pessoa, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(
            @PathVariable("id") Long id
    ){
        logger.info("DELETE -> /pessoa" + id);
        this.pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
