CREATE TABLE ES_GROUPS(GROUP_ID NUMBER(10) PRIMARY KEY, GROUP_NAME VARCHAR(50) NOT NULL, CREATED_BY VARCHAR(10),CREATED_DATE TIMESTAMP);

CREATE TABLE ES_GROUP_MEMBERS(GROUP_MEMBER_ID NUMBER(10) PRIMARY KEY, MEMBER_NAME VARCHAR(10),CREATED_BY VARCHAR(10),CREATED_DATE TIMESTAMP,  GROUP_ID NUMBER(10) , FOREIGN KEY (GROUP_ID) 
    REFERENCES ES_GROUPS(GROUP_ID));