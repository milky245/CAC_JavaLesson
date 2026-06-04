-- spring_userで接続後、以下を実行する

DROP SEQUENCE seq_comments;
DROP TABLE comments CASCADE CONSTRAINTS;
DROP TABLE users CASCADE CONSTRAINTS;

CREATE TABLE users (
  id NUMBER(4) PRIMARY KEY,
  user_name VARCHAR2(100) ,
  password VARCHAR2(16)
);
CREATE TABLE comments (
  id NUMBER(3) PRIMARY KEY,
  created_time TIMESTAMP,
  text VARCHAR2(100 CHAR),
  user_id NUMBER(4) REFERENCES users(id)
);


-- seq_categories シーケンスを作成する。
CREATE SEQUENCE seq_comments NOCACHE;

-- users テーブルにレコードを追加する。
INSERT INTO users VALUES (1111,'Tanaka Shingo','aaa@123');
INSERT INTO users VALUES (2222,'Saito Yuko','bbb@456');

-- comments テーブルにレコードを追加する。
INSERT INTO comments VALUES (seq_comments.nextval,'2022-5-1','testコメント',1111);
INSERT INTO comments VALUES (seq_comments.nextval,'2022-5-2','Hello!!',1111);
INSERT INTO comments VALUES (seq_comments.nextval,'2022-5-3','SpringBoot!!!',2222);
INSERT INTO comments VALUES (seq_comments.nextval,'2022-5-4','Hey',2222);


COMMIT;
