CREATE DATABASE IF NOT EXISTS PokeZoo;
USE PokeZoo;

-- CREACION DE TABLAS
	-- Tabla Food (Juan Manuel Lopez)
CREATE TABLE IF NOT EXISTS Food (
idFood TINYINT AUTO_INCREMENT,
quantityFo INT UNSIGNED NOT NULL,
dailyConsumeFo INT UNSIGNED NOT NULL,
nameFo VARCHAR(30) NOT NULL,
descriptionFo VARCHAR(500) NOT NULL,
PRIMARY KEY(idFood)
);

	-- Tabla Pokemon (Daniel Quintana)
CREATE TABLE IF NOT EXISTS Pokemon (
idPokemon INT AUTO_INCREMENT,
namePo VARCHAR(60) NOT NULL,
alias VARCHAR(60) UNIQUE,
typeP VARCHAR(60) NOT NULL,
typeS VARCHAR(60),
descriptionPo VARCHAR(200),
numPokedex SMALLINT NOT NULL,
photoPo LONGBLOB,
idFood TINYINT,
PRIMARY KEY (IdPokemon),
FOREIGN KEY (idFood) REFERENCES Food(idFood)
);

	-- Tabla Enclosure (Juan Manuel Lopez)
CREATE TABLE IF NOT EXISTS Enclosure (
idEnclosure TINYINT AUTO_INCREMENT PRIMARY KEY,
typeEn VARCHAR(30) NOT NULL,
numberEn TINYINT NOT NULL
);

	-- Tabla Enclo_Poke (Juan Manuel Lopez)
CREATE TABLE IF NOT EXISTS Enclo_Poke (
id TINYINT AUTO_INCREMENT,
idEnclosure TINYINT,
idPokemon INT,
PRIMARY KEY(id),
FOREIGN KEY(idEnclosure) REFERENCES Enclosure(idEnclosure),
FOREIGN KEY(idPokemon) REFERENCES Pokemon(idPokemon)
);

	-- Tabla Shop (Iker Vellarino)
CREATE TABLE IF NOT EXISTS Shop(
idShop TINYINT AUTO_INCREMENT,
nameSh VARCHAR(50) NOT NULL,
capacitySh TINYINT NOT NULL,
PRIMARY KEY(idShop)
);

	-- Tabla Product (Iker Vellarino)
CREATE TABLE IF NOT EXISTS Product (
idProduct TINYINT AUTO_INCREMENT,
namePr VARCHAR(100) NOT NULL,
descriptionPr VARCHAR(200),
photoPr LONGBLOB,
valuePr DOUBLE NOT NULL CHECK(valuePr > 0),
quantityPr SMALLINT UNSIGNED NOT NULL,
idShop TINYINT,
PRIMARY KEY(idProduct),
FOREIGN KEY (idShop) REFERENCES Shop(idShop)
);

	-- Tabla User
CREATE TABLE IF NOT EXISTS User(
idUser TINYINT AUTO_INCREMENT,
isAdmin BOOLEAN NOT NULL DEFAULT 0,
username VARCHAR(50) NOT NULL,
passwd VARCHAR(50) NOT NULL,
isBlock BOOLEAN NOT NULL DEFAULT 0,
PRIMARY KEY(idUser)
);

	-- Table Worker
CREATE TABLE IF NOT EXISTS Worker(
dni CHAR(9),
nameWo VARCHAR(50) NOT NULL,
surnameWo VARCHAR(50),
phoneWo VARCHAR(15),
idUser TINYINT,
PRIMARY KEY(dni),
FOREIGN KEY (idUser) REFERENCES User(idUser) ON DELETE CASCADE
);

	-- Tabla WorkerData
CREATE TABLE IF NOT EXISTS WorkerData (
idWorkerData TINYINT AUTO_INCREMENT,
dni CHAR(9),
idEmployee TINYINT,
idDependent TINYINT UNSIGNED DEFAULT NULL,
PRIMARY KEY(idWorkerData, idEmployee),
FOREIGN KEY (dni) REFERENCES Worker(dni)
);

	-- Tabla EmployeeData
CREATE TABLE IF NOT EXISTS EmployeeData (
idEmployeeData TINYINT AUTO_INCREMENT,
idEmployee TINYINT,
idCleaner TINYINT UNSIGNED DEFAULT NULL,
idCaretaker TINYINT UNSIGNED DEFAULT NULL,
PRIMARY KEY(idEmployeeData)
-- FOREIGN KEY (idEmployee) REFERENCES WorkerData(idEmployee)
); 

