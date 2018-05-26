delete from member_role;
delete from member;

insert into member(id, uid, password, name, email, regdate, chgdate) values(1, 'jsmaster', '$2a$10$VdhB/74F2W4bA3T6tiaUYe3xdPdJZUKKliXSV1Y0e9GzaT/yElSSi', 'JS Shim', 'js0507dev@gmail.com', '2018-05-23 09:41:23', '2018-05-23 09:41:23');

insert into member_role(uid, rolename) values(1, 'BASIC');