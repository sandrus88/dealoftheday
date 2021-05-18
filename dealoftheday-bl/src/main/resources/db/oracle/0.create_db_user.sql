alter session set "_ORACLE_SCRIPT"=true;   -- wrong but necessary since we are logged into CDB  in local env (and not into PDB)
CREATE USER dod_user IDENTIFIED BY dod_pwd;

grant create session to dod_user;
grant create table to dod_user;
grant create view, create procedure, create sequence to dod_user;

alter user dod_user quota unlimited on users;