CREATE DATABASE IF NOT EXISTS test
    COLLATE utf8_general_ci;

USE test;

DROP TABLE IF EXISTS part;

CREATE TABLE part
(
    id       	BIGINT(20)  NOT NULL AUTO_INCREMENT,
    name     	VARCHAR(50) NULL,
    necessity   BIT(1)      NULL,
    quantity	INT(4)      NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

insert into part(name, necessity, quantity)
values ('материнская плата', true, 3)
     , ('процессор', true, 2)
     , ('оперативная память', true, 5)
     , ('кулер процессора', true, 7)
     , ('блок питания', true, 1)
     , ('накопитель SSD', true, 3)
     , ('накопитель HDD', false, 13)
     , ('корпус', true, 8)
     , ('DVD-привод', false, 15)
     , ('видеокарта', false, 9)
     , ('звуковая карта', false, 13)
     , ('сетевая карта', false, 2)
     , ('вентилятор 120*120', false, 4)
     , ('клавиатура', false, 3)
     , ('мышь', false, 7)
     , ('коврик для мыши', false, 4)
     , ('TV-тюнер', false, 5)
     , ('веб-камера', false, 30)
     , ('монитор', false, 12)
     , ('контроллер SATA', false, 3)
     , ('картридер', false, 3);
