--liquibase formatted sql

--changeset MelnykVL:create-twitter-tweets-table
--comment create table twitter.tweets
CREATE TABLE twitter.tweets
(
    id                  SERIAL PRIMARY KEY,
    message             VARCHAR(280) NOT NULL,
    user_profiles_id    INTEGER NOT NULL,
    created_timestamp   TIMESTAMP NOT NULL
);
--rollback drop table twitter.tweets;

--changeset MelnykVL:add-twitter-user_profiles-table-constraints
--comment add constraints to twitter.tweets table
ALTER TABLE twitter.tweets
    ADD CONSTRAINT tweets__user_profiles__fk
        FOREIGN KEY (user_profiles_id) REFERENCES twitter.user_profiles (id);