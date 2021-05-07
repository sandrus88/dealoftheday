 
create table customer (	
    ID number, 
    NAME varchar2(100 byte), 
    SURNAME varchar2(100 byte),
    BIRTHDATE date,
    EMAIL varchar2(100 byte),
    PWD varchar2(100 byte),
    TEL varchar2(100 byte),
    SEX	varchar2(1 byte),
    ACTIVE number(1),
        
    PRIMARY KEY (ID)
);

create table city (	
    ID char(2), 
    NAME varchar2(100 byte), 
    LAT double,
    LNG double,
        
    PRIMARY KEY (ID)
);

create table partner (	
    ID number, 
    NAME varchar2(100 byte), 
    ADDRESS varchar2(100 byte),
    TEL varchar2(100 byte),
    CELL varchar2(100 byte),
    EMAIL varchar2(100 byte),
    WEB_SITE varchar2(100 byte),
    CATEGORY varchar2(100 byte),
    CITY_ID char(2),
        
    PRIMARY KEY (ID),
    CONSTRAINT partner_city_fk FOREIGN KEY (CITY_ID) REFERENCES city(ID)
);