drop table product;

create table productOption(
  productOptionNo int AUTO_INCREMENT primary key,
  productNo int not null,
  optionProcedure int not null,
  addPrice int not null,
  productAmount int not null,
  productOptionName varchar(30) not null,
  optionStat int not null,
  recentUpdateTime datetime not null,
  recentUpdateUserNo int not null
);

commit;

insert into productOption values(null,4,1,2000,5,'빅플라워 블랙',1,now(),2);
insert into productOption values(null,4,2,3000,2,'빅플라워 핑크',1,now(),2);
insert into productOption values(null,4,3,4000,3,'빅플라워 네이비',1,now(),2);

insert into productOption values(null,5,1,4000,15,'일라일라 블랙',1,now(),2);
insert into productOption values(null,5,2,3000,2,'일라일라 핑크',1,now(),2);
insert into productOption values(null,5,3,4000,13,'일라일라 네이비',1,now(),2);

insert into productOption values(null,6,1,2000,5,'s라인 블랙',1,now(),2);
insert into productOption values(null,6,2,4000,21,'s라인 핑크',1,now(),2);
insert into productOption values(null,6,3,5000,32,'s라인 네이비',1,now(),2);


ALTER TABLE productOption
	ADD CONSTRAINT FK_productOption_TO_product 
		FOREIGN KEY (
			productNo
		)
		REFERENCES product ( 
			productNo 
		);