drop table coffee if exists;

create table coffee (
    coffee_id bigint generated always as identity primary key,
    brand varchar(20),
    origin varchar(20),
    characteristics varchar(30)
) ;