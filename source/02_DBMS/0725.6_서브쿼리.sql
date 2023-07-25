-- [VI] Sub Query : ���� query(SQL��) �ȿ� query(SQL��)�� ����
-- �� 1. ���� ���� ����
    -- ���������� �ʿ��� ex. �޿��� ���� ���� �޴� ����� ��� ����
    SELECT MAX(SAL) FROM EMP; -- ��������
    SELECT * FROM EMP WHERE SAL = (SELECT MAX(SAL) FROM EMP); -- ��������

    -- ���������� ����(1) ������ ��������(���������� �������� ������) : = > >= < <= !=
        ex. SCOTT�� ������ �μ����� �ٹ��ϴ� ����� �̸�, �޿�
        SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'; -- ������ ��������
        SELECT ENAME, SAL
            FROM EMP
            WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT')
            AND ENAME <> 'SCOTT'; -- ��������
    -- ���������� ����(2) ������ ��������(���������� �������� 2���̻�) : IN, > ALL, > ANY(SOME), EXISTS
        -- ex. SCOTT�̳� KING�� ������ �μ����� �ٹ��ϴ� ����� �̸�, �޿�
        SELECT DEPTNO FROM EMP WHERE ENAME IN('SCOTT','KING'); -- ������ �������� 10,20
        SELECT ENAME, SAL
            FROM EMP
            WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME IN('SCOTT','KING')); -- ��������

