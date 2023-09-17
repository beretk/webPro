-- ex1
SELECT * FROM EMP; -- 이클립스에서 실행 : 실행할 sql을 블럭 잡고 alt+x
-- ex2
SELECT * FROM DEPT;
 -- 입력받은 파라미터 값의 직원을 출력 (10->10번부서 직원/0->모든부서직원)
SELECT * FROM EMP WHERE DEPTNO  LIKE '%'||'0';
-- ex3
SELECT * FROM DEPT;
SELECT E.*, DNAME
  FROM EMP E, DEPT D 
  WHERE E.DEPTNO=D.DEPTNO AND E.DEPTNO LIKE '%'||'10';
  
-- example
SELECT E.*, DNAME 
  FROM EMP E, DEPT D
  WHERE D.DEPTNO=E.DEPTNO AND ENAME LIKE '%'||TRIM(UPPER('  s '))||'%';







