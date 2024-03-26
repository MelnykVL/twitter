--liquibase formatted sql

--changeset MelnykVL:create-twitter-user_profiles-table
--comment create table twitter.user_profiles
CREATE TABLE twitter.user_profiles
(
    id          INTEGER PRIMARY KEY,
    nickname    VARCHAR(32)     NOT NULL,
    image_link  VARCHAR(128)    NOT NULL
);
--rollback drop table twitter.user_profiles;

--changeset MelnykVL:add-twitter-user_profiles-table-constraints
--comment add constraints to twitter.user_profiles table
ALTER TABLE twitter.user_profiles
    ADD CONSTRAINT user_profiles__user_accounts__fk
        FOREIGN KEY (id) REFERENCES identity.user_accounts (id);

ALTER TABLE twitter.user_profiles
    ADD CONSTRAINT user_profiles__nickname__unique
        UNIQUE (nickname);
--rollback alter table twitter.user_profiles drop constraint user_profiles__user_accounts__fk
--rollback alter table twitter.user_profiles drop constraint user_profiles__nickname__unique