DROP TABLE `permission`;
DROP TABLE `resource`;
DROP TABLE `role`;


create table if not exists permission(  
    id varchar(40) primary key,  
    name varchar(40) unique,  
    description varchar(255)  
)ENGINE=INNODB DEFAULT CHARSET=UTF8; 

create table if not exists resource(  
    id varchar(40) primary key,  
    uri varchar(255) unique,  
    description varchar(255),  
    permission_id varchar(40),  
    constraint rPermission_id_FK foreign key(permission_id) references permission(id)  
)ENGINE=INNODB DEFAULT CHARSET=UTF8;
  

  
create table if not exists role(  
    id varchar(40) primary key,  
    name varchar(40) unique,  
    description varchar(255)  
)ENGINE=INNODB DEFAULT CHARSET=UTF8; 
  
create table if not exists user(  
    id varchar(40) primary key,  
    username varchar(40) not null unique,  
    password varchar(40) not null  
)ENGINE=INNODB DEFAULT CHARSET=UTF8;
  
create table if not exists permission_role(  
    permission_id varchar(40) not null,  
    role_id varchar(40) not null,  
    constraint permission_id_FK foreign key(permission_id) references permission(id),  
    constraint role_id_FK foreign key(role_id) references role(id),  
    constraint primary key(permission_id,role_id)  
)ENGINE=INNODB DEFAULT CHARSET=UTF8;
  
create table if not exists user_role(  
    user_id varchar(40) not null,  
    role_id varchar(40) not null,  
    constraint user_id_FK foreign key(user_id) references user(id),  
    constraint uRole_id_FK foreign key(role_id) references role(id),  
    constraint primary key(user_id,role_id)  
)ENGINE=INNODB DEFAULT CHARSET=UTF8;