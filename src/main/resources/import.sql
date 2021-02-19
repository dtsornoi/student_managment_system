INSERT INTO attendance (lectures_delivered, attended)
SELECT (5, true)
WHERE NOT EXISTS
    (SELECT lectures_delivered, attended
     FROM attendance
     WHERE lectures_delivered = 5 AND attended = true);

INSERT INTO course (course_name)
SELECT ('Java Fundamentals')
WHERE NOT EXISTS
    (SELECT course_name
     FROM course
     WHERE course_name = 'Java Fundamentals');

INSERT INTO students (first_name, last_name, address)
SELECT ('Indrek', 'Kaul','Tuukri 15')
WHERE NOT EXISTS
    (SELECT first_name, last_name, address
     FROM students
     WHERE first_name = 'Indrek' AND last_name = 'Kaul' AND address = 'Tuukri 15');

INSERT INTO teachers (teacher_name, teacher_address)
SELECT ('Hatef Palizgar', 'Ehitajate tee 5')
WHERE NOT EXISTS
    (SELECT teacher_name, teacher_address
     FROM teachers
     WHERE teacher_name_name = 'Hatef Palizgar' AND teacher_address = 'Ehitajate tee 5');




