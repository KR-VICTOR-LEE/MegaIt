1. ������ ���̺��� ����� ����ϴ� SQL���� �ۼ��Ͻÿ�(5��).
SELECT * FROM EMP;
SELECT * FROM DEPT;
SELECT * FROM SALGRADE;
2. TO_DATE �������Լ��� �̿��Ͽ� EMP ���̺��� HIREDATE�� 1981�� 2�� 20�Ϻ��� 1981�� 5�� 1�� ���̿� 
�Ի��� ����� �����, ��å, �Ի����� �����Ի��Ϻ��� �ֱ��Ի��� ������ �����Ͽ� ����ϴ� SQL���� �ۼ��Ͻÿ�(5��).
SELECT ENAME, JOB, HIREDATE 
    FROM EMP 
    WHERE HIREDATE BETWEEN TO_DATE('1981,02,20','RRRR/MM/DD') 
    AND TO_DATE('1981,05,01','RRRR/MM/DD');

3. EMP���̺�� DEPT���̺��� self join�� outer join�� �̿��Ͽ�
�����, �޿�, �μ���ȣ, �μ���, �ٹ���, ���ӻ����� ��簡 ���� �������� ��ü ���� �� ����ϴ� SQL���� �ۼ��Ͻÿ�. 
��, ��簡 ���� ��� ���� ��� ���������� ����Ѵ�(5��).
SELECT W.ENAME, W.SAL, W.DEPTNO, DNAME, LOC, NVL(M.ENAME, '����') M
    FROM EMP W, EMP M, DEPT D
        WHERE W.DEPTNO=D.DEPTNO AND W.MGR=M.EMPNO(+);
4. SALGRADE ���̺��� LOSAL�� ������� �޿�, HISAL�� ��� �ְ� �޿��� �̿��Ͽ�, 
EMP ���̺��� ����� ���, �����, ��å, �޿�, �޿������ �޿� ���� 
������������ �����Ͽ� ����ϴ� SQL���� �ۼ��Ͻÿ�(5��).
SELECT EMPNO, ENAME, JOB, SAL, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL ORDER BY SAL DESC;

5. EMP ���̺��� �μ���ȣ�� 20���� ����� ���,
�����, �޿��� ����ϵ� �޿� �տ��� $�� ���̰�, ���ڴ� 3�ڸ����� �޸�( , )�� �߰��Ͽ� ����ϴ� SQL���� �ۼ��Ͻÿ�.
�� �޿�(SAL)�� Ÿ���� NUMBER(7,2)�� �Ѵ�(5��).
SELECT EMPNO, ENAME, TO_CHAR(SAL, '$99,999')
    FROM EMP
    WHERE DEPTNO=20;

6. EMP ���̺��� ��å�� �޿� ����� 3000�̻��� ��å�� ���Ͽ� 
�����, ��ձ޿�, �ݿ��� ���� ����ϴ� SQL���� �ۼ��Ͻÿ�(5��).
SELECT JOB, AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY JOB
    HAVING AVG(SAL) >=3000;
7. EMP���̺��� ������� ��FORD���� ������ ��å(JOB)�� �޿�(SAL)�� 
���� ����� ��� ������ ����ϴ� SQL���� �ۼ��Ͻÿ�(5��).
SELECT * FROM EMP
    WHERE (JOB, SAL) = (SELECT JOB, SAL FROM EMP
    WHERE ENAME = 'FORD') AND ENAME != 'FORE';
8. EMP ���̺��� ������� ��FORD���� ����� �����ϴ� SQL���� �ۼ��Ͻÿ�(5��).
DELETE FROM EMP WHERE ENAME = 'FORD';
9. �����ͺ��̽����� Ʈ������� ������ ó���� �� ������ ���Ѵ�. 
�����͸� �����ϱ� ���� INSERT, UPDATE, DELETE ���� ��ɵ��� ����ʰ� ���ÿ� Ʈ������� ����Ǵµ�,
�̵� INSERT, UPDATE, DELETE�۾��� ���������� �����ͺ��̽��� �ݿ���ó���ǵ��� ��ɾ �ۼ��Ͻÿ�(5��).
INSERT INTO EMP VALUES (1111,'HONG','SALESMAN',NULL,SYSDATE,8000,NULL,20);
UPDATE EMP SET JOB = 'IT' WHERE ENAME = 'HONG';
DELETE FROM EMP WHERE ENAME = 'HONG';
10. EMP���̺��� ��������� ��ȸ�ϴ� �ð��� �����ϱ� ���� ���Ǵ� �ε��� ���� ��ɾ �ۼ��Ͻÿ�. 
������ �ε����� �̸��� IDX_EMP_ENAME���� �Ѵ�(10��).
CREATE TABLE  IDX_EMP_ENAME 
    AS SELECT * FROM EMP;
CREATE INDEX  IDX_EMP_ENAME ON EMP(ENAME); 
11. ���� ���� ������ ���̺� ���� ������ ������ ������ ��ųʸ��並 ���캸�� SQL���� �ۼ��Ͻÿ�(5��).
CREATE OR  REPLACE VIEW EMPv
    AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO FROM EMP;
SELECT * FROM EMPv;    
