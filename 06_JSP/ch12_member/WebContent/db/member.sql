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
    
    --1. 회원가입시 ID중복체크를 위한 SQL : public int confirmId(String id)
    SELECT * FROM MEMBER WHERE ID='aaa';
    --2. 회원가입 : public int joinMember (MemberDto dto)
    INSERT INTO MEMBER (ID, PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, RDATE, ADDRESS)
        VALUES ('aaa','111','홍길동','02','1111','1111','m','hong@h.com','1995-12-12',SYSDATE,'서울');
    --3. 로그인(id/pw) : public int loginCheck(String id, String pw)
    SELECT ID, PW FROM MEMBER WHERE ID='aaa';
    --4. ID로 dto가져오기 : public MemeberDto getMember(String id)
   SELECT * FROM MEMBER WHERE ID='aaa'; 
    --5. 회원정보 수정 : public int modifyMember(MemberDto dto)
    UPDATE MEMBER SET PW='111',
                                        NAME = '신길동',
                                        PHONE1 = '010',
                                        PHONE2 = '9999',
                                        PHONE3 = '8888',
                                        GENDER = 'm',
                                        EMAIL = 'a@A.COM',
                                        BIRTH = '1990-12-01',
                                        ADDRESS = '안양'
                                    WHERE ID ='aaa';
    --
    SELECT * FROM MEMBER;
    commit;