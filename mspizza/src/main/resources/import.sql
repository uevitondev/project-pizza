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

INSERT INTO tb_pizzeria (name) VALUES ('Pizzaria Valle');
INSERT INTO tb_pizzeria (name) VALUES ('Pizzaria Sabor');

INSERT INTO tb_category (name) VALUES ('PIZZAS');
INSERT INTO tb_category (name) VALUES ('BEBIDAS');
INSERT INTO tb_category (name) VALUES ('SALGADOS');
INSERT INTO tb_category (name) VALUES ('DOCES');


INSERT INTO tb_product (name, description, price, category_id, pizzeria_id) VALUES ('Greek Pizza', 'Far far away, behind the word mountains, far from the countries Vokalia and Consonantia', 20.00, 1, 1);
INSERT INTO tb_product (name, description, price, category_id, pizzeria_id) VALUES ('Italian Pizza', 'ar far away, behind the word mountains, far from the countries Vokalia and Consonantia', 10.00, 1, 1);
INSERT INTO tb_product (name, description, price, category_id, pizzeria_id) VALUES ('American Pizza', 'Far far away, behind the word mountains, far from the countries Vokalia and Consonantia', 45.99, 1, 1);
INSERT INTO tb_product (name, description, price, category_id, pizzeria_id) VALUES ('Tomatoe Pie', 'Far far away, behind the word mountains, far from the countries Vokalia and Consonantia', 45.99, 1, 2);
INSERT INTO tb_product (name, description, price, category_id, pizzeria_id) VALUES ('Margherita', 'Far far away, behind the word mountains, far from the countries Vokalia and Consonantia', 45.99, 1, 2);

INSERT INTO tb_order (instant, description, status, total, user_id, pizzeria_id) VALUES ('2023-08-16T21:12:27.198940800Z', 'Far far away, behind the word mountains', 'CANCELADO', 50.00, 1, 1);
INSERT INTO tb_order (instant, description, status, total, user_id, pizzeria_id) VALUES ('2023-08-16T21:12:27.198940800Z', 'Far far away, behind the word mountains', 'CANCELADO', 100.00, 2, 1);

INSERT INTO tb_order_item (qtd, subtotal, product_id, order_id) VALUES (2, 40.00, 1, 1);
INSERT INTO tb_order_item (qtd, subtotal, product_id, order_id) VALUES (2, 20.00, 2, 1);

