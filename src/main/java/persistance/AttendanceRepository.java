package persistance;

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

}