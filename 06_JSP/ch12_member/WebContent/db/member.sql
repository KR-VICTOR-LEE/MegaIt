-- TABLE DROP & CREATE
DROP TABLE MEMBER CASCADE CONSTRAINTS;
CREATE TABLE MEMBER(
    ID VARCHAR2(30) PRIMARY KEY,
    PW VARCHAR2(30) NOT NULL,
    NAME VARCHAR2(30) NOT NULL,
    PHONE1 VARCHAR2(5),
    PHONE2 VARCHAR2(5),
    PHONE3 VARCHAR2(5),
    GENDER VARCHAR2(1),
    EMAIL VARCHAR2(30),
    BIRTH DATE,
    RDATE DATE NOT NULL, -- ������
    ADDRESS VARCHAR2 (200)
    );
    
    --1. ȸ�����Խ� ID�ߺ�üũ�� ���� SQL : PUBLIC INT CONFIRMID(STRING ID)
    SELECT * FROM MEMBER WHERE ID='AAA';
    --2. ȸ������ : PUBLIC INT JOINMEMBER (MEMBERDTO DTO)
    INSERT INTO MEMBER (ID, PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, RDATE, ADDRESS)
        VALUES ('AAA','111','ȫ�浿','02','1111','1111','M','HONG@H.COM','1995-12-12',SYSDATE,'����');
    --3. �α���(ID/PW) : PUBLIC INT LOGINCHECK(STRING ID, STRING PW)
    SELECT ID, PW FROM MEMBER WHERE ID='AAA';
    --4. ID�� DTO�������� : PUBLIC MEMEBERDTO GETMEMBER(STRING ID)
   SELECT * FROM MEMBER WHERE ID='AAA'; 
    --5. ȸ������ ���� : PUBLIC INT MODIFYMEMBER(MEMBERDTO DTO)
    UPDATE MEMBER SET PW='111',
                                        NAME = '�ű浿',
                                        PHONE1 = '010',
                                        PHONE2 = '9999',
                                        PHONE3 = '8888',
                                        GENDER = 'M',
                                        EMAIL = 'A@A.COM',
                                        BIRTH = '1990-12-01',
                                        ADDRESS = '�Ⱦ�'
                                    WHERE ID ='AAA';
    --
    SELECT * FROM MEMBER;