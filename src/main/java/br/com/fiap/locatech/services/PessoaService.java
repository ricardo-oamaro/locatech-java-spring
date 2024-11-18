package br.com.fiap.locatech.services;

import br.com.fiap.locatech.entities.Pessoa;
import br.com.fiap.locatech.repositories.PessoaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public void save(Pessoa pessoa) {
        var save = this.pessoaRepository.save(pessoa);
        Assert.state(save == 1, "Erro ao salvar pessoa");
    }

    public void updatePessoa(Pessoa pessoa, Long id) {
        var update = this.pessoaRepository.update(pessoa, id);
        if (update == 0) {
            throw new RuntimeException("Erro ao atualizar pessoa");
        }
    }

    public void deletePessoa(Long id) {
        var delete = this.pessoaRepository.delete(id);
        if (delete== 0) {
            throw new RuntimeException("Erro ao deletar pessoa");
        }
    }

    public Pessoa findPessoaById(Long id) {
        return this.pessoaRepository.findById(id).orElse(null);
    }

    public List<Pessoa> findAll(int page, int size) {
        int offset = (page - 1) * size;
        return this.pessoaRepository.findAll(size, offset);
    }
}

