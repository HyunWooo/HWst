drop table orders;


-- 주문
CREATE TABLE Orders (
	orderNo     int AUTO_INCREMENT PRIMARY KEY, -- 주문번호
	userNo       int NOT NULL, -- 구매자_회원번호
	orderTime    datetime NOT NULL, -- 주문일시
	receiverName  varchar(10) NOT NULL, -- 받는사람명
	phone       varchar(20)  NOT NULL, -- 전화번호
	postCode    varchar(10)  NOT NULL, -- 우편번호
	address    varchar(50)   NOT NULL, -- 주소
	messasge    varchar(50)   NOT NULL, -- 배송시요구사항
	grade    int   NOT NULL, -- 등급번호
	orderStat  int   NOT NULL, -- 주문상태
	allTotalPrice   varchar(10)    NOT NULL, -- 총가격
	discountPrice    varchar(10)   NOT NULL, -- 할인금액
	discountedTotalPrice  varchar(10)  NOT NULL, -- 할인된총가격
	recentUpdateTime  datetime   NOT NULL, -- 최근수정일시
	recentUpdateUserNo int NOT NULL  -- 최근수정자회원번호
);


-- 주문_상품
CREATE TABLE OrderProduct (
	orderNo      int NOT NULL, -- 주문번호
	productOptionNo      int NOT NULL, -- 상품옵션번호
	buyAmount  int NOT NULL,     -- 주문수량
	totalPrice     int NOT NULL,     -- 상품가격
	productStat      int NOT NULL,     -- 상품상태
	deliveryStat int NOT NULL,     -- 배송상태
	deliveryDate datetime NULL,     -- 배송일자
	recentUpdateTime    datetime NOT  NULL,     -- 최근수정일시
	recentUpdateUserNo  int NOT NULL,      -- 최근수정자회원번호
	PRIMARY KEY(orderNo,productOptionNo)
);

-- 결제
CREATE TABLE Payment (
	orderNo          int PRIMARY KEY, -- 주문번호
	checkoutInfo          int  NOT NULL,     -- 결제방법
	depositYN       int NOT NULL,     -- 입금여부
	refundBankName  varchar(10) NULL,     -- 환불계좌은행명
	refundAccountNo varchar(20) NULL      -- 환불계좌번호
);

commit;


-- 주문//안됨
ALTER TABLE `MY_SCHEMA`.`Order`
	ADD CONSTRAINT `FK_Buyer_TO_Order` -- 구매자 -> 주문
		FOREIGN KEY (
			`userNo` -- 구매자_회원번호
		)
		REFERENCES `MY_SCHEMA`.`Buyer` ( -- 구매자
			`userNo` -- 구매자_회원번호
		);
		
		