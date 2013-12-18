-- You can use this file to load seed data into the database using SQL statements

insert into role (id, rolename) values (1, 'user')
insert into role (id, rolename) values (2, 'admin')

insert into OneToOneEntity (id, exampleString) values (1, 'Example String editable by user john')
insert into OneToOneEntity (id, exampleString) values (2, 'Example String editable by user mark')
insert into OneToOneEntity (id, exampleString) values (3, 'Example String editable by user peter')
insert into OneToOneEntityEditableByAdmin (id, exampleString) values (1, 'Example String editable by admin')
insert into BaseEntity (id, oneToOneEntityId, oneToOneEntityEditableByAdminId) values (1, 1, null) 
insert into BaseEntity (id, oneToOneEntityId, oneToOneEntityEditableByAdminId) values (2, 2, null) 
insert into BaseEntity (id, oneToOneEntityId, oneToOneEntityEditableByAdminId) values (3, 3, null) 

insert into user (id, username, password, baseEntityId) values (1, 'captain', MD5('444'), null) 
insert into user (id, username, password, baseEntityId) values (2, 'john', MD5('123'), 1) 
insert into user (id, username, password, baseEntityId) values (3, 'mark', MD5('456'), 2) 
insert into user (id, username, password, baseEntityId) values (4, 'peter', MD5('789'), 3) 
insert into userrole (users_id, users_username, roles_id) values (1, 'captain', 1)
insert into userrole (users_id, users_username, roles_id) values (1, 'captain', 2)
insert into userrole (users_id, users_username, roles_id) values (2, 'john', 1)
insert into userrole (users_id, users_username, roles_id) values (3, 'mark', 1)
insert into userrole (users_id, users_username, roles_id) values (4, 'peter', 1)


