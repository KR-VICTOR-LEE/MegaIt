-- �μ���ȣ �ߺ�üũ


SELECT * FROM DEPT  WHERE  DEPTNO  = 70; -- rs.next () ����� true (�ߺ� ���) / false(�μ���/�μ���ġ �Է¹޾� �Է�)
SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=70;
-- �Է�
INSERT INTO DEPT VALUES(70,'IT','BUSAN');
-- ����
UPDATE DEPT SET DNAME = 'ABC', LOC='SEOUL' WHERE DEPTNO = 90;
COMMIT;
select * from dept;