-- �� 2. ������ ��������
    -- ex1. SCOTT�� ������ �ٹ������� �ٹ��ϴ� ����� ��� ����
        -- ������ �߰�(DALLAS 50������, 50���μ��� �ٹ��ϴ� ȫ�浿 ���)
        INSERT INTO DEPT VALUES (50, 'IT', 'DALLAS');
        INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES (8000, 'ȫ�浿', 50); 
        SELECT * FROM DEPT;
        SELECT * FROM EMP;
    SELECT LOC
        FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO AND ENAME='SCOTT'; -- ��������
    SELECT E.*, DNAME, LOC
        FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO AND LOC=(SELECT LOC
                                            FROM EMP E, DEPT D
                                            WHERE E.DEPTNO=D.DEPTNO AND ENAME='SCOTT')
                                AND ENAME <> 'SCOTT'; -- ��������
        ROLLBACK; -- DML(�߰�, ����, ����, �˻�) ��ɾ� ���
    -- ex2. �����Ի������̸��� �����Ի���  
    SELECT MIN(HIREDATE) FROM EMP; -- ��������(�����Ի���)
    SELECT ENAME, HIREDATE FROM EMP WHERE HIREDATE=(SELECT MIN(HIREDATE) FROM EMP); -- ��������
    -- ex3. �ֱ��Ի������� �̸��� �ֱ� �Ի���
    SELECT MAX(HIREDATE) FROM EMP; -- ��������(�ֱ��Ի���)
    SELECT ENAME, HIREDATE FROM EMP WHERE HIREDATE=(SELECT MAX(HIREDATE) FROM EMP); -- ��������
    -- ex4. �����Ի������̸��� �����Ի���, �ֱ��Ի������� �̸��� �ֱ� �Ի��� (ex2 + ex3)
    SELECT E1.ENAME, E1.HIREDATE, E2.ENAME, E2.HIREDATE
        FROM EMP E1, EMP E2
        WHERE E1.HIREDATE = (SELECT MIN(HIREDATE) FROM EMP) AND
              E2.HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);
    
    SELECT
        (SELECT ENAME FROM EMP WHERE HIREDATE=(SELECT MIN(HIREDATE) FROM EMP)) �����Ի���,
        (SELECT MIN(HIREDATE) FROM EMP) �����Ի���,
        (SELECT ENAME FROM EMP WHERE HIREDATE=(SELECT MAX(HIREDATE) FROM EMP)) �ֱ��Ի���,
        (SELECT MAX(HIREDATE) FROM EMP) �ֱ��Ի���
    FROM DUAL;
    -- ex5. SCOTT�� ���� �μ��� �ٹ��ϴ� ������� �޿���
    SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'; -- ��������
    SELECT SUM(SAL) FROM EMP 
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'); -- ��������
    -- ex6. SCOTT�� ������ JOB�� ���� ����� ��� �ʵ�(����)
    SELECT JOB FROM EMP WHERE ENAME='SCOTT'; -- ��������
    SELECT * FROM EMP WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME='SCOTT');
    -- ex7. DALLAS�� �ٹ��ϴ� ����� �̸��� �μ���ȣ (��������, EQUI-JOIN)
    SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS'; -- ������ ��������
    SELECT ENAME, DEPTNO FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS'); -- ��������
    SELECT ENAME, D.DEPTNO
        FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO AND LOC = 'DALLAS'; -- JOIN �̿�
    -- ex8. 'KING'�� ���ӻ���� ����� �̸��� �޿�
    SELECT EMPNO FROM EMP WHERE ENAME='KING'; -- ��������
    SELECT ENAME, SAL FROM EMP WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME='KING');
    SELECT W.ENAME, W.SAL  
        FROM EMP W, EMP M
        WHERE W.MGR = M.EMPNO AND M.ENAME = 'KING'; -- SELF-JOIN�̿�
    -- ex9. ��ձ޿� ���Ϸ� �޴� ����� �̸��� �޿��� ���
    SELECT ENAME, SAL
        FROM EMP
        WHERE SAL<= (SELECT AVG(SAL) FROM EMP);
    -- ex10. ��ձ޿� ���Ϸ� �޴� ����� �̸�, �޿�, ��ձ޿�(�Ҽ������� �ݿø�)�� ���
    SELECT ENAME, SAL, ROUND((SELECT AVG(SAL) FROM EMP)) AVG
        FROM EMP
        WHERE SAL<= (SELECT AVG(SAL) FROM EMP);
    -- ex11. ��ձ޿� ���Ϸ� �޴� ����� �̸�, �޿�, ��ձ޿����� ����(�Ҽ������� �ݿø�)�� ���
    SELECT ENAME, SAL, ROUND((SELECT AVG(SAL) FROM EMP)-SAL) "DIFF"
        FROM EMP
        WHERE SAL <= (SELECT AVG(SAL) FROM EMP);
    -- ������ ���߿� ��������
    -- 'SCOTT'�� JOB�� �μ���ȣ�� ���� ������ ��� �ʵ� ����
    SELECT JOB, DEPTNO FROM EMP WHERE ENAME='SCOTT'; -- ���߿� ��������
    SELECT * FROM EMP 
        WHERE(JOB, DEPTNO) = (SELECT JOB, DEPTNO FROM EMP WHERE ENAME='SCOTT')
        AND ENAME <> 'SCOTT'; -- ��������

-- �� 3. ������ �������� : IN, ALL, ANY(=SOME), EXISTS
-- (1) IN : ���������� ��� ��  �ϳ���� ��ġ�ϸ� ��
    -- ex. �μ��� �Ի����� ���� ���� ����� �̸�, �Ի���, �μ���ȣ
    SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO; -- ������ ���߿� ��������
    SELECT ENAME, HIREDATE, DEPTNO
        FROM EMP
        WHERE(DEPTNO, HIREDATE) IN (SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO); -- ��������
    -- ex. �޿��� 3000�̻� �޴� ����� �Ҽӵ� �μ� ������� ��� �ʵ�
    SELECT DEPTNO FROM EMP WHERE SAL>=3000; --������ ��������(20,10,20)
    SELECT * FROM EMP WHERE DEPTNO IN(SELECT DEPTNO FROM EMP WHERE SAL>=3000); -- ��������








-- �ڡڡ�<�� ��������>�ڡڡ�--
-- 1 ~13 : ������ ��������

