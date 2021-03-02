package persistence;

import model.Grades;
import util.DBUtil;

import javax.persistence.EntityManager;

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
}