-- INDICES
/*	-- Indice Tabla Pokemon (Daniel Quintana) */
CREATE INDEX indicePokedex
ON Pokemon(numPokedex);

CREATE INDEX indice_nombresPo
ON Pokemon(namePo);

CREATE FULLTEXT INDEX indiceTipos
ON Pokemon(typeP);

/*	-- Indices Tablas Food y Enclosure (Juan Manuel Lopez) */
CREATE UNIQUE INDEX nombreTipo
ON Enclosure(typeEn);

CREATE INDEX nombreBaya
ON Food(nameFo);

CREATE INDEX cantidadBaya
ON Food(quantityFo DESC);
    
/*	-- Indices Tablas Product y Shop (Iker Vellarino) */
CREATE UNIQUE INDEX productoNombreUnico
ON Product(namePr);

CREATE UNIQUE INDEX tiendaNombreUnico
ON Shop(nameSh);

CREATE UNIQUE INDEX userNombreUnico
ON User(username);

-- INSERTS
	-- Table User
INSERT INTO User(isAdmin, username, passwd) 
VALUES 
	(1, "admin", "admin1234"),
    (0, "iker", "Iker1234"),
    (0, "juanma", "Juanma1234"),
    (0, "dani", "Dani1234");
    
    -- Table Worker
    INSERT INTO Worker(dni, nameWo, surnameWo, phoneWo, idUser) 
VALUES 
	('12345678A', "admin", "admin", '666666666', 1),
    ('21435687B', "Iker", "Vellarino", '666666667', 2),
    ('21435687C', "Juan Manuel", "Lopez", '666666668', 3),
    ('21435687D', "Daniel", "Quintana", '666666669', 4);
    
	-- Table Shop
INSERT INTO Shop(nameSh, capacitySh) VALUE("Poke-Recuerdos", 40);

	-- Table Product
INSERT INTO Product(namePr, descriptionPr, photoPr, quantityPr, valuePr, idShop)
VALUES
    ("Oshawott: Peluche Sentado", "Este peluche del tamaño de la palma de la mano es una forma divertida y encantadora de presumir de uno de tus Pokémon favoritos de tipo Agua, descubierto originalmente en Unova", NULL, 30, 11.99, 1),
	("Eevee: Figura Primavera", "¿Qué hay más adorable que Eevee? ¿Qué tal Eevee sentado con unas flores, rodeado de más flores? - Dimensiones: 3.5 x 3.5 x 3.4 IN", NULL, 30, 49.99, 1),
	("Pikachu: Figura Estados de ánimo - Hambriento", "Dimensiones: 3.6 x 4 x 2.9 IN", NULL, 30, 14.99, 1),
	("Mareep: Llavero de peluche", "Mide aproximadamente 31/2 pulgadas de alto y 6 1/2 pulgadas de largo", NULL, 30, 13.99, 1),
	("Piplup: Llavero de peluche", "", NULL, 30, 10.99, 1),
	("Wailmer: Llavero de peluche", "Dimensiones: 5 x 3 x 3.5 IN", NULL, 30, 8.99, 1),
	("Scorbunny: Llavero de peluche", "", NULL, 30, 10.99, 1),
	("Pokeball: Estuche de peluche", "Dimensiones: 5 x 1.8 x 4.8 IN", NULL, 30, 13.99, 1),
	("Torchic: Llavero de peluche", "Dimensiones: 3.2 x 3.2 x 6 IN", NULL, 30, 11.99, 1),
	("Pósters Destinos Pokémon(pack de 8)", "Cada póster mide unas 18 pulgadas de alto y 12 de ancho", NULL, 30, 39.99, 1),
	("Lapras: Flotador de Piscina", "Dimensiones: 72.5 x 80 x 53 IN, Capacidad de carga: 200 kg", NULL, 30, 59.99, 1),
	("Juego de ajedrez Pokémon", "Incluye tablero, 16 Magikarp, 4 Snorlax, 4 Rapidash, 4 Dragonite y 4 Pikachu (2 machos y 2 hembras)", NULL, 30, 199.99, 1),
	("Pósters amigos Pokémon(pack de 7)", "Dimensiones: 18 x 12 x 0.3 IN", NULL, 30, 39.99, 1),
	("Marco para diploma de graduación Pikachu", "Marco para diploma de graduación Pikachu", NULL, 30, 49.99, 1),
	("Maceta grande Pokémon", "Dimensiones: 7.2 x 7 IN", NULL, 30, 39.99, 1),
	("Imanes Insignia Gimnasio de Kanto(pack de 8)", "", NULL, 30, 19.99, 1),
	("Pikachu: Sujetalibros", "Dimensiones: 5 x 3 x 5 IN", NULL, 30, 24.99, 1);

