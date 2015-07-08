-- 회원
ALTER TABLE Users
	DROP PRIMARY KEY; -- 회원 기본키

-- 회원
DROP TABLE IF EXISTS Users RESTRICT;

TRUNCATE TABLE Users;
drop table users;

-- 회원
CREATE TABLE Users (
	userNo      int AUTO_INCREMENT primary key, -- 회원번호
	id          varchar(30) not NULL,     -- 아이디
	pw          varchar(20) not NULL,     -- 비밀번호
	name        varchar(10) not NULL,     -- 이름
	phone       varchar(20) not NULL,     -- 전화번호
	postCode    varchar(10) not NULL,     -- 우편번호
	address     varchar(50) not NULL,     -- 주소
	userSection int not NULL      -- 회원구분
);

-- 구매자
CREATE TABLE Buyer (
	userNo        int primary key, -- 구매자_회원번호
	grade        int not NULL,  -- 등급번호
	udtGradeTime date not NULL      -- 등급변경일시
);

-- 판매자
CREATE TABLE Seller (
	userNo    int primary key,  -- 판매자_회원번호
	bankName  varchar(10) not NULL,     -- 입금계좌은행명
	accountNo varchar(20) not NULL      -- 계좌번호
);

CREATE TABLE Admin (
	userNo     int primary key, -- 관리자번호
	adminName varchar(10) not NULL      -- 관리담담자명
);



-- 구매자
ALTER TABLE Buyer
	ADD CONSTRAINT FK_Users_TO_Buyer -- 회원 -> 구매자
		FOREIGN KEY (
			userNo -- 구매자_회원번호
		)
		REFERENCES Users ( -- 회원
			userNo -- 회원번호
		);
		
-- 판매자
ALTER TABLE Seller
	ADD CONSTRAINT FK_Users_TO_Seller -- 회원 -> 판매자
		FOREIGN KEY (
			userNo -- 판매자_회원번호
		)
		REFERENCES Users ( -- 회원
			userNo -- 회원번호
		);
		
-- 관리자
ALTER TABLE Admin
	ADD CONSTRAINT FK_Users_TO_Admin -- 회원 -> 관리자
		FOREIGN KEY (
			userNo -- 관리자번호
		)
		REFERENCES Users ( -- 회원
			userNo -- 회원번호
		);
		
commit;

insert into users values(null, 'gusdn@sk.com' , '123123' , '김현우' , '010-3341-3855' , '158-092', '서울시 양천구 신월2동 467-1 라벤하임 502호',0);
insert into users values(null, 'sellerKing@sk.com' , '123123' , '판매왕' , '010-6295-3855' ,'152-823','서울시 여의도구 여의도동 523번지',1);
insert into users values(null, 'admin@sk.com' , '123123' , '관리자' , '010-3341-3855' ,'123-456','경기도 부천시 소사구 소사본동 13번지', 2);

insert into Buyer values((select userNo from users where id='gusdn@sk.com'),0,now());
insert into Seller values((select userNo from users where id='sellerKing@sk.com'),'우리','1002-389-901006');
insert into Admin values((select userNo from users where id='admin@sk.com'),'김현우');
