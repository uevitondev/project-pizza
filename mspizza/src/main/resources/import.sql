INSERT INTO tb_role (id, name) VALUES (1L, 'ADMIN');
INSERT INTO tb_role (id, name) VALUES (2L, 'ClIENT');


INSERT INTO tb_user (id, first_name, last_name, email, password) VALUES (1L, 'Ueviton', 'Santos', 'ueviton@gmail.com', 'ueviton123');
INSERT INTO tb_user (id, first_name, last_name, email, password) VALUES (2L, 'Maria', 'Santos', 'maria@gmail.com', 'maria123');
INSERT INTO tb_user (id, first_name, last_name, email, password) VALUES (3L, 'Marcos', 'Santos', 'marcos@gmail.com', 'marcos123');
INSERT INTO tb_user (id, first_name, last_name, email, password) VALUES (4L, 'Vitoria', 'Santos', 'vitoria@gmail.com', 'vitoria123');
INSERT INTO tb_user (id, first_name, last_name, email, password) VALUES (5L, 'Ana', 'Santos', 'ana@gmail.com', 'ana123');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (4, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (5, 2);



