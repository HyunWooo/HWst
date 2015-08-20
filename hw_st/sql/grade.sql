TRUNCATE TABLE grade;



CREATE TABLE Grade (
	grading            int NOT NULL, -- 등급번호
	gradeName          varchar(20) NOT NULL,     -- 등급명
	discountPercent     int NOT NULL,     -- 할인율
	accmulOrderPayment int NOT NULL,     -- 누적주문완료결제금액
	accmulOrderNo      int NOT NULL      -- 누적주문완료건수
);

insert grade values(1,'일반',0,0,0);
insert grade values(2,'실버',5,200000,10);
insert grade values(3,'골드',10,500000,30);
