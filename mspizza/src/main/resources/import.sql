INSERT INTO tb_role (id, authority) VALUES (1L, 'ADMIN');
INSERT INTO tb_role (id, authority) VALUES (2L, 'CLIENT');


INSERT INTO tb_user (first_name, last_name, email, password,is_enabled) VALUES ('Ueviton', 'Santos', 'ueviton@gmail.com', '$2a$10$Y7fk59/1Pg.ig0Goy0yTS.5RgKD18N5J3MYCo5bPYzVpslJqfr4uu', true);
INSERT INTO tb_user (first_name, last_name, email, password, is_enabled) VALUES ('Maria', 'Santos', 'maria@gmail.com', '$2a$10$Y7fk59/1Pg.ig0Goy0yTS.5RgKD18N5J3MYCo5bPYzVpslJqfr4uu', true);
INSERT INTO tb_user (first_name, last_name, email, password,is_enabled) VALUES ('Marcos', 'Santos', 'marcos@gmail.com', '$2a$10$Y7fk59/1Pg.ig0Goy0yTS.5RgKD18N5J3MYCo5bPYzVpslJqfr4uu', true);
INSERT INTO tb_user (first_name, last_name, email, password,is_enabled) VALUES ('Vitoria', 'Santos', 'vitoria@gmail.com', '$2a$10$Y7fk59/1Pg.ig0Goy0yTS.5RgKD18N5J3MYCo5bPYzVpslJqfr4uu', true);
INSERT INTO tb_user (first_name, last_name, email, password,is_enabled) VALUES ('Ana', 'Santos', 'ana@gmail.com', '$2a$10$Y7fk59/1Pg.ig0Goy0yTS.5RgKD18N5J3MYCo5bPYzVpslJqfr4uu', true);

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (4, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (5, 2);

INSERT INTO tb_pizzeria (name) VALUES ('Valle');
INSERT INTO tb_pizzeria (name) VALUES ('Sabor');

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
INSERT INTO tb_product (name, description, price, category_id, pizzeria_id) VALUES ('Pizza de Calabresa', 'Deliciosa pizza com fatias de calabresa, molho de tomate e queijo derretido.', 25.99, 1, 2);
INSERT INTO tb_product (name, description, price, category_id, pizzeria_id) VALUES ('Pizza Margherita', 'Pizza tradicional com molho de tomate, queijo mozarela, tomate e manjericão fresco.', 23.99, 1, 2);
INSERT INTO tb_product (name, description, price, category_id, pizzeria_id) VALUES ('Pizza Quatro Queijos', 'Combinação de queijo mozarela, gorgonzola, parmesão e catupiry.', 27.99, 1, 2);
INSERT INTO tb_product (name, description, price, category_id, pizzeria_id) VALUES ('Pizza de Frango com Catupiry', 'Pizza com frango desfiado e catupiry cremoso.', 26.99, 1, 2);
INSERT INTO tb_product (name, description, price, category_id, pizzeria_id) VALUES ('Pizza Portuguesa', 'Pizza com presunto, ovos, cebola, pimentão, azeitonas e queijo.', 28.99, 1, 2);
INSERT INTO tb_product (name, description, price, category_id, pizzeria_id) VALUES ('Pizza Vegetariana', 'Opção vegetariana com variedade de legumes e queijos.', 24.99, 1, 2);
INSERT INTO tb_product (name, description, price, category_id, pizzeria_id) VALUES ('Pizza de Pepperoni', 'Pizza com generosas fatias de pepperoni e queijo derretido.', 26.49, 1, 2);
INSERT INTO tb_product (name, description, price, category_id, pizzeria_id) VALUES ('Calzone de Presunto e Queijo', 'Massa recheada com presunto, queijo e molho de tomate.', 18.99, 2, 2);
INSERT INTO tb_product (name, description, price, category_id, pizzeria_id) VALUES ('Lasanha à Bolonhesa', 'Camadas de massa intercaladas com molho bolonhesa e queijo gratinado.', 21.99, 1, 2);
INSERT INTO tb_product (name, description, price, category_id, pizzeria_id) VALUES ('Salada Caesar', 'Mix de alface, croutons, parmesão e molho Caesar.', 9.99, 2, 2);
INSERT INTO tb_product (name, description, price, category_id, pizzeria_id) VALUES ('Refrigerante Coca-Cola (lata)', 'Lata gelada de Coca-Cola.', 4.49, 1, 2);
INSERT INTO tb_product (name, description, price, category_id, pizzeria_id) VALUES ('Brownie de Chocolate', 'Delicioso brownie de chocolate servido com sorvete.', 7.99, 2, 2);

INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/468515806/pt/foto/pizza.jpg?s=2048x2048&w=is&k=20&c=glgCdae12P2FWboy9krgcZIT5M46PFGMNYyFAbpyHiM=', 'IMAGE', 1);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/468515806/pt/foto/pizza.jpg?s=2048x2048&w=is&k=20&c=glgCdae12P2FWboy9krgcZIT5M46PFGMNYyFAbpyHiM=', 'IMAGE', 2);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/468515806/pt/foto/pizza.jpg?s=2048x2048&w=is&k=20&c=glgCdae12P2FWboy9krgcZIT5M46PFGMNYyFAbpyHiM=', 'IMAGE', 3);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/468515806/pt/foto/pizza.jpg?s=2048x2048&w=is&k=20&c=glgCdae12P2FWboy9krgcZIT5M46PFGMNYyFAbpyHiM=', 'IMAGE', 4);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/468515806/pt/foto/pizza.jpg?s=2048x2048&w=is&k=20&c=glgCdae12P2FWboy9krgcZIT5M46PFGMNYyFAbpyHiM=', 'IMAGE', 5);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/468515806/pt/foto/pizza.jpg?s=2048x2048&w=is&k=20&c=glgCdae12P2FWboy9krgcZIT5M46PFGMNYyFAbpyHiM=', 'IMAGE', 6);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/468515806/pt/foto/pizza.jpg?s=2048x2048&w=is&k=20&c=glgCdae12P2FWboy9krgcZIT5M46PFGMNYyFAbpyHiM=', 'IMAGE', 7);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/468515806/pt/foto/pizza.jpg?s=2048x2048&w=is&k=20&c=glgCdae12P2FWboy9krgcZIT5M46PFGMNYyFAbpyHiM=', 'IMAGE', 8);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/468515806/pt/foto/pizza.jpg?s=2048x2048&w=is&k=20&c=glgCdae12P2FWboy9krgcZIT5M46PFGMNYyFAbpyHiM=', 'IMAGE', 9);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/468515806/pt/foto/pizza.jpg?s=2048x2048&w=is&k=20&c=glgCdae12P2FWboy9krgcZIT5M46PFGMNYyFAbpyHiM=', 'IMAGE', 10);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/468515806/pt/foto/pizza.jpg?s=2048x2048&w=is&k=20&c=glgCdae12P2FWboy9krgcZIT5M46PFGMNYyFAbpyHiM=', 'IMAGE', 11);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/468515806/pt/foto/pizza.jpg?s=2048x2048&w=is&k=20&c=glgCdae12P2FWboy9krgcZIT5M46PFGMNYyFAbpyHiM=', 'IMAGE', 12);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/468515806/pt/foto/pizza.jpg?s=2048x2048&w=is&k=20&c=glgCdae12P2FWboy9krgcZIT5M46PFGMNYyFAbpyHiM=', 'IMAGE', 13);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/468515806/pt/foto/pizza.jpg?s=2048x2048&w=is&k=20&c=glgCdae12P2FWboy9krgcZIT5M46PFGMNYyFAbpyHiM=', 'IMAGE', 14);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/468515806/pt/foto/pizza.jpg?s=2048x2048&w=is&k=20&c=glgCdae12P2FWboy9krgcZIT5M46PFGMNYyFAbpyHiM=', 'IMAGE', 15);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/468515806/pt/foto/pizza.jpg?s=2048x2048&w=is&k=20&c=glgCdae12P2FWboy9krgcZIT5M46PFGMNYyFAbpyHiM=', 'IMAGE', 16);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/468515806/pt/foto/pizza.jpg?s=2048x2048&w=is&k=20&c=glgCdae12P2FWboy9krgcZIT5M46PFGMNYyFAbpyHiM=', 'IMAGE', 17);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/468515806/pt/foto/pizza.jpg?s=2048x2048&w=is&k=20&c=glgCdae12P2FWboy9krgcZIT5M46PFGMNYyFAbpyHiM=', 'IMAGE', 18);

INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/1349383878/pt/foto/hawaiian-pizza-with-ham-and-pineapple.jpg?s=2048x2048&w=is&k=20&c=6rfKb8hlJ-P96F9ojG2EzMdy_b16fES6PHrdAU_cMCE=', 'IMAGE', 1);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/1349383878/pt/foto/hawaiian-pizza-with-ham-and-pineapple.jpg?s=2048x2048&w=is&k=20&c=6rfKb8hlJ-P96F9ojG2EzMdy_b16fES6PHrdAU_cMCE=', 'IMAGE', 2);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/1349383878/pt/foto/hawaiian-pizza-with-ham-and-pineapple.jpg?s=2048x2048&w=is&k=20&c=6rfKb8hlJ-P96F9ojG2EzMdy_b16fES6PHrdAU_cMCE=', 'IMAGE', 3);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/1349383878/pt/foto/hawaiian-pizza-with-ham-and-pineapple.jpg?s=2048x2048&w=is&k=20&c=6rfKb8hlJ-P96F9ojG2EzMdy_b16fES6PHrdAU_cMCE=', 'IMAGE', 4);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/1349383878/pt/foto/hawaiian-pizza-with-ham-and-pineapple.jpg?s=2048x2048&w=is&k=20&c=6rfKb8hlJ-P96F9ojG2EzMdy_b16fES6PHrdAU_cMCE=', 'IMAGE', 5);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/1349383878/pt/foto/hawaiian-pizza-with-ham-and-pineapple.jpg?s=2048x2048&w=is&k=20&c=6rfKb8hlJ-P96F9ojG2EzMdy_b16fES6PHrdAU_cMCE=', 'IMAGE', 6);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/1349383878/pt/foto/hawaiian-pizza-with-ham-and-pineapple.jpg?s=2048x2048&w=is&k=20&c=6rfKb8hlJ-P96F9ojG2EzMdy_b16fES6PHrdAU_cMCE=', 'IMAGE', 7);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/1349383878/pt/foto/hawaiian-pizza-with-ham-and-pineapple.jpg?s=2048x2048&w=is&k=20&c=6rfKb8hlJ-P96F9ojG2EzMdy_b16fES6PHrdAU_cMCE=', 'IMAGE', 8);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/1349383878/pt/foto/hawaiian-pizza-with-ham-and-pineapple.jpg?s=2048x2048&w=is&k=20&c=6rfKb8hlJ-P96F9ojG2EzMdy_b16fES6PHrdAU_cMCE=', 'IMAGE', 9);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/1349383878/pt/foto/hawaiian-pizza-with-ham-and-pineapple.jpg?s=2048x2048&w=is&k=20&c=6rfKb8hlJ-P96F9ojG2EzMdy_b16fES6PHrdAU_cMCE=', 'IMAGE', 10);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/1349383878/pt/foto/hawaiian-pizza-with-ham-and-pineapple.jpg?s=2048x2048&w=is&k=20&c=6rfKb8hlJ-P96F9ojG2EzMdy_b16fES6PHrdAU_cMCE=', 'IMAGE', 11);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/1349383878/pt/foto/hawaiian-pizza-with-ham-and-pineapple.jpg?s=2048x2048&w=is&k=20&c=6rfKb8hlJ-P96F9ojG2EzMdy_b16fES6PHrdAU_cMCE=', 'IMAGE', 12);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/1349383878/pt/foto/hawaiian-pizza-with-ham-and-pineapple.jpg?s=2048x2048&w=is&k=20&c=6rfKb8hlJ-P96F9ojG2EzMdy_b16fES6PHrdAU_cMCE=', 'IMAGE', 13);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/1349383878/pt/foto/hawaiian-pizza-with-ham-and-pineapple.jpg?s=2048x2048&w=is&k=20&c=6rfKb8hlJ-P96F9ojG2EzMdy_b16fES6PHrdAU_cMCE=', 'IMAGE', 14);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/1349383878/pt/foto/hawaiian-pizza-with-ham-and-pineapple.jpg?s=2048x2048&w=is&k=20&c=6rfKb8hlJ-P96F9ojG2EzMdy_b16fES6PHrdAU_cMCE=', 'IMAGE', 15);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/1349383878/pt/foto/hawaiian-pizza-with-ham-and-pineapple.jpg?s=2048x2048&w=is&k=20&c=6rfKb8hlJ-P96F9ojG2EzMdy_b16fES6PHrdAU_cMCE=', 'IMAGE', 16);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/1349383878/pt/foto/hawaiian-pizza-with-ham-and-pineapple.jpg?s=2048x2048&w=is&k=20&c=6rfKb8hlJ-P96F9ojG2EzMdy_b16fES6PHrdAU_cMCE=', 'IMAGE', 17);
INSERT INTO tb_product_image (url, type, product_id) VALUES ('https://media.istockphoto.com/id/1349383878/pt/foto/hawaiian-pizza-with-ham-and-pineapple.jpg?s=2048x2048&w=is&k=20&c=6rfKb8hlJ-P96F9ojG2EzMdy_b16fES6PHrdAU_cMCE=', 'IMAGE', 18);


INSERT INTO tb_order (instant, status, total, user_id, pizzeria_id) VALUES ('2023-08-16T21:12:27.198940800Z', 'CANCELADO', 60.00, 1, 1);
INSERT INTO tb_order (instant, status, total, user_id, pizzeria_id) VALUES ('2023-08-16T21:12:27.198940800Z', 'CANCELADO', 20.00, 1, 1);

INSERT INTO tb_order_item (quantity, subtotal, observation, product_id, order_id) VALUES (2, 40.00, 'Adicionar Cebola!', 1, 1);
INSERT INTO tb_order_item (quantity, subtotal, observation, product_id, order_id) VALUES (2, 20.00, 'Adcionar azeite!', 2, 1);
INSERT INTO tb_order_item (quantity, subtotal, observation, product_id, order_id) VALUES (1, 20.00, 'Adicionar molho!', 1, 2);