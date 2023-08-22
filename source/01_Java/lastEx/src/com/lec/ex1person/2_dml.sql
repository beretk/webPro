-- ���α׷��� �� query
-- 1���� 2�� ����� �Է°����� ��������
SELECT JNAME FROM JOB;

-- 1�� ���. PNAME, JNAME, KOR, ENG, MAT�Է¹޾� PERSON ���̺��� INSERT
INSERT INTO PERSON 
    VALUES(PERSON_PNO_SQ.NEXTVAL, 'ȫ�浿', (SELECT JNO FROM JOB WHERE JNAME='���'), 99,99,100);
DELETE FROM person WHERE pNO=6;
SELECT * FROM PERSON;
COMMIT;

-- 2�� ���. JNAME�Է¹޾�, RANK, PNAME(PNO), JNAME, KOR, ENG, MAT, SUM���
SELECT PNAME || '(' || PNO || ')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
    FROM PERSON P, JOB J
    WHERE P.JNO=J.JNO AND JNAME='���'
    ORDER BY SUM DESC; -- INLINE VIEW�� �� ����
SELECT ROWNUM RANK, A.*
    FROM (SELECT PNAME || '(' || PNO || ')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
                FROM PERSON P, JOB J
                WHERE P.JNO=J.JNO AND JNAME='���'
                ORDER BY SUM DESC) A; -- 2�� ��ɿ� �� QUERY

-- 3�� ���. RANK, PNAME(PNO), JNAME, KOR, ENG, MAT, SUM���
SELECT ROWNUM RANK, A.*
    FROM (SELECT PNAME || '(' || PNO || ')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
                FROM PERSON P, JOB J
                WHERE P.JNO=J.JNO 
                ORDER BY SUM DESC) A; 
SELECT * FROM PERSON;
DELETE FROM PERSON WHERE PNO=8;
























