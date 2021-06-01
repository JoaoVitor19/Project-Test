INSERT INTO tb_locador(name ,CPF ,email) VALUES ('Pedro LOC1', 98712312321 ,'pedroloc1@gmail.com');
INSERT INTO tb_locador(name ,CPF ,email) VALUES ('Lucas LOC2', 12121345643 , 'lucasloc2@gmail.com');
INSERT INTO tb_locador(name ,CPF ,email) VALUES ('Junior LOC3', 57097678924 , 'juniorloc3@gmail.com');


INSERT INTO tb_produtos(locador_id, name, value, description) VALUES (1, 'Playstation 4', 2.500, 'produto novo');
INSERT INTO tb_produtos(locador_id, name, value, description) VALUES (1, 'Xbox One', 1.000, 'semi novo');
INSERT INTO tb_produtos(locador_id, name, value, description) VALUES (1, 'Playstation 3', 600, 'pouco usado');


INSERT INTO tb_produtos(locador_id, name, value , description) VALUES (2, 'Notebook', 10.000, 'Não trava');
INSERT INTO tb_produtos(locador_id, name, value , description) VALUES (2, 'Macbook', 23.000, 'Roda jogos');
INSERT INTO tb_produtos(locador_id, name, value , description) VALUES (2, 'Tablet', 600, 'trava em jogos');


INSERT INTO tb_produtos(locador_id, name, value , description) VALUES (3, 'Iphone 7', 1.900, 'Sem Biometria');
INSERT INTO tb_produtos(locador_id, name, value , description) VALUES (3, 'Xiaomi Note 9', 1.200, 'Não trava');
INSERT INTO tb_produtos(locador_id, name, value , description) VALUES (3, 'Iphone 12', 8.000, 'Com capinhas');