--1. ������̺��� ���� ���� �Ի��� ����� �̸�, �޿�, �Ի���
SELECT MIN(HIREDATE) FROM EMP;
SELECT ENAME, SAL, HIREDATE 
    FROM EMP
    WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);

-- 2. ȸ�翡�� ���� �޿��� ���� ����� �̸�, �޿�
SELECT MIN(SAL) FROM EMP;
SELECT ENAME, SAL
    FROM EMP
    WHERE SAL = (SELECT MIN(SAL) FROM EMP);

-- 3. ȸ�� ��պ��� �޿��� ���� �޴� ����� �̸�, �޿�, �μ��ڵ�
SELECT AVG(SAL) FROM EMP;
SELECT ENAME, SAL, DEPTNO
    FROM EMP
    WHERE SAL > (SELECT AVG(SAL) FROM EMP);

--4. ȸ�� ��� ������ �޿��� �޴� ����� �̸�, �޿�, �μ���
SELECT AVG(SAL) FROM EMP;
SELECT ENAME, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND 
    SAL <= (SELECT AVG(SAL) FROM EMP);
    
--5. SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���
SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT';
SELECT ENAME, SAL, HIREDATE, GRADE
    FROM EMP,SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL AND
    HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT');

--6. 5��(SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���)�� �μ��� �߰��ϰ� �޿��� ū �� ����
SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT';
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME
    FROM EMP E, SALGRADE, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND
    HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT')
    ORDER BY SAL DESC;
    
--7. BLAKE ���� �޿��� ���� ������� ���, �̸�, �޿�
SELECT SAL FROM EMP WHERE ENAME = 'BLAKE';
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME = 'BLAKE');
    
--8. MILLER���� �ʰ� �Ի��� ����� ���, �̸�, �Ի���
SELECT HIREDATE FROM EMP WHERE ENAME='MILLER';
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE HIREDATE > (SELECT HIREDATE FROM EMP WHERE ENAME='MILLER');
    
--9. �����ü ��� �޿����� �޿��� ���� ������� ���, �̸�, �޿�
SELECT AVG(SAL) FROM EMP;
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL > (SELECT AVG(SAL) FROM EMP);

--10. CLARK�� ���� �μ���ȣ�̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ����� ���, �̸�, �޿�
SELECT DEPTNO FROM EMP WHERE ENAME='CLARK'; -- ��������(CLARK�� �μ���ȣ)
SELECT SAL FROM EMP WHERE EMPNO=7698; -- ��������( 7698��� ������ �޿�)
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME='CLARK') AND 
    SAL > (SELECT SAL FROM EMP WHERE EMPNO=7698);

--11.  �����ȭ. CLARK�� ���� �μ����̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ����� ���, �̸�, �޿�
SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='CLARK'; -- ��������(�μ���)
SELECT SAL FROM EMP WHERE EMPNO=7698; -- ��������(7698��� ������ �޿�)
SELECT EMPNO, ENAME, SAL
    FROM EMP E, DEPT D
    WHERE DNAME = (SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='CLARK') AND
    SAL > (SELECT SAL FROM EMP WHERE EMPNO=7698);

--12. BLAKE�� ���� �μ��� �ִ� ��� ����� �̸��� �Ի�����
SELECT DEPTNO FROM EMP WHERE ENAME = 'BLAKE';
SELECT ENAME, HIREDATE
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'BLAKE');
    
--13. ��� �޿� �̻��� �޴� ��� �������� ���ؼ� �����ȣ�� �̸� �� �޿��� ���� ������ ���)
SELECT AVG(SAL) FROM EMP;
SELECT EMPNO, ENAME
    FROM EMP
    WHERE SAL >= (SELECT AVG(SAL) FROM EMP)
    ORDER BY SAL DESC;

-- 14~26 : �����༭������, ������ 23���� ����

































