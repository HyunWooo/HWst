drop table users;

create table users(
  userCode int AUTO_INCREMENT primary key,
  id varchar(20) not null,
  pw varchar(20) not null,
  name varchar(10) not null,
  phone varchar(20) not null,
  userStat int not null
);

commit;

insert into users values(null, 'gusdn@sk.com' , '123123' , '±èÇö¿ì' , '010-3341-3855' , 1);
insert into users values(null, 'seller@naver.com' , '123123' , 'ÆÇ¸Å¿Õ' , '010-6295-3855' , 2);
insert into users values(null, 'admin@sk.com' , '123123' , '°ü¸®ÀÚ' , '010-3341-3855' , 0);
