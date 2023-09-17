-- [VI] Sub Query : 메인 query(SQL문) 안에 query(SQL문)가 내포
-- ★ 1. 서브 쿼리 개념
    -- 서브쿼리가 필요한 ex. 급여를 제일 많이 받는 사람의 모든 정보
    SELECT MAX(SAL) FROM EMP; -- 서브쿼리
    SELECT * FROM EMP WHERE SAL = (SELECT MAX(SAL) FROM EMP); -- 메인쿼리

    -- 서브쿼리의 종류(1) 단일행 서브쿼리(서브쿼리의 실행결과가 단일행) : = > >= < <= !=
        -- ex. SCOTT과 동일한 부서에서 근무하는 사원의 이름, 급여
        SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'; -- 단일행 서브쿼리
        SELECT ENAME, SAL
            FROM EMP
            WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT')
            AND ENAME <> 'SCOTT'; -- 메인쿼리
    -- 서브쿼리의 종류(2) 다중행 서브쿼리(서브쿼리의 실행결과가 2행이상) : IN, > ALL, > ANY(SOME), EXISTS
        -- ex. SCOTT이나 KING과 동일한 부서에서 근무하는 사원의 이름, 급여
        SELECT DEPTNO FROM EMP WHERE ENAME IN('SCOTT','KING'); -- 다중행 서브쿼리 10,20
        SELECT ENAME, SAL
            FROM EMP
            WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME IN('SCOTT','KING')); -- 메인쿼리

-- ★ 2. 단일행 서브쿼리
    -- ex1. SCOTT과 동일한 근무지에서 근무하는 사원의 모든 정보
        -- 데이터 추가(DALLAS 50번부터, 50번부서에 근무하는 홍길동 사원)
        INSERT INTO DEPT VALUES (50, 'IT', 'DALLAS');
        INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES (8000, '홍길동', 50); 
        SELECT * FROM DEPT;
        SELECT * FROM EMP;
    SELECT LOC
        FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO AND ENAME='SCOTT'; -- 서브쿼리
    SELECT E.*, DNAME, LOC
        FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO AND LOC=(SELECT LOC
                                            FROM EMP E, DEPT D
                                            WHERE E.DEPTNO=D.DEPTNO AND ENAME='SCOTT')
                                AND ENAME <> 'SCOTT'; -- 메인쿼리
        ROLLBACK; -- DML(추가, 삭제, 수정, 검색) 명령어 취소
    -- ex2. 최초입사직원이름과 최초입사일  
    SELECT MIN(HIREDATE) FROM EMP; -- 서브쿼리(최초입사일)
    SELECT ENAME, HIREDATE FROM EMP WHERE HIREDATE=(SELECT MIN(HIREDATE) FROM EMP); -- 메인쿼리
    -- ex3. 최근입사직원의 이름과 최근 입사일
    SELECT MAX(HIREDATE) FROM EMP; -- 서브쿼리(최근입사일)
    SELECT ENAME, HIREDATE FROM EMP WHERE HIREDATE=(SELECT MAX(HIREDATE) FROM EMP); -- 메인쿼리
    -- ex4. 최초입사직원이름과 최초입사일, 최근입사직원의 이름과 최근 입사일 (ex2 + ex3)
    SELECT E1.ENAME, E1.HIREDATE, E2.ENAME, E2.HIREDATE
        FROM EMP E1, EMP E2
        WHERE E1.HIREDATE = (SELECT MIN(HIREDATE) FROM EMP) AND
              E2.HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);
    
    SELECT
        (SELECT ENAME FROM EMP WHERE HIREDATE=(SELECT MIN(HIREDATE) FROM EMP)) 최초입사자,
        (SELECT MIN(HIREDATE) FROM EMP) 최초입사일,
        (SELECT ENAME FROM EMP WHERE HIREDATE=(SELECT MAX(HIREDATE) FROM EMP)) 최근입사자,
        (SELECT MAX(HIREDATE) FROM EMP) 최근입사일
    FROM DUAL;
    -- ex5. SCOTT과 같은 부서에 근무하는 사람들의 급여합
    SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'; -- 서브쿼리
    SELECT SUM(SAL) FROM EMP 
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'); -- 메인쿼리
    -- ex6. SCOTT과 동일한 JOB을 가진 사원의 모든 필드(정보)
    SELECT JOB FROM EMP WHERE ENAME='SCOTT'; -- 서브쿼리
    SELECT * FROM EMP WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME='SCOTT');
    -- ex7. DALLAS에 근무하는 사원의 이름과 부서번호 (서브쿼리, EQUI-JOIN)
    SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS'; -- 단일행 서브쿼리
    SELECT ENAME, DEPTNO FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS'); -- 메인쿼리
    SELECT ENAME, D.DEPTNO
        FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO AND LOC = 'DALLAS'; -- JOIN 이용
    -- ex8. 'KING'이 직속상사인 사원의 이름과 급여
    SELECT EMPNO FROM EMP WHERE ENAME='KING'; -- 서브쿼리
    SELECT ENAME, SAL FROM EMP WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME='KING');
    SELECT W.ENAME, W.SAL  
        FROM EMP W, EMP M
        WHERE W.MGR = M.EMPNO AND M.ENAME = 'KING'; -- SELF-JOIN이용
    -- ex9. 평균급여 이하로 받는 사원의 이름과 급여를 출력
    SELECT ENAME, SAL
        FROM EMP
        WHERE SAL<= (SELECT AVG(SAL) FROM EMP);
    -- ex10. 평균급여 이하로 받는 사원의 이름, 급여, 평균급여(소수점에서 반올림)를 출력
    SELECT ENAME, SAL, ROUND((SELECT AVG(SAL) FROM EMP)) AVG
        FROM EMP
        WHERE SAL<= (SELECT AVG(SAL) FROM EMP);
    -- ex11. 평균급여 이하로 받는 사원의 이름, 급여, 평균급여와의 차이(소수점에서 반올림)를 출력
    SELECT ENAME, SAL, ROUND((SELECT AVG(SAL) FROM EMP)-SAL) "DIFF"
        FROM EMP
        WHERE SAL <= (SELECT AVG(SAL) FROM EMP);
    -- 단일행 다중열 서브쿼리
    -- 'SCOTT'의 JOB과 부서번호가 같은 직원의 모든 필드 직원
    SELECT JOB, DEPTNO FROM EMP WHERE ENAME='SCOTT'; -- 다중열 서브쿼리
    SELECT * FROM EMP 
        WHERE(JOB, DEPTNO) = (SELECT JOB, DEPTNO FROM EMP WHERE ENAME='SCOTT')
        AND ENAME <> 'SCOTT'; -- 메인쿼리

