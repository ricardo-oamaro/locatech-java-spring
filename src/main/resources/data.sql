CREATE TABLE veiculos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(255) NOT NULL,
    modelo VARCHAR(255) NOT NULL,
    placa VARCHAR(255) NOT NULL,
    ano INT NOT NULL,
    cor VARCHAR(255) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL
);

INSERT INTO veiculos (marca, modelo, placa, ano, cor, valor) VALUES ('Chevrolet', 'Onix', 'ABC-1234', 2020, 'Preto', 100.00);


CREATE TABLE pessoas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(255) NOT NULL,
    telefone VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

INSERT INTO pessoas (nome, cpf, telefone, email) VALUES ('João', '123.456.789-00', '11 99999-9999', 'teste@teste.com');