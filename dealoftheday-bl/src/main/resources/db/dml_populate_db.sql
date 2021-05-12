
insert into customer (ID, NAME, SURNAME, BIRTHDATE, EMAIL, PWD, TEL, SEX, ACTIVE) values (1, 'Sandro', 'Gargano', TO_DATE('03/05/1988', 'DD/MM/YYYY'), 'sandrus88@hotmail.it', 'pwd1', '0601', 'M', 1);
insert into customer (ID, NAME, SURNAME, BIRTHDATE, EMAIL, PWD, TEL, SEX, ACTIVE) values (2, 'Ermal', 'Aliraj', TO_DATE('08/06/1984', 'DD/MM/YYYY'), 'ermalaliraj@gmail.com', 'pwd2', '0602', 'M', 1);
insert into customer (ID, NAME, SURNAME, BIRTHDATE, EMAIL, PWD, TEL, SEX, ACTIVE) values (3, 'Armela', 'Xhaxho', TO_DATE('03/07/1989', 'DD/MM/YYYY'), 'armelaxhaxho@hotmail.com', 'pwd3', '0603', 'F', 0);
insert into customer (ID, NAME, SURNAME, BIRTHDATE, EMAIL, PWD, TEL, SEX, ACTIVE) values (4, 'Aida', 'Xhaxho', TO_DATE('30/07/1984', 'DD/MM/YYYY'), 'aidaxhaxho@gmail.com', 'pwd4', '0604', 'F', 0);
insert into customer (ID, NAME, SURNAME, BIRTHDATE, EMAIL, PWD, TEL, SEX, ACTIVE) values (5, 'Mario', 'Rossi', TO_DATE('04/10/1975', 'DD/MM/YYYY'), 'mariorossi@hotmail.it', 'pwd5', '0605', 'M', 1);
 
insert into city (ID, NAME, LAT, LNG) values ('MI', 'Milano', 45.46427, 9.18951);
insert into city (ID, NAME, LAT, LNG) values ('FI', 'Firenze', 43.77925, 11.24626);
insert into city (ID, NAME, LAT, LNG) values ('PA', 'Palermo', 38.13205, 13.33561);
insert into city (ID, NAME, LAT, LNG) values ('RM', 'Roma', 41.89193, 12.51133);
insert into city (ID, NAME, LAT, LNG) values ('TO', 'Torino', 45.07049, 7.68682);
insert into city (ID, NAME, LAT, LNG) values ('NA', 'Napoli', 40.85631, 14.24641);
insert into city (ID, NAME, LAT, LNG) values ('BA', 'Bari', 41.11148, 16.85540);
insert into city (ID, NAME, LAT, LNG) values ('BO', 'Bologna', 44.49381, 11.33875);
insert into city (ID, NAME, LAT, LNG) values ('GE', 'Genova', 44.42640, 8.91519);
insert into city (ID, NAME, LAT, LNG) values ('AO', 'Aosta',  45.73764, 7.31722);
 
insert into partner (ID, NAME, ADDRESS, TEL, CELL, EMAIL, WEB_SITE, CATEGORY, CITY_ID) values (1, 'Ristorante la Padellaccia', 'Via San Antonino 19/r', '055', '+39329', 'padellaccia@hotmail.it', 'www.lapadellaccia.com', 'FOOD_AND_RESTAURANTS', 'FI');
insert into partner (ID, NAME, ADDRESS, TEL, CELL, EMAIL, WEB_SITE, CATEGORY, CITY_ID) values (2, 'Ristorante la Perla', 'Via Roma, 2', '02', '+39340', 'perla@hotmail.it', 'www.laperla.it', 'FOOD_AND_RESTAURANTS', 'MI');
insert into partner (ID, NAME, ADDRESS, TEL, CELL, EMAIL, WEB_SITE, CATEGORY, CITY_ID) values (3, 'Bar dietro l angolo', 'Piazza Puccini, 34', '06', '+39370', 'bar_dietro_angolo@hotmail.it', null, 'BAR_AND_DRINKS', 'RM');
insert into partner (ID, NAME, ADDRESS, TEL, CELL, EMAIL, WEB_SITE, CATEGORY, CITY_ID) values (4, 'Viaggiando viaggiando di Lucrezia Rossi', 'Piazza Verdi, angolo Via del Rinascimento, 56', '011', '+39345', 'viaggiando_viaggiando@hotmail.it', 'www.viaggiando.com', 'VISIT_TOURS', 'TO');
insert into partner (ID, NAME, ADDRESS, TEL, CELL, EMAIL, WEB_SITE, CATEGORY, CITY_ID) values (5, 'Cinema Manzoni di Show srl', 'Via del Melarancio, 78', '091', '+39393', 'cinema_manzoni@hotmail.it', null, 'CINEMA_THEATER_CONCERT', 'PA');
insert into partner (ID, NAME, ADDRESS, TEL, CELL, EMAIL, WEB_SITE, CATEGORY, CITY_ID) values (6, 'Caffè Pulcinella', 'Piazza SS.Annunziata, 67', '081', '+39327', 'caffe_pulcinella@hotmail.it', 'www.caffe_pulcinella.com', 'BAR_AND_DRINKS', 'NA');
insert into partner (ID, NAME, ADDRESS, TEL, CELL, EMAIL, WEB_SITE, CATEGORY, CITY_ID) values (7, 'Pausa Bellezza di Beatrice Verdi', 'Viale degli Abruzzi, 50', '051', '+39348', 'pausa_bellezza@hotmail.it', 'www.pausa_bellezza.it', 'BEAUTY_CARE', 'BO');
insert into partner (ID, NAME, ADDRESS, TEL, CELL, EMAIL, WEB_SITE, CATEGORY, CITY_ID) values (8, 'Clinica dentistica dott. Lo Varco', 'Largo Alinari, 6', '080', '+39333', 'clinica_lovarco@hotmail.it', null, 'HEALTH_CARE', 'BA');
insert into partner (ID, NAME, ADDRESS, TEL, CELL, EMAIL, WEB_SITE, CATEGORY, CITY_ID) values (9, 'Acquario Di Genova', 'Ponte Spinola', '010', '+39356', 'acquario_genova@hotmail.it', 'www.acquariogenova.it', 'ADVENTURE', 'GE');
insert into partner (ID, NAME, ADDRESS, TEL, CELL, EMAIL, WEB_SITE, CATEGORY, CITY_ID) values (10, 'Ristorante La vie en rose', 'Via delle rose, 4', '055', '+39343', 'lavienrose@hotmail.it', 'www.lavieenrose.com', 'FOOD_AND_RESTAURANTS', 'FI');