-- ★ 3. 다중행 서브쿼리 : IN, ALL, ANY(=SOME), EXISTS
-- (1) IN : 서브쿼리의 결과 중  하나라도 일치하면 참
    -- ex. 부서별 입사일이 가장 늦은 사람의 이름, 입사일, 부서번호
    SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO; -- 다중행 다중열 서브쿼리
    SELECT ENAME, HIREDATE, DEPTNO
        FROM EMP
        WHERE(DEPTNO, HIREDATE) IN (SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO); -- 메인쿼리
    -- ex. 급여가 3000이상 받는 사원이 소속된 부서 사원들의 모든 필드
    SELECT DEPTNO FROM EMP WHERE SAL>=3000; --다중행 서브쿼리(20,10,20)
    SELECT * FROM EMP WHERE DEPTNO IN(SELECT DEPTNO FROM EMP WHERE SAL>=3000); -- 메인쿼리
-- (2) ALL : 서브쿼리 결과가 모두 만족하면 참
    -- ex. 30번 부서직원 모든 급여보다 큰 직원의 모든 필드
    SELECT  SAL FROM EMP WHERE DEPTNO=30; -- 950, 1250,1500, 1600, 2850
    SELECT * FROM EMP 
        WHERE SAL > ALL (SELECT  SAL FROM EMP WHERE DEPTNO=30); -- 다중행 서브쿼리 이용
        -- = 30번 부서에서의 최대 급여보다 많이 받는 직원의 모든 필드
    SELECT * FROM EMP 
        WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE DEPTNO=30); -- 단일행 서브쿼리 이용

-- (3) ANY(=SOME) : 서브쿼리 결과가 하나이상 만족하면 참
    -- 30번 부서 직원 한명만이라도 급여가 큰 직원의 모든 필드
    SELECT SAL FROM EMP WHERE DEPTNO=30; -- 서브쿼리 결과 : 950, 1250,1500, 1600, 2850
    SELECT * FROM EMP
        WHERE SAL > ANY (SELECT SAL FROM EMP WHERE DEPTNO=30); -- 다중행 서브쿼리 이용
    -- = 30번 부서에서의 최소 급여보다 많이 받은 직원의 모든 필드
    SELECT * FROM EMP
        WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO=30); -- 메인쿼리 : 단일행 서브쿼리

