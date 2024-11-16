package br.com.fiap.locatech.services;

import br.com.fiap.locatech.entities.Veiculo;
import br.com.fiap.locatech.repositories.VeiculoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public List<Veiculo> findAll(int page, int size) {
        int offset = (page - 1) * size;
        return veiculoRepository.findAll(size, offset);
    }

    public Optional<Veiculo> findVeiculoById(Long id) {
        return veiculoRepository.findById(id);
    }

    public void saveVeiculo(Veiculo veiculo) {
        var save = this.veiculoRepository.save(veiculo);
        Assert.state(save == 1, "Erro ao salvar veículo");
    }

    public void updateVeiculo(Veiculo veiculo, Long id) {
        var update = this.veiculoRepository.update(veiculo, id);
        if(update == 0) {
            throw new RuntimeException("Erro ao atualizar veículo");
        }
    }

    public void deleteVeiculo(Long id) {
        var delete = this.veiculoRepository.delete(id);
        if(delete == 0) {
            throw new RuntimeException("Erro ao deletar veículo");
        }
    }
}
