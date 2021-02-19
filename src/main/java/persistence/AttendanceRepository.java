package persistence;

import model.Attendance;
import util.DBUtil;

import javax.persistence.EntityManager;

public class AttendanceRepository {
    private EntityManager entityManager;


    public AttendanceRepository() {
        entityManager = DBUtil.getEntityManager();
    }

    public void save(Attendance attendance){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(attendance);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void update(Attendance attendance){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(attendance);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(Attendance attendance){
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(attendance));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

}
