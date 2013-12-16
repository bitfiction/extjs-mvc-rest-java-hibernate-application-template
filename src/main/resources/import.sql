-- You can use this file to load seed data into the database using SQL statements

insert into role (id, rolename) values (1, 'user')
insert into role (id, rolename) values (2, 'admin')

insert into OneToOneEntity (id, exampleString) values (1, 'Example String editable by regular user')
insert into OneToOneEntityEditableByAdmin (id, exampleString) values (1, 'Example String editable by admin')
insert into BaseEntity (id, oneToOneEntityId, oneToOneEntityEditableByAdminId) values (1, 1, 1) 

insert into user (id, username, password, baseEntityId) values (1, 'captain', MD5('444'), 1) 
insert into user (id, username, password, baseEntityId) values (2, 'john', MD5('444'), 1) 
insert into userrole (users_id, users_username, roles_id) values (1, 'captain', 1)
insert into userrole (users_id, users_username, roles_id) values (1, 'captain', 2)
insert into userrole (users_id, users_username, roles_id) values (2, 'john', 1)


