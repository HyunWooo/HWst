-- ȸ��
ALTER TABLE Users
	DROP PRIMARY KEY; -- ȸ�� �⺻Ű

-- ȸ��
DROP TABLE IF EXISTS Users RESTRICT;

TRUNCATE TABLE Users;
drop table users;

-- ȸ��
CREATE TABLE Users (
	userNo      int AUTO_INCREMENT primary key, -- ȸ����ȣ
	id          varchar(30) not NULL,     -- ���̵�
	pw          varchar(20) not NULL,     -- ��й�ȣ
	name        varchar(10) not NULL,     -- �̸�
	phone       varchar(20) not NULL,     -- ��ȭ��ȣ
	postCode    varchar(10) not NULL,     -- �����ȣ
	address     varchar(50) not NULL,     -- �ּ�
	userSection int not NULL      -- ȸ������
);

-- ������
CREATE TABLE Buyer (
	userNo        int primary key, -- ������_ȸ����ȣ
	grade        int not NULL,  -- ��޹�ȣ
	udtGradeTime date not NULL      -- ��޺����Ͻ�
);

-- �Ǹ���
CREATE TABLE Seller (
	userNo    int primary key,  -- �Ǹ���_ȸ����ȣ
	bankName  varchar(10) not NULL,     -- �Աݰ��������
	accountNo varchar(20) not NULL      -- ���¹�ȣ
);

CREATE TABLE Admin (
	userNo     int primary key, -- �����ڹ�ȣ
	adminName varchar(10) not NULL      -- ��������ڸ�
);



-- ������
ALTER TABLE Buyer
	ADD CONSTRAINT FK_Users_TO_Buyer -- ȸ�� -> ������
		FOREIGN KEY (
			userNo -- ������_ȸ����ȣ
		)
		REFERENCES Users ( -- ȸ��
			userNo -- ȸ����ȣ
		);
		
-- �Ǹ���
ALTER TABLE Seller
	ADD CONSTRAINT FK_Users_TO_Seller -- ȸ�� -> �Ǹ���
		FOREIGN KEY (
			userNo -- �Ǹ���_ȸ����ȣ
		)
		REFERENCES Users ( -- ȸ��
			userNo -- ȸ����ȣ
		);
		
-- ������
ALTER TABLE Admin
	ADD CONSTRAINT FK_Users_TO_Admin -- ȸ�� -> ������
		FOREIGN KEY (
			userNo -- �����ڹ�ȣ
		)
		REFERENCES Users ( -- ȸ��
			userNo -- ȸ����ȣ
		);
		
commit;

insert into users values(null, 'gusdn@sk.com' , '123123' , '������' , '010-3341-3855' , '158-092', '����� ��õ�� �ſ�2�� 467-1 ������ 502ȣ',0);
insert into users values(null, 'sellerKing@sk.com' , '123123' , '�Ǹſ�' , '010-6295-3855' ,'152-823','����� ���ǵ��� ���ǵ��� 523����',1);
insert into users values(null, 'admin@sk.com' , '123123' , '������' , '010-3341-3855' ,'123-456','��⵵ ��õ�� �һ籸 �һ纻�� 13����', 2);

insert into Buyer values((select userNo from users where id='gusdn@sk.com'),0,now());
insert into Seller values((select userNo from users where id='sellerKing@sk.com'),'�츮','1002-389-901006');
insert into Admin values((select userNo from users where id='admin@sk.com'),'������');
