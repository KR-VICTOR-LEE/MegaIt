-- FRIEND TABLE & SEQ DROP & CREATE
DROP TABLE FRIEND;
DROP SEQUENCE FRIEND_SEQ;
CREATE SEQUENCE FRIEND_SEQ MAXVALUE 9999;
CREATE TABLE FRIEND(
        NO NUMBER(4,0) PRIMARY KEY,
        NAME VARCHAR2(30) NOT NULL,
        TEL VARCHAR2(30)
    );
    -- ģ�� ���� ��������
   SELECT * FROM FRIEND;
    -- ģ�� �߰�
   INSERT INTO FRIEND VALUES (FRIEND_SEQ.NEXTVAL, 'ȫ�浿','010-9999-9999');
    -- ģ�� �˻�
    SELECT * FROM FRIEND WHERE NAME LIKE '%'||'��'||'%' AND TEL LIKE '%'||'9999'||'%';
    COMMIT;