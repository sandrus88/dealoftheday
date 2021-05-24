
insert into customer (ID, NAME, SURNAME, BIRTHDATE, EMAIL, PWD, TEL, SEX, ACTIVE) values (1, 'Sandro', 'Gargano', TO_DATE('03/05/1988', 'DD/MM/YYYY'), 'sandrus88@hotmail.it', 'pwd1', '0601', 'M', 1);
insert into customer (ID, NAME, SURNAME, BIRTHDATE, EMAIL, PWD, TEL, SEX, ACTIVE) values (2, 'Ermal', 'Aliraj', TO_DATE('08/06/1984', 'DD/MM/YYYY'), 'ermalaliraj@gmail.com', 'pwd2', '0602', 'M', 1);
insert into customer (ID, NAME, SURNAME, BIRTHDATE, EMAIL, PWD, TEL, SEX, ACTIVE) values (3, 'Armela', 'Xhaxho', TO_DATE('03/07/1989', 'DD/MM/YYYY'), 'armelaxhaxho@hotmail.com', 'pwd3', '0603', 'F', 0);
insert into customer (ID, NAME, SURNAME, BIRTHDATE, EMAIL, PWD, TEL, SEX, ACTIVE) values (4, 'Aida', 'Xhaxho', TO_DATE('30/07/1984', 'DD/MM/YYYY'), 'aidaxhaxho@gmail.com', 'pwd4', '0604', 'F', 0);
insert into customer (ID, NAME, SURNAME, BIRTHDATE, EMAIL, PWD, TEL, SEX, ACTIVE) values (5, 'Mario', 'Rossi', TO_DATE('04/10/1975', 'DD/MM/YYYY'), 'mariorossi@hotmail.it', 'pwd5', '0605', 'M', 1);
 
insert into city (ID, NAME, LAT, LNG, LAST_UPDATE) values ('MI', 'Milano', 45.46427, 9.18951, CURRENT_TIMESTAMP);
insert into city (ID, NAME, LAT, LNG, LAST_UPDATE) values ('FI', 'Firenze', 43.77925, 11.24626, CURRENT_TIMESTAMP);
insert into city (ID, NAME, LAT, LNG, LAST_UPDATE) values ('PA', 'Palermo', 38.13205, 13.33561, CURRENT_TIMESTAMP);
insert into city (ID, NAME, LAT, LNG, LAST_UPDATE) values ('RM', 'Roma', 41.89193, 12.51133, CURRENT_TIMESTAMP);
insert into city (ID, NAME, LAT, LNG, LAST_UPDATE) values ('TO', 'Torino', 45.07049, 7.68682, CURRENT_TIMESTAMP);
insert into city (ID, NAME, LAT, LNG, LAST_UPDATE) values ('NA', 'Napoli', 40.85631, 14.24641, CURRENT_TIMESTAMP);
insert into city (ID, NAME, LAT, LNG, LAST_UPDATE) values ('BA', 'Bari', 41.11148, 16.85540, CURRENT_TIMESTAMP);
insert into city (ID, NAME, LAT, LNG, LAST_UPDATE) values ('BO', 'Bologna', 44.49381, 11.33875, CURRENT_TIMESTAMP);
insert into city (ID, NAME, LAT, LNG, LAST_UPDATE) values ('GE', 'Genova', 44.42640, 8.91519, CURRENT_TIMESTAMP);
insert into city (ID, NAME, LAT, LNG, LAST_UPDATE) values ('AO', 'Aosta',  45.73764, 7.31722, CURRENT_TIMESTAMP);
 
