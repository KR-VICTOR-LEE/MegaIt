-- [V] 그룹함수 ; SUM, AVG, MIN, MAX, COUNT, STDDEV(표준편차), VARIANCE(분산)

SELECT ENAME, ROUND(SAL, -3) FROM EMP; -- 단일행함수(4장)
SELECT MAX(SAL) FROM EMP;              -- 그룹함수 (5장)
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; -- 그룹함수(5장)
SELECT ENAME, MAX(SAL) FROM EMP; -- 에러(단일행과 다중행 같이 써서) 최대급여를 받는 사람의 이름(6장. 서브쿼리)

-- ★ 1. 그룹함수들 실습
SELECT ROUND(AVG(SAL),2) FROM EMP;
SELECT COUNT(*) FROM EMP; -- EMP 테이블의 행(ROW)수
SELECT AVG(SAL), SUM(SAL)/COUNT(SAL) FROM EMP;
SELECT COMM FROM EMP; -- SUM:300+500+1400+0(2200) AVG:2200/4=550
-- 모든 그룹함수는 NULL값을 제외
SELECT SUM(COMM), AVG(COMM), COUNT(COMM), MIN(COMM), MAX(COMM) FROM EMP;
-- SAL의 평균, 합, 최소급여, 최대급여, 급여분산, 급여표준편차, 갯수
SELECT AVG(SAL), SUM(SAL), MIN(SAL), MAX(SAL), VARIANCE(SAL), STDDEV(SAL) FROM EMP;
SELECT SQRT(VARIANCE(SAL)), STDDEV(SAL) FROM EMP;
-- 그룹함수 MIN, MAX, COUNT는 숫자형, 문자형, 날짜형 모두 사용가능
SELECT MIN(ENAME), MAX(ENAME), COUNT(ENAME) ENAME갯수, COUNT(COMM) COMM갯수 FROM EMP;
-- 탄탄1. 가장최근에 입사한 사원의 입사일과, 가장 최초입사한 사원의 입사일
SELECT MIN(HIREDATE) 최소입사일, MAX(HIREDATE) 최근입사일, COUNT(HIREDATE) FROM EMP;
-- 탄탄2. 83/01/12 최근입사일 : 14,336일 근무, 80/12/17 최초입사일 : 15,092일 근무
SELECT MAX(HIREDATE) || ' 최근입사일 : ' ||
    TO_CHAR(SYSDATE-MAX(HIREDATE), '99,999') || '일 근무, ' ||
    MIN(HIREDATE) || ' 최초입사일 : ' ||
    TO_CHAR(SYSDATE-MIN(HIREDATE), '99,999') || '일 근무'
FROM EMP;
SELECT MAX(HIREDATE) || ' 최근입사일 : ' ||
        TO_CHAR(MIN(SYSDATE-HIREDATE), '99,999') || '일 근무, ' ||
        MIN(HIREDATE) || '최초입사일 : ' ||
        TO_CHAR(MAX(SYSDATE-HIREDATE), '99,999') || '일 근무'
    FROM EMP;
-- 10번 부서소속의 사원 급여 평균
SELECT AVG(SAL) FROM EMP WHERE DEPTNO=10;

-- ★ 2. GROUP BY 절
-- 부서번호별 최대급여, 최소급여, 급여평균, 급여합
        -- GROUP BY 절에는 컬럼의 별칭 사용 불가
SELECT DEPTNO 부서, MAX(SAL), MIN(SAL), AVG(SAL), SUM(SAL) FROM EMP GROUP BY DEPTNO; 
SELECT DEPTNO 부서, MAX(SAL), MIN(SAL), ROUND(AVG(SAL)), SUM(SAL) FROM EMP GROUP BY DEPTNO; 
    -- ex. SAL이 5000미만인 사원에 대해서만 부서번호별 사원수, 최대급여, 최소급여, 평균급여(부서번호순 정렬)
    SELECT DEPTNO 부서, COUNT(*), MAX(SAL), MIN(SAL), AVG(SAL)  -- SELECT 절에서는 필드 별칭 사용 가능
        FROM EMP 
        WHERE SAL<5000  -- WHERE절에서는 필드 별칭 사용 불가
        GROUP BY DEPTNO -- GROUP BY 절에서는 필드 별칭 사용 불가
        ORDER BY 부서;  -- ORDER BY절에서는 필드 별칭 사용 가능
    -- ex. 부서명별 사원수, 최대급여, 최소급여, 평균급여(소수점2자리) (사원수가 많은 순으로 정렬)
    SELECT DNAME, COUNT(*), MAX(SAL), MIN(SAL), ROUND(AVG(SAL),2)
        FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO
        GROUP BY DNAME
        ORDER BY COUNT(*) DESC;

