drop table sys_user;
drop table sys_role;
drop table sys_authority;
drop table sys_role_authority;
drop table sys_role_user;

create table sys_user
(
    id                   bigint unsigned not null primary key,
    nickname             varchar(100) not null,
    username             varchar(50)  not null,
    password             varchar(255) not null,
    is_deleted           tinyint(1),
    is_enabled           tinyint(1),
    version              timestamp,
    gmt_create           timestamp,
    gmt_create_user_id   bigint unsigned,
    gmt_modified         timestamp,
    gmt_modified_user_id bigint unsigned
);

create table sys_role
(
    id                   bigint unsigned not null primary key,
    code                 varchar(50) not null,
    name                 varchar(50) not null,
    gmt_create           timestamp,
    gmt_create_user_id   bigint unsigned,
    gmt_modified         timestamp,
    gmt_modified_user_id bigint unsigned
);

create table sys_authority
(
    id                   bigint unsigned not null primary key,
    code                 varchar(50) not null,
    name                 varchar(50) not null,
    gmt_create           timestamp,
    gmt_create_user_id   bigint unsigned,
    gmt_modified         timestamp,
    gmt_modified_user_id bigint unsigned
);

create table sys_role_authority
(
    id                   bigint unsigned not null primary key,
    role_id              bigint unsigned not null,
    authority_id         bigint unsigned not null,
    gmt_create           timestamp,
    gmt_create_user_id   bigint unsigned,
    gmt_modified         timestamp,
    gmt_modified_user_id bigint unsigned
);

create table sys_role_user
(
    id                   bigint unsigned not null primary key,
    role_id              bigint unsigned not null,
    user_id              bigint unsigned not null,
    gmt_create           timestamp,
    gmt_create_user_id   bigint unsigned,
    gmt_modified         timestamp,
    gmt_modified_user_id bigint unsigned
);

insert into sys_user(id, nickname, username, password, is_deleted, is_enabled, version, gmt_create,
                     gmt_modified)
values (2024012714131759301, '超级管理员', 'admin',
        '$2a$10$XzyeFNnRM/rY8i8Zt.Jrh.LdTdYzkkapVAB8GuCnFCkBVv7yQSFge', 0, 1, current_timestamp,
        current_timestamp, current_timestamp);
insert into sys_user(id, nickname, username, password, is_deleted, is_enabled, version, gmt_create,
                     gmt_modified)
values (2024012714131759302, '普通用户', 'user',
        '$2a$10$6Tn8f0SozhzuFRAG39QH3e.74LRnYO0/WYDsdhH6C.yKQoW9oMvMC', 0, 1, current_timestamp,
        current_timestamp, current_timestamp);

insert into sys_role(id, code, name, gmt_create, gmt_modified)
values (2024012714171580701, 'admin', '超级管理员', current_timestamp, current_timestamp);
insert into sys_role(id, code, name, gmt_create, gmt_modified)
values (2024012714171580702, 'user', '普通用户', current_timestamp, current_timestamp);

insert into sys_authority(id, code, name, gmt_create, gmt_modified)
values (2024012714171581101, '/user/list', '用户管理', current_timestamp, current_timestamp);
insert into sys_authority(id, code, name, gmt_create, gmt_modified)
values (2024012714171581102, '/user/insert', '新增用户', current_timestamp, current_timestamp);
insert into sys_authority(id, code, name, gmt_create, gmt_modified)
values (2024012714171581103, '/user/update', '修改用户', current_timestamp, current_timestamp);
insert into sys_authority(id, code, name, gmt_create, gmt_modified)
values (2024012714171581104, '/user/delete', '删除用户', current_timestamp, current_timestamp);
insert into sys_authority(id, code, name, gmt_create, gmt_modified)
values (2024012714171581105, '/user/password/reset', '还原密码', current_timestamp,
        current_timestamp);
insert into sys_authority(id, code, name, gmt_create, gmt_modified)
values (2024012714171581106, '/user/password/change', '修改密码', current_timestamp,
        current_timestamp);
insert into sys_authority(id, code, name, gmt_create, gmt_modified)
values (2024012714171581107, '/self/password/change', '修改密码', current_timestamp,
        current_timestamp);

insert into sys_role_authority (id, role_id, authority_id, gmt_create, gmt_modified)
values (2024012714171581201, 2024012714171580701, 2024012714171581101, current_timestamp,
        current_timestamp);
insert into sys_role_authority (id, role_id, authority_id, gmt_create, gmt_modified)
values (2024012714171581202, 2024012714171580701, 2024012714171581102, current_timestamp,
        current_timestamp);
insert into sys_role_authority (id, role_id, authority_id, gmt_create, gmt_modified)
values (2024012714171581203, 2024012714171580701, 2024012714171581103, current_timestamp,
        current_timestamp);
insert into sys_role_authority (id, role_id, authority_id, gmt_create, gmt_modified)
values (2024012714171581204, 2024012714171580701, 2024012714171581104, current_timestamp,
        current_timestamp);
insert into sys_role_authority (id, role_id, authority_id, gmt_create, gmt_modified)
values (2024012714171581205, 2024012714171580701, 2024012714171581105, current_timestamp,
        current_timestamp);
insert into sys_role_authority (id, role_id, authority_id, gmt_create, gmt_modified)
values (2024012714171581206, 2024012714171580701, 2024012714171581106, current_timestamp,
        current_timestamp);
insert into sys_role_authority (id, role_id, authority_id, gmt_create, gmt_modified)
values (2024012714171581207, 2024012714171580701, 2024012714171581107, current_timestamp,
        current_timestamp);
insert into sys_role_authority (id, role_id, authority_id, gmt_create, gmt_modified)
values (2024012714171581208, 2024012714171580702, 2024012714171581107, current_timestamp,
        current_timestamp);

insert into sys_role_user (id, role_id, user_id, gmt_create, gmt_modified)
values (2024012714171581301, 2024012714171580701, 2024012714131759301, current_timestamp,
        current_timestamp);
insert into sys_role_user (id, role_id, user_id, gmt_create, gmt_modified)
values (2024012714171581302, 2024012714171580702, 2024012714131759302, current_timestamp,
        current_timestamp);
