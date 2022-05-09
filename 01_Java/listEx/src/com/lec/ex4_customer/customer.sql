DROP TABLE CUSTOMER;
DROP TABLE CUS_LEVEL;
DROP SEQUENCE CUSTOMER_SEQ;
CREATE TABLE CUS_LEVEL(
    LEVELNO NUMBER(1,0) PRIMARY KEY,
    LEVELNAME VARCHAR2(20),
    LOW NUMBER(9,0),
    HIGH NUMBER(9,0));

CREATE SEQUENCE CUSTOMER_SEQ MAXVALUE 999999 NOCACHE NOCYCLE;

CREATE TABLE CUSTOMER(
    cID NUMBER(6,0) PRIMARY KEY,
    cTEL VARCHAR2(20) NOT NULL,
    cNAME VARCHAR2(30) NOT NULL,
    cPOINT NUMBER(9,0) DEFAULT 1000,
    cAMOUNT NUMBER(9,0) DEFAULT 0,
    LEVELNO NUMBER(1,0) DEFAULT 1 REFERENCES CUS_LEVEL(LEVELNO));
    
-- ���̵����� �Է�(CUS_LEVEL)

INSERT INTO CUS_LEVEL VALUES (1, 'NORMAL',0,999999);
INSERT INTO CUS_LEVEL VALUES (2, 'SILVER', 1000000,1999999);
INSERT INTO CUS_LEVEL VALUES (3, 'GOLD', 2000000,2999999);
INSERT INTO CUS_LEVEL VALUES (4, 'VIP', 3000000,3999999);
INSERT INTO CUS_LEVEL VALUES (5, 'VVIP', 4000000,99999999);

SELECT * FROM CUS_LEVEL;

INSERT INTO CUSTOMER (cID, cTEL, cNAME)
        VALUES (CUSTOMER_SEQ.NEXTVAL, '010-9999-9999','ȫ�浿');
INSERT INTO CUSTOMER 
        VALUES (CUSTOMER_SEQ.NEXTVAL, '010-9999-9999','ȫ�浿',0,4000000,5);
INSERT INTO CUSTOMER 
        VALUES (CUSTOMER_SEQ.NEXTVAL, '010-7777-7777','�ű浿',0,100000,1);

SELECT * FROM CUSTOMER;

-- ���α׷��� �ʿ��� QUERY
-- 0. �����̸��� �˻� : Vector<String> gitLevelNNames()
SELECT LEVELNAME FROM CUS_LEVEL;
-- 1. ���̵�˻� : CustomerDto cIdgetCustomer(int cId)
        -- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forlevelLUP
SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME,    
          (SELECT  HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND LEVELNO!=5) forlevelUP
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO AND CID =1;

-- 2. ��4�ڸ�(FULL)�˻� : ARRAYLIST<CUSTOMERDTO> CTELGETCUSTOMER
SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME,    
          (SELECT  HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND LEVELNO!=5)
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO AND cTEL  LIKE '%'||'7777'  ORDER BY CAMOUNT DESC;
-- 3. �����̸��˻� 
        -- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forlevelLUP
SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME,    
          (SELECT  HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND LEVELNO!=5)
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO AND CNAME = 'ȫ�浿'  ORDER BY CAMOUNT DESC;        
-- 4. ����Ʈ�θ� ���� : (1�� id�� 100�� ����) : int buyWithPoint (int cId, int cAmount)
UPDATE CUSTOMER SET CPOINT = CPOINT - 100 WHERE CID=1;
-- 5. ��ǰ���� : int buy(cId, int cAmount)
        -- ��ǰ���� update���� cPoint, cAmount, levelNo�� ����
        -- 5-1. cPoint, cAmount ����
UPDATE CUSTOMER SET cPOINT = cPOINT + (1000000*0.05),
    cAMOUNT = cAMOUNT + 1000000
    WHERE CID=1;
    SELECT * FROM CUSTOMER;
        -- 5-2 levelNo �����ϱ� �� �� ������ȣ�� ������ ���� ��ȣ
SELECT CID, CNAME, CAMOUNT, C.LEVELNO ������, L.LEVELNO �����ɷ���
    FROM CUSTOMER C, CUS_LEVEL L 
    WHERE CAMOUNT BETWEEN LOW AND HIGH;
        -- 5-3 levelNo�� ����
UPDATE CUSTOMER SET LEVELNO = ( SELECT C.LEVELNO
                                                                    FROM CUSTOMER C, CUS_LEVEL L 
                                                                    WHERE CAMOUNT BETWEEN LOW AND HIGH AND CID=1)
            WHERE CID=1;
SELECT * FROM CUSTOMER;
        -- 5-1 �� 5-3 �� ���� CPOINT, CAMOUNT, LEVELNO�� �Ѳ����� ����
UPDATE CUSTOMER SET cPOINT = cPOINT + (1000000*0.05),
                      cAMOUNT = cAMOUNT + 1000000,
                      LEVELNO = (SELECT L.LEVELNO
                                    FROM CUSTOMER C, CUS_LEVEL L
                                    WHERE CAMOUNT+1000000 BETWEEN LOW AND HIGH AND CID=1)
    WHERE CID=1; -- DAO�� �� QUERY
  SELECT * FROM CUSTOMER;
        
-- 6. ��޺���� : ArrayList<CustomerDto> levelNameGetCustomer(String levelName)
        --     CID, CNAME, CPOINT, CAMOUNT, LEVELNAME, forlevelLUP
SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME,    
          (SELECT  HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND LEVELNO!=5)
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO AND LEVELNAME='NORMAL' ORDER BY CAMOUNT DESC;        
-- 7. ��ü��� : ArrayList<CustomerDto> getCustomers()
--     CID, CNAME, CPOINT, CAMOUNT, LEVELNAME, forlevelLUP
SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME,    
          (SELECT  HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND LEVELNO!=5)
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO  ORDER BY CAMOUNT DESC;   
-- 8. ȸ������ : int insertCustomer (String cTel,String  cName)
INSERT INTO CUSTOMER (CID, CTEL, CNAME)
    VALUES (CUSTOMER_SEQ.NEXTVAL, '010-6666-6666', '���浿');
-- 9. ��ȣ���� : int updateCustomer(int cId , String cTel)
UPDATE CUSTOMER SET CTEL = '010-5555-5555' WHERE CID=4;
-- 10. ȸ��Ż�� : int deleteCustomer(String cTel)
DELETE FROM CUSTOMER WHERE CTEL =  '010-6666-6666';
COMMIT;