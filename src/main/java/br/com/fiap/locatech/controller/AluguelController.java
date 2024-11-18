package br.com.fiap.locatech.controller;

import br.com.fiap.locatech.dto.AluguelRequestDTO;
import br.com.fiap.locatech.entities.Aluguel;
import br.com.fiap.locatech.repositories.VeiculoRepository;
import br.com.fiap.locatech.services.AluguelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    private static final Logger logger = LoggerFactory.getLogger(AluguelController.class);

    private final AluguelService aluguelService;

    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @GetMapping
    public ResponseEntity<List<Aluguel>> findAllAlugueis(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ){
        logger.info("/alugueis");
        var alugueis = this.aluguelService.findAllAlugueis(page, size);
        return ResponseEntity.ok(alugueis);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluguel> findAluguelById(
            @RequestParam("id") Long id
    ){
        logger.info("/alugueis" + id);
        var aluguel = this.aluguelService.findAluguelById(id);
        return ResponseEntity.ok(aluguel);
    }

    @PostMapping
    public ResponseEntity<Void> saveAluguel(
            @RequestBody AluguelRequestDTO aluguel
    ){
        logger.info("POST -> /aluguel");
        this.aluguelService.save(aluguel);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAluguel(
            @RequestParam("id") Long id,
            @RequestBody Aluguel aluguel
    ){
        logger.info("PUT -> /aluguel" + id);
        this.aluguelService.update(aluguel, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluguel(
            @RequestParam("id") Long id
    ){
        logger.info("DELETE -> /aluguel" + id);
        this.aluguelService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
