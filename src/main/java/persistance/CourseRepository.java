package persistance;

import model.Course;
import util.DBUtil;

import javax.persistence.EntityManager;

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
}
