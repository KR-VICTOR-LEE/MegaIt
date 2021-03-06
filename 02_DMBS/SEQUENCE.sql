--[VIII] SEQUENCE : 순차번호 생서기, 대부분 인위적인 PK 사용 용도

CREATE SEQUENCE FRIEND_SEQ
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 9999
    MINVALUE 1
    NOCACHE
    NOCYCLE;
    
SELECT FRIEND_SEQ.NEXTVAL FROM DUAL;
DROP SEQUENCE FRIEND_SEQ;
CREATE SEQUENCE FRIEND_SEQ
    MAXVALUE 9999
    NOCACHE
    NOCYCLE;
DROP TABLE FRIEND;

CREATE TABLE FRIEND(
    NUM NUMBER(4) PRIMARY KEY, -- 시퀀스 이용
    NAME VARCHAR2(30) NOT NULL,
    TEL VARCHAR(30) UNIQUE, -- NULL허용, 유일한 값
    ADDRESS VARCHAR2(300),
    LAST_MODIFYED DATE DEFAULT SYSDATE );
INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS) 
    VALUES (FRIEND_SEQ.NEXTVAL ,'홍길동' ,NULL ,'서울시 강남구 강남대로 94길 13 삼겸빌딩 402' );
SELECT * FROM FRIEND;

INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
    VALUES (FRIEND_SEQ.NEXTVAL, '신길동', '010-8888-8888', '서울시 영등포구');
SELECT FRIEND_SEQ.CURRVAL FROM DUAL;
COMMIT;

--ex. 초기값 101부터 최대값 999,999까지 1씩 증가하는 TEST_SEQ 시퀀스를 생성
CREATE SEQUENCE TEST_SEQ START WITH 101 MAXVALUE 999999 NOCACHE NOCYCLE;
SELECT TEST_SEQ.CURRVAL FROM DUAL; --시퀀스의 현재 값이 없어서 에러
SELECT TEST_SEQ.NEXTVAL FROM DUAL;

-- 연습문제 6번
CREATE TABLE BOOKCATEGORY(
    CATEGORY_CODE NUMBER(3) PRIMARY KEY,
    CATEGOFYNAME VARCHAR2(50) UNIQUE,
    OFFICE_LOC VARCHAR2(50) NOT NULL );

CREATE TABLE BOOK(
CATEGORY_CODE NUMBER(3)  REFERENCES BOOKCATEGORY(CATEGORY_CODE),
    BOOKNO VARCHAR2(10) PRIMARY KEY,
    BOOKNAME VARCHAR2(50),
    PUBLISHER VARCHAR2(50),
    PUBYEAR VARCHAR2(50) DEFAULT EXTRACT(YEAR FROM SYSDATE)  );
DROP TABLE BOOK;

INSERT INTO BOOKCATEGORY VALUES (100,'철학','3층 인문실');
INSERT INTO BOOKCATEGORY VALUES (200,'인문','3층 인문실');
INSERT INTO BOOKCATEGORY VALUES (300,'자연과학','4층 과학실');
INSERT INTO BOOKCATEGORY VALUES (400,'IT','4층 과학실');
SELECT * FROM BOOKCATEGORY;

INSERT INTO BOOK VALUES (100,'100A01', '철학자의 삶', '더존출판', '2021');
INSERT INTO BOOK VALUES (400,'400A01', '이것이 DB다', '더존출판', '2018');
SELECT * FROM BOOK;
-- 연습문제 7번
CREATE TABLE MAJOR(
    MAJOR_CODE NUMBER(3) PRIMARY KEY,
    MAJOR_NAME VARCHAR2(50) UNIQUE,
    MAJOR_OFFICE_LOC VARCHAR2(300) NOT NULL);
DROP TABLE STUDENT;
CREATE TABLE STUDENT(
    SUTDENT_CODE VARCHAR2(50) PRIMARY KEY,
    STUDENT_NAME VARCHAR2(50) NOT NULL,
    SCORE NUMBER(3) CHECK(0<=SCORE AND  SCORE<=100),
    MAJOR_CODE NUMBER(3) REFERENCES MAJOR(MAJOR_CODE));

INSERT INTO MAJOR VALUES(1,'경영정보','경영관 305호');
INSERT INTO MAJOR VALUES(2,'소프트웨어공학','정보관 808호');
INSERT INTO MAJOR VALUES(3,'디자인','예술관 606호');
INSERT INTO MAJOR VALUES(4,'경제','경상관 202호');
SELECT * FROM MAJOR;

INSERT INTO STUDENT VALUES('A01','김길동',100,1);
INSERT INTO STUDENT VALUES('A02','문길동',90,2);
INSERT INTO STUDENT VALUES('A03','홀길동',95,1);
SELECT * FROM STUDENT;
-- 연습문제 8번
CREATE SEQUENCE MEMBER_SEQ
    INCREMENT BY 1
    MAXVALUE 9999
    MINVALUE 1
    NOCACHE
    NOCYCLE;

CREATE TABLE MEMBER(
    MNO NUMBER(4) PRIMARY KEY,
    MNAME VARCHAR2(50) NOT NULL,
    MPW VARCHAR2(20) CHECK (LENGTH(MPW )<=8),
    MEMAIL VARCHAR2(50) UNIQUE,
    MPOINT NUMBER(10) CHECK(MPOINT >= 0),
    MRDATE DATE DEFAULT SYSDATE,
    LEVELNO NUMBER(2) REFERENCES MEMBER_LEVEL(LEVELNO) );

CREATE SEQUENCE MEMBER_LEVEL_SEQ
    INCREMENT BY 1
    MAXVALUE 9999
    MINVALUE -1
    NOCACHE
    NOCYCLE;


CREATE TABLE MEMBER_LEVEL(
    LEVELNO NUMBER(4) PRIMARY KEY,
    LEVELNAME VARCHAR2(50) NOT NULL); 

SELECT * FROM MEMBER;
INSERT INTO MEMBER VALUES (MEMBER_SEQ.NEXTVAL,'홍길동','aa','hong@hong.com',0,'22/03/10',0);
INSERT INTO MEMBER VALUES (MEMBER_SEQ.NEXTVAL,'신길동','bb','sin@sin.com',1000,'22/04/01', 1);

INSERT INTO MEMBER_LEVEL VALUES (MEMBER_LEVEL_SEQ.NEXTVAL, 'BLACK');  
INSERT INTO MEMBER_LEVEL VALUES (MEMBER_LEVEL_SEQ.NEXTVAL, '일반');
INSERT INTO MEMBER_LEVEL VALUES (MEMBER_LEVEL_SEQ.NEXTVAL, '실버');    
INSERT INTO MEMBER_LEVEL VALUES (MEMBER_LEVEL_SEQ.NEXTVAL, '골드');    


SELECT MNO, MNAME, TO_CHAR(MRDATE, 'YYYY-MM-DD'),MEMAIL, MPOINT point, LEVELNAME || '고객'
    FROM MEMBER M , MEMBER_LEVEL L
    WHERE M.LEVELNO=L.LEVELNO ;