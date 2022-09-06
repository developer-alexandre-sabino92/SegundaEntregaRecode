create database viajando;
use viajando;

CREATE TABLE Cliente (
    Id_Cliente integer PRIMARY KEY auto_increment,
    Nome varchar(30),
    Email varchar (30),
    Telefone integer
);

CREATE TABLE Pacote_Viagem (
    Id_Pacote integer PRIMARY KEY auto_increment,
    Destino varchar(50)
);

CREATE TABLE Compra (
    fk_Pacote_Viagem_Id_Pacote integer,
    fk_Cliente_Id_Cliente integer
);
 
ALTER TABLE Compra ADD CONSTRAINT FK_Compra_1
    FOREIGN KEY (fk_Pacote_Viagem_Id_Pacote)
    REFERENCES Pacote_Viagem (Id_Pacote)
    ON DELETE RESTRICT;
 
ALTER TABLE Compra ADD CONSTRAINT FK_Compra_2
    FOREIGN KEY (fk_Cliente_Id_Cliente)
    REFERENCES Cliente (Id_Cliente)
    ON DELETE RESTRICT;