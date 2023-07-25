-- [V] �׷��Լ� : SUM, AVG, MIN, MAX, COUNT, STDDEV(ǥ������), VARIANCE(�л�)
SELECT MAX(SAL) FROM EMP; -- ���̺� ��ü�� �ִ밪
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; -- �׷캰 �ִ밪
-- �ִ�޿��� �޴� ����� �̸��� �޿� -> VI.��������
SELECT ENAME, SAL FROM EMP WHERE SAL = (SELECT MAX(SAL) FROM EMP);

-- 1. �׷��Լ��� �ǽ� / ��� - 2* ǥ������ / ��� +2 *ǥ������
SELECT ROUND(AVG(SAL),2) FROM EMP;
SELECT AVG(SAL), SUM(SAL)/COUNT(SAL) FROM EMP;
SELECT SUM(COMM) FROM EMP; -- ��� : 2200/14 = 157.142857~ 2200/4 = 550
SELECT SUM(COMM), COUNT(COMM), AVG(COMM) FROM EMP; -- ��� �׷��Լ��� NULL���� �����ϰ� ����
SELECT COUNT(*) FROM EMP; -- EMP ���̺��� ���
    -- ex. SAL�� ���, ��, �ּҰ�, �ִ밪, �л�, ǥ������, ����(�Ҽ��� ���ڸ����� �ݿø�)
    SELECT ROUND(AVG(SAL),1),SUM(SAL), MIN(SAL), MAX(SAL), 
        ROUND(VARIANCE(SAL),1), ROUND(STDDEV(SAL),1)
        FROM EMP;
    -- �׷��Լ� MIN, MAX, COUNT�� ������, ������, ��¥�� ��� ����
    SELECT MIN(ENAME), MIN(HIREDATE) FROM EMP;
    
    -- źź ������
    -- źźex1. �Ի����� ���� ������ ����� �Ի��ϰ� ���� �ֱٿ� �Ի��� ����� �Ի����� ���. 
    SELECT MIN(HIREDATE)FIRST, MAX(HIREDATE)LAST FROM EMP;  
    SELECT MIN(HIREDATE)FIRST, MAX(HIREDATE)LAST FROM EMP;
    -- źźex2. (���) 80/12/17:155590��° 83/01/12:14803��°
        --  (hint : TRUNC, MIN, ||)
        -- ex. EMP���� �̸�, �Ի���, �ٹ��ϼ�
    SELECT TRUNC(SYSDATE-MIN(HIREDATE))||':��°', TRUNC(SYSDATE-MAX(HIREDATE))||':��°'FROM EMP;
    SELECT MIN(HIREDATE) || ':' || TRUNC(SYSDATE-MIN(HIREDATE)) || '��°' FIRST,
            MAX(HIREDATE) || ':' || TRUNC(SYSDATE-MAX(HIREDATE)) ||'��°' LAST
            FROM EMP;
     
    -- źźex3.  (���) 80��12��17�� �����Ի�:15,558��° 83��01��12�� �ֱ��Ի� :14,803��°
       --  (hint :TRUNC, MIN, ||, TO_CHAR, TRIM)
    SELECT TO_CHAR(MIN(HIREDATE), 'RR"��"MM"��"DD" �����Ի�:"') ||
        TRIM(TO_CHAR( TRUNC(SYSDATE - MIN(HIREDATE)), '99,999')) || '��°'  FIRST,
        TO_CHAR(MAX(HIREDATE), 'RR"��"MM"��"DD"�� �ֱ��Ի�:"') ||
        TRIM(TO_CHAR( TRUNC(SYSDATE - MAX(HIREDATE)), '99,999')) || '��°' LAST
        FROM EMP;
    SELECT TO_CHAR(MIN(HIREDATE), 'RR"��"MM"��"DD"�� �����Ի�:"') ||
        TRIM(TO_CHAR( TRUNC(SYSDATE - MIN(HIREDATE)), '99,999')) || '��°'  FIRST,
        TO_CHAR(MAX(HIREDATE), 'RR"��"MM"��"DD"�� �ֱ��Ի�:"') ||
        TRIM(TO_CHAR( TRUNC(SYSDATE - MAX(HIREDATE)), '99,999')) || '��°' LAST
        FROM EMP;
     
    -- źźex4. 10�� �μ� �Ҽ��� ��� �߿��� Ŀ�̼��� �޴� ����� ���� ���� ���ÿ�.
    SELECT COUNT(COMM) FROM EMP WHERE DEPTNO=10;
    
