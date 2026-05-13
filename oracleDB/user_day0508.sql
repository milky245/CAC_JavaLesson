CREATE TABLE dept( 
  dept_id NUMBER(2) PRIMARY KEY, 
  dept_name VARCHAR2(20) NOT NULL 
); 
 
CREATE TABLE employee ( 
  emp_id NUMBER(5) PRIMARY KEY, 
  emp_pass VARCHAR2(10) NOT NULL, 
  emp_name VARCHAR2(20) NOT NULL, 
  gender NUMBER(1) NOT NULL, 
  address VARCHAR2(30), 
  birthday DATE, 
  dept_id NUMBER(2) NOT NULL REFERENCES dept(dept_id) 
); 

INSERT INTO dept VALUES (1,'総務部'); 
INSERT INTO dept VALUES (2,'営業部'); 
INSERT INTO dept VALUES (3,'経理部'); 
INSERT INTO dept VALUES (4,'資材部'); 
 
INSERT INTO employee VALUES (1,'1111','山田太郎',1,'千葉県','2009/09/09',1); 
INSERT INTO employee VALUES (2,'2222','高橋健一',1,'埼玉県','2009/09/10',1); 
INSERT INTO employee VALUES (3,'3333','鈴木花子',2,'東京都','2009/09/10',2); 
INSERT INTO employee VALUES (4,'4444','佐々木良子',2,'埼玉県','2009/09/14',3); 
INSERT INTO employee VALUES (5,'mypass','Peter',1,'China','2001/06/01',2);

COMMIT;