drop table category;

create table category(
  catCode int primary key,
  upCatCode int not null,
  catName varchar(10) not null
);

commit;

insert into category values(0,0,'대분류');
insert into category values(1,0,'의류');
insert into category values(2,0,'악세사리');
insert into category values(3,0,'디지털');
insert into category values(4,0,'기타잡화');
insert into category values(5,1,'남성의류');
insert into category values(6,1,'여성의류');
insert into category values(7,1,'유아의류');
insert into category values(8,1,'스포츠의류');
insert into category values(9,2,'귀걸이');
insert into category values(10,2,'목걸이');
insert into category values(11,3,'가전제품');
insert into category values(12,3,'컴퓨터');
insert into category values(13,0,'기타잡화');

