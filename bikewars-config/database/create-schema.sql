drop table if exists user_stocks; 
drop table if exists stocks;
drop table if exists user_profile; 
drop table if exists users;
drop table if exists user_jobs; 

create table users(
id integer not null auto_increment,
email varchar(255), 
password varchar(255),
status integer,
cash integer,
created timestamp,
modified timestamp,
primary key(id)
)ENGINE = InnoDB;

create unique index email_inx on users(email);
create index login_inx on users(email, password);

create table stocks (
id integer not null auto_increment,
name varchar(255),
description text,
current_price integer,
created timestamp,
modified timestamp,
primary key(id)
)ENGINE = InnoDB;

create table user_stocks(
id integer not null auto_increment,
user_id integer,
stock_id integer,
count integer,
purchase_date timestamp,
purchase_price integer,
primary key(id),
foreign key(stock_id) references stocks(id) on delete cascade,
foreign key(user_id) references users(id) on delete cascade
)ENGINE = InnoDB;

create table user_profile(
id integer not null auto_increment,
nickname varchar(255),
energy integer,
max_energy integer,
energy_inc integer,
cash integer,
health integer,
max_health integer,
health_inc integer,
created timestamp,
modified timestamp,
primary key(id),
foreign key(id) references users(id) on delete cascade 
) ENGINE = InnoDB;

create table user_jobs (
id integer not null auto_increment,
name varchar(255),
description varchar(255),
income integer,
energy integer,
created timestamp,
modified timestamp,
primary key(id)
) ENGINE =InnoDB;



