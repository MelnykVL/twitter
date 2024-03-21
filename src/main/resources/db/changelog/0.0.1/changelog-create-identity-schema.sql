--liquibase formatted sql

--changeset MelnykVL:create-identity-schema
--comment create new identity schema
CREATE SCHEMA identity;
--rollback DROP SCHEMA identity;

--changeset MelnykVL:create-identity-user_accounts-table
--comment create table identity.user_accounts
CREATE TABLE identity.user_accounts
(
    id          SERIAL PRIMARY KEY,
    username    VARCHAR(32) UNIQUE NOT NULL,
    password    VARCHAR(128) NOT NULL
);
--rollback drop table identity.user_accounts;

--changeset MelnykVL:create-identity-user_roles-table
--comment create table identity.user_roles
CREATE TABLE identity.user_roles
(
    id          SERIAL PRIMARY KEY,
    authority   VARCHAR(32) UNIQUE NOT NULL
);
--rollback drop table identity.user_roles;

--changeset MelnykVL:create-identity-user_accounts_roles-table
--comment create table identity.user_accounts_roles
CREATE TABLE identity.user_accounts_roles
(
    user_account_id INTEGER NOT NULL,
    user_role_id    INTEGER NOT NULL
);
--rollback drop table identity.user_accounts_roles;

--changeset MelnykVL:add-user_accounts_roles-table-constraints
-- comment add constraints to to user_accounts_roles
ALTER TABLE  identity.user_accounts_roles
    ADD CONSTRAINT user_accounts_roles__user_roles__fk
        FOREIGN KEY (user_role_id) REFERENCES identity.user_roles (id);

ALTER TABLE  identity.user_accounts_roles
    ADD CONSTRAINT user_accounts_roles__user_accounts__fk
        FOREIGN KEY (user_account_id) REFERENCES identity.user_accounts (id);

ALTER TABLE  identity.user_accounts_roles
    ADD CONSTRAINT user_accounts_roles_unique
        UNIQUE (user_account_id, user_role_id);
--rollback alter table identity.user_accounts_roles drop constraint user_accounts_roles__user_roles__fk;
--rollback alter table identity.user_accounts_roles drop constraint user_accounts_roles__user_accounts__fk;
--rollback alter table identity.user_accounts_roles drop constraint user_accounts_roles_unique;

--changeset MelnykVL:add-data-to-user_roles-table
--comment add roles to user_roles table
INSERT INTO identity.user_roles(authority)
VALUES  ('ROLE_USER'),
        ('ROLE_ADMIN');
--rollback truncate table identity.user_roles