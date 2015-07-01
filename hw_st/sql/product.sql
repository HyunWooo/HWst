drop table product;

create table product(
  proCode int AUTO_INCREMENT primary key,
  CatCode int not null,
  proName varchar(30) not null,
  proAmount int not null,
  proPrice int not null,
  proStat int not null,
  proDetails varchar(200) not null,
  userCode int not null
);

commit;

insert into product values(null,5,'���� ī��Ƽ',10,15000,2,'������ �Ա� ���� ī��Ƽ',1);
insert into product values(null,5,'���� ����Ƽ',20,10000,2,'���� �߳����� ����Ƽ',1);
insert into product values(null,5,'���� ���̳�',5,20000,2,'�������� ������ ���̳�',1);

