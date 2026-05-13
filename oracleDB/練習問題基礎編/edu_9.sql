SELECT COUNT(*) AS "numberOfEmployees" FROM emp;

SELECT MAX(sal) AS "給与(最大値)", 
MIN(sal) AS "給与(最小値)", 
SUM(sal) AS "給与(合計値)" FROM emp;

SELECT job, COUNT(*) AS "行数" FROM emp GROUP BY job;