-- �� 2. GROUP BY��
    -- ex. �μ���ȣ�� �ִ�޿�, ��ձ޿�(�μ���ȣ �� ����)
    SELECT DEPTNO, MAX(SAL), AVG(SAL) FROM EMP GROUP BY DEPTNO ORDER BY DEPTNO;
        -- �� GROUP BY�������� �ʵ��� ��Ī�� ������ �ݵ�� �ʵ� �̸� ���(ORDER BY�������� �ʵ��� ��Ī ��밡��)
    SELECT DEPTNO �μ�, MAX(SAL) MAX, AVG(SAL) AVG
        FROM EMP
        GROUP BY DEPTNO
        ORDER BY MAX(SAL); --Alias�� ��밡��
    -- ex. �μ��� �ִ�޿�, ��ձ޿�( �μ�������� ����)
    SELECT DNAME, MAX(SAL), AVG(SAL)
        FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO 
        GROUP BY DNAME
        ORDER BY DNAME;
    -- ex. SAL�� 5000�̸��� ����� ���ؼ��� �μ���ȣ��, �����, �ִ�޿�, �ּұ޿�, ��ձ޿�(�μ���ȣ �� ����)
    SELECT DEPTNO, COUNT(*), MAX(SAL),MIN(SAL), AVG(SAL)    -- (3)
        FROM EMP        -- (1)
        WHERE SAL<5000  -- (2)
        GROUP BY DEPTNO -- (3)
        ORDER BY DEPTNO; -- (4)
        
-- �� 3. HAVING�� : �׷��Լ��� ����� ������ ��(�ʵ��� ������ ����Ͽ� ����� ������ ���� WHERE��)
    -- ex. �μ���ȣ�� ��ձ޿�(��ձ޿��� 2000 �̻��� �μ��� ���)
    SELECT DEPTNO, AVG(SAL)
    FROM EMP       
    GROUP BY DEPTNO
    HAVING AVG(SAL) >= 2000;
    -- ex. SAL�� 5000�̸��� ����� ���� �μ��� �ּұ޿�, ��ձ޿�(�Ҽ��� 2�ڸ����� �ݿø�), �ִ�޿�
        --(��, ��ձ޿��� 1800�̻��� �μ��� ���� ��ձ޿� ������ ����)
    SELECT DNAME, MIN(SAL), ROUND(AVG(SAL),2), MAX(SAL)
        FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO AND SAL < 5000
        GROUP BY DNAME
        HAVING AVG(SAL) >= 1800
        ORDER BY AVG(SAL);

-- �� 4. �׷��Լ� ����� ���谪 ���� : ROLLUP���
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO);
SELECT NVL(TO_CHAR(DEPTNO),'��')DEPTNO, SUM(SAL)SUMSAL FROM EMP GROUP BY ROLLUP(DEPTNO);
SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY DEPTNO, JOB ORDER BY DEPTNO, JOB;
SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO, JOB); -- ROLLUP�� �ϸ� ORDER BY�� �ڵ����� ����

-- �ڡڡ�<�� ��������>
-- 1. �ο���,�ִ� �޿�,�ּ� �޿�,�޿��� ���� ���
SELECT COUNT(*), MAX(SAL), MIN(SAL), SUM(SAL)
    FROM EMP;
    
-- 2. ������ �ο����� ���Ͽ� ���
SELECT JOB, COUNT(*)
    FROM EMP
    GROUP BY JOB;
    
--- 3. �ְ� �޿��� �ּ� �޿��� ���̴� ���ΰ� ���
SELECT MAX(SAL)- MIN(SAL) FROM EMP;

-- 4. �� �μ����� �ο���, �޿� ���, ���� �޿�, �ְ� �޿�, �޿��� ���� ���(�޿��� ���� ���� ������)
SELECT DEPTNO, ROUND(AVG(SAL), 2), MIN(SAL), MAX(SAL), SUM(SAL)
    FROM EMP
    GROUP BY DEPTNO
    ORDER BY SUM(SAL) DESC;
SELECT DNAME, COUNT(*), AVG(SAL), MIN(SAL), MAX(SAL), SUM(SAL)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO 
    GROUP BY DNAME
    ORDER BY SUM(SAL) DESC;
    
-- 5. �μ���, ������ �׷��Ͽ� ����� �μ���ȣ, ����, �ο���, �޿��� ���, �޿��� ���� ���(�μ���ȣ, ���������� �������� ����)
SELECT DEPTNO, JOB, COUNT(*), ROUND(AVG(SAL), 2), SUM(SAL)
    FROM EMP
    GROUP BY DEPTNO, JOB
    ORDER BY DEPTNO, JOB;
    
