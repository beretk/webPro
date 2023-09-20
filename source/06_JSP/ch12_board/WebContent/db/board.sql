-- DROP TABLE & SEQUENCE / CREATE TABLE & SEQUENCE
DROP TABLE BOARD;
DROP SEQUENCE BOARD_SEQ;
CREATE TABLE BOARD(
    bID NUMBER(6)     PRIMARY KEY, -- 글번호
    bNAME VARCHAR2(50)   NOT NULL, -- 글번호
    bTITLE VARCHAR2(100) NOT NULL, -- 글제목
    bCONTENT VARCHAR2(1000),       -- 글본문 (VARCHAR2(4000)초과시 CLOB)
    bEMAIL VARCHAR2(50),           -- 메일주소
    bHIT   NUMBER(6) DEFAULT 0 NOT NULL, -- 글조회수
    bPW    VARCHAR2(50) NOT NULL,  -- 글 삭제시 쓸 비밀번호
    bGROUP NUMBER(6)    NOT NULL,  -- 글 그룹(원들의 경우 글번호/답변들인 경우 원글의 BGROUP로)
    bSTEP  NUMBER(3)    NOT NULL,  -- 같은 그룹내의 출력 순서(원글 0)
    bINDENT NUMBER(3)   NOT NULL,  -- 글 LIST출력시 글 제목 들여쓰기 정도(원글 0)
    bIP    VARCHAR2(20) NOT NULL,  -- 글 쓰기를 요청한 컴퓨터의 IP주소
    bDATE  DATE DEFAULT SYSDATE NOT NULL -- 글 작성 시점
);
CREATE SEQUENCE BOARD_SEQ MAXVALUE 999999 NOCACHE NOCYCLE;
SELECT * FROM BOARD;

-- DUMMY DATA
INSERT INTO BOARD (BID, BNAME, BTITLE, BCONTENT, BEMAIL, BPW, BGROUP, BSTEP, BINDENT, BIP)
    VALUES (BOARD_SEQ.NEXTVAL, '홍', '제목1', '냉무', NULL, '111', BOARD_SEQ.CURRVAL, 0, 0, '192.168.0.253');
INSERT INTO BOARD (BID, BNAME, BTITLE, BCONTENT, BEMAIL, BPW, BGROUP, BSTEP, BINDENT, BIP)
    VALUES (BOARD_SEQ.NEXTVAL, '김', '제목2', '냉무', NULL, '111', BOARD_SEQ.CURRVAL, 0, 0, '192.168.0.252');
UPDATE BOARD SET BHIT=11 WHERE BID=1; -- 조회수 조작
SELECT * FROM BOARD ORDER BY BGROUP DESC;

-- DAO에 쓸 SQL
-- 1. 글목록(글 그룹이 최신글이 위로)
SELECT * FROM BOARD ORDER BY BGROUP DESC;
-- 2. 전체 글 갯수
SELECT COUNT(*) CNT FROM BOARD;
-- 3. 원글쓰기 - 작성자, 글제목, 본문, 이메일, 비번, IP(BGROUP은 글번호, BSTEP은 0, BINDENT는 0)
INSERT INTO BOARD (BID, BNAME, BTITLE, BCONTENT, BEMAIL, BPW, BGROUP, BSTEP, BINDENT, BIP)
    VALUES (BOARD_SEQ.NEXTVAL, '김', '제목2', '냉무', 'K@K.COM', '111', BOARD_SEQ.CURRVAL, 0, 0, '192.168.0.252');
-- 4. bID로 조회수 1올리기(글상세보기시 필요)
UPDATE BOARD SET BHIT = BHIT + 1 WHERE BID=1;
-- 5. bID로 DTO가져오기(글상세보기) - 4번조회수 올리고 DTO가져오기
-- 6. bID로 DTO가져오기(글수정 FORM, 답변글쓰기 FORM) 
SELECT * FROM BOARD WHERE BID=1;
-- 7. 글수정(작성자, 글제목, 본문, 이메일, 비번, IP수정)
UPDATE BOARD
    SET BNAME = '홍길동',
        BTITLE = '바꾼제목',
        BCONTENT = '바꾼본문',
        BEMAIL = 'H@H.COM',
        BPW    = '111',
        BIP    = '127.0.0.1'
    WHERE BID = 1;
-- 8. 글삭제(비번을 맞게 입력한 경우만 삭제)
COMMIT;
DELETE FROM BOARD WHERE BID=11 AND BPW='111';
ROLLBACK;
SELECT * FROM BOARD ORDER BY BGROUP DESC;



















