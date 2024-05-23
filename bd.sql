CREATE database mercadinhojava;
USE mercadinhojava;

CREATE TABLE produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    preco DOUBLE NOT NULL
);
ALTER TABLE produto ADD COLUMN quantidade INT NOT NULL DEFAULT 0;



-- Atualizar a quantidade dos itens existentes
UPDATE produto SET quantidade = 100 WHERE nome = 'Óleo de Soja';
UPDATE produto SET quantidade = 50 WHERE nome = 'Açúcar';
UPDATE produto SET quantidade = 80 WHERE nome = 'Sal';
UPDATE produto SET quantidade = 120 WHERE nome = 'Café';
UPDATE produto SET quantidade = 60 WHERE nome = 'Leite';
UPDATE produto SET quantidade = 40 WHERE nome = 'Farinha de Trigo';
UPDATE produto SET quantidade = 70 WHERE nome = 'Fubá';
UPDATE produto SET quantidade = 90 WHERE nome = 'Sabão em Pó';
UPDATE produto SET quantidade = 75 WHERE nome = 'Detergente';
UPDATE produto SET quantidade = 85 WHERE nome = 'Desinfetante';
UPDATE produto SET quantidade = 100 WHERE nome = 'Papel Higiênico';
UPDATE produto SET quantidade = 70 WHERE nome = 'Sabonete';
UPDATE produto SET quantidade = 80 WHERE nome = 'Shampoo';
UPDATE produto SET quantidade = 60 WHERE nome = 'Condicionador';
UPDATE produto SET quantidade = 50 WHERE nome = 'Escova de Dentes';
UPDATE produto SET quantidade = 65 WHERE nome = 'Creme Dental';

-- Inserir novos itens com quantidade
INSERT INTO produto (nome, preco, quantidade) VALUES ('Detergente Líquido', 10.99, 85);
INSERT INTO produto (nome, preco, quantidade) VALUES ('Amaciante', 8.49, 70);
INSERT INTO produto (nome, preco, quantidade) VALUES ('Desodorante', 12.99, 60);
INSERT INTO produto (nome, preco, quantidade) VALUES ('Pão Francês', 3.99, 150);
INSERT INTO produto (nome, preco, quantidade) VALUES ('Biscoito de Polvilho', 5.49, 120);

