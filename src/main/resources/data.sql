CREATE TABLE veiculos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(255) NOT NULL,
    modelo VARCHAR(255) NOT NULL,
    placa VARCHAR(255) NOT NULL,
    ano INT NOT NULL,
    cor VARCHAR(255) NOT NULL,
    valor_diaria DECIMAL(10, 2) NOT NULL
);

CREATE TABLE pessoas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(255) NOT NULL,
    telefone VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);
CREATE TABLE alugueis (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    veiculo_id BIGINT NOT NULL,
    pessoa_id BIGINT NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE NOT NULL,
    valor_total DECIMAL(10, 2) NOT NULL
);


INSERT INTO veiculos (marca, modelo, placa, ano, cor, valor_diaria) VALUES ('Chevrolet', 'Onix', 'ABC-1234', 2020, 'Preto', 100.00);

INSERT INTO pessoas (nome, cpf, telefone, email) VALUES ('João', '123.456.789-00', '11 99999-9999', 'teste@teste.com');

INSERT INTO alugueis (veiculo_id, pessoa_id, data_inicio, data_fim, valor_total) VALUES (1, 1, '2021-01-01', '2021-01-02', 100.00);