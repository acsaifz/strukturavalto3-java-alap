create table loans(
    id bigint auto_increment,
    name varchar(255),
    debt bigint,
    interest double,
    constraint pk_loans primary key(id)
);