-- 6. ������, �μ��� �׷��Ͽ� �����  ����, �μ���ȣ, �ο���, �޿��� ���, �޿��� ���� ���(��°���� ������, �μ���ȣ �� �������� ����)
SELECT JOB, DEPTNO, COUNT(*), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY JOB, DEPTNO
    ORDER BY JOB, DEPTNO;
    
--7. ������� 5���̻� �Ѵ� �μ���ȣ�� ������� ���
SELECT DEPTNO, COUNT(*)
    FROM EMP
    GROUP BY DEPTNO
    HAVING COUNT(*) >= 5;

-- 8. ������� 5���̻� �Ѵ� �μ���� ������� ���
SELECT DNAME, COUNT(*)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    GROUP BY DNAME
    HAVING COUNT(*) >= 5;
   
--9. ������ �޿��� ����� 3000�̻��� ������ ���ؼ� ������, ��� �޿�, �޿��� ���� ���
SELECT JOB, ROUND(AVG(SAL), 2), SUM(SAL)
    FROM EMP
    GROUP BY JOB
    HAVING AVG(SAL) >= 3000;
    
--10. �޿� ���� 5000�� �ʰ��ϴ� �� ������ ���ؼ� ������ �޿����� ���(�޿� �հ�� �������� ����)
SELECT JOB, SUM(SAL)
    FROM EMP
    GROUP BY JOB
    HAVING SUM(SAL) >5000
    ORDER BY SUM(SAL) DESC;
    
--11. �μ��� �޿����, �μ��� �޿��հ�, �μ��� �ּұ޿��� ���
SELECT DEPTNO, ROUND(AVG(SAL), 2), SUM(SAL), MIN(SAL)
    FROM EMP
    GROUP BY DEPTNO;

--12. ���� 11���� �����Ͽ�, �μ��� �޿���� �ִ�ġ, �μ��� �޿����� �ִ�ġ, �μ��� �ּұ޿��� �ִ�ġ�� ���
SELECT  MAX(ROUND(AVG(SAL), 2)), MAX(SUM(SAL)), MAX(MIN(SAL))
    FROM EMP
    GROUP BY DEPTNO;
  
--13. ��� ���̺��� �Ʒ��� ����� ���
--   H_YEAR	COUNT(*)	MIN(SAL)	MAX(SAL)	AVG(SAL)	SUM(SAL)
--     80	  1		    800		    800		    800		    800
--	81	 10		    950		    5000	    2282.5	  22825
--	82	  2		    1300	    3000	   2150		   4300
--	83	  1		    1100	    1100	    1100	   1100
SELECT TO_CHAR(HIREDATE,'RR')YEAR, COUNT(*), MIN(SAL), MAX(SAL), ROUND(AVG(SAL), 2), SUM(SAL)
    FROM EMP
    GROUP BY TO_CHAR(HIREDATE, 'RR')
    ORDER BY TO_CHAR(HIREDATE, 'RR');
SELECT TO_CHAR(HIREDATE, 'RR') YEAR, COUNT(*), MIN(SAL), MAX(SAL), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY TO_CHAR(HIREDATE, 'RR')
    ORDER BY YEAR;    
    
-- 14.  �Ʒ��� ����� ���(�Ի�⵵�� �����)
--  1980     1	
--  1981     10
--  1982     2
--  1983     1
--  total    14	
SELECT NVL(TO_CHAR(HIREDATE,'YYYY'),'TOTAL'), COUNT(*)
    FROM EMP
    GROUP BY ROLLUP(TO_CHAR(HIREDATE,'YYYY')); 

--15. �ִ�޿�, �ּұ޿�, ��ü�޿���, ����� ���
SELECT 
MAX(SAL), MIN(SAL), SUM(SAL), ROUND(AVG(SAL), 2)
    FROM EMP;
    
--16. �μ��� �ο��� ���
SELECT DEPTNO, COUNT(*) 
    FROM EMP
    GROUP BY DEPTNO;
SELECT DEPTNO, COUNT(*) FROM EMP GROUP BY DEPTNO; 
SELECT DNAME, COUNT(*) 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO GROUP BY DNAME;
    
--17. �μ��� �ο����� 6���̻��� �μ���ȣ ���
SELECT DEPTNO, COUNT(*)
    FROM EMP
    GROUP BY DEPTNO
    HAVING COUNT(*) >=6;

