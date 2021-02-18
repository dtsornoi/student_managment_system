package persistance;

import model.Login;
import util.DBUtil;

import javax.persistence.EntityManager;

public class LoginRepository {
    private EntityManager entityManager;

    public LoginRepository() {
        entityManager = DBUtil.getEntityManager();
    }

    public void save(Login login){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(login);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }

    }
}
