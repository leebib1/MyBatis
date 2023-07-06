SELECT * FROM STUDENT;
SELECT STUDENT_NO AS STUDENTNO,
	 		STUDENT_NAME AS STUDENTNAME,
	 		STUDENT_TEL AS STUDENTEL,
	 		STUDENT_EMAIL AS STUDENTEMAIL,
	 		STUDENT_ADDR As STUDENTADDRESS,
	 		REG_DATE
	 	FROM STUDENT WHERE STUDENT_NO=1;
create table student(
		student_no number primary key,
		student_name varchar2(30) not null,
		student_tel char(11) not null,
		student_email varchar2(50),
		student_addr varchar2(256),
		reg_date date default sysdate
	);

	create sequence seq_student;

	insert into student values (seq_student.nextval, '홍길동', '01012345678', 'honggd@google.com','서울시 강남구', default);
COMMIT;