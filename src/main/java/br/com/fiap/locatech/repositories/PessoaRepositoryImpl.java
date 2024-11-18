package br.com.fiap.locatech.repositories;

import br.com.fiap.locatech.entities.Pessoa;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PessoaRepositoryImpl implements PessoaRepository{

    private final JdbcClient jdbcClient;

    public PessoaRepositoryImpl(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<Pessoa> findById(Long id) {
        return this.jdbcClient
                .sql("SELECT * FROM pessoas WHERE id = :id")
                .param("id", id)
                .query(Pessoa.class)
                .optional();
    }

    @Override
    public List<Pessoa> findAll(int size, int offset) {
        return this.jdbcClient
                .sql("SELECT * FROM pessoas LIMIT :size OFFSET :offset")
                .param("size", size)
                .param("offset", offset)
                .query(Pessoa.class)
                .list();
    }

    @Override
    public Integer save(Pessoa pessoa) {
        return this.jdbcClient
                .sql("INSERT INTO pessoas (nome, cpf, email, telefone) VALUES (:nome, :cpf, :email, :telefone)")
                .params("nome", pessoa.getNome())
                .params("cpf", pessoa.getCpf())
                .params("email", pessoa.getEmail())
                .params("telefone", pessoa.getTelefone())
                .update();
    }

    @Override
    public Integer update(Pessoa pessoa, Long id) {
        return this.jdbcClient
                .sql("UPDATE pessoas SET nome = :nome, cpf = :cpf, email = :email, telefone = :telefone WHERE id = :id")
                .params("nome", pessoa.getNome())
                .params("cpf", pessoa.getCpf())
                .params("email", pessoa.getEmail())
                .params("telefone", pessoa.getTelefone())
                .params("id", id)
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return this.jdbcClient
                .sql("DELETE FROM pessoas WHERE id = :id")
                .param("id", id)
                .update();
    }
}
