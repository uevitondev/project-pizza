INSERT INTO tb_role (id, authority) VALUES (1L, 'ADMIN');
INSERT INTO tb_role (id, authority) VALUES (2L, 'CLIENT');


INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Ueviton', 'Santos', 'ueviton@gmail.com', '$2a$10$Y7fk59/1Pg.ig0Goy0yTS.5RgKD18N5J3MYCo5bPYzVpslJqfr4uu');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Maria', 'Santos', 'maria@gmail.com', '$2a$10$Y7fk59/1Pg.ig0Goy0yTS.5RgKD18N5J3MYCo5bPYzVpslJqfr4uu');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Marcos', 'Santos', 'marcos@gmail.com', '$2a$10$Y7fk59/1Pg.ig0Goy0yTS.5RgKD18N5J3MYCo5bPYzVpslJqfr4uu');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Vitoria', 'Santos', 'vitoria@gmail.com', '$2a$10$Y7fk59/1Pg.ig0Goy0yTS.5RgKD18N5J3MYCo5bPYzVpslJqfr4uu');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Ana', 'Santos', 'ana@gmail.com', '$2a$10$Y7fk59/1Pg.ig0Goy0yTS.5RgKD18N5J3MYCo5bPYzVpslJqfr4uu');

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
INSERT INTO tb_product (name, description, price, category_id, pizzeria_id) VALUES ('Calabresa', 'Far far away, behind the word mountains, far from the countries Vokalia and Consonantia', 25.99, 1, 2);


INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/468515806/pt/foto/pizza.jpg?s=2048x2048&w=is&k=20&c=glgCdae12P2FWboy9krgcZIT5M46PFGMNYyFAbpyHiM=', 'IMAGE', 1);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/1349383878/pt/foto/hawaiian-pizza-with-ham-and-pineapple.jpg?s=2048x2048&w=is&k=20&c=6rfKb8hlJ-P96F9ojG2EzMdy_b16fES6PHrdAU_cMCE=', 'IMAGE', 1);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/468515806/pt/foto/pizza.jpg?s=2048x2048&w=is&k=20&c=glgCdae12P2FWboy9krgcZIT5M46PFGMNYyFAbpyHiM=', 'IMAGE', 2);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/1349383878/pt/foto/hawaiian-pizza-with-ham-and-pineapple.jpg?s=2048x2048&w=is&k=20&c=6rfKb8hlJ-P96F9ojG2EzMdy_b16fES6PHrdAU_cMCE=', 'IMAGE', 2);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/468515806/pt/foto/pizza.jpg?s=2048x2048&w=is&k=20&c=glgCdae12P2FWboy9krgcZIT5M46PFGMNYyFAbpyHiM=', 'IMAGE', 3);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/1349383878/pt/foto/hawaiian-pizza-with-ham-and-pineapple.jpg?s=2048x2048&w=is&k=20&c=6rfKb8hlJ-P96F9ojG2EzMdy_b16fES6PHrdAU_cMCE=', 'IMAGE', 3);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/468515806/pt/foto/pizza.jpg?s=2048x2048&w=is&k=20&c=glgCdae12P2FWboy9krgcZIT5M46PFGMNYyFAbpyHiM=', 'IMAGE', 4);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/1349383878/pt/foto/hawaiian-pizza-with-ham-and-pineapple.jpg?s=2048x2048&w=is&k=20&c=6rfKb8hlJ-P96F9ojG2EzMdy_b16fES6PHrdAU_cMCE=', 'IMAGE', 4);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/468515806/pt/foto/pizza.jpg?s=2048x2048&w=is&k=20&c=glgCdae12P2FWboy9krgcZIT5M46PFGMNYyFAbpyHiM=', 'IMAGE', 5);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/1349383878/pt/foto/hawaiian-pizza-with-ham-and-pineapple.jpg?s=2048x2048&w=is&k=20&c=6rfKb8hlJ-P96F9ojG2EzMdy_b16fES6PHrdAU_cMCE=', 'IMAGE', 5);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/468515806/pt/foto/pizza.jpg?s=2048x2048&w=is&k=20&c=glgCdae12P2FWboy9krgcZIT5M46PFGMNYyFAbpyHiM=', 'IMAGE', 6);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/1349383878/pt/foto/hawaiian-pizza-with-ham-and-pineapple.jpg?s=2048x2048&w=is&k=20&c=6rfKb8hlJ-P96F9ojG2EzMdy_b16fES6PHrdAU_cMCE=', 'IMAGE', 6);



INSERT INTO tb_order (instant, status, total, user_id, pizzeria_id) VALUES ('2023-08-16T21:12:27.198940800Z', 'CANCELADO', 50.00, 1, 1);
INSERT INTO tb_order (instant, status, total, user_id, pizzeria_id) VALUES ('2023-08-16T21:12:27.198940800Z', 'CANCELADO', 100.00, 2, 1);

INSERT INTO tb_order_item (quantity, subtotal, observation, product_id, order_id) VALUES (2, 40.00, 'Adicionar Cebola!', 1, 1);
INSERT INTO tb_order_item (quantity, subtotal, observation, product_id, order_id) VALUES (2, 20.00, 'Adcionar azeite!', 2, 1);
INSERT INTO tb_order_item (quantity, subtotal, observation, product_id, order_id) VALUES (1, 20.00, 'Adicionar molho!', 1, 2);