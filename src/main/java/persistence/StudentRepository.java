package persistence;

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

    public void update(Student student){
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(student);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(Student student){
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(student));
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
