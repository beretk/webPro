DROP TABLE ORDER_DETAIL;
DROP TABLE ORDERS;
DROP TABLE MEMBER;
DROP TABLE PRODUCT;
DROP TABLE CART;

CREATE TABLE MEMBER(
    mID   VARCHAR2(20) PRIMARY KEY,
    mNAME VARCHAR2(50) NOT NULL,
    mADDR VARCHAR2(255),
    mTEL  VARCHAR2(30),
    mMAIL VARCHAR2(30) NOT NULL
);
SELECT * FROM MEMBER;


CREATE TABLE PRODUCT(
    pCODE  VARCHAR2(5) PRIMARY KEY,
    pNAME  VARCHAR2(50),
    PRICE  NUMBER(6) NOT NULL CHECK(PRICE>0),
    pSTOCK NUMBER(3) NOT NULL CHECK(pSTOCK>=0)   
);
SELECT * FROM PRODUCT;

DROP SEQUENCE CART_SEQ;
CREATE SEQUENCE CART_SEQ MAXVALUE 999999999 NOCACHE;
CREATE TABLE CART(
    cNO   NUMBER(9) PRIMARY KEY,
    mID   VARCHAR2(20) REFERENCES MEMBER(mID) NOT NULL,
    pCODE VARCHAR2(5) REFERENCES PRODUCT(pCODE) NOT NULL,
    QTY   NUMBER(3) CHECK(QTY>0) NOT NULL,
    COST  NUMBER(9) 
);
SELECT * FROM CART;

DROP SEQUENCE ORDERS_SEQ;
CREATE SEQUENCE ORDERS_SEQ MAXVALUE 999999999 NOCACHE;
CREATE TABLE ORDERS(
    oNO   VARCHAR2(9) PRIMARY KEY,
    mID   VARCHAR2(20) REFERENCES MEMBER(mID) NOT NULL,
    oNAME VARCHAR2(50) NOT NULL,
    oADDR VARCHAR2(255) NOT NULL,
    oTEL  VARCHAR2(30) NOT NULL,
    oDATE DATE DEFAULT SYSDATE
);
SELECT * FROM ORDERS;

DROP SEQUENCE ORDER_DETAIL_SEQ;
CREATE SEQUENCE ORDER_DETAIL_SEQ;
CREATE TABLE ORDER_DETAIL(
    odNO  NUMBER(9) PRIMARY KEY,
    oNO   VARCHAR2(9) REFERENCES ORDERS(oNO) NOT NULL,
    pCODE VARCHAR2(5) REFERENCES PRODUCT(pCODE) NOT NULL,
    QTY   NUMBER(3) CHECK(QTY>0) NOT NULL,
    COST  NUMBER(9)     
);
SELECT * FROM ORDER_DETAIL;

INSERT INTO MEMBER VALUES('abc', 'ȫ 浿', '        빮  ', '010-9999-9999', 'hong@hong.com');
INSERT INTO MEMBER VALUES('def', '  浿', '  ⵵       ', '010-8888-8888', 'kim@kim.com');
SELECT * FROM MEMBER;

INSERT INTO PRODUCT VALUES('A1', '    ', 3000, 100);
INSERT INTO PRODUCT VALUES('B1', '    ', 3000, 100);
INSERT INTO PRODUCT VALUES('C1', ' ҵ   ',7000, 100);
INSERT INTO PRODUCT VALUES('A2', '    ũ', 200, 100);
INSERT INTO PRODUCT VALUES('B2', '  ¡  ', 5000, 100);
SELECT * FROM PRODUCT;

--  ֹ   ȣ      ϱ      ('230728' || ' 001 => '2307280001')
SELECT TO_CHAR(SYSDATE, 'RRMMDD') || TRIM(TO_CHAR(ORDERS_SEQ.NEXTVAL, '000')) oNO FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'RRMMDD') || SUBSTR(TO_CHAR(ORDERS_SEQ.NEXTVAL, '000'), 2, 3) oNO FROM DUAL;

--      ù  ° ȫ 浿    ֹ   (23.07.26)     
-- 1. ȫ 浿(abc)     ٱ            
INSERT INTO CART VALUES (CART_SEQ.NEXTVAL, 'abc', 'A1', 3, (SELECT PRICE FROM PRODUCT WHERE PCODE='A1')*3);
INSERT INTO CART VALUES (CART_SEQ.NEXTVAL, 'abc', 'B1', 1, (SELECT PRICE FROM PRODUCT WHERE PCODE='B1')*1);
SELECT * FROM CART;

-- 2. ȫ 浿(abc)    ֹ  ϱ 
    -- 2-1. ORDERS( ֹ )   ̺ 
    INSERT INTO ORDERS( ONO, MID, ONAME, OADDR, OTEL)
        VALUES(TO_CHAR(SYSDATE, 'RRMMDD') || TRIM(TO_CHAR(ORDERS_SEQ.NEXTVAL, '000')), 'abc', 'ȫ 浿', '        빮  ',
            '010-9999-9999');
    SELECT * FROM ORDERS;
    -- 2-2. ORDER_DETAIL( ֹ   )    ̺ (  ٱ  Ͽ               ѹ     ֹ       )
         ֹ       ̺   INSERT       ʿ                 
    SELECT 
      ORDER_DETAIL_SEQ.NEXTVAL odNO,
      TO_CHAR(SYSDATE, 'RRMMDD')||TRIM(TO_CHAR(ORDERS_SEQ.CURRVAL, '000')) ONO, PCODE, QTY, COST
    FROM CART WHERE MID='abc'; --  ֹ       ̺   insert       ʿ            
  DROP SEQUENCE ORDER_DETAIL_SEQ; --                                 
  CREATE SEQUENCE ORDER_DETAIL_SEQ MAXVALUE 999999999 NOCYCLE NOCACHE;
  INSERT INTO ORDER_DETAIL (odNO, oNO, pCODE, QTY, COST)
    SELECT 
      ORDER_DETAIL_SEQ.NEXTVAL odNO,
      TO_CHAR(SYSDATE, 'RRMMDD')||TRIM(TO_CHAR(ORDERS_SEQ.CURRVAL, '000')) ONO,PCODE, QTY, COST
    FROM CART WHERE MID='abc';
  SELECT * FROM ORDER_DETAIL; -- ORDERS    ̺   ORDER_DETAIL   ̺   ϼ 




