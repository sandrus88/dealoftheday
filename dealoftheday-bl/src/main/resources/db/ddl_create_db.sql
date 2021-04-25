 
create table customer (	
    ID number, 
    NAME varchar2(100 byte), 
    SURNAME varchar2(100 byte),
    BIRTHDATE date,
    EMAIL varchar2(100 byte),
    PWD varchar2(100 byte),
    TEL varchar2(100 byte),
        
    PRIMARY KEY (ID)
);

create table city (	
    ID char(2), 
    NAME varchar2(100 byte), 
    LAT double;
    LNG double;
        
    PRIMARY KEY (ID)
);