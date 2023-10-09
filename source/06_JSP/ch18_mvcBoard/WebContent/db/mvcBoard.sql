-- table 및 sequence 제거
DROP TABLE MVC_BOARD;
DROP SEQUENCE MVC_BOARD_SEQ;

-- table 및 sequence 생성
CREATE TABLE MVC_BOARD(
    bID     NUMBER(6) PRIMARY KEY,         -- 글번호
    bNAME   VARCHAR2(50) NOT NULL,         -- 작성자
    bTITLE  VARCHAR2(100) NOT NULL,        -- 글제목
    bCONTENT VARCHAR2(1000),               -- 글본문
    bDATE   DATE DEFAULT SYSDATE NOT NULL, -- 작성시점
    bHIT    NUMBER(6) DEFAULT 0,           -- 조회수
    bGROUP  NUMBER(6) NOT NULL,            -- 글그룹
    bSTEP   NUMBER(2) NOT NULL,            -- 그룹내 출력순서
    bINDENT NUMBER(3) NOT NULL,            -- 들여쓰기
    bIP     VARCHAR2(50) NOT NULL          --IP
);
CREATE SEQUENCE MVC_BOARD_SEQ MAXVALUE 999999 NOCACHE NOCYCLE;

-- dummy data(3개이상 - 2개 원글 + 1개 답변글)
INSERT INTO MVC_BOARD(bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP)
    VALUES(MVC_BOARD_SEQ.NEXTVAL, '김', '제목1', '내용1', MVC_BOARD_SEQ.CURRVAL, 0, 0, '192.168.0.255');
INSERT INTO MVC_BOARD(bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP)
    VALUES(MVC_BOARD_SEQ.NEXTVAL, '이', '제목2', '내용2', MVC_BOARD_SEQ.CURRVAL, 0, 0, '192.168.0.254');
INSERT INTO MVC_BOARD(bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP)
    VALUES(MVC_BOARD_SEQ.NEXTVAL, '신', '제목2-1(글3)', NULL, 2, 1, 1, '192.168.0.255');

-- dao에 들어갈 query
-- 1.글목록(startRow부터 endRow)
SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC;
SELECT ROWNUM RN, A.*
    FROM(SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC,BSTEP) A;-- TOP-N구문 전단계
SELECT  *
    FROM(SELECT ROWNUM RN, A.*
        FROM(SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC,BSTEP) A)
    WHERE RN BETWEEN 2 AND 3;

-- 2.글갯수
SELECT COUNT(*) CNT FROM MVC_BOARD;

-- 3.원글쓰기(사용자로부터 입력받은 bname,btitle,bcontent,bip,bgroup은 글번호,bstep과 bindent는 0)
INSERT INTO MVC_BOARD(bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP)
    VALUES(MVC_BOARD_SEQ.NEXTVAL, '박', '제목3', NULL, MVC_BOARD_SEQ.CURRVAL, 0, 0, '192.168.1.253');
    
-- 4.bid로 조회수 1 올리기
UPDATE MVC_BOARD SET BHIT = BHIT + 1 WHERE BID=3;

-- 5.bid로 dto 가져오기
SELECT * FROM MVC_BOARD WHERE BID=3;

-- 6.글수정(특정 bid의 bname,btitle,bcontent,bip 수정)
UPDATE MVC_BOARD 
    SET
        BNAME = '최길순',
        BTITLE = '제목2-1(글3)수정',
        BCONTENT = '본문수정',
        BIP = '192.168.0.251'
    WHERE BID = 3;
COMMIT;

-- 7.글삭제(특정 bid삭제)
DELETE FROM MVC_BOARD WHERE BID=1;
ROLLBACK;

-- 8.답변글 저장 전단계(엑셀 ⓐ단계 ):3번글의 답변글을 달기 위해 3번글 정보 필요
SELECT * FROM MVC_BOARD WHERE BID=3;
UPDATE MVC_BOARD SET BSTEP = BSTEP+1 WHERE BGROUP=2 AND BSTEP >1;

-- 9.답변글 저장(원글의 bgroup=2, bstep=1, bindent=1)
INSERT INTO MVC_BOARD (BID, bNAME, bTITLE, BCONTENT, BGROUP, bSTEP, BINDENT, BIP)
  VALUES (MVC_BOARD_SEQ.NEXTVAL, '송', '제목3의 답', '', 2, 2, 2, '192.1.1.1');
COMMIT;
SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP; -- 확인






