-- EX1. 사용자에게 부서번호 입력받아 부서 정보 뿌리기
SELECT * FROM DEPT WHERE DEPTNO=30;
INSERT INTO DEPT VALUES(50,'IT','SEOUL');
SELECT * FROM DEPT;
--EX2. 
SELECT * FROM DEPT WHERE DEPTNO=30;  -- (1) 
    --해당부서먼호 사원의 정보 (사번,이름,급여,상사명)을 출력 
SELECT W.EMPNO, W.ENAME, W.SAL ,M.ENAME MANAGER
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO AND W.DEPTNO = 30; --(2)
 
 --EX3.
 SELECT * FROM DEPT WHERE DNAME=UPPER('sales'); -- (1)
 --(2) 사번, 이름, 급여, 급여등급
 SELECT EMPNO, ENAME, SAL, GRADE
    FROM EMP E, SALGRADE, DEPT D
    WHERE SAL BETWEEN LOSAL AND HISAL AND E.DEPTNO=D.DEPTNO AND DNAME = UPPER('sales');
SELECT EMPNO, ENAME, SAL, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL AND DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME=UPPER('sales'));