SELECT * FROM EMPLOYEE;
SELECT * FROM DEPARTMENT;
SELECT * FROM SAL_GRADE;
SELECT * FROM EMPLOYEE JOIN DEPARTMENT ON DEPT_CODE=DEPT_ID JOIN JOB USING(JOB_CODE);
SELECT * FROM JOB;