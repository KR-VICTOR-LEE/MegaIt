-- 부서번호 중복체크


SELECT * FROM DEPT  WHERE  DEPTNO  = 70; -- rs.next () 결과가 true (중복 출력) / false(부서명/부서위치 입력받아 입력)
SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=70;
-- 입력
INSERT INTO DEPT VALUES(70,'IT','BUSAN');
-- 수정
UPDATE DEPT SET DNAME = 'ABC', LOC='SEOUL' WHERE DEPTNO = 90;
COMMIT;
select * from dept;