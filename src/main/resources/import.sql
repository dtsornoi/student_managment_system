INSERT INTO attendance (attended, lectures_delivered)
SELECT 5, true
WHERE NOT EXISTS
    (SELECT *
     FROM attendance
     WHERE attended = true AND lectures_delivered = 5);

INSERT INTO course (course_name)
SELECT 'Java Fundamentals'
WHERE NOT EXISTS
    (SELECT *
     FROM course
     WHERE course_name = 'Java Fundamentals');

INSERT INTO students (address, first_name, last_name)
SELECT 'Narva mnt 13','John','Smith'
WHERE NOT EXISTS
    (SELECT *
     FROM students
     WHERE address = 'Tuukri 15' AND first_name = 'Indrek' AND last_name = 'Kaul');

INSERT INTO teachers (teacher_address, teacher_name)
SELECT 'Ehitajate tee 5', 'Hatef Palizgar'
WHERE NOT EXISTS
    (SELECT *
     FROM teachers
     WHERE teacher_address = 'Ehitajate tee 5' AND teacher_name = 'Hatef Palizgar');




