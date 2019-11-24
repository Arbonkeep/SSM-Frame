-- 创建spring数据库
CREATE DATABASE spring;

CREATE TABLE account(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(40),
	money FLOAT
)CHARACTER SET utf8 COLLATE utf8_general_ci;

INSERT INTO account(NAME,money) VALUES('aaa',1000);
INSERT INTO account(NAME,money) VALUES('bbb',1000);
INSERT INTO account(NAME,money) VALUES('ccc',1000);

SELECT * FROM account;