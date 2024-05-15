## Getting Started

entre no local onde esta o arquivo e compile ele usando esse comando(linux ubuntu):

javac -cp .:/usr/share/java/mysql-connector-java-8.4.0.jar SistemaCadastrobd.java

Depois execute esse comando para rodar o sisteminha 

java -cp .:/usr/share/java/mysql-connector-java-8.4.0.jar SistemaCadastrobd


create database mercadinhoJava;
use mercadinhoJava;

CREATE TABLE produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DOUBLE NOT NULL,
    quantidade INT NOT NULL
);
