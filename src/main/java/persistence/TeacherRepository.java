package persistence;

import model.Student;
import model.Teacher;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

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
            entityManager.remove(entityManager.merge(teacher));
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }


    public List<Teacher> allTeachers() {
        String sql = "FROM Teacher";

        return entityManager.createQuery(sql).getResultList();
    }
}
