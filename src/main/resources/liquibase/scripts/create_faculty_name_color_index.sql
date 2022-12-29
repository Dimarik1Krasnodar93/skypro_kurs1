--liquibase formatted sql

--changeset author:id1
CREATE TABLE users1 (
                       id SERIAL,
                       email TEXT
)