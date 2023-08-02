INSERT INTO tb_role (id, name) VALUES (1L, 'ADMIN');
INSERT INTO tb_role (id, name) VALUES (2L, 'CLIENT');


INSERT INTO tb_user (id, first_name, last_name, email, password) VALUES (1L, 'Ueviton', 'Santos', 'ueviton@gmail.com', '$2a$10$Y7fk59/1Pg.ig0Goy0yTS.5RgKD18N5J3MYCo5bPYzVpslJqfr4uu');
INSERT INTO tb_user (id, first_name, last_name, email, password) VALUES (2L, 'Maria', 'Santos', 'maria@gmail.com', '$2a$10$Y7fk59/1Pg.ig0Goy0yTS.5RgKD18N5J3MYCo5bPYzVpslJqfr4uu');
INSERT INTO tb_user (id, first_name, last_name, email, password) VALUES (3L, 'Marcos', 'Santos', 'marcos@gmail.com', '$2a$10$Y7fk59/1Pg.ig0Goy0yTS.5RgKD18N5J3MYCo5bPYzVpslJqfr4uu');
INSERT INTO tb_user (id, first_name, last_name, email, password) VALUES (4L, 'Vitoria', 'Santos', 'vitoria@gmail.com', '$2a$10$Y7fk59/1Pg.ig0Goy0yTS.5RgKD18N5J3MYCo5bPYzVpslJqfr4uu');
INSERT INTO tb_user (id, first_name, last_name, email, password) VALUES (5L, 'Ana', 'Santos', 'ana@gmail.com', '$2a$10$Y7fk59/1Pg.ig0Goy0yTS.5RgKD18N5J3MYCo5bPYzVpslJqfr4uu');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (4, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (5, 2);



