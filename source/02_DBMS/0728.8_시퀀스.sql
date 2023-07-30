-- [VIII] Sequence : 순차번호 생성기. 대분분 인위적인 PK 사용 용도
DROP SEQUENCE FRIEND_SEQ;
CREATE SEQUENCE FRIEND_SEQ
  START WITH 1  -- 1부터 시작(기본값)
  INCREMENT BY 1 -- 1씩 증가(기본값)
  MAXVALUE  9999  -- 최대값
  MINVALUE  1     -- 최소값(기본값)
  NOCACHE
  NOCYCLE;
SELECT FRIEND_SEQ.NEXTVAL FROM DUAL; -- 다음 순차번호 생성  
SELECT FRIEND_SEQ.CURRVAL FROM DUAL; -- 시퀀스의 현재 값
DROP SEQUENCE FRIEND_SEQ;
CREATE SEQUENCE FRIEND_SEQ MAXVALUE 99999 NOCACHE NOCYCLE;
DROP TABLE FRIEND;
CREATE TABLE FRIEND (
  NO NUMBER(5) PRIMARY KEY, -- 시퀀스를 사용해서 값이 들어갈 필드
  NAME VARCHAR2(30) NOT NULL,
  TEL  VARCHAR2(20) UNIQUE, -- NULL 허용, NULL이 아니면 유일한 값
  ADDRESS VARCHAR2(255),
  LAST_MODIFY DATE DEFAULT SYSDATE
);
INSERT INTO FRIEND (NO, NAME, TEL, ADDRESS) 
  VALUES (FRIEND_SEQ.NEXTVAL, '홍길동', NULL, '서울 서대문'); -- 몇번 실행 
SELECT * FROM FRIEND;
--INSERT INTO FRIEND (NO, NAME, TEL, ADDRESS)
--  VALUES (FRIEND_SEQ.NEXTVAL, NULL, '010-9999-9999','서울 마포'); -- 에러(NOT NULL)
INSERT INTO FRIEND (NO, NAME, TEL, ADDRESS)
  VALUES (FRIEND_SEQ.NEXTVAL, '홍길동', '010-9999-9999','서울 마포');  
INSERT INTO FRIEND (NO, NAME, TEL, ADDRESS)
  VALUES (FRIEND_SEQ.NEXTVAL, '신길동', '010-9999-9999','서울 영등포'); -- 에러(UNIQUE)
INSERT INTO FRIEND (NO, NAME, TEL, ADDRESS)
  VALUES (FRIEND_SEQ.NEXTVAL, '신길동', '010-8888-9999','서울 영등포');
SELECT * FROM FRIEND;

-- ex. 초기값 101부터 최대값 999,999까지 1씩 증가하는 TEST_SEQ 시퀀스를 생서하고 시퀀스를 사용하시오
CREATE SEQUENCE TEST_SEQ 
    START WITH 101
    MAXVALUE 999999
    NOCACHE
    NOCYCLE;
SELECT TEST_SEQ.CURRVAL FROM DUAL; -- 시퀀스 사용전에는 현재값을 조회할 수 없음
SELECT TEST_SEQ.NEXTVAL FROM DUAL; --시퀀스 사용

-- ex. 시퀀스 NO_SEQ 초기값 1부터 999까지 1씩 증가하는 사용 :
    -- SYSDATE의 'RRMMDD' 추출 => '230728' || 시퀀스 생성수(3) -> '003'=> '230728001'
DROP SEQUENCE NO_SEQ;
CREATE SEQUENCE NO_SEQ MAXVALUE 999 NOCACHE NOCYCLE;
SELECT TO_CHAR(SYSDATE, 'RRMMDD')FROM DUAL;













