-- BooKDao 들어갈 QUERY
-- 1. 책등록
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, 'HTML5',2000,'114.jpg','noImg.png','좋다 ',10);
-- 2. 책목록(PAGING 없이)
SELECT * FROM BOOK ORDER BY BRDATE DESC;
-- 2. 책목록(PAGING처리 : TOP-N)
SELECT ROWNUM RN, A.*
  FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A; -- TOP-N구문의 INLINE VIEW에 들어갈 QUERY
SELECT *
  FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A)
  WHERE RN BETWEEN 7 AND 12; -- DAO에 들어갈 QUERY
-- 3. 등록된 책 갯수
SELECT COUNT(*) CNT FROM BOOK;
-- 4. 책상세보기(BID로 DTO가져오기)
SELECT * FROM BOOK WHERE BID=1;

-- CustomerDao에 들어갈 query
-- 1. 회원가입시 id 중복체크 : public int confirmId(String cid)
SELECT COUNT(*) FROM CUSTOMER WHERE CID='aaa';
-- SELECT * FROM CUSTOMER WHERE CID='aaa';
-- 2. 회원가입 : public int joinCustmer(CustomerDto dto)
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CBIRTH, CGENDER)
  VALUES ('aaa', '111', '홍길동', '010-9999-9999', 'h@h.com', '서울', '1995-12-12', 'm');
-- 3. 로그인 : public int loginCheck(String cid, String cpw)
SELECT * FROM CUSTOMER WHERE CID='aaa' AND CPW='111';

-- 4. cid로 DTO 가져오기 : public CustomerDto getCustomer(String cid)
SELECT * FROM CUSTOMER WHERE CID='aaa';

-- 5. 정보수정 : public int modifyCustomer(CustomerDto dto)
UPDATE CUSTOMER SET CPW = '111',
                CNAME='마길순',
                CTEL = '02-111-1111',
                CEMAIL='m@h.com',
                CADDRESS='제주도',
                CBIRTH = '1999-12-12',
                CGENDER = 'f'
          WHERE CID='aaa';
-- 6. 회원리스트 public ArrayList<CustomerDto> listCustomer(startRow, endRow) : cid순으로 TOP-N
SELECT * 
  FROM (SELECT ROWNUM RN, CID, CPW, CNAME, CEMAIL, CADDRESS  
      FROM (SELECT * FROM CUSTOMER ORDER BY CID)) 
  WHERE RN BETWEEN 3 AND 5;

-- 7. 가입한 회원수 public int getCustomerTotalCnt()
SELECT COUNT(*) CNT FROM CUSTOMER;

-- FileBoardDao에 들어갈 query
-- 1. 글목록(startRow ~ endRow까지 fileBoard 리스트)
SELECT F.*, CNAME, CEMAIL 
  FROM FILEBOARD F, CUSTOMER C 
  WHERE F.CID = C.CID
  ORDER BY fGROUP DESC, fSTEP; -- 출력 기준
SELECT ROWNUM RN, A.* 
  FROM (SELECT * FROM FILEBOARD ORDER BY fGROUP DESC, fSTEP) A; -- TOP-N구문 전단계
SELECT *
  FROM (SELECT ROWNUM RN, A.* 
        FROM (SELECT * FROM FILEBOARD ORDER BY fGROUP DESC, fSTEP) A )
  WHERE RN BETWEEN 2 AND 3; -- TOP-N구문 (DAO에 들어갈 QUERY)

-- 2. 전체 글 갯수
SELECT COUNT(*) CNT FROM FILEBOARD;

-- 3. 글쓰기 : cid(글쓴이id), 글제목, 본문, 첨부파일, 비번, ip (fgroup은 글번호, fstep과 findent는 0)
INSERT INTO FILEBOARD (FID, cID, fTITLE, fCONTENT, FILENAME, fPW, 
                fGROUP, fSTEP, fINDENT, fIP)
        VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa', '글3','냉무', null, '111',
                FILEBOARD_SEQ.CURRVAL, 0,0, '192.168.0.31');

-- 4. fid로 조회수 1올리기
UPDATE FILEBOARD SET FHIT = FHIT + 1 WHERE FID=1;

-- 5. fid로 dto가져오기
SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C 
  WHERE F.CID = C.CID AND FID=1
  ORDER BY fGROUP DESC, fSTEP;

-- 6. 글수정 : 글제목, 본문, 첨부파일, 비번, ip 수정
UPDATE FILEBOARD
  SET 
      FTITLE = '바꾼제목',
      FCONTENT = '바꾼본문',
      FILENAME = NULL,
      FPW    = '111',
      FIP    = '127.0.0.1'
  WHERE FID=1;

-- 7. 글삭제(fid, fpw)
COMMIT;
DELETE FROM FILEBOARD WHERE FID=1 AND FPW='111';
ROLLBACK;

-- 8. 답변글 쓰기 전단계(엑셀 a단계)
UPDATE FILEBOARD SET FSTEP = FSTEP+1 WHERE FGROUP=1 AND FSTEP>0;
-- 9. 답변글 쓰기
INSERT INTO FILEBOARD (fID, cID, fTITLE, fCONTENT, FILENAME, fPW, 
                fGROUP, fSTEP, fINDENT, fIP)
        VALUES (FILEBOARD_SEQ.NEXTVAL, 'ccc', '글1-1','냉무',null,'111',
                1, 1, 1, '192.168.0.31');
COMMIT;