-- Table Eclosure
INSERT INTO Enclosure(typeEn, numberEn)
VALUES
	("Bicho",1),
	("Dragón",2),
	("Eléctrico",3),
	("Hada",4),
	("Lucha",5),
	("Fuego",6),
	("Volador",7),
	("Fantasma",8),
	("Planta",9),
	("Tierra",10),
	("Hielo",11),
	("Normal",12),
	("Veneno",13),
	("Psíquico",14),
	("Roca",15),
	("Acero",16),
	("Agua",17);

-- Table Food
INSERT INTO Food (quantityFo, dailyConsumeFo, nameFo, descriptionFo)
VALUES 
	(500,100,"Baya","Restaura 10 PS"),
	(500,100,"Baya Dorada","Restaura 30 PS"),
	(500,100,"Bayamarga","Cura la confusión"),
	(500,100,"AntiquemBaya","Descongle a un Pokémon"),
	(500,100,"Baya Hielo","Cura las quemaduras"),
	(500,100,"Baya Menta","Despierta al Pokémon"),
	(500,100,"Antiparabaya","Cura la parálisis"),
	(500,100,"Bayantídoto","Cura el envenenamiento"),
	(500,100,"Baya Milagro","Cura cualquier alteración del estado"),
	(500,100,"Baya Misterio","Restaura 5 PP de un ataque"),
	(500,100,"Baya Zreza","Cura la parálisis"),
	(500,100,"Baya Atania","Despierta al Pokémon"),
	(500,100,"Baya Meloc","Cura el envenenamiento"),
	(500,100,"Baya Safre","Cura las quemaduras"),
	(500,100,"Baya Perasi","Cura el congelamiento"),
	(500,100,"Baya Zanama","Restaura 10 PP"),
	(500,100,"Baya Aranja","Restaura 10 PS"),
	(500,100,"Baya Caquic","Cura la confusión"),
	(500,100,"Baya Ziuela","Cura cualquier alteración de estado"),
	(500,100,"Baya Zidra","Restaura 30 PS"),
	(500,100,"Baya Higog","Restaura 1/8 de los PS pero confunde si al Pokémon no le gusta el sabor picante"),
	(500,100,"Baya Wiki","Restaura 1/8 de los PS pero confunde si al Pokémon no le gusta el sabor seco"),
	(500,100,"Baya Ango","Restaura 1/8 de los PS pero confunde si al Pokémon no le gusta el sabor dulce"),
	(500,100,"Baya Guaya","Restaura 1/8 de los PS pero confunde si al Pokémon no le gusta el sabor amargo"),
	(500,100,"Baya Pabaya","Restaura 1/8 de los PS pero confunde si al Pokémon no le gusta el sabor ácido"),
	(500,100,"Baya Frambu","Sirve para hacer Pokécubos"),
	(500,100,"Baya Oram","Sirve para hacer Pokécubos"),
	(500,100,"Baya Latano","Sirve para hacer Pokécubos"),
	(500,100,"Baya Peragu","Sirve para hacer Pokécubos"),
	(500,100,"Baya Pinia","Sirve para hacer Pokécubos"),
	(500,100,"Baya Grana","Hace que el Pokémon sea amistoso, pero baja puntos de esfuerzo de PS (sólo Esm). Sirve para hacer Pokécubos"),
	(500,100,"Baya Algama","Restaura 10 PS"),
	(500,100,"Baya","Hace que el Pokémon sea amistoso, pero baja puntos de esfuerzo de At. (sólo Esm). Sirve para hacer Pokécubos"),
	(500,100,"Baya Ispero","Hace que el Pokémon sea amistoso, pero baja puntos de esfuerzo de Def. (sólo Esm). Sirve para hacer Pokécubos"),
	(500,100,"Baya Meluce","Hace que el Pokémon sea amistoso, pero baja puntos de esfuerzo de AtEsp. (sólo Esm). Sirve para hacer Pokécubos"),
	(500,100,"Baya Uvav","Hace que el Pokémon sea amistoso, pero baja puntos de esfuerzo de DefEsp. (sólo Esm). Sirve para hacer Pokécubos"),
	(500,100,"Baya Tamate","Hace que el Pokémon sea amistoso, pero baja puntos de esfuerzo de Vel. (sólo Esm). Sirve para hacer Pokécubos"),
	(500,100,"Baya Mais","Sirve para hacer Pokécubos"),
	(500,100,"Baya Aostan","Sirve para hacer Pokécubos"),
	(500,100,"Baya Rautan","Sirve para hacer Pokécubos"),
	(500,100,"Baya Monli","Sirve para hacer Pokécubos"),
	(500,100,"Baya Wikano","Sirve para hacer Pokécubos"),
	(500,100,"Baya Plama","Sirve para hacer Pokécubos"),
	(500,100,"Baya Sambia","Sirve para hacer Pokécubos"),
	(500,100,"Baya Rudion","Sirve para hacer Pokécubos"),
	(500,100,"Baya Andano","Sirve para hacer Pokécubos"),
	(500,100,"Baya Lichi","Aumenta el At. cuando los PS están por debajo de 1/3"),
	(500,100,"Baya Gonlan","Aumenta la Def. cuando los PS están por debajo de 1/3"),
	(500,100,"Baya Aslac","Aumenta la Vel. cuando los PS están por debajo de 1/3"),
	(500,100,"Baya Yapati","Aumenta el AtEsp. cuando los PS están por debajo de 1/3"),
	(500,100,"Baya Aricoc","Aumenta la DefEsp. cuando los PS están por debajo de 1/3"),
	(500,100,"Baya Zonlan","Aumenta la posibilidad de dar un golpe crítico cuando los PS están por debajo de 1/3"),
	(500,100,"Baya Arabol","Aumenta cualquier stat cuando los PS están por debajo de 1/3"),
	(500,100,"Baya Enigma","Sirve para hacer Pokécubos. Restaura 1/4 de los PS máximos cuando el Pokémon es afectado por ataques supereficaces");
    
