INSERT INTO `house`.`housing_association` (`id`, `name`, `adress`) VALUES  (1,'Wspolnota Mieszkaniowa Rodzinna', 'Kosciuszki 32');
INSERT INTO `house`.`housing_association` (`id`, `name`, `adress`) VALUES (2,'Wspolnota Mieszkaniowa Spoleczna', 'Hallera 169');
INSERT INTO `house`.`housing_association` (`id`, `name`, `adress`) VALUES (3,'Wspolnota Mieszkaniowa Razem', 'Pisludskiego 132');
INSERT INTO `house`.`housing_association` (`id`, `name`, `adress`) VALUES (4,'Wspolnota Mieszkaniowa Roza', 'Armii Krajowej 62');
INSERT INTO `house`.`housing_association` (`id`, `name`, `adress`) VALUES (5,'Wspolnota Mieszkaniowa Sloneczna', 'Brucknera 2');

INSERT INTO `house`.`apartament` (`id`, `number`, `area`, `housing_association_id`) VALUES(1,12,47,1);
INSERT INTO `house`.`apartament` (`id`, `number`, `area`, `housing_association_id`) VALUES(2,13,120,1);
INSERT INTO `house`.`apartament` (`id`, `number`, `area`, `housing_association_id`) VALUES (3,3,75,2);
INSERT INTO `house`.`apartament` (`id`, `number`, `area`, `housing_association_id`) VALUES (4,1,67,3);
INSERT INTO `house`.`apartament` (`id`, `number`, `area`, `housing_association_id`) VALUES (5,2,53,4);
INSERT INTO `house`.`apartament` (`id`, `number`, `area`, `housing_association_id`) VALUES (6,15,140,5);
INSERT INTO `house`.`apartament` (`id`, `number`, `area`, `housing_association_id`) VALUES (7,4,36,5);
INSERT INTO `house`.`apartament` (`id`, `number`, `area`, `housing_association_id`) VALUES (8,7,42,4);


INSERT INTO `house`.`inhabitant` (`id`, `first_name`, `last_name`, `sex`, apartament_id) VALUES (1,'Tomasz','Kowalski','M',1);
INSERT INTO `house`.`inhabitant` (`id`, `first_name`, `last_name`, `sex`, apartament_id) VALUES (2,'Mateusz','Piorko','M',4);
INSERT INTO `house`.`inhabitant` (`id`, `first_name`, `last_name`, `sex`, apartament_id) VALUES (3,'Grzegorz','Dolny','M',2);
INSERT INTO `house`.`inhabitant` (`id`, `first_name`, `last_name`, `sex`, apartament_id) VALUES (4,'Jan','Piedziwiatr','M',5);
INSERT INTO `house`.`inhabitant` (`id`, `first_name`, `last_name`, `sex`, apartament_id) VALUES (5,'Barbara','Gorka','F',2);
INSERT INTO `house`.`inhabitant` (`id`, `first_name`, `last_name`, `sex`, apartament_id) VALUES  (6,'Anna','Lewandowka','F',3);
INSERT INTO `house`.`inhabitant` (`id`, `first_name`, `last_name`, `sex`, apartament_id) VALUES  (7,'Grazyna','Cebula','F',3);
INSERT INTO `house`.`inhabitant` (`id`, `first_name`, `last_name`, `sex`, apartament_id) VALUES  (8,'Karolina','Kopytko','F',6);