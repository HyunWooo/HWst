
ALTER TABLE Users
	DROP PRIMARY KEY; 


DROP TABLE IF EXISTS Users RESTRICT;

TRUNCATE TABLE Users;
drop table users;


CREATE TABLE Users (
	userNo      int AUTO_INCREMENT primary key, 
	id          varchar(30) not NULL,     
	pw          varchar(20) not NULL,     
	name        varchar(10) not NULL,     
	phone       varchar(20) not NULL,     
	postCode    varchar(10) not NULL,    
	address     varchar(50) not NULL,    
	userSection int not NULL      
);


CREATE TABLE Buyer (
	userNo        int primary key, 
	grade        int not NULL,  
	udtGradeTime date not NULL      
);


CREATE TABLE Seller (
	userNo    int primary key,  
	bankName  varchar(10) not NULL,     
	accountNo varchar(20) not NULL     
);

CREATE TABLE Admin (
	userNo     int primary key,
	adminName varchar(10) not NULL   
);




ALTER TABLE Buyer
	ADD CONSTRAINT FK_Users_TO_Buyer 
		FOREIGN KEY (
			userNo 
		)
		REFERENCES Users ( 
			userNo
		);
		

ALTER TABLE Seller
	ADD CONSTRAINT FK_Users_TO_Seller
		FOREIGN KEY (
			userNo
		)
		REFERENCES Users (
			userNo 
		);
		

ALTER TABLE Admin
	ADD CONSTRAINT FK_Users_TO_Admin 
		FOREIGN KEY (
			userNo
		)
		REFERENCES Users ( 
			userNo 
		);
		
commit;

insert into users values(null, 'gusdn@sk.com' , '123123' , '김현우' , '010-3341-3855' , '158-092', '서울시 양천구 신월2동 467-1 라벤하임 502호',1);
insert into users values(null, 'sellerKing@sk.com' , '123123' , '판매왕' , '010-6295-3855' ,'152-823','서울시 동작구 보라매역',2);
insert into users values(null, 'admin@sk.com' , '123123' , '관리자' , '010-3341-3855' ,'123-456','종로타워', 3);

insert into Buyer values((select userNo from users where id='gusdn@sk.com'),0,now());
insert into Seller values((select userNo from users where id='sellerKing@sk.com'),'우리','1002-389-901006');
insert into Admin values((select userNo from users where id='admin@sk.com'),'리스팅개발팀');


alter table users modify userSection enum('BUYER','SELLER', 'ADMIN');
alter table users modify userSection enum('UNREGISTER','BUYER','SELLER', 'ADMIN');
