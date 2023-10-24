--------------------------------------------------------------
---------------  MemberDao에 들어갈 query ---------------------
--------------------------------------------------------------
-- (1) 회원id 중복체크
SELECT * FROM MVC_MEMBER WHERE mId='aaa';
-- (2) 회원 EMAIL 중복체크
SELECT COUNT(*) CNT FROM MVC_MEMBER WHERE MEMAIL='aaa@naver.com';
-- (3) 회원가입
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('aaa','1','홍길동','aaa@naver.com','NOIMG.JPG','1998/12/12','서대문');
-- (4) 로그인
SELECT * FROM MVC_MEMBER WHERE mID='aaa' and mPW='1';
-- (5) mid로 dto가져오기(로그인 성공시 session에 넣기 위함)
SELECT * FROM MVC_MEMBER WHERE mId='aaa';
-- (6) 회원정보 수정
UPDATE MVC_MEMBER SET mPw = '1',
                    mName = 'HONG',
                    mEmail = 'aaa1@naver.com',
                    mPhoto = 'NOIMG.JPG',
                    mBirth = '1991/12/12',
                    mAddress = '서울'
        WHERE mId='aaa';
-- (7) 회원리스트(top-N구문)
SELECT * FROM (SELECT ROWNUM RN, A.* FROM 
                        (SELECT * FROM MVC_MEMBER ORDER BY mname) A)
        WHERE RN BETWEEN 1 AND 16;
-- (8) 회원수
SELECT COUNT(*) cnt FROM MVC_MEMBER;
COMMIT;
-- (9) 회원탈퇴
DELETE FROM MVC_MEMBER WHERE MID='son';
ROLLBACK;

--------------------------------------------------------------
-----------------  BoardDao에 들어갈 query --------------------
--------------------------------------------------------------
-- (1) 글목록(startRow~endRow)
SELECT F.*, MNAME FROM FILEBOARD F, MVC_MEMBER M
  WHERE F.MID=M.MID 
  ORDER BY FGROUP DESC, FSTEP; -- 출력 기준
SELECT * FROM
  (SELECT ROWNUM RN, A.* FROM (SELECT F.*, MNAME FROM FILEBOARD F, MVC_MEMBER M
                              WHERE F.MID=M.MID 
                              ORDER BY FGROUP DESC, FSTEP) A)
  WHERE RN BETWEEN 1 AND 7; -- dao에 쓸 query
-- (2) 글갯수
SELECT COUNT(*) FROM FILEBOARD;
-- (3) 글쓰기(원글쓰기)
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME, FGROUP, FSTEP, FINDENT, FIP)
  VALUES (FILEBOARD_SEQ.NEXTVAL, 'son','토트넘','난 공격수', 'a.docx', 
    FILEBOARD_SEQ.CURRVAL, 0,0, '192.168.0.31');
-- (4) hit 1회 올리기
UPDATE FILEBOARD SET FHIT = FHIT + 1 WHERE FID=1;
-- (5) 글번호(fid)로 글전체 내용(BoardDto) 가져오기
SELECT F.*, MNAME
  FROM FILEBOARD F, MVC_MEMBER M WHERE F.MID=M.MID AND FID=1;
-- (6) 글 수정하기(fid, ftitle, fcontent, ffilename, frdate(SYSDATE), fip 수정)
UPDATE FILEBOARD SET FTITLE = '바뀐제목',
                    FCONTENT = '바뀐본문',
                    fFILENAME = NULL,
                    FIP = '192.168.151.10',
                    FRDATE = SYSDATE
            WHERE FID = 2;
-- (7) 글 삭제하기
COMMIT;
-- 글 삭제시 해당 글 하나 삭제하기 (삭제하려는 글의 FID필요. 3번글 삭제)
DELETE FROM FILEBOARD WHERE FID=3;
ROLLBACK;
-- 글 삭제시 답변글까지 삭제하는 로직(지우려는 3번글의 삭제하려는 글의 FGROUP=1, FSTEP=1, FINDENT=1 필요)
SELECT * FROM FILEBOARD ORDER BY FGROUP DESC, FSTEP;
DELETE FROM FILEBOARD WHERE FGROUP = 1 AND (FSTEP>=1 AND 
    FSTEP<(SELECT NVL(MIN(FSTEP),9999) 
          FROM FILEBOARD WHERE FGROUP=1 AND FSTEP>1 AND FINDENT<=1));
UPDATE FILEBOARD SET fSTEP = fSTEP-2 WHERE fGROUP=1 AND fSTEP>2;-- 생략 가능(2은 위의 DELETE문 수행결과) : fSTEP 재조정
COMMIT;
-- (8) 답변글 쓰기 전 단계(원글의 fgroup과 같고, 원글의 fstep보다 크면 fstep을 하나 증가하기)
UPDATE FILEBOARD SET FSTEP = FSTEP + 1 WHERE FGROUP=5 AND FSTEP>0;
-- (9) 답변글 쓰기
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME, FGROUP, FSTEP, FINDENT, FIP)
  VALUES (FILEBOARD_SEQ.NEXTVAL, 'son','박지성 아님', '잘한다', null, 
    5, 1, 1, '194.161.13.11'); -- 5번글의 답변글
COMMIT;
-- (10) 회원탈퇴시 탈퇴하는 회원(mid)이 쓴 글 모두 삭제하기
DELETE FROM FILEBOARD WHERE MID='son';
ROLLBACK;


--------------------------------------------------------------
-----------------  AdminDao에 들어갈 query --------------------
--------------------------------------------------------------
-- (1) admin 로그인
SELECT * FROM ADMIN WHERE AID='admin' AND APW='1';
-- (2) 로그인 후 세션에 넣을 용도 : admin aid로 dto 가져오기
SELECT * FROM ADMIN WHERE AID='admin';