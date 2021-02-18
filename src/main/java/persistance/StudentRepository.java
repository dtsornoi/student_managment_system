package persistance;

import model.Student;
import util.DBUtil;

import javax.persistence.EntityManager;

public class StudentRepository {
    private EntityManager entityManager;

    public StudentRepository() {
        entityManager = DBUtil.getEntityManager();
    }

    public void save(Student student){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }

    }
}