insert into partner (ID, NAME, ADDRESS, TEL, CELL, EMAIL, WEB_SITE, CATEGORY, CITY_ID) values (1, 'Ristorante la Padellaccia', 'Via San Antonino 19/r', '055', '+39329', 'padellaccia@hotmail.it', 'www.lapadellaccia.com', 'FOOD_AND_RESTAURANTS', 'FI');
insert into partner (ID, NAME, ADDRESS, TEL, CELL, EMAIL, WEB_SITE, CATEGORY, CITY_ID) values (2, 'Ristorante la Perla', 'Via Roma, 2', '02', '+39340', 'perla@hotmail.it', 'www.laperla.it', 'FOOD_AND_RESTAURANTS', 'MI');
insert into partner (ID, NAME, ADDRESS, TEL, CELL, EMAIL, WEB_SITE, CATEGORY, CITY_ID) values (3, 'Bar dietro l angolo', 'Piazza Puccini, 34', '06', '+39370', 'bar_dietro_angolo@hotmail.it', null, 'BAR_AND_DRINKS', 'RM');
insert into partner (ID, NAME, ADDRESS, TEL, CELL, EMAIL, WEB_SITE, CATEGORY, CITY_ID) values (4, 'Viaggiando viaggiando di Lucrezia Rossi', 'Piazza Verdi, angolo Via del Rinascimento, 56', '011', '+39345', 'viaggiando_viaggiando@hotmail.it', 'www.viaggiando.com', 'VISIT_TOURS', 'TO');
insert into partner (ID, NAME, ADDRESS, TEL, CELL, EMAIL, WEB_SITE, CATEGORY, CITY_ID) values (5, 'Cinema Manzoni di Show srl', 'Via del Melarancio, 78', '091', '+39393', 'cinema_manzoni@hotmail.it', null, 'CINEMA_THEATER_CONCERT', 'PA');
insert into partner (ID, NAME, ADDRESS, TEL, CELL, EMAIL, WEB_SITE, CATEGORY, CITY_ID) values (6, 'Caffe Pulcinella', 'Piazza SS.Annunziata, 67', '081', '+39327', 'caffe_pulcinella@hotmail.it', 'www.caffe_pulcinella.com', 'BAR_AND_DRINKS', 'NA');
insert into partner (ID, NAME, ADDRESS, TEL, CELL, EMAIL, WEB_SITE, CATEGORY, CITY_ID) values (7, 'Pausa Bellezza di Beatrice Verdi', 'Viale degli Abruzzi, 50', '051', '+39348', 'pausa_bellezza@hotmail.it', 'www.pausa_bellezza.it', 'BEAUTY_CARE', 'BO');
insert into partner (ID, NAME, ADDRESS, TEL, CELL, EMAIL, WEB_SITE, CATEGORY, CITY_ID) values (8, 'Clinica dentistica dott. Lo Varco', 'Largo Alinari, 6', '080', '+39333', 'clinica_lovarco@hotmail.it', null, 'HEALTH_CARE', 'BA');
insert into partner (ID, NAME, ADDRESS, TEL, CELL, EMAIL, WEB_SITE, CATEGORY, CITY_ID) values (9, 'Acquario Di Genova', 'Ponte Spinola', '010', '+39356', 'acquario_genova@hotmail.it', 'www.acquariogenova.it', 'ADVENTURE', 'GE');
insert into partner (ID, NAME, ADDRESS, TEL, CELL, EMAIL, WEB_SITE, CATEGORY, CITY_ID) values (10, 'Ristorante La vie en rose', 'Via delle rose, 4', '055', '+39343', 'lavienrose@hotmail.it', 'www.lavieenrose.com', 'FOOD_AND_RESTAURANTS', 'FI');

insert into users (USERNAME, NAME, SURNAME, EMAIL, PWD, ENABLED, LOCKED, FAILED_LOGIN_COUNT, LAST_UPDATE) values ('admin', 'AdminName', 'AdminSurname', 'sandrus88@hotmail.it', 'admin', 1, 1, 0, CURRENT_TIMESTAMP);
insert into users (USERNAME, NAME, SURNAME, EMAIL, PWD, ENABLED, LOCKED, FAILED_LOGIN_COUNT, LAST_UPDATE) values ('userSandro', 'Sandro', 'Gargano', 'sandro_gargano@hotmail.it', 'sandro88', 1, 1, 0, CURRENT_TIMESTAMP);
insert into users (USERNAME, NAME, SURNAME, EMAIL, PWD, ENABLED, LOCKED, FAILED_LOGIN_COUNT, LAST_UPDATE) values ('user3', 'User3Name', 'User3Surname', 'user3@gmail.com', 'user3', 1, 1, 0, CURRENT_TIMESTAMP);
insert into users (USERNAME, NAME, SURNAME, EMAIL, PWD, ENABLED, LOCKED, FAILED_LOGIN_COUNT, LAST_UPDATE) values ('user4', 'User4Name', 'User4Surname', 'user4@hotmail.com', 'user4', 1, 1, 0, CURRENT_TIMESTAMP);
insert into users (USERNAME, NAME, SURNAME, EMAIL, PWD, ENABLED, LOCKED, FAILED_LOGIN_COUNT, LAST_UPDATE) values ('user5', 'User5Name', 'User5Surname', 'user5@hotmail.it', 'user5', 1, 0, 0, CURRENT_TIMESTAMP);

insert into role (ID, NAME, DESCRIPTION) values (1, 'DataEntry', 'Role for inserting customers and contracts');
insert into role (ID, NAME, DESCRIPTION) values (2, 'Editor', 'Role for editing the deal description and add pictures. Cannot publish');
insert into role (ID, NAME, DESCRIPTION) values (3, 'Publisher', 'Role for handling the ');
insert into role (ID, NAME, DESCRIPTION) values (4, 'Viewer', 'Role for only accessing to statistics');
insert into role (ID, NAME, DESCRIPTION) values (5, 'Administrator', 'Full access and control');

insert into user_role (USER_ID, ROLE_ID) values ('admin', 5);
insert into user_role (USER_ID, ROLE_ID) values ('admin', 3);
insert into user_role (USER_ID, ROLE_ID) values ('userSandro', 4);

