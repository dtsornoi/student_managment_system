package persistence;

import model.MarksSheet;
import util.DBUtil;

import javax.persistence.EntityManager;

public class MarksSheetRepository {
    private EntityManager entityManager;

    public MarksSheetRepository() {
        entityManager = DBUtil.getEntityManager();
    }

    public void save(MarksSheet marksSheet){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(marksSheet);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void update(MarksSheet marksSheet){
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(marksSheet);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(MarksSheet marksSheet){
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(marksSheet));
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
