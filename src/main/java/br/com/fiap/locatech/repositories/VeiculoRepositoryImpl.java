package br.com.fiap.locatech.repositories;

import br.com.fiap.locatech.entities.Veiculo;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class VeiculoRepositoryImpl implements VeiculoRepository{

    private final JdbcClient jdbcClient;

    public VeiculoRepositoryImpl(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<Veiculo> findById(Long id) {
        return this.jdbcClient.sql("SELECT * FROM veiculos WHERE id = :id")
                .param("id", id)
                .query(Veiculo.class)
                .optional();
    }

    @Override
    public List<Veiculo> findAll(int size, int offset) {
        return this.jdbcClient
                .sql("SELECT * FROM veiculos LIMIT :size OFFSET :offset")
                .param("size", size)
                .param("offset", offset)
                .query(Veiculo.class)
                .list();
    }

    @Override
    public Integer save(Veiculo veiculo) {
        return this.jdbcClient
                .sql("INSERT INTO veiculos (marca, modelo, placa, ano, cor, valor_diaria) VALUES (:marca, :modelo, :placa, :ano, :cor, :valorDiaria)")
                .params("marca", veiculo.getMarca())
                .params("modelo", veiculo.getModelo())
                .params("placa", veiculo.getPlaca())
                .params("ano", veiculo.getAno())
                .params("cor", veiculo.getCor())
                .params("valorDiaria", veiculo.getValorDiaria())
                .update();
    }

    @Override
    public Integer update(Veiculo veiculo, Long id) {
        return this.jdbcClient
                .sql("UPDATE veiculos SET marca = :marca, modelo = :modelo, placa = :placa, ano = :ano, cor = :cor, valor_diaria = :valorDiaria WHERE id = :id")
                .params("marca", veiculo.getMarca())
                .params("modelo", veiculo.getModelo())
                .params("placa", veiculo.getPlaca())
                .params("ano", veiculo.getAno())
                .params("cor", veiculo.getCor())
                .params("valorDiaria", veiculo.getValorDiaria())
                .params("id", id)
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return this.jdbcClient
                .sql("DELETE FROM veiculos WHERE id = :id")
                .param("id", id)
                .update();
    }
}