-- Table Pokemon
    INSERT INTO Pokemon (idFood, namePo, typeP, typeS, descriptionPo, numPokedex, photoPo) 
    VALUES  
    (1, "Bulbasaur", "Planta", "Veneno", "Una extraña semilla fue plantada en su espalda al nacer. Las plantas brotan y crecen con este Pokémon.", 1, NULL),
    (2, "Ivysaur", "Planta", "Veneno", "Cuando el brote en la espalda empieza a inflamarse, una ráfaga de aroma dulce indica que la flor nacerá.", 2, NULL),
    (3, "Venusaur", "Planta", "Veneno", "La flor que tiene en su espalda tiene unos colores muy vivos si se mantiene en plena nutrición y a la luz del sol.", 3, NULL),
    (4, "Charmander", "Fuego", NULL, "El fuego en la punta de la cola es una medida de su vida. Si está sano, su cola arde intensamente.", 4, NULL),
    (5, "Charmeleon", "Fuego", NULL, "Si se agita durante la batalla, se escupe llamas intensas, incinerando todo a sus alrededores.", 5, NULL),
    (6, "Charizard", "Fuego", "Volador", "Escupe fuego tan caliente que funde las rocas. Puede causar los incendios forestales al soplar las llamas.", 6, NULL),
    (7, "Squirtle", "Agua", NULL, "Se esconde en su concha, y luego contraataca con chorros de agua en cada oportunidad.", 7, NULL),
    (8, "Wartortle", "Agua", NULL, "A menudo se esconde en el agua para acechar a su presa desprevenida. Para nadar rápido, mueve las orejas para mantener el equilibrio.", 8, NULL),
    (9, "Blastoise", "Agua", NULL, "Los chorros de agua, surtidores de los cañones de cohetes sobre su caparazón puede perforar una capa de acero.", 9, NULL),
    (10, "Caterpie", "Bicho", NULL, "Se cubre con una piel verde. Cuando crece, se desprende de la piel, se recubre de seda, y se convierte en un capullo.", 10, NULL),
    (11, "Metapod", "Bicho", NULL, "Una concha de acero duro protege a su tierno cuerpo. Se queda en silencio soportando las dificultades a la espera de la evolución.", 11, NULL),
    (12, "Butterfree", "Bicho", "Volador", "Le encanta la miel de las flores y pueden localizar los parches de flores que tienen incluso cantidades muy pequeñas de polen.", 12, NULL),
    (13, "Weedle", "Bicho", "Veneno", "Se encuentra a menudo en los bosques y praderas. Cuenta con una púa tóxica cerca de dos pulgadas en la parte superior de su cabeza.", 13,NULL),
    (14, "Kakuna", "Bicho", "Veneno", "A la espera de la evolución, se esconde debajo de las hojas de los depredadores y en los rincones de las ramas.", 14, NULL),
    (15, "Beedrill", "Bicho", "Veneno", "Su mejor ataque consiste en volar alrededor a gran velocidad, golpeando con las agujas de veneno.", 15, NULL),
    (16, "Pidgey", "Normal", "Volador", "Es dócil y prefiere evitar el conflicto. Si se les molesta, sin embargo, puede devolver el golpe feroz.", 16, NULL),
    (17, "Pidgeotto", "Normal", "Volador", "Vuela por su amplio territorio en busca de presas, derribandolas con sus garras muy desarrolladas.", 17, NULL),
    (18, "Pidgeot", "Normal", "Volador", "Aleteando sus alas con toda su fuerza, Pidgeot puede hacer una ráfaga de viento capaz de derribar grandes árboles.", 18, NULL),
    (19, "Ratatta", "Normal", NULL, "Cauteloso en extremo, su vitalidad robusta le permite vivir en cualquier tipo de ambiente.", 19, NULL),
    (20, "Raticatte", "Normal", NULL, "Roe objetos duros constantemente para disminuir el tamaño de sus colmillos ya qué siempre están en constante crecimiento.", 20, NULL),
    (21, "Spearow", "Normal", "Volador", "A la hora de proteger su territorio, compensa su incapacidad para volar a gran altura con una increíble velocidad.", 21, NULL),
    (22, "Fearow", "Normal", "Volador", "Este Pokémon ha existido desde tiempos remotos. Al menor atisbo de peligro, alza el vuelo y huye.", 22, NULL),
    (23, "Ekans", "Veneno", NULL, "La longitud de este Pokémon aumenta con el tiempo. Por la noche, se enrosca en las ramas de los árboles para descansar.", 23, NULL),
    (24, "Arbok", "Veneno", NULL, "Se han llegado a identificar hasta seis variaciones distintas de los espeluznantes dibujos de su piel.", 24, NULL),
    (25, "Pikachu", "Electrico", NULL, "Cuando se enfada, este Pokémon descarga la energía que almacena en el interior de las bolsas de las mejillas.", 25, NULL),
    (1, "Raichu", "Electrico", NULL, "Su cola actúa como toma de tierra y descarga electricidad al suelo, lo que le protege de los calambrazos.", 26, NULL),
    (1, "Sandshrew", "Tierra", NULL, "Le gusta revolcarse por la arena seca para eliminar todo rastro de suciedad y humedad en la piel.", 27, NULL);

