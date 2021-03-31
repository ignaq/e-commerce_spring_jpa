/* table productos */

insert into productos (nombre, descripcion, foto, precio, fecha) values ('Smart TV Hitachi LE504KSMART20 LED 4K 50','Con el Smart TV LE504KSMART20 vas a acceder a las aplicaciones en las que se encuentran tus contenidos favoritos. Además, podés navegar por Internet, interactuar en redes sociales y divertirte con videojuegos. Viví en 4K', 'https://http2.mlstatic.com/D_NQ_NP_817015-MLA41765520080_052020-O.webp', 44.999, NOW());
insert into productos (nombre, descripcion, foto, precio, fecha) values ('Smart TV Samsung SA504KSMART20 LED 4K 32','Con el Smart TV LE504KSMART20 vas a acceder a las aplicaciones en las que se encuentran tus contenidos favoritos. Además, podés navegar por Internet, interactuar en redes sociales y divertirte con videojuegos. Viví en 4K', 'https://http2.mlstatic.com/D_NQ_NP_817015-MLA41765520080_052020-O.webp', 29.999, NOW());
insert into productos (nombre, descripcion, foto, precio, fecha) values ('Smart TV Hitachi LE504KSMART20 LED 4K 50','Con el Smart TV LE504KSMART20 vas a acceder a las aplicaciones en las que se encuentran tus contenidos favoritos. Además, podés navegar por Internet, interactuar en redes sociales y divertirte con videojuegos. Viví en 4K', 'https://http2.mlstatic.com/D_NQ_NP_817015-MLA41765520080_052020-O.webp', 44.999, NOW());
insert into productos (nombre, descripcion, foto, precio, fecha) values ('Smart TV Hitachi LE504KSMART20 LED 4K 50','Con el Smart TV LE504KSMART20 vas a acceder a las aplicaciones en las que se encuentran tus contenidos favoritos. Además, podés navegar por Internet, interactuar en redes sociales y divertirte con videojuegos. Viví en 4K', 'https://http2.mlstatic.com/D_NQ_NP_817015-MLA41765520080_052020-O.webp', 44.999, NOW());
insert into productos (nombre, descripcion, foto, precio, fecha) values ('Smart TV Hitachi LE504KSMART20 LED 4K 50','Con el Smart TV LE504KSMART20 vas a acceder a las aplicaciones en las que se encuentran tus contenidos favoritos. Además, podés navegar por Internet, interactuar en redes sociales y divertirte con videojuegos. Viví en 4K', 'https://http2.mlstatic.com/D_NQ_NP_817015-MLA41765520080_052020-O.webp', 44.999, NOW());
insert into productos (nombre, descripcion, foto, precio, fecha) values ('Smart TV Hitachi LE504KSMART20 LED 4K 50','Con el Smart TV LE504KSMART20 vas a acceder a las aplicaciones en las que se encuentran tus contenidos favoritos. Además, podés navegar por Internet, interactuar en redes sociales y divertirte con videojuegos. Viví en 4K', 'https://http2.mlstatic.com/D_NQ_NP_817015-MLA41765520080_052020-O.webp', 44.999, NOW());
insert into productos (nombre, descripcion, foto, precio, fecha) values ('Smart TV Hitachi LE504KSMART20 LED 4K 50','Con el Smart TV LE504KSMART20 vas a acceder a las aplicaciones en las que se encuentran tus contenidos favoritos. Además, podés navegar por Internet, interactuar en redes sociales y divertirte con videojuegos. Viví en 4K', 'https://http2.mlstatic.com/D_NQ_NP_817015-MLA41765520080_052020-O.webp', 44.999, NOW());


/*Users y roles*/


insert into users (username, password, enabled) values ('nacho','$2a$10$L2kiLtvUUH4j5Bwa8GS41O/laiijfxNeFB.CIhARU6K5P.VsJs50i',1);
insert into users (username, password, enabled) values ('admin','$2a$10$qt5p92GvnDds4CmEl2P.7OaKpTsWY/DKjHLJckDv8IJkfdbOkLqJ6',1);

insert into authorities (user_id, authority) values (1, 'ROLE_USER');
insert into authorities (user_id, authority) values (2, 'ROLE_ADMIN');
insert into authorities (user_id, authority) values (2, 'ROLE_USER');
insert into clientes (id, nombre, apellido, email, fecha_registro ,fk_usuario) values (1,'Juan Ignacio','Quintero','j.ignacioquintero@gmail.com', NOW(),1);
insert into clientes (id, nombre, apellido, email, fecha_registro, fk_usuario) values (2,'El Admin','web','admin@gmail.com', NOW(), 2);