insert into users (USERNAME, NAME, SURNAME, EMAIL, PWD, ENABLED, LOCKED, FAILED_LOGIN_COUNT) values ('admin', 'Admin', 'Admin', 'sandrus88@hotmail.it', 'admin', 1, 0, 0);
insert into users (USERNAME, NAME, SURNAME, EMAIL, PWD, ENABLED, LOCKED, FAILED_LOGIN_COUNT) values ('admin2', 'Admin2', 'Admin2', 'admin2@hotmail.it', 'admin2', 0, 1, 0);
insert into users (USERNAME, NAME, SURNAME, EMAIL, PWD, ENABLED, LOCKED, FAILED_LOGIN_COUNT) values ('admin3', 'Admin3', 'Admin3', 'admin3@gmail.com', 'admin3', 1, 1, 0);
insert into users (USERNAME, NAME, SURNAME, EMAIL, PWD, ENABLED, LOCKED, FAILED_LOGIN_COUNT) values ('admin4', 'Admin4', 'Admin4', 'admin4@hotmail.com', 'admin4', 0, 0, 0);
insert into users (USERNAME, NAME, SURNAME, EMAIL, PWD, ENABLED, LOCKED, FAILED_LOGIN_COUNT) values ('admin5', 'Admin5', 'Admin5', 'admin5@hotmail.it', 'admin5', 1, 0, 0);
insert into users (USERNAME, NAME, SURNAME, EMAIL, PWD, ENABLED, LOCKED, FAILED_LOGIN_COUNT) values ('admin6', 'Admin6', 'Admin6', 'admin6@gmail.it', 'admin6', 1, 0, 0);
insert into users (USERNAME, NAME, SURNAME, EMAIL, PWD, ENABLED, LOCKED, FAILED_LOGIN_COUNT) values ('admin7', 'Admin7', 'Admin7', 'admin7@hotmail.it', 'admin7', 0, 1, 0);
insert into users (USERNAME, NAME, SURNAME, EMAIL, PWD, ENABLED, LOCKED, FAILED_LOGIN_COUNT) values ('admin8', 'Admin8', 'Admin8', 'admin8@gmail.com', 'admin8', 1, 1, 0);
insert into users (USERNAME, NAME, SURNAME, EMAIL, PWD, ENABLED, LOCKED, FAILED_LOGIN_COUNT) values ('admin9', 'Admin9', 'Admin9', 'admin9@hotmail.com', 'admin9', 0, 0, 0);
insert into users (USERNAME, NAME, SURNAME, EMAIL, PWD, ENABLED, LOCKED, FAILED_LOGIN_COUNT) values ('admin10', 'Admin10', 'Admin10', 'admin10@hotmail.it', 'admin10', 1, 0, 0);

insert into role (ID, NAME, DESCRIPTION) values (1, 'Administrator', 'Description of Administrator');
insert into role (ID, NAME, DESCRIPTION) values (2, 'Editor', 'Description of Editor');
insert into role (ID, NAME, DESCRIPTION) values (3, 'Subscriber', 'Description of Subscriber');
insert into role (ID, NAME, DESCRIPTION) values (4, 'Contributor', 'Description of Contributor');
insert into role (ID, NAME, DESCRIPTION) values (5, 'Viewer', 'Description of Viewer');
insert into role (ID, NAME, DESCRIPTION) values (6, 'Support', 'Description of Support');

insert into user_role (USER_ID, ROLE_ID) values ('admin', 1);
