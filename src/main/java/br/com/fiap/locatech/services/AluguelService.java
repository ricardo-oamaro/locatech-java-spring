package br.com.fiap.locatech.services;

import br.com.fiap.locatech.entities.Aluguel;
import br.com.fiap.locatech.repositories.AluguelRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class AluguelService {

    private final AluguelRepository aluguelRepository;

    public AluguelService(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    public List<Aluguel> findAllAlugueis(int page, int size) {
        int offset = (page - 1) * size;
        return this.aluguelRepository.findAll(size, offset);
    }

    public Aluguel findAluguelById(Long id) {
        return this.aluguelRepository.findById(id).orElse(null);
    }

    public void save(Aluguel aluguel) {
        this.aluguelRepository.save(aluguel);
        Assert.state(this.aluguelRepository.save(aluguel) == 1, "Erro ao salvar aluguel");
    }

    public void update(Aluguel aluguel, Long id) {
        this.aluguelRepository.update(aluguel, id);
        if (this.aluguelRepository.update(aluguel, id) == 0) {
            throw new RuntimeException("Erro ao atualizar aluguel");
        }
    }

    public void delete(Long id) {
        this.aluguelRepository.delete(id);
        if (this.aluguelRepository.delete(id) == 0) {
            throw new RuntimeException("Erro ao deletar aluguel");
        }
    }

}
