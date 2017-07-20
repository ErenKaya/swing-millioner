package tr.com.eren.millioner.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import tr.com.eren.millioner.entity.WrongQuestion;

public class WrongQuestionRepository {

    public List<WrongQuestion> list() {

        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createQuery("select wrongQuestion from WrongQuestion as wrongQuestion");
        List<WrongQuestion> questionList = query.getResultList();
        entityManager.close();
        return questionList;

    }

    public EntityManager getEntityManager() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("kimMilyonerOlmakIsterPU");
        EntityManager entityManager = managerFactory.createEntityManager();
        return entityManager;
    }

    public void insert(WrongQuestion question) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(question);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(WrongQuestion question) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(question);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(long questionId) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        WrongQuestion question = entityManager.getReference(WrongQuestion.class, questionId);
        entityManager.remove(question);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public WrongQuestion find(long questionId) {
        EntityManager entityManager = getEntityManager();
        WrongQuestion question = entityManager.find(WrongQuestion.class, questionId);
        entityManager.close();
        return question;
    }

}
