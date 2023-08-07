-- 프로그램에 사용할 query

-- 1번과 2번 수행시 입력가능한 직업명들
SELECT JNAME FROM JOB;

-- 1번 기능. PNAME, JNAME, KOR, ENG, MAT입력받아 PERSON 테이블에 INSERT
INSERT INTO PERSON 
  VALUES (PERSON_PNO_SQ.NEXTVAL, '홍길동', (SELECT JNO FROM JOB WHERE JNAME='배우'), 99, 99, 100);
SELECT * FROM PERSON;
COMMIT;

-- 2번 기능. JNAME입력받아, RANK, PNAME(PNO), JNAME, KOR, ENG, MAT, SUM 출력
SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
  FROM PERSON P, JOB J
  WHERE P.JNO = J.JNO AND JNAME='배우'
  ORDER BY SUM DESC; -- INLINE VIEW에 들어갈 내용
SELECT ROWNUM RANK, A.*
  FROM (SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
          FROM PERSON P, JOB J
          WHERE P.JNO = J.JNO AND JNAME='배우'
          ORDER BY SUM DESC) A; -- 2번 기능에 들어갈 QUERY
          
-- 3번 기능. RANK, PNAME(PNO), JNAME, KOR, ENG, MAT, SUM 출력
SELECT ROWNUM RANK, A.*
  FROM (SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
          FROM PERSON P, JOB J
          WHERE P.JNO = J.JNO
          ORDER BY SUM DESC) A;
