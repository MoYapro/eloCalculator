create table if not exists match
(
    id           uuid not null,
    outcome      varchar(10),
    black_player uuid,
    white_player uuid,
    played_on    varchar(255),
    primary key (id)
);
create table if not exists users
(
    id           uuid not null,
    display_name varchar(255),
    email        varchar(255),
    username     varchar(255),
    elo          int,
    primary key (id)
);

