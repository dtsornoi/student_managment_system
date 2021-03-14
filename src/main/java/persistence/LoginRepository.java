package persistence;

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

    public void update(Login login){
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(login);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(Login login){
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(login));
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public Login findByUsername(String username){
        String sql = "FROM Login l WHERE l.username=:username";

        return entityManager.createQuery(sql, Login.class).setParameter("username", username).getSingleResult();
    }

    public Login findByPassword(String password){
        String sql = "FROM Login l WHERE l.password=:password";

        return entityManager.createQuery(sql, Login.class).setParameter("password", password).getSingleResult();
    }
}
