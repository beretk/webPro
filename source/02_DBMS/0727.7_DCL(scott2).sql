SELECT * FROM TAB;
SELECT * FROM USER_TABLES; -- 현계정이 소유한 테이블
SELECT * FROM ALL_TABLES
    WHERE TABLE_NAME='EMP'; -- 현계정이 사용가능한 테이블
SELECT * FROM SCOTT.EMP;
SELECT * FROM SCOTT.DEPT;
SELECT *
    FROM SCOTT.EMP E, SCOTT.DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
    
    -- 권한 박탈후
    SELECT * FROM SCOTT.EMP; -- 에러
    SELECT * FROM SCOTT.DEPT; -- 에러