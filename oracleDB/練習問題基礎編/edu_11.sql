SELECT e.empno, e.ename, d.dname FROM 
emp e INNER JOIN dept d 
ON e.deptno = d.deptno;

SELECT e.empno, e.ename, d.dname FROM 
emp e RIGHT OUTER JOIN dept d 
ON e.deptno = d.deptno;