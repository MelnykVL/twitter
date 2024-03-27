--liquibase formatted sql

--changeset MelnykVL:create-twitter-tweets-table
--comment create table twitter.tweets
CREATE TABLE twitter.tweets
(
    id                 SERIAL PRIMARY KEY,
    message            VARCHAR(280) NOT NULL,
    user_profile_id    INTEGER      NOT NULL,
    created_timestamp  TIMESTAMP    NOT NULL
);
--rollback drop table twitter.tweets;

--changeset MelnykVL:add-twitter-user_profiles-table-constraints
--comment add constraints to twitter.tweets table
ALTER TABLE twitter.tweets
    ADD CONSTRAINT tweets__user_profiles__fk
        FOREIGN KEY (user_profile_id) REFERENCES twitter.user_profiles (id);

--rollback alter table twitter.tweets drop constraint tweets__user_profiles__fk;

--changeset MelnykVL:add-twitter-user_profiles-table-column-modified_timestamp
--comment add column modified_timestamp to twitter.tweets table
ALTER TABLE twitter.tweets
    ADD COLUMN modified_timestamp TIMESTAMP;

UPDATE twitter.tweets
SET modified_timestamp = created_timestamp
WHERE modified_timestamp IS NULL;

ALTER TABLE twitter.tweets
    ALTER COLUMN modified_timestamp SET NOT NULL;
--rollback alter table twitter.tweets drop column modified_timestamp;