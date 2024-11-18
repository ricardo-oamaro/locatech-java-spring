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
        this.pessoaRepository.save(pessoa);
        Assert.state(this.pessoaRepository.save(pessoa) == 1, "Erro ao salvar pessoa");
    }

    public void update(Pessoa pessoa, Long id) {
        this.pessoaRepository.update(pessoa, id);
        if (this.pessoaRepository.update(pessoa, id) == 0) {
            throw new RuntimeException("Erro ao atualizar pessoa");
        }
    }

    public void delete(Long id) {
        this.pessoaRepository.delete(id);
        if (this.pessoaRepository.delete(id) == 0) {
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

