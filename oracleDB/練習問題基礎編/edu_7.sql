SELECT ename, superior FROM emp WHERE superior IS NOT NULL;

SELECT ename, sal, job FROM emp WHERE sal <= 300000;

SELECT ename, job, deptno FROM emp WHERE job = 'SE' AND deptno = '01';

SELECT ename, job, deptno FROM emp WHERE job = 'PL' OR deptno = '01';


SELECT empno, ename FROM emp WHERE ename LIKE '%城%';

SELECT ename, hiredate FROM emp WHERE hiredate BETWEEN 
'2000/01/01' AND '2001/12/31';