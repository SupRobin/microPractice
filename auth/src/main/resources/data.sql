-- Insert data into the student table
INSERT INTO student (first_name, last_name, email, date_of_birth, enrollment_date)
VALUES ('John', 'Doe', 'john.doe@example.com', '2000-01-15', '2025-01-10 08:30:00');

INSERT INTO student (first_name, last_name, email, date_of_birth, enrollment_date)
VALUES ('Jane', 'Smith', 'jane.smith@example.com', '1999-07-20', '2025-02-05 09:00:00');

-- Insert data into the course table
INSERT INTO course (course_code, course_name, description)
VALUES ('CS101', 'Introduction to Computer Science', 'Basics of computer science principles.');

INSERT INTO course (course_code, course_name, description)
VALUES ('MATH201', 'Calculus II', 'Advanced topics in calculus including integration techniques.');

-- Insert data into the enrollment table to link students and courses
INSERT INTO enrollment (student_id, course_id, enrollment_date)
VALUES (1, 1, '2025-01-15');

INSERT INTO enrollment (student_id, course_id, enrollment_date)
VALUES (1, 2, '2025-01-16');

INSERT INTO enrollment (student_id, course_id, enrollment_date)
VALUES (2, 1, '2025-02-06');