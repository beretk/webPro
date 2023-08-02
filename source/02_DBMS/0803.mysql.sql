-- DCL(계정생성, 권한부여, 권한박탈, 계정삭제)
-- DDL(FK 제약조건, 시퀀스없음)
-- DML(out join, and;&&, or;||, 일부단일함수, ROWNUM이 없어 TOP-N 구문이 다름)
-- Java 시간에 쓸 데이터 넣고 연습해 보기alter
show databases; -- database 리스트

-- ★ ★ ★ DCL(계정생성, 권한부여, 권한박탈, 계정삭제)
create user scott identified by 'tiger'; -- 계정 생성
grant all on *.* to scott; -- 권한부여
flush privileges;
revoke all on *.* from scott; -- 권한박탈
drop user scott;
-- 특정 데이터 베이스로 들어감
show databases; -- 데이터 베이스들 리스트
use world; -- world 데이터 베이스로 들어감
select database(); -- 현재 들어와 있는 데이터 베이스
show tables; -- 현재 데이터 베이스안의 테이블들
create database kimdb; -- 새로운 데이터베이스 생성(kimdb)
use kimdb;
select database();
show tables; -- 오라클에서 select * from


-- ★ ★ ★ DDL  
create table emp(
	empno    numeric(4) ,
    ename    varchar(20) not null,
    nickname varchar(20) ,
    sal      numeric(7,2) ,
    comm     numeric(7,2) default 0
);
desc emp;
drop table if exists emp;
create table emp(
	empno    numeric(4) primary key,
    ename    varchar(20) not null,
    nickname varchar(20) unique,
    sal      numeric(7,2) check(sal>0),
    comm     numeric(7,2) default 0
    primary key (empno),
    unique (nickname),
    check(sal>0)
);
insert into emp values (1111, '홍길동', '동해번쩍', 900, null);
insert into emp values (1112, '홍길동', '동해번쩍', 900, null); -- 에러(unique)
select * from emp;






