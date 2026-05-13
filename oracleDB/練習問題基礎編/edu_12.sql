CREATE SEQUENCE dept_seq 
START WITH 10 
INCREMENT BY 1;

INSERT INTO dept VALUES (dept_seq.NEXTVAL, '経営統括部', 'Redmond, WA 98052-7329 USA'); 
INSERT INTO dept VALUES (dept_seq. NEXTVAL, 'ネットワーク事業部', NULL);