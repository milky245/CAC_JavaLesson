--2.table operation
CREATE TABLE dept (
    deptno VARCHAR2(2) PRIMARY KEY, -- 部門番号
    dname VARCHAR2(50) NOT NULL, -- 部門名
    loc VARCHAR2(100) -- 部門場所
);

CREATE TABLE emp (
    empno VARCHAR2(3) PRIMARY KEY, -- 社員番号
    ename VARCHAR2(20) NOT NULL, -- 社員名
    superior VARCHAR2(20), --上司
    hiredate DATE NOT NULL, -- 入社日
    sal NUMBER(10) NOT NULL, -- 給与
    job VARCHAR2(30),-- 職種
    deptno VARCHAR2(2), -- 部門番号
    /*
    部署テーブルの外部キー
    */
    CONSTRAINT fk_deptno FOREIGN KEY (deptno) 
                REFERENCES dept(deptno)
);