-- ★ 3. HAVING 절 : 그룹함수 결과의 조건
-- 부서번호별 평균 급여 (평균급여가 2000이상인 부서만 출력, 평균급여 순으로 정렬)
SELECT DEPTNO, AVG(SAL) "AVG"
    FROM EMP
    GROUP BY DEPTNO
    HAVING AVG(SAL) >= 2000 -- HAVING 절에는 필드 별칭 사용 불가
    ORDER BY AVG;
-- SAL이 5000미만인 사원에 대해 부서명별 최소급여, 최대급여, 평균급여 
    -- (단, 평균급여가 1800이상인 부서명에 대해서 평균급여순으로 정렬 출력)
SELECT DNAME, MIN(SAL), MAX(SAL), AVG(SAL)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND SAL<5000
    GROUP BY DNAME
    HAVING AVG(SAL) >= 1800
    ORDER BY AVG(SAL);
    
-- ★ 4. 결과 집계합 내 집계값 생성
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO); 
    -- 부서별, JOB별 급여합
    SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY DEPTNO, JOB ORDER BY DEPTNO;
    -- 부서별, JOB별 급여합 (소계와 전체합 포함)
    SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO, JOB);

-- ★<총 연습문제>
-- 1. 인원수,최대 급여,최소 급여,급여의 합을 출력
SELECT COUNT(*), MAX(SAL), MIN(SAL), SUM(SAL) FROM EMP;

-- 2. 업무별 인원수를 구하여 출력
SELECT JOB, COUNT(*) FROM EMP GROUP BY JOB;

--- 3. 최고 급여와 최소 급여의 차이는 얼마인가 출력
SELECT MAX(SAL) - MIN(SAL) FROM EMP;

-- 4. 각 부서별로 인원수, 급여 평균, 최저 급여, 최고 급여, 급여의 합을 출력(급여의 합이 많은 순으로)
SELECT DEPTNO, COUNT(*), AVG(SAL), MIN(SAL), MAX(SAL), SUM(SAL) 
    FROM EMP
    GROUP BY DEPTNO 
    ORDER BY SUM(SAL) DESC; 
    
SELECT DEPTNO, COUNT(*), AVG(SAL), MIN(SAL), MAX(SAL), SUM(SAL) SUM_SAL 
    FROM EMP 
    GROUP BY DEPTNO 
    ORDER BY SUM_SAL DESC; -- order by 절에는 필드의 별칭 쓸 수 있음
    
SELECT DNAME, COUNT(*), AVG(SAL), MIN(SAL), MAX(SAL), SUM(SAL) 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    GROUP BY DNAME
    ORDER BY SUM(SAL) DESC;
    
-- 5. 부서별, 업무별 그룹하여 결과를 부서번호, 업무, 인원수, 급여의 평균, 급여의 합을 출력
        -- (부서번호, 업무순으로 오름차순 정렬)
SELECT DEPTNO, JOB, COUNT(*), AVG(SAL), SUM(SAL) 
    FROM EMP 
    GROUP BY DEPTNO, JOB 
    ORDER BY DEPTNO, JOB;  -- 부서번호, 업무별
    
-- 6. 업무별, 부서별 그룹하여 결과를  업무, 부서번호, 인원수, 급여의 평균, 급여의 합을 출력
    -- (출력결과는 업무순, 부서번호 순 오름차순 정렬)
SELECT JOB, DEPTNO, COUNT(*), AVG(SAL), SUM(SAL) 
    FROM EMP 
    GROUP BY JOB, DEPTNO 
    ORDER BY JOB, DEPTNO;
    
--7. 사원수가 5명이상 넘는 부서번호와 사원수를 출력
SELECT DEPTNO, COUNT(*) 
  FROM EMP 
  GROUP BY DEPTNO 
  HAVING COUNT(*)>5; --그룹(group by)에 대한 조건은 having절에
  
-- 8. 사원수가 5명이상 넘는 부서명과 사원수를 출력
SELECT DNAME, COUNT(*)  
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO 
    GROUP BY DNAME 
    HAVING COUNT(*)>=5;
      
--9. 업무별 급여의 평균이 3000이상인 업무에 대해서 업무명, 평균 급여, 급여의 합을 출력
SELECT JOB, AVG(SAL), SUM(SAL) 
    FROM EMP 
    GROUP BY JOB 
    HAVING AVG(SAL)>=3000;
    
--10. 급여 합이 5000을 초과하는 각 업무에 대해서 업무와 급여합을 출력(급여 합계순 내림차순 정렬)
SELECT JOB, SUM(SAL)
    FROM EMP 
    GROUP BY JOB 
    HAVING SUM(SAL)>5000 
    ORDER BY SUM(SAL) DESC;
    
