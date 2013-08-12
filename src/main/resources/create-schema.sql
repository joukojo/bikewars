drop table if exists users;
drop table if exists user_stocks; 
drop table if exists stocks;


create table users(
id integer not null auto_increment,
email varchar(255), 
password varchar(255),
status integer,
cash integer,
primary key(id)
)ENGINE = InnoDB;

create unique index email_inx on users(email);
create index login_inx on users(email, password);

create table stocks (
id integer not null auto_increment,
name varchar(255),
description text,
current_price integer,
primary key(id)
)ENGINE = InnoDB;

create table user_stocks(
id integer not null auto_increment,
user_id integer,
stock_id integer,
count integer,
purchase_date datetime,
primary key(id),
foreign key(stock_id) references stocks(id) on delete cascade,
foreign key(user_id) references users(id) on delete cascade
)ENGINE = InnoDB;

