package persistence;

import model.Course;
import model.Grades;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class GradesRepository {
    private EntityManager entityManager;

    public GradesRepository() {
        entityManager = DBUtil.getEntityManager();
    }

    public void save(Grades grades){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(grades);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void update(Grades grades){
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(grades);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(Grades grades){
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(grades));
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<Grades> allGrades(){
        String sql = "FROM Grades";
        return entityManager.createQuery(sql).getResultList();
    }

    public Course findCourseByName(Course course){
        String sql = "FROM Course c WHERE c.courseName = :name";
        return (Course) entityManager.createQuery(sql).setParameter("name", course.getCourseName()).getSingleResult();
    }

}