SELECT JOB, SUM(SAL) SUMSAL
    FROM EMP 
    GROUP BY JOB 
    HAVING SUM(SAL)>5000 
    ORDER BY SUMSAL DESC; -- ORDER BY 절에만 필드 별칭 사용 가능
    
--11. 부서별 급여평균, 부서별 급여합계, 부서별 최소급여를 출력
SELECT DEPTNO, AVG(SAL), SUM(SAL), MIN(SAL) 
    FROM EMP 
    GROUP BY DEPTNO; -- 부서번호별
SELECT DNAME, AVG(SAL), SUM(SAL), MIN(SAL) 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO 
    GROUP BY DNAME; -- 부서이름별
    
--12. 위의 11번을 수정하여, 부서별 급여평균 최대치, 부서별 급여합의 최대치, 부서별 최소급여의 최대치를 출력
SELECT round(max(AVG(SAL))), max(SUM(SAL)), max(MIN(SAL))
    FROM EMP 
    GROUP BY DEPTNO;
    
--13. 사원 테이블에서 아래의 결과를 출력하(년도별 연봉합)
--H_YEAR COUNT(*)	MIN(SAL)	MAX(SAL)	AVG(SAL)	SUM(SAL)
--  80	  1		    800		    800		    800		    800
--	81	 10		    950		    5000	    2282.5	  22825
--	82	  2		    1300	    3000	    2150		  4300
--	83	  1		    1100	    1100	    1100	    1100
SELECT TO_CHAR(HIREDATE,'RR') H_YEAR, COUNT(*), MIN(SAL), MAX(SAL), AVG(SAL), SUM(SAL) 
    FROM EMP 
    GROUP BY TO_CHAR(HIREDATE,'RR')
    ORDER BY H_YEAR;
    
SELECT SUBSTR(EXTRACT(YEAR FROM HIREDATE),3,2) H_YEAR, 
        COUNT(*), MIN(SAL), MAX(SAL), AVG(SAL), SUM(SAL) 
    FROM EMP 
    GROUP BY SUBSTR(EXTRACT(YEAR FROM HIREDATE),3,2) 
    ORDER BY H_YEAR;
    
-- 14.  아래의 결과를 출력(입사년도별 사원수)
--  1980     1	
--  1981     10
--  1982     2
--  1983     1
--  total    14	
SELECT NVL(TO_CHAR(HIREDATE,'YYYY'),'total') YEAR, COUNT(*) CNT 
FROM EMP
    GROUP BY ROLLUP(TO_CHAR(HIREDATE,'YYYY'))
    ORDER BY TO_CHAR(HIREDATE, 'YYYY');
SELECT NVL(TO_CHAR(EXTRACT(YEAR FROM HIREDATE)),'total') YEAR, COUNT(*) CNT 
FROM EMP
    GROUP BY ROLLUP(EXTRACT(YEAR FROM HIREDATE))
    ORDER BY YEAR;
    
--15. 최대급여, 최소급여, 전체급여합, 평균을 출력
SELECT MAX(SAL), MIN(SAL), SUM(SAL), AVG(SAL) FROM EMP;

--16. 부서별 인원수 출력
SELECT DEPTNO, COUNT(*) FROM EMP GROUP BY DEPTNO;
SELECT DNAME, COUNT(*) 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO 
    GROUP BY DNAME;
    
--17. 부서별 인원수가 6명이상인 부서번호 출력
SELECT DEPTNO, COUNT(*) 
    FROM EMP 
    GROUP BY DEPTNO 
    HAVING COUNT(*)>=6;
    
--18. 급여가 높은 순서대로 등수를 부여하여 다음과 같은 결과가 나오게 하시오. 
-- (힌트 self join, group by, count사용)
--ENAME	    등수
--________________________
--KING		1
--SCOTT		2
--……
SELECT E1.ENAME, E1.SAL, E2.ENAME, E2.SAL
    FROM EMP E1, EMP E2
    WHERE E1.SAL<E2.SAL(+); -- 1단계 : SELF JOIN / OUTER JOIN
    
SELECT E1.ENAME, COUNT(E2.ENAME)+1 RANK
    FROM EMP E1, EMP E2
    WHERE E1.SAL<E2.SAL(+)
    GROUP BY E1.ENAME
    ORDER BY RANK; -- 완성단계 : GROUP BY COUNT

SELECT ENAME, RANK() OVER(ORDER BY SAL DESC) "RANK",
            DENSE_RANK() OVER(ORDER BY SAL DESC) "DENSE_RANK",
            ROW_NUMBER() OVER(ORDER BY SAL DESC) "ROW_NUMBER" FROM EMP;
