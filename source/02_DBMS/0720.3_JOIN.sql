-- [III] JOIN : 2개 이상의 테이블을 연결하여 데이터를 검색하는 방법
SELECT * FROM EMP WHERE ENAME = 'SCOTT'; -- 1행
SELECT * FROM DEPT; -- 4행
-- CROSS JOIN(FROM 절에 테이블을 2개이상)
SELECT * FROM EMP,DEPT WHERE ENAME='SCOTT'; -- 1*4 = 4행
SELECT * FROM EMP,DEPT; --EMP의 14*DEPT의 4 = 56행

-- 1. EQUI JOIN(동등 조인) : 공통필드(DEPTNO)의 값이 일치되는 조건만 JOIN
SELECT * FROM EMP, DEPT 
    WHERE EMP.DEPTNO=DEPT.DEPTNO AND ENAME='SCOTT';
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPT.DEPTNO, DNAME, LOC
    FROM EMP, DEPT 
    WHERE EMP.DEPTNO=DEPT.DEPTNO;
SELECT EMPNO "NO", ENAME, JOB, MGR, HIREDATE, SAL, COMM, E.DEPTNO, DNAME,LOC
    FROM EMP E,DEPT D -- 테이블의 별칭이 있을경우 원테이블 명을 사용할 수 없고 별칭을 사용
    WHERE E.DEPTNO = D.DEPTNO
    ORDER BY EMPNO;
    -- ex. 급여가 2000이상인 직원만 이름,직책,급여 부서명,근무지,부서번호 출력
    SELECT ENAME, JOB, SAL, DNAME, LOC, E.DEPTNO
        FROM EMP E, DEPT D
        WHERE E.DEPTNO = D.DEPTNO AND SAL>=2000;
    -- ex. 20번 부서의 직원만 이름,부서번호, 근무지 출력
    SELECT ENAME, E.DEPTNO, LOC
        FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO AND E.DEPTNO=20;
    -- ex. 근무지(LOC)가 CHICAGO인 사람의 이름,업무,급여,부서번호를 출력
    SELECT ENAME, JOB, SAL, D.DEPTNO
        FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO AND LOC='CHICAGO';
    -- ex. 부서번호가 10이거나 20인 사원의 이름, 업무, 근무지(급여순)
    SELECT ENAME, JOB, LOC
        FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO AND E.DEPTNO IN(10,20) 
        ORDER BY SAL;
    -- ex. JOB이 SALEAMAN이거나 MANAGER인 사원의 이름, 급여, 상여, 연봉=(SAL+COMM)*12,부서명,근무지(연봉이 큰순)
    SELECT ENAME, SAL, COMM, (SAL+NVL(COMM,0))*12 ANNUAL, DNAME, LOC
        FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO AND JOB IN('SALESMAN','MANAGER')
        ORDER BY ANNUAL DESC;
    -- ex. COMM이 NULL이고 SAL이 1200이상인 사원의 이름, 급여, 입사일, 부서번호, 부서명(부서명 순, 급여 큰 순 정렬)
    SELECT ENAME, SAL, HIREDATE,E.DEPTNO, DNAME
        FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO AND COMM IS NOT NULL AND SAL>=1200
        ORDER BY DNAME, SAL DESC;
        
­- 탄탄1	뉴욕에서 근무하는 사원의 이름과 급여를 출력하시오
SELECT ENAME, SAL, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND LOC='NEW YORK';
­- 탄탄2	ACCOUNTING 부서 소속 사원의 이름과 입사일을 출력하시오
SELECT ENAME, HIREDATE, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND DNAME='ACCOUNTING';
­- 탄탄3	직급이 MANAGER인 사원의 이름, 부서명을 출력하시오
SELECT ENAME, DNAME, JOB
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND JOB='MANAGER';
­- 탄탄4	Comm이 null이 아닌 사원의 이름, 급여, 부서코드, 근무지를 출력하시오.
SELECT ENAME, SAL, D.DEPTNO
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND COMM IS NOT NULL;
    
-- ★ 2. NON-EQUI JOIN
SELECT * FROM EMP WHERE ENAME = 'SCOTT'; -- SAL이 3000
SELECT * FROM SALGRADE; --급여 등급 정보(하한 과 상한은 절대 겹치면 안됨)
SELECT * FROM EMP, SALGRADE
    WHERE ENAME='SCOTT'; --CROSS JOIN(EMP의 1행*SALGRADE의 5행 =5행)
SELECT * FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL AND ENAME='SCOTT';
    -- ex. 모든 사원의 사번, 이름, 직책, 상사사번, 급여, 급여등급(1등급, 2등급,...)
    SELECT EMPNO, ENAME, JOB, MGR, SAL, GRADE||'등급' GRADE
        FROM EMP, SALGRADE
        WHERE SAL BETWEEN LOSAL AND HISAL;
    SELECT EMPNO, ENAME, JOB, MGR, SAL, GRADE||'등급' GRADE
        FROM EMP, SALGRADE
        WHERE SAL >=LOSAL AND SAL<+HISAL; 

--탄탄1. Comm이 null이 아닌 사원의 이름, 급여, 등급, 부서번호, 부서이름, 근무지를 출력하시오.
SELECT ENAME, SAL, GRADE, D.DEPTNO, DNAME, LOC 
    FROM EMP E, DEPT D, SALGRADE --14* 4*15개
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND COMM IS NOT NULL;

-- ★ 3.

-- ★ 4.

--<시험 연습문제>
--  PART2 (1~7)
--1. 모든 사원에 대한 이름, 부서번호, 부서명을 출력하는 SELECT 문장을 작성하여라.
SELECT ENAME, D.DEPTNO, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO ;
--2. NEW YORK에서 근무하고 있는 사원에 대하여 이름, 업무, 급여, 부서명을 출력
SELECT ENAME, JOB, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND LOC='NEW YORK';
--3. 보너스를 받는 사원에 대하여 이름,부서명,위치를 출력
SELECT ENAME,DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND COMM>0;
--4. 이름 중 L자가 있는 사원에 대하여 이름,업무,부서명,위치를 출력
SELECT ENAME, JOB, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND ENAME LIKE '%L%';
--5. 사번, 사원명, 부서코드, 부서명을 검색하라. 사원명기준으로 오름차순정열
SELECT EMPNO,ENAME, D.DEPTNO, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO 
    ORDER BY ENAME ;
--6. 사번, 사원명, 급여, 부서명을 검색하라. 
    --단 급여가 2000이상인 사원에 대하여 급여를 기준으로 내림차순으로 정열하시오
SELECT EMPNO, ENAME, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND SAL>=2000
    ORDER BY SAL DESC;
--7. 사번, 사원명, 업무, 급여, 부서명을 검색하시오. 단 업무가 MANAGER이며 급여가 2500이상인
-- 사원에 대하여 사번을 기준으로 오름차순으로 정열하시오.
SELECT EMPNO, ENAME, JOB, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND JOB='MANAGER' AND SAL>=2500
    ORDER BY EMPNO ;
        













