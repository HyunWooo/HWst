drop table cart;

create table cart(
  cartNo int AUTO_INCREMENT not null,
  productOptionNo int not null,
  userNo int not null,
  buyAmount int not null,
  cartTime datetime not null,
  PRIMARY KEY(cartNo,productOptionNo)
);


commit;

insert into cart values(null, 1, 70, 3, now());
insert into cart values(null, 2, 70, 1, now());
insert into cart values(null, 3, 70, 1, now());
insert into cart values(null, 4, 70, 3, now());
insert into cart values(null, 6, 70, 5, now());
insert into cart values(null, 8, 70, 3, now());
insert into cart values(null, 9, 70, 4, now());



ALTER TABLE Cart
	ADD CONSTRAINT FK_ProductOption_TO_Cart -- 상품옵션 -> 장바구니
		FOREIGN KEY (
			productOptionNo -- 상품옵션번호
		)
		REFERENCES ProductOption ( -- 상품옵션
			productOptionNo -- 상품옵션번호
		);


ALTER TABLE Cart
	ADD CONSTRAINT FK_Buyer_TO_cart -- 구매자 -> 장바구니
		FOREIGN KEY (
			userNo -- 구매자_회원번호
		)
		REFERENCES Buyer ( -- 구매자
			userNo -- 구매자_회원번호
		);

-- 장바구니//이거안됨



[CartVo [cartNo=19, productOptionNo=4, userNo=70, buyAmount=8, cartTime=2015-07-15 17:32:33.0, categoryNo=7, productNo=5, name=꽃무늬 원피스, productOptionName=일라일라 블랙, productAmount=15, addPrice=4000, basicPrice=42000, eachPrice=46000], 
CartVo [cartNo=24, productOptionNo=4, userNo=70, buyAmount=5, cartTime=2015-07-15 23:25:24.0, categoryNo=7, productNo=5, name=꽃무늬 원피스, productOptionName=일라일라 블랙, productAmount=15, addPrice=4000, basicPrice=42000, eachPrice=46000], 
CartVo [cartNo=35, productOptionNo=4, userNo=70, buyAmount=2, cartTime=2015-07-16 20:45:58.0, categoryNo=7, productNo=5, name=꽃무늬 원피스, productOptionName=일라일라 블랙, productAmount=15, addPrice=4000, basicPrice=42000, eachPrice=46000], 
CartVo [cartNo=22, productOptionNo=8, userNo=70, buyAmount=3, cartTime=2015-07-15 17:37:37.0, categoryNo=7, productNo=6, name=꼬스꼬스 워싱쾅쾅 원피스, productOptionName=s라인 핑크, productAmount=21, addPrice=4000, basicPrice=33000, eachPrice=37000], 
CartVo [cartNo=21, productOptionNo=9, userNo=70, buyAmount=3, cartTime=2015-07-15 17:37:37.0, categoryNo=7, productNo=6, name=꼬스꼬스 워싱쾅쾅 원피스, productOptionName=s라인 네이비, productAmount=32, addPrice=5000, basicPrice=33000, eachPrice=38000]]

testVo는[CartVo [cartNo=19, productOptionNo=4, userNo=70, buyAmount=8, cartTime=2015-07-15 17:32:33.0, categoryNo=7, productNo=5, name=꽃무늬 원피스, productOptionName=일라일라 블랙, productAmount=15, addPrice=4000, basicPrice=42000, eachPrice=46000], 
CartVo [cartNo=24, productOptionNo=4, userNo=70, buyAmount=5, cartTime=2015-07-15 23:25:24.0, categoryNo=7, productNo=5, name=꽃무늬 원피스, productOptionName=일라일라 블랙, productAmount=15, addPrice=4000, basicPrice=42000, eachPrice=46000], 
CartVo [cartNo=35, productOptionNo=4, userNo=70, buyAmount=2, cartTime=2015-07-16 20:45:58.0, categoryNo=7, productNo=5, name=꽃무늬 원피스, productOptionName=일라일라 블랙, productAmount=15, addPrice=4000, basicPrice=42000, eachPrice=46000], 
CartVo [cartNo=22, productOptionNo=8, userNo=70, buyAmount=3, cartTime=2015-07-15 17:37:37.0, categoryNo=7, productNo=6, name=꼬스꼬스 워싱쾅쾅 원피스, productOptionName=s라인 핑크, productAmount=21, addPrice=4000, basicPrice=33000, eachPrice=37000], 
CartVo [cartNo=21, productOptionNo=9, userNo=70, buyAmount=3, cartTime=2015-07-15 17:37:37.0, categoryNo=7, productNo=6, name=꼬스꼬스 워싱쾅쾅 원피스, productOptionName=s라인 네이비, productAmount=32, addPrice=5000, basicPrice=33000, eachPrice=38000]]
5
0번째 비교: 4 : 4 = true
13
[CartVo [cartNo=24, productOptionNo=4, userNo=70, buyAmount=13, cartTime=2015-07-15 23:25:24.0, categoryNo=7, productNo=5, name=꽃무늬 원피스, productOptionName=일라일라 블랙, productAmount=15, addPrice=4000, basicPrice=42000, eachPrice=46000], CartVo [cartNo=35, productOptionNo=4, userNo=70, buyAmount=2, cartTime=2015-07-16 20:45:58.0, categoryNo=7, productNo=5, name=꽃무늬 원피스, productOptionName=일라일라 블랙, productAmount=15, addPrice=4000, basicPrice=42000, eachPrice=46000], CartVo [cartNo=22, productOptionNo=8, userNo=70, buyAmount=3, cartTime=2015-07-15 17:37:37.0, categoryNo=7, productNo=6, name=꼬스꼬스 워싱쾅쾅 원피스, productOptionName=s라인 핑크, productAmount=21, addPrice=4000, basicPrice=33000, eachPrice=37000], CartVo [cartNo=21, productOptionNo=9, userNo=70, buyAmount=3, cartTime=2015-07-15 17:37:37.0, categoryNo=7, productNo=6, name=꼬스꼬스 워싱쾅쾅 원피스, productOptionName=s라인 네이비, productAmount=32, addPrice=5000, basicPrice=33000, eachPrice=38000]]
[19]
1번째 비교: 4 : 8 = false
2번째 비교: 8 : 9 = false

		
		
		
		