-- Table Enclo_Poke
	INSERT INTO Enclo_Poke (idEnclosure, idPokemon)
    VALUES
    (1,10),
    (3,25),
    (3,26),
    (6,4);

-- CREACION VISTAS
CREATE VIEW comidaMasUsada AS
SELECT f.nameFo AS "Nombre Baya", Count(p.idFood) AS "Veces usada" 
FROM Food AS f
LEFT JOIN Pokemon AS p ON p.idFood = f.idFood
GROUP BY f.idFood
ORDER BY Count(*) DESC;

CREATE VIEW pokemonsPorRecintos AS 
SELECT e.numberEn AS "Numero Recinto", e.typeEn AS "Tipo", Count(*) AS "Nº Pokemons"
FROM enclosure AS e 
JOIN enclo_poke AS ep ON e.idEnclosure = ep.idEnclosure
JOIN pokemon AS p ON ep.idPokemon = p.idPokemon
GROUP BY e.numberEn, e.typeEn
ORDER BY Count(*) DESC;

-- CREACION ROLES
CREATE ROLE IF NOT EXISTS Admin;
GRANT ALL ON pokezoo.*
TO Admin;

CREATE ROLE IF NOT EXISTS Trabajador;
GRANT SELECT 
ON pokeZoo.*
TO Trabajador;

-- CREACION USUARIOS
CREATE USER IF NOT EXISTS 'Admin'@'localhost' IDENTIFIED BY '1234' 
DEFAULT ROLE Admin;

CREATE USER IF NOT EXISTS 'Cliente'@'localhost' IDENTIFIED BY 'Cliente1234'
DEFAULT ROLE Trabajador
WITH max_queries_per_hour 20
max_connections_per_hour 5
max_user_connections 1
PASSWORD EXPIRE INTERVAL 60 DAY;

CREATE USER IF NOT EXISTS 'Supervisor'@'localhost' IDENTIFIED BY 'Supervisor1234'
DEFAULT ROLE Trabajador
WITH max_user_connections 2
PASSWORD EXPIRE INTERVAL 120 DAY;