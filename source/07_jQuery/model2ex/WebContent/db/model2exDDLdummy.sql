DROP TABLE FILEBOARD;
DROP SEQUENCE FILEBOARD_SEQ;
DROP TABLE MVC_MEMBER;
DROP TABLE ADMIN CASCADE CONSTRAINTS;
----------------------------------------------------------------------
--                    MVC_MEMBER    테이블 생성                      --
----------------------------------------------------------------------
CREATE TABLE MVC_MEMBER(
    mID VARCHAR2(30) PRIMARY KEY,
    mPW VARCHAR2(30) NOT NULL,
    mNAME VARCHAR2(30) NOT NULL,
    mEMAIL VARCHAR2(30) UNIQUE,
    mPHOTO VARCHAR2(30) NOT NULL, -- 회원가입시 사진업로드를 안 할시 기본 이미지로(NOIMG.JPG)
    mBIRTH DATE,
    mADDRESS VARCHAR2(300),
    mRDATE DATE DEFAULT SYSDATE NOT NULL    
);

-- DUMMY DATA
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('gayun','1','김가연','gayun@naver.com','gayun.jpg','1972/09/09','광주광역시');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('gico','1','지코','gico@naver.com','gico.jpg','1992/09/14','서울시');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('go','1','고소영','go@naver.com','go.jpg','1972/10/06','서울시');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('han','1','한지민','han@naver.com','han.jpg','1982/11/05','서울시');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('jang','1','장동건',null,'jang.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('jo','1','조현우',null,'jo.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('kang','1','강동원',null,'kang.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('kim','1','김태희',null,'kim.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('lee','1','이선빈',null,'lee.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('lim','1','임요한',null,'lim.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('park','1','박보검',null,'park.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('rain','1','비',null,'rain.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('sgy','1','송가연',null,'songkayeon.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('son','1','손흥민',null,'son.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('song','1','송중기',null,'song.jpg',null,null);
SELECT * FROM MVC_MEMBER ORDER BY mRDATE DESC;

----------------------------------------------------------------------
--                   FILEBOARD 테이블 생성                           --
----------------------------------------------------------------------
CREATE TABLE FILEBOARD(
    fID     NUMBER(6) PRIMARY KEY,         -- 글번호
    mID     VARCHAR2(30) REFERENCES MVC_MEMBER(MID) NOT NULL, -- 아이디
    fTITLE  VARCHAR2(100) NOT NULL,         -- 글제목
    fCONTENT VARCHAR2(4000),               -- 글본문
    fFILENAME VARCHAR2(100),
    fRDATE   DATE DEFAULT SYSDATE NOT NULL, -- 글 작성시점
    fHIT    NUMBER(6) DEFAULT 0,           -- 글 조회수
    fGROUP  NUMBER(6) NOT NULL,            -- 글그룹(원글의 경우 글번호로/답변글일경우 원글의 BGROUP로)
    fSTEP   NUMBER(2) NOT NULL,            -- 글그룹내 출력 순서(원글 0)
    fINDENT NUMBER(3) NOT NULL,            -- 글 LIST 출력시 글 제목 들여쓰기 정도(원글0)
    fIP     VARCHAR2(50) NOT NULL          -- 글 쓴 컴퓨터의 IP    
);

CREATE SEQUENCE FILEBOARD_SEQ MAXVALUE 999999 NOCACHE NOCYCLE;
SELECT * FROM FILEBOARD ORDER BY FGROUP DESC, FSTEP;

-- dummy data (3개 이상 - 2개원글+1개답변글)
-- 더미데이터 원글쓰기 (글1)
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME, FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'go','글1','content',null, FILEBOARD_SEQ.CURRVAL, 0, 0, '192.168.20.31'); -- 첫번째 글1
SELECT * FROM FILEBOARD ORDER BY FGROUP DESC, FSTEP;

-- 더미데이터 답변글쓰기 (위의 "글1"에 대한 첫번째 답변글)
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME, FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'gico','글1-1(글1의 첫답변)','content', null, 1, 1, 1, '192.168.20.31');
SELECT * FROM FILEBOARD ORDER BY FGROUP DESC, FSTEP;

-- 더미데이터 답변글쓰기 (위의 "글1"에 대한 두번째 답변글)
UPDATE FILEBOARD SET FSTEP = FSTEP+1 
    WHERE FGROUP = 1 AND FSTEP>0;
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME, FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'gico','글1-2(글1의 첫답변)','content', null, 1, 1, 1, '192.168.20.31');
SELECT * FROM FILEBOARD ORDER BY FGROUP DESC, FSTEP;

-- 더미데이터 답변글쓰기(위의 "글1-2"에 대한 첫번째 답변글)
--    답변글 추가전 STEP a 수행
UPDATE FILEBOARD SET FSTEP = FSTEP+1 
    WHERE FGROUP = 1 AND FSTEP>1;
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME, FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'gayun','글1-1-1','content', null, 1, 2, 2, '192.168.10.151');
SELECT * FROM FILEBOARD ORDER BY FGROUP DESC, FSTEP;
-- 더미데이터 원글 쓰기(글4)
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME, FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'go','글4','content','a.docx', FILEBOARD_SEQ.CURRVAL, 0, 0, '192.168.20.31'); -- 원글4 쓰기
SELECT * FROM FILEBOARD ORDER BY FGROUP DESC, FSTEP;
  
UPDATE MVC_BOARD SET BHIT=11 WHERE BID=3;
----------------------------------------------------------------------
--                   ADMIN TABLE    테이블 생성                      -- 
----------------------------------------------------------------------
CREATE TABLE ADMIN(
    aID VARCHAR2(30) PRIMARY KEY,
    aPW VARCHAR2(30) NOT NULL,
    aNAME VARCHAR2(30) NOT NULL
);
INSERT INTO ADMIN VALUES('admin', '1', '관리자');
COMMIT;
------------------------------------------------
--                 확인용                      -- 
------------------------------------------------
SELECT * FROM MVC_MEMBER ORDER BY mRDATE DESC;
SELECT * FROM FILEBOARD ORDER BY FGROUP DESC, FSTEP;
SELECT * FROM ADMIN;


