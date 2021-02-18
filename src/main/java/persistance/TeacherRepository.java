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
}
