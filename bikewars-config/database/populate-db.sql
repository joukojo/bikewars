insert into users(email, password, created, modified) values ('user1@bikewars.net', 'password', NOW(), NOW()); 
insert into users(email, password, created, modified) values ('user2@bikewars.net', 'password', NOW(), NOW()); 
insert into users(email, password, created, modified) values ('user3@bikewars.net', 'password', NOW(), NOW()); 
insert into users(email, password, created, modified) values ('user4@bikewars.net', 'password', NOW(), NOW()); 
insert into users(email, password, created, modified) values ('user5@bikewars.net', 'password', NOW(), NOW()); 
insert into users(email, password, created, modified) values ('user6@bikewars.net', 'password', NOW(), NOW()); 
insert into users(email, password, created, modified) values ('user7@bikewars.net', 'password', NOW(), NOW()); 
insert into users(email, password, created, modified) values ('user8@bikewars.net', 'password', NOW(), NOW()); 
insert into users(email, password, created, modified) values ('user9@bikewars.net', 'password', NOW(), NOW()); 
insert into users(email, password, created, modified) values ('user10@bikewars.net', 'password', NOW(), NOW()); 


insert into user_profile(id, nickname, energy, max_energy, energy_inc, health, max_health, health_inc) values (1, 'user1', 1, 100, 10, 1, 100, 10); 
insert into user_profile(id, nickname, energy, max_energy, energy_inc, health, max_health, health_inc) values (2, 'user2', 1, 100, 10, 1, 100, 10); 
insert into user_profile(id, nickname, energy, max_energy, energy_inc, health, max_health, health_inc) values (3, 'user3', 1, 100, 10, 1, 100, 10); 
insert into user_profile(id, nickname, energy, max_energy, energy_inc, health, max_health, health_inc) values (4, 'user4', 1, 100, 10, 1, 100, 10); 
insert into user_profile(id, nickname, energy, max_energy, energy_inc, health, max_health, health_inc) values (5, 'user5', 1, 100, 10, 1, 100, 10); 
insert into user_profile(id, nickname, energy, max_energy, energy_inc, health, max_health, health_inc) values (6, 'user6', 1, 100, 10, 1, 100, 10); 
insert into user_profile(id, nickname, energy, max_energy, energy_inc, health, max_health, health_inc) values (7, 'user7', 1, 100, 10, 1, 100, 10); 
insert into user_profile(id, nickname, energy, max_energy, energy_inc, health, max_health, health_inc) values (8, 'user8', 1, 100, 10, 1, 100, 10); 
insert into user_profile(id, nickname, energy, max_energy, energy_inc, health, max_health, health_inc) values (9, 'user9', 1, 100, 10, 1, 100, 10); 
insert into user_profile(id, nickname, energy, max_energy, energy_inc, health, max_health, health_inc) values (10, 'user10', 1, 100, 10, 1, 100, 10); 


INSERT INTO user_jobs  ( name, description, income, energy, created, modified) values('job1', 'job1 description', 10,10, now(), now());
INSERT INTO user_jobs  ( name, description, income, energy, created, modified) values('job2', 'job2 description', 10,10, now(), now());
INSERT INTO user_jobs  ( name, description, income, energy, created, modified) values('job3', 'job3 description', 30, 30, now(), now());
INSERT INTO user_jobs  ( name, description, income, energy, created, modified) values('job4', 'job4 description', 40, 40, now(), now());
INSERT INTO user_jobs  ( name, description, income, energy, created, modified) values('job5', 'job5 description', 50, 50, now(), now());
INSERT INTO user_jobs  ( name, description, income, energy, created, modified) values('job6', 'job6 description', 60, 60, now(), now());

INSERT INTO stocks (id, name, description, current_price, min_price, delta_price, created, modified) VALUES (15, 'stock name 15', 'stock description 15', 10, 5, 3,  now(), now());
INSERT INTO stocks (id, name, description, current_price, min_price, delta_price, created, modified) VALUES (16, 'stock name 16', 'stock description 16', 12, 20, 15,now(), now());
INSERT INTO stocks (id, name, description, current_price, min_price, delta_price, created, modified) VALUES (17, 'stock name 17', 'stock description 17', 10, 15, 10, now(), now());
INSERT INTO stocks (id, name, description, current_price, min_price, delta_price, created, modified) VALUES (18, 'stock name 18', 'stock description 18', 120, 10, 60, now(), now());
INSERT INTO stocks (id, name, description, current_price, min_price, delta_price, created, modified) VALUES (19, 'stock name 19', 'stock description 19', 200, 15, 90, now(), now());
INSERT INTO stocks (id, name, description, current_price, min_price, delta_price, created, modified) VALUES (20, 'stock name 20', 'stock description 20', 400, 200, 600, now(), now());
