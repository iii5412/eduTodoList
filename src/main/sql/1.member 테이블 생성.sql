DROP TABLE MEMBER IF EXISTS CASCADE;
CREATE TABLE MEMBER
(
    id        INTEGER,
    member_id VARCHAR(10) NOT NULL,
    password  VARCHAR(20) NOT NULL,
    name      VARCHAR(10) NOT NULL,
    regist_dt TIMESTAMP   NOT NULL,
    modify_dt TIMESTAMP   NOT NULL,
    PRIMARY KEY (id)
);

CREATE SEQUENCE member_seq START WITH 1 INCREMENT BY 50;
DROP SEQUENCE MEMBER_SEQ;