-- (4) EXISTS : 서브쿼리 결과가 존재하면 참
    -- ex. 직속부하가 있는 직원들의 사번, 이름, 급여
    SELECT EMPNO, ENAME, SAL
        FROM EMP MANAGER
        WHERE EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO=MGR); --서브쿼리 이용
    SELECT DISTINCT M.EMPNO, M.ENAME, M.SAL
        FROM EMP W, EMP M
        WHERE W.MGR=M.EMPNO; -- SELF JOIN 이용
    -- ex. 직속부하가 없는 직원들의 사번, 이름, 급여
    SELECT EMPNO, ENAME, SAL
        FROM EMP M
        WHERE NOT EXISTS (SELECT * FROM EMP WHERE M.EMPNO=MGR); -- 서브쿼리 이용
    SELECT M.EMPNO, M.ENAME, M.SAL
        FROM EMP W, EMP M
        WHERE W.MGR(+)=M.EMPNO AND W.ENAME IS NULL;
        
-- 탄탄1. 부서별로 가장 급여를 많이 받는 사원의 모든 정보를 출력(IN 연산자 이용)
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; -- 서브쿼리
SELECT E.*, DNAME, LOC 
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND
    SAL BETWEEN LOSAL AND HISAL AND
    (E.DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO)
    ORDER BY E.DEPTNO;
    
-- 탄탄2. 직급(JOB)이 MANAGER인 사람의 속한 부서의 부서 번호와 부서명과 지역을 출력(IN)
SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER';
SELECT * FROM DEPT 
    WHERE DEPTNO IN(SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER');  

-- 탄탄3. 급여가 3000이상인 사람들 중 연봉 등급을 나누어서 해당 등급별 최고 급여를 받는 사람들의 사번, 이름, 직업, 입사일, 급여, 급여등급을 출력
SELECT EMPNO FROM EMP WHERE SAL>=3000;
SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL AND
    EMPNO IN(SELECT EMPNO FROM EMP WHERE SAL >=3000);
SELECT GRADE, MAX(SAL) 
    FROM EMP, SALGRADE 
    WHERE SAL BETWEEN LOSAL AND HISAL AND SAL>=3000 
    GROUP BY GRADE; -- 서브쿼리
SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL AND
    (GRADE, SAL) IN (SELECT GRADE, MAX(SAL) 
                    FROM EMP, SALGRADE 
                    WHERE SAL BETWEEN LOSAL AND HISAL AND SAL>=3000 
                    GROUP BY GRADE);

-- 탄탄4. 응용심화 : 입사일 분기별로 가장 높은 월급을 받는 사람들의 분기, 사번, 이름, JOB, 상사사번, 입사일, 급여, 상여를 출력하세요
SELECT HIREDATE, CEIL(EXTRACT(MONTH FROM HIREDATE)/3)"QUARTER" FROM EMP; -- 분기
SELECT HIREDATE, TO_CHAR(HIREDATE,'Q') QUARTER FROM EMP;
SELECT TO_CHAR(HIREDATE, 'Q'), MAX(SAL)
    FROM EMP 
    GROUP BY TO_CHAR(HIREDATE, 'Q'); -- 서브쿼리
SELECT TO_CHAR(HIREDATE, 'Q') QUARTER, EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM
    FROM EMP
    WHERE (TO_CHAR(HIREDATE, 'Q'),SAL) IN (SELECT TO_CHAR(HIREDATE, 'Q'), MAX(SAL)
                                            FROM EMP 
                                            GROUP BY TO_CHAR(HIREDATE, 'Q')); -- 메인쿼리
                                            
-- 탄탄5. 급여가 3000미만인 사람 중에 가장 최근에 입사한 사람의 사원번호와 이름, 급여, 입사일을 출력
SELECT EMPNO, ENAME, SAL, HIREDATE
    FROM EMP
    WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP WHERE SAL<3000);

-- 탄탄6. SALESMAN 모든 사원들 보다 급여를 많이 받는 사원들의 이름과 급여와 직급(담당 업무)를 출력하되 영업 사원은 출력하지 않는다.(ALL이용)
SELECT ENAME, SAL, JOB
    FROM EMP
    WHERE SAL > ALL(SELECT SAL FROM EMP WHERE JOB='SALESMAN');
SELECT ENAME, SAL, JOB
    FROM EMP
    WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE JOB='SALESMAN');    

-- 탄탄7. SALESMAN 일부 어떤 한 사원보다 급여를 많이 받는 사원들의 이름과 급여와 직급(담당 업무)를 출력하되 영업 사원도 출력(ANY)
SELECT ENAME, SAL, JOB
    FROM EMP
    WHERE SAL > ANY(SELECT SAL FROM EMP WHERE JOB='SALESMAN');
SELECT ENAME, SAL, JOB
    FROM EMP
    WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE JOB='SALESMAN');


-- ★★★<총 연습문제>★★★--
-- 1 ~13 : 단일행 서브쿼리

--1. 사원테이블에서 가장 먼저 입사한 사람의 이름, 급여, 입사일
SELECT MIN(HIREDATE) FROM EMP;
SELECT ENAME, SAL, HIREDATE 
    FROM EMP
    WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);

-- 2. 회사에서 가장 급여가 적은 사람의 이름, 급여
SELECT MIN(SAL) FROM EMP;
SELECT ENAME, SAL
    FROM EMP
    WHERE SAL = (SELECT MIN(SAL) FROM EMP);

-- 3. 회사 평균보다 급여를 많이 받는 사람의 이름, 급여, 부서코드
SELECT AVG(SAL) FROM EMP;
SELECT ENAME, SAL, DEPTNO
    FROM EMP
    WHERE SAL > (SELECT AVG(SAL) FROM EMP);

--4. 회사 평균 이하의 급여를 받는 사람의 이름, 급여, 부서명
SELECT AVG(SAL) FROM EMP;
SELECT ENAME, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND 
    SAL <= (SELECT AVG(SAL) FROM EMP);
    
--5. SCOTT보다 먼저 입사한 사람의 이름, 급여, 입사일, 급여 등급
SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT';
SELECT ENAME, SAL, HIREDATE, GRADE
    FROM EMP,SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL AND
    HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT');

--6. 5번(SCOTT보다 먼저 입사한 사람의 이름, 급여, 입사일, 급여 등급)에 부서명 추가하고 급여가 큰 순 정렬
SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT';
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME
    FROM EMP E, SALGRADE, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND
    HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT')
    ORDER BY SAL DESC;
    
--7. BLAKE 보다 급여가 많은 사원들의 사번, 이름, 급여
SELECT SAL FROM EMP WHERE ENAME = 'BLAKE';
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME = 'BLAKE');
    
--8. MILLER보다 늦게 입사한 사원의 사번, 이름, 입사일
SELECT HIREDATE FROM EMP WHERE ENAME='MILLER';
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE HIREDATE > (SELECT HIREDATE FROM EMP WHERE ENAME='MILLER');
    
--9. 사원전체 평균 급여보다 급여가 많은 사원들의 사번, 이름, 급여
SELECT AVG(SAL) FROM EMP;
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL > (SELECT AVG(SAL) FROM EMP);

--10. CLARK와 같은 부서번호이며, 사번이 7698인 직원의 급여보다 많은 급여를 받는 사원의 사번, 이름, 급여
SELECT DEPTNO FROM EMP WHERE ENAME='CLARK'; -- 서브쿼리(CLARK으 부서번호)
SELECT SAL FROM EMP WHERE EMPNO=7698; -- 서브쿼리( 7698사번 직원의 급여)
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME='CLARK') AND 
    SAL > (SELECT SAL FROM EMP WHERE EMPNO=7698);

--11.  응용심화. CLARK와 같은 부서명이며, 사번이 7698인 직원의 급여보다 많은 급여를 받는 사원의 사번, 이름, 급여
SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='CLARK'; -- 서브쿼리(부서명)
SELECT SAL FROM EMP WHERE EMPNO=7698; -- 서브쿼리(7698사번 직원의 급여)
SELECT EMPNO, ENAME, SAL
    FROM EMP E, DEPT D
    WHERE DNAME = (SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='CLARK') AND
    SAL > (SELECT SAL FROM EMP WHERE EMPNO=7698);

--12. BLAKE와 같은 부서에 있는 모든 사원의 이름과 입사일자
SELECT DEPTNO FROM EMP WHERE ENAME = 'BLAKE';
SELECT ENAME, HIREDATE
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'BLAKE');
    
--13. 평균 급여 이상을 받는 모든 종업원에 대해서 사원번호와 이름 단 급여가 많은 순으로 출력)
SELECT AVG(SAL) FROM EMP;
SELECT EMPNO, ENAME
    FROM EMP
    WHERE SAL >= (SELECT AVG(SAL) FROM EMP)
    ORDER BY SAL DESC;

-- 14~26 : 다중행서브쿼리, 단일행 23번은 같이
-- 여기서부터는 다중행서브쿼리와 단일행서브쿼리, 이전은 단일행서브쿼리

-- 14.  이름에 “T”가 있는 사원이 근무하는 부서에서 근무하는 모든 직원의 사원 번호,이름,급여(단 사번 순 출력)
SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%';
SELECT EMPNO, ENAME, SAL
    FROM EMP  
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%')
    ORDER BY EMPNO;

-- 15. 부서 위치가 Dallas인 모든 종업원에 대해 이름,업무,급여
SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS';
SELECT ENAME, JOB, SAL
    FROM EMP 
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');

-- 16. EMP 테이블에서 King에게 보고하는 모든 사원의 이름과 급여
SELECT EMPNO FROM EMP WHERE ENAME = 'King';
SELECT ENAME, SAL
    FROM EMP
    WHERE MGR = (SELECT EMPNO FROM EMP WHERE INITCAP(ENAME) = 'King');

-- 17. SALES부서 사원의 이름, 업무
SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES';
SELECT ENAME, JOB
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND D.DNAME='SALES';
    
-- 18. 월급이 부서 30의 최저 월급보다 높은 사원의 모든 필드
SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 30;
SELECT * FROM EMP
    WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 30);

-- 19.  FORD와 업무도 월급도 같은 사원의 모든 필드
SELECT JOB FROM EMP WHERE ENAME = 'FORD';
SELECT SAL FROM EMP WHERE ENAME = 'FORD';
SELECT * FROM EMP
    WHERE JOB IN (SELECT JOB FROM EMP WHERE ENAME = 'FORD') AND
    SAL IN (SELECT SAL FROM EMP WHERE ENAME = 'FORD') AND ENAME <> 'FORD';
    
-- 20. 이름이 JONES인 직원의 JOB과 같거나 FORD의 SAL 이상을 받는 사원의 정보를 이름, 업무, 부서번호, 급여
    -- 단, 업무별 알파벳 순, 월급이 많은 순으로 출력
SELECT JOB FROM EMP WHERE ENAME = 'JONES';
SELECT SAL FROM EMP WHERE ENAME = 'FORD';
SELECT ENAME, JOB, DEPTNO, SAL
    FROM EMP
    WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'JONES') OR
    SAL >= (SELECT SAL FROM EMP WHERE ENAME = 'FORD')
    ORDER BY JOB, SAL DESC;
  
-- 21. SCOTT 또는 WARD와 월급이 같은 사원의 정보를 이름,업무,급여
SELECT SAL FROM EMP WHERE ENAME = 'SCOTT' OR ENAME = 'WARD';
SELECT ENAME, JOB, SAL
    FROM EMP
    WHERE SAL IN (SELECT SAL FROM EMP WHERE ENAME = 'SCOTT' OR ENAME = 'WARD') AND
    ENAME NOT IN('SCOTT','WARD');
    
-- 22. CHICAGO에서 근무하는 사원과 같은 업무를 하는 사원들의 이름,업무
SELECT DNAME FROM DEPT WHERE LOC = 'CHICAGO';
SELECT ENAME, JOB
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO  AND
    DNAME IN(SELECT DNAME FROM DEPT WHERE LOC = 'CHICAGO');

-- 23. 부서 평균 월급보다 월급이 높은 사원을 사번, 이름, 급여, 부서번호
SELECT EMPNO, ENAME, SAL, DEPTNO
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO);
    -- 사번, 이름, 급여, 부서번호, 해당부서의 평균급여
    SELECT EMPNO, ENAME, SAL, DEPTNO, ROUND((SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO)) DEPTAVG
        FROM EMP E
        WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO);
        
-- 24. 업무별로 평균 월급보다 적은 월급을 받는 사원을 부서번호, 이름, 급여
SELECT AVG(SAL) FROM EMP;
SELECT E.EMPNO, ENAME, SAL, D.DEPTNO
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND 
    SAL < (SELECT AVG(SAL) FROM EMP);
    
-- 25. 적어도 한 명 이상으로부터 보고를 받을 수 있는 사원을 업무, 이름, 사번, 부서번호를 출력(단, 부서번호 순으로 오름차순 정렬)
SELECT JOB, ENAME, EMPNO, DEPTNO
    FROM EMP M
    WHERE EXISTS (SELECT * FROM EMP WHERE MGR=M.EMPNO);

-- 26.  말단 사원의 사번, 이름, 업무, 부서번호
SELECT EMPNO,ENAME,JOB, DEPTNO 
    FROM EMP M
    WHERE NOT EXISTS (SELECT * FROM EMP WHERE MGR = M.EMPNO);

