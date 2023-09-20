-- CustomerDao에 들어갈 Query

-- 1. 회원가입시 ID 중복체크 : public int confirmID(String id)
SELECT COUNT(*) FROM CUSTOMER WHERE CID='aaa';

-- 2. 회원가입 INSERT : public int joinCustomer(CustomerDto dto)
INSERT INTO CUSTOMER(CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CBIRTH, CGENDER)
    VALUES ('aaa','111','신길동','010-9999-9999','hong@hong.com','서울','1999-12-25','m');

-- 3. 로그인 : public int loginCheck(String cid, String cpw)
SELECT * FROM CUSTOMER WHERE CID='aaa' AND CPW='111';

-- 4. cid로 DTO가져오기 : public CustomerDto getCustomer(String cid)
SELECT * FROM CUSTOMER WHERE CID='aaa';

-- 5. 정보수정 : public int modifyCustomer(CustomerDto dto)
UPDATE CUSTOMER 
    SET CPW = '111',
        CNAME = '신길동',
        CTEL = '010-5555-5555',
        CEMAIL = 'shin@shin.com',
        CADDRESS = '경기',
        CBIRTH = '2020-03-14',
        CGENDER = 'm'
    WHERE CID = 'aaa';
COMMIT;



