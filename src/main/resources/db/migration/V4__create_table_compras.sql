DROP TABLE IF EXISTS compra;
CREATE TABLE compra(
    id bigint not null auto_increment,
    descricao varchar(150) not null, 
    local varchar(150), 
    PRIMARY KEY(id)
    );