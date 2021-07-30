create table posts
(
    id          serial primary key,
    name        varchar(2000),
    description text,
    created     timestamp without time zone not null default now()
);

insert into posts (name)
values ('О чем этот форум?');
insert into posts (name)
values ('Правила форума.');

CREATE TABLE users
(
    id       serial primary key,
    username VARCHAR(50)  NOT NULL unique,
    password VARCHAR(100) NOT NULL,
    enabled  boolean default true
);

ALTER TABLE posts
    ADD COLUMN user_id int;

ALTER TABLE users
    add column authority_id int;

CREATE TABLE authorities
(
    id        serial primary key,
    authority VARCHAR(50) NOT NULL unique
);