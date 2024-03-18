--liquibase formatted sql

--changeset MelnykVL:create-twitter-schema
--comment create new schema
CREATE SCHEMA twitter;
--rollback DROP SCHEMA twitter;