ALTER SESSION SET"_ORACLE_SCRIPT"=TRUE;
CREATE USER mybatis IDENTIFIED BY mybatis DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
GRANT CONNECT, RESOURCE TO mybatis;