-- Dept.xml의 id=deptList (DeptDao.java X)
SELECT * FROM DEPT;


-- Emp.xml의 id=empList
SELECT * FROM EMP WHERE 1=1
    AND ENAME LIKE '%' || 'A' || '%' 
    AND JOB LIKE '%' || 'M' || '%' 
    AND DEPTNO=10;