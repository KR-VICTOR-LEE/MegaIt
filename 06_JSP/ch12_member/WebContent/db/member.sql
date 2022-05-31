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
    RDATE DATE NOT NULL, -- 가입일
    ADDRESS VARCHAR2 (200)
    );
    
    --1. 회원가입시 ID중복체크를 위한 SQL : PUBLIC INT CONFIRMID(STRING ID)
    SELECT * FROM MEMBER WHERE ID='AAA';
    --2. 회원가입 : PUBLIC INT JOINMEMBER (MEMBERDTO DTO)
    INSERT INTO MEMBER (ID, PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, RDATE, ADDRESS)
        VALUES ('AAA','111','홍길동','02','1111','1111','M','HONG@H.COM','1995-12-12',SYSDATE,'서울');
    --3. 로그인(ID/PW) : PUBLIC INT LOGINCHECK(STRING ID, STRING PW)
    SELECT ID, PW FROM MEMBER WHERE ID='AAA';
    --4. ID로 DTO가져오기 : PUBLIC MEMEBERDTO GETMEMBER(STRING ID)
   SELECT * FROM MEMBER WHERE ID='AAA'; 
    --5. 회원정보 수정 : PUBLIC INT MODIFYMEMBER(MEMBERDTO DTO)
    UPDATE MEMBER SET PW='111',
                                        NAME = '신길동',
                                        PHONE1 = '010',
                                        PHONE2 = '9999',
                                        PHONE3 = '8888',
                                        GENDER = 'M',
                                        EMAIL = 'A@A.COM',
                                        BIRTH = '1990-12-01',
                                        ADDRESS = '안양'
                                    WHERE ID ='AAA';
    --
    SELECT * FROM MEMBER;