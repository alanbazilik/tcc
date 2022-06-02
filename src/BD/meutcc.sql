CREATE TABLE Usuario(
nome_user VARCHAR(80) not null,
senha_user VARCHAR(80) not null,
);
CREATE TABLE funcionario (
    cod_funcionario INTEGER PRIMARY KEY,
    nome_funcionario VARCHAR(80) not null,
     rg VARCHAR(80) not null,
    cpf VARCHAR(14) not null,
    fk_bairro INTEGER,
    fk_cidade INTEGER,
    fk_codtelefone integer,
    fk_codrua integer,
    numerocasa varchar(10) not null,
    UNIQUE ( rg, cpf)
);

CREATE TABLE estado (
    codestado INTEGER PRIMARY KEY,
    nome_estado VARCHAR(80) not null unique UNIQUE
);

CREATE TABLE cidade (
    codcidade INTEGER PRIMARY KEY,
    nomecidade varchar(80) not null,
    fk_uf INTEGER,
    UNIQUE (nomecidade, codcidade)
);

CREATE TABLE bairro (
    codbairro INTEGER PRIMARY KEY,
    bairro VARCHAR(80)
);

CREATE TABLE produto (
    codigo_barras INTEGER PRIMARY KEY,
    produto VARCHAR(80),
    quantidade INTEGER,
    fk_tipo INTEGER,
    fk_marca INTEGER
);

CREATE TABLE marca (
    cod_marca_produto INTEGER PRIMARY KEY UNIQUE,
    marca_produto VARCHAR(80) not null unique
);

CREATE TABLE tipo (
    cod_tipo_produto INTEGER PRIMARY KEY,
     tipo VARCHAR(80) not null unique UNIQUE
);

CREATE TABLE Cliente (
    cod_cliente INTEGER PRIMARY KEY,
    nome_cliente VARCHAR(80),
     rg VARCHAR(80),
    cpf VARCHAR(14),
    fk_bairro INTEGER,
    fk_cidade INTEGER,
    fk_codtelefone integer,
    fk_codrua integer,
    numerocasa varchar(10) not null
);

CREATE TABLE Tipo_Telefone (
    codtipotel integer PRIMARY KEY,
    nometipotel varchar(80) not null unique,
    UNIQUE (codtipotel, nometipotel)
);

CREATE TABLE Rua (
    codrua integer PRIMARY KEY UNIQUE,
    nomerua varchar(80) not null unique
);

CREATE TABLE Telefone (
    codtelefone integer PRIMARY KEY,
    numerotel varchar(20) not null unique,
    fk_codtipotel integer,
    UNIQUE (codtelefone, numerotel)
);

CREATE TABLE Venda (
    codvenda integer PRIMARY KEY UNIQUE,
    datavenda date not null,
    fk_codcliente INTEGER,
    fk_codfuncionario INTEGER
);

CREATE TABLE Itens_Venda (
    fk_codproduto INTEGER,
    fk_codvenda integer,
    quantv numeric(10,2) not null,
    valorv numeric(10,2) not null,
    PRIMARY KEY (fk_codproduto, fk_codvenda)
);
 
 
ALTER TABLE funcionario ADD CONSTRAINT FK_funcionario_4
    FOREIGN KEY (fk_codrua)
    REFERENCES Rua (codrua);
 
ALTER TABLE funcionario ADD CONSTRAINT FK_funcionario_5
    FOREIGN KEY (fk_estado)
    REFERENCES estado (codestado);
 
 
ALTER TABLE funcionario ADD CONSTRAINT FK_funcionario_7
    FOREIGN KEY (fk_bairro)
    REFERENCES bairro (codbairro);
 
ALTER TABLE funcionario ADD CONSTRAINT FK_funcionario_8
    FOREIGN KEY (fk_cidade)
    REFERENCES cidade (codcidade);
 
ALTER TABLE funcionario ADD CONSTRAINT FK_funcionario_9
    FOREIGN KEY (fk_codtelefone)
    REFERENCES Telefone (codtelefone);
 
ALTER TABLE cidade ADD CONSTRAINT FK_cidade_3
    FOREIGN KEY (fk_uf)
    REFERENCES estado (codestado);
 

 
ALTER TABLE produto ADD CONSTRAINT FK_produto_2
    FOREIGN KEY (fk_marca)
    REFERENCES marca (cod_marca_produto);
 
ALTER TABLE produto ADD CONSTRAINT FK_produto_3
    FOREIGN KEY (fk_tipo)
    REFERENCES tipo (cod_tipo_produto);
 
 
ALTER TABLE Cliente ADD CONSTRAINT FK_Cliente_3
    FOREIGN KEY (fk_bairro)
    REFERENCES bairro (codbairro);
 
ALTER TABLE Cliente ADD CONSTRAINT FK_Cliente_4
    FOREIGN KEY (fk_cidade)
    REFERENCES cidade (codcidade);
 
ALTER TABLE Cliente ADD CONSTRAINT FK_Cliente_5
    FOREIGN KEY (fk_codtelefone)
    REFERENCES Telefone (codtelefone);
 
ALTER TABLE Cliente ADD CONSTRAINT FK_Cliente_6
    FOREIGN KEY (fk_codrua)
    REFERENCES Rua (codrua);