package persistance;

import model.Teacher;
import util.DBUtil;

import javax.persistence.EntityManager;

public class TeacherRepository {
    private EntityManager entityManager;

    public TeacherRepository() {
        entityManager = DBUtil.getEntityManager();
    }

    public void save(Teacher teacher){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(teacher);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void update(Teacher teacher){
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(teacher);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(Teacher teacher){
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(teacher);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