insert into contract (ID, CLIENT_FULLNAME, CLIENT_CELL, BROKER_FULLNAME, BROKER_CELL, SIGNED_DATE, START_DATE, END_DATE, IBAN, CONTRACT_COMMENT, PARTNER_ID) values (1, 'Client1', 'Cell Client1', 'Broker1', 'Cell Broker1', TO_DATE('01/01/2020', 'DD/MM/YYYY'), TO_DATE('01/02/2020', 'DD/MM/YYYY'), TO_DATE('01/03/2020', 'DD/MM/YYYY'), 'IT0001', 'Comment about Contract1', 1);
insert into contract (ID, CLIENT_FULLNAME, CLIENT_CELL, BROKER_FULLNAME, BROKER_CELL, SIGNED_DATE, START_DATE, END_DATE, IBAN, CONTRACT_COMMENT, PARTNER_ID) values (2, 'Client2', 'Cell Client2', 'Broker2', 'Cell Broker2', TO_DATE('02/01/2020', 'DD/MM/YYYY'), TO_DATE('02/02/2020', 'DD/MM/YYYY'), TO_DATE('02/03/2020', 'DD/MM/YYYY'), 'IT0002', 'Comment about Contract2', 1);
insert into contract (ID, CLIENT_FULLNAME, CLIENT_CELL, BROKER_FULLNAME, BROKER_CELL, SIGNED_DATE, START_DATE, END_DATE, IBAN, CONTRACT_COMMENT, PARTNER_ID) values (3, 'Client3', 'Cell Client3', 'Broker3', 'Cell Broker3', TO_DATE('03/01/2020', 'DD/MM/YYYY'), TO_DATE('03/02/2020', 'DD/MM/YYYY'), TO_DATE('03/03/2020', 'DD/MM/YYYY'), 'IT0003', 'Comment about Contract3', 2);
insert into contract (ID, CLIENT_FULLNAME, CLIENT_CELL, BROKER_FULLNAME, BROKER_CELL, SIGNED_DATE, START_DATE, END_DATE, IBAN, CONTRACT_COMMENT, PARTNER_ID) values (4, 'Client4', 'Cell Client4', 'Broker4', 'Cell Broker4', TO_DATE('04/01/2020', 'DD/MM/YYYY'), TO_DATE('04/02/2020', 'DD/MM/YYYY'), TO_DATE('04/03/2020', 'DD/MM/YYYY'), 'IT0004', 'Comment about Contract4', 3);
insert into contract (ID, CLIENT_FULLNAME, CLIENT_CELL, BROKER_FULLNAME, BROKER_CELL, SIGNED_DATE, START_DATE, END_DATE, IBAN, CONTRACT_COMMENT, PARTNER_ID) values (5, 'Client5', 'Cell Client5', 'Broker5', 'Cell Broker5', TO_DATE('05/01/2020', 'DD/MM/YYYY'), TO_DATE('05/02/2020', 'DD/MM/YYYY'), TO_DATE('05/03/2020', 'DD/MM/YYYY'), 'IT0005', 'Comment about Contract5', 4);

insert into deal (ID, TITLE, TITLE_NEWSLETTER, MAIN_IMG, SYNTHESIS, CONDITIONS, DESCRIPTION, STATUS, CONTRACT_COMMENT, LAST_UPDATE, LAST_UPDATE_USER, APPROVED_DATE, PARTNER_ID, CONTRACT_ID) values (1, 'Hotel Santa Lucia 4 stelle ', 'Newsletter Hotel Santa Lucia', 'Img Hotel Santa Lucia', 'Synthesis deal 1', 'Conditions deal 1', 'Description deal 1', 'DEAL_INSERTED', 'Comment about deal 1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, TO_DATE('02/01/2021', 'DD/MM/YYYY'), 4, 1);
insert into deal (ID, TITLE, TITLE_NEWSLETTER, MAIN_IMG, SYNTHESIS, CONDITIONS, DESCRIPTION, STATUS, CONTRACT_COMMENT, LAST_UPDATE, LAST_UPDATE_USER, APPROVED_DATE, PARTNER_ID, CONTRACT_ID) values (2, 'Cena per 2', 'Newsletter Cena per 2', 'Img Cena per 2', 'Synthesis deal 2', 'Conditions deal 2', 'Description deal 2', 'DEAL_INSERTED', 'Comment about deal 2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, TO_DATE('01/01/2021', 'DD/MM/YYYY'), 1, 2);


insert into deal_item (ID, TITLE_ITEM, DISCOUNTED_PRICE, FULL_PRICE, COMMISSION_PERCENTAGE, NR_MIN_CUSTOMERS, NR_MAX_CUSTOMERS, TOT_PURCHASE, DEAL_ID) values (1, 'Soggiorno 3 notti', 59.99, 99.99, 5.99, 50, 100, 149.99, 1);
insert into deal_item (ID, TITLE_ITEM, DISCOUNTED_PRICE, FULL_PRICE, COMMISSION_PERCENTAGE, NR_MIN_CUSTOMERS, NR_MAX_CUSTOMERS, TOT_PURCHASE, DEAL_ID) values (2, 'Soggiorno 5 notti', 69.99, 109.99, 6.99, 50, 100, 199.99, 1);
insert into deal_item (ID, TITLE_ITEM, DISCOUNTED_PRICE, FULL_PRICE, COMMISSION_PERCENTAGE, NR_MIN_CUSTOMERS, NR_MAX_CUSTOMERS, TOT_PURCHASE, DEAL_ID) values (3, 'Soggiorno 7 notti', 79.99, 119.99, 7.99, 50, 100, 189.99, 1);
