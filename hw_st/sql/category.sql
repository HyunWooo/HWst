drop table category;

create table category(
  categoryNo int AUTO_INCREMENT primary key,
  upCategoryNo int not null,
  categoryName varchar(20) not null,
  recentUpdateTime datetime not null,
  recentUpdateUserNo int not null
);

commit;

insert into category values(null,1,'대분류', now(), 3);
insert into category values(null,1,'의류', now(), 3);
insert into category values(null,1,'악세사리', now(), 3);
insert into category values(null,1,'디지털', now(), 3);
insert into category values(null,1,'기타잡화', now(), 3);
insert into category values(null,2,'남성의류', now(), 3);
insert into category values(null,2,'여성의류', now(), 3);
insert into category values(null,2,'유아의류', now(), 3);
insert into category values(null,2,'스포츠용', now(), 3);
insert into category values(null,3,'귀걸이', now(), 3);
insert into category values(null,3,'목걸이', now(), 3);
insert into category values(null,4,'가전제품', now(), 3);
insert into category values(null,4,'컴퓨터', now(), 3);

ALTER TABLE category
	ADD CONSTRAINT FK_category_TO_category 
		FOREIGN KEY (
			upCategoryNo
		)
		REFERENCES category ( 
			categoryNo 
		);


		ALTER TABLE Product
	ADD CONSTRAINT FK_Category_TO_Product -- 카테고리 -> 상품
		FOREIGN KEY (
			categoryNo -- 카테고리번호
		)
		REFERENCES Category ( -- 카테고리
			categoryNo -- 카테고리번호
		);





