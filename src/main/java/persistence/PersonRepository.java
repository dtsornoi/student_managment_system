package persistence;

import model.Course;
import model.Person;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class PersonRepository {
    private EntityManager entityManager;

    public PersonRepository() {
        entityManager = DBUtil.getEntityManager();
    }

    public void save(Person person){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(person);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void update(Person person){
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(person);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(Person person){
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(person));
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<Person> allStudents() {
        String sql = "FROM Person p WHERE p.isTeacher = false";

        return entityManager.createQuery(sql).getResultList();
    }

    public List<Person> allTeachers(){
        String sql = "FROM Person p WHERE p.isTeacher = true";

        return entityManager.createQuery(sql).getResultList();
    }

    public Person findTeacherByName(Person person){
        String sql = "FROM Person p WHERE p.firstName = :name AND p.isTeacher = true";
        return (Person) entityManager.createQuery(sql).setParameter("name", person.getFirstName()).getSingleResult();
    }

    public Person findStudentByName(Person person){
        String sql = "FROM Person p WHERE p.firstName = :name AND p.isTeacher = false";
        return (Person) entityManager.createQuery(sql).setParameter("name", person.getFirstName()).getSingleResult();
    }

    public Person findStudentByNameAndCourse(String name, Course course){
        String sql = "FROM Person p WHERE p.firstName = :name AND p.course.courseName = :courseName";

        return entityManager.createQuery(sql, Person.class)
                .setParameter("name", name)
                .setParameter("courseName", course.getCourseName())
                .getSingleResult();
    }
}
