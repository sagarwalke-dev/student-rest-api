DROP TABLE IF EXISTS TBL_SUBJECT;

/*subject table*/
CREATE TABLE TBL_SUBJECT (
  subject_id INT NOT NULL,
  title VARCHAR(100) NULL);

  /*Groups table*/
DROP TABLE IF EXISTS  TBL_GROUPS;
CREATE TABLE TBL_GROUPS ( 
  group_id INT NOT NULL,
  name VARCHAR(45) NULL);

  /*Teacher table*/
  DROP TABLE IF EXISTS  TBL_TEACHER;
  CREATE TABLE TBL_TEACHER(
  `teacher_id` INT NOT NULL,
  PRIMARY KEY (`teacher_id`),
  subject_id INT  NULL,
  group_id INT NULL,
    FOREIGN KEY (subject_id)
    REFERENCES TBL_SUBJECT(subject_id),
    FOREIGN KEY (group_id)
    REFERENCES TBL_GROUPS(group_id));
    
    /*Students table*/
    DROP TABLE IF EXISTS  TBL_STUDENTS;
  CREATE TABLE TBL_STUDENTS(
  `student_id` INT NOT NULL,
  PRIMARY KEY (`student_id`),
  first_name VARCHAR(100) NULL,
  last_name VARCHAR(100) NULL,
  group_id INT NULL,
    FOREIGN KEY (group_id)
    REFERENCES TBL_GROUPS(group_id));
    
    DROP TABLE IF EXISTS  TBL_MARKS;
  CREATE TABLE TBL_MARKS(
  `mark_id` INT NOT NULL,
  PRIMARY KEY (`mark_id`),
  date DATE NULL,
  mark INT NULL,
  student_id INT NULL,
  subject_id INT NULL,
    FOREIGN KEY (student_id)
    REFERENCES TBL_STUDENTS(student_id),
	FOREIGN KEY (subject_id)
    REFERENCES TBL_SUBJECT(subject_id));