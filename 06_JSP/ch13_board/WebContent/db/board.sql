-- ���̺� dorp & create
CREATE TABLE BOARD(
    NUM NUMBER(5,0) PRIMARY KEY, --�۹�ȣ
    WRITER VARCHAR2(30) NOT NULL, --�۾���
    SUBJECT VARCHAR2(100) NOT NULL, --������
    CONTENT VARCHAR2(4000) NOT NULL, --����
    EMAIL VARCHAR2(30), -- �ۼ��� �̸���
    READCOUNT NUMBER(5) DEFAULT 0, --�� HIT�� (��ȸ��)
    PW VARCHAR2(30) NOT NULL, --�� ������ �� ��й�ȣ
    REF NUMBER(5,0) NOT NULL, -- �۱׷�(������ ���, �۹�ȣ��/�亯���� ��� ������ �۹�ȣ��)
    RE_STEP NUMBER(5) NOT NULL, --�׷쳻 ��� ����(���� 0)
    RE_INDENT NUMBER(5) NOT NULL, --�� LIST ��½� ���� �鿩���� ���� (����0)
    IP VARCHAR2 (20) NOT NULL, --���ۼ��� ��ǻ�� IP�ּ�
    RDATE DATE DEFAULT SYSDATE); --�۾� ����(��¥+�ð�)

-- 