select version();

select current_database();

select inet_server_addr(), inet_server_port();

--CREATE database dvdrental;

--select [필드명] from [테이블명]
select * from customer;	

select first_name, last_name, email from customer;

select first_name || ' ' || last_name, email from customer;

--Alias 필드명 재정의
select first_name || ' ' || last_name as full_name1, email from customer;

--Alias 생략 문법
select first_name || ' ' || last_name full_name2, email from customer;

--Alias 빈칸 적용
select first_name || ' ' || last_name "full name3", email from customer;

--현재 시간
select now();

--ASC / DESC
select first_name, last_name from customer order by first_name;

select first_name, last_name from customer order by first_name desc;

select first_name, last_name from customer order by first_name asc, last_name desc;

--함수사용 length()
select first_name, length(first_name) len from customer order by len desc;

--테이블 생성 및 row 값 추가
create table sort_demo(num INT);

insert into sort_demo(num) values (1), (2), (3), (null);

select * from sort_demo;


--sort할때 null의 위치
select * from sort_demo order by num desc;

--null을 맨 아래로
select * from sort_demo order by num desc nulls last;






