 
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
    ID varchar2(2 byte), 
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
    CITY_ID varchar2(2 byte),
        
    PRIMARY KEY (ID),
    CONSTRAINT partner_city_fk FOREIGN KEY (CITY_ID) REFERENCES city(ID)
);

create table users (	
    USERNAME varchar2(100 byte), 
    NAME varchar2(100 byte), 
    SURNAME varchar2(100 byte),
    EMAIL varchar2(100 byte),
    PWD varchar2(100 byte),
    ENABLED number(1),
    LOCKED	number(1),
    FAILED_LOGIN_COUNT number,
        
    PRIMARY KEY (USERNAME)
);

create table role (	
    ID varchar2(100 byte), 
    DESCRIPTION varchar2(100 byte), 
        
    PRIMARY KEY (ID)
);

create table user_role (
	USER_ID varchar2(100 byte),
    ROLE_ID varchar2(100 byte),  
        
    PRIMARY KEY (USER_ID, ROLE_ID),
    CONSTRAINT users_to_role_fk FOREIGN KEY (USER_ID) REFERENCES users(USERNAME),
    CONSTRAINT role_to_users_fk FOREIGN KEY (ROLE_ID) REFERENCES role(ID)
);