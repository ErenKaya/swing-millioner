package tr.com.eren.millioner.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import tr.com.eren.millioner.entity.MillionerUser;

public class MillionerUserRepository {

    public List<MillionerUser> list() {

        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createQuery("select millionerUser from MillionerUser as millionerUser");
        List<MillionerUser> millionerUserList = query.getResultList();
        entityManager.close();
        return millionerUserList;
    }

    public EntityManager getEntityManager() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("kimMilyonerOlmakIsterPU");
        EntityManager entityManager = managerFactory.createEntityManager();
        return entityManager;
    }

    public void insert(MillionerUser millionerUser) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(millionerUser);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(MillionerUser millionerUser) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(millionerUser);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(long millionerUserId) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        MillionerUser millionerUser = entityManager.getReference(MillionerUser.class, millionerUserId);
        entityManager.remove(millionerUser);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public MillionerUser find(long millionerUserId) {
        EntityManager entityManager = getEntityManager();
        MillionerUser millionerUser = entityManager.find(MillionerUser.class, millionerUserId);
        entityManager.close();
        return millionerUser;
    }

}
