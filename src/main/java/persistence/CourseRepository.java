package persistence;

import model.Course;
import model.Person;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseRepository {
    private EntityManager entityManager;

    public CourseRepository() {
        entityManager = DBUtil.getEntityManager();
    }

    public void save(Course course){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void update(Course course){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(course);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(Course course){
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(course));
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<Course> allCourses(){
        String sql = "FROM Course";
        return entityManager.createQuery(sql).getResultList();
    }

    public Course findCourseByName(Course course){
        String sql = "FROM Course c WHERE c.courseName = :name";
        return (Course) entityManager.createQuery(sql).setParameter("name", course.getCourseName()).getSingleResult();
    }
}
