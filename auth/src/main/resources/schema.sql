-- Drop tables if they exist (in reverse order due to foreign key dependencies)
DROP TABLE IF EXISTS enrollment;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS student;

-- Create the student table
CREATE TABLE student
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name      VARCHAR(50)  NOT NULL,
    last_name       VARCHAR(50)  NOT NULL,
    email           VARCHAR(100) NOT NULL UNIQUE,
    date_of_birth   DATE,
    enrollment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create the course table
CREATE TABLE course
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    course_code VARCHAR(10)  NOT NULL UNIQUE,
    course_name VARCHAR(100) NOT NULL,
    description VARCHAR(255)
);

-- Create the enrollment table to link students and courses
CREATE TABLE enrollment
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    student_id      BIGINT NOT NULL,
    course_id       BIGINT NOT NULL,
    enrollment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES student (id),
    FOREIGN KEY (course_id) REFERENCES course (id)
);
