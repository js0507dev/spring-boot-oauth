-- normal member
insert into member(id, uid, password, name, email, regdate, chgdate) values(1, 'jsmaster', '', 'JS Shim', 'js0507dev@gmail.com', '2018-05-23 09:41:23', '2018-05-23 09:41:23');

-- member role
insert into member_role(uid, rolename) values(1, 'BASIC');