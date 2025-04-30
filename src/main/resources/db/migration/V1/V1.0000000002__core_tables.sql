insert into users (username, password)
values ('Sanjar', '123456');

insert into role (name)
values ('ADMIN');

insert into user_role (user_id, role_id)
values(
    (select id from users where username = 'Sanjar'),
    (select id from role where name = 'ADMIN')
);

