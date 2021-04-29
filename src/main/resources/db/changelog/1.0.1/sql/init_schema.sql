create table if not exists nest
(
    id      serial primary key,
    name    varchar(200),
    address varchar(200)
    );

create table if not exists birds
(
    id      serial primary key,
    name    varchar(200),
    color   varchar(200),
    fly     boolean,
    nest_id bigint,
    constraint birds_nest
    foreign key (nest_id)
    references nest (id)
    );