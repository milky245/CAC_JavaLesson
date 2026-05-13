UPDATE dept SET dname = '人事部' WHERE deptno = '04'; 

COMMIT; 

UPDATE emp SET superior = '鈴木 仁', job = 'SE', sal = 290000, 
deptno = '01' WHERE empno = '008'; 


COMMIT; 

DELETE FROM emp WHERE empno = '006'; 

COMMIT; 