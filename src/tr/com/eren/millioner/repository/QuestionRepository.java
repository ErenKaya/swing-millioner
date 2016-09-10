package tr.com.eren.millioner.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import tr.com.eren.millioner.entity.Question;

public class QuestionRepository {

    public List<Question> list() {

        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createQuery("select question from Question as question");
        List<Question> questionList = query.getResultList();
        entityManager.close();
        return questionList;

    }

    public EntityManager getEntityManager() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("kimMilyonerOlmakIsterPU");
        EntityManager entityManager = managerFactory.createEntityManager();
        return entityManager;
    }

    public void insert(Question question) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(question);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(Question question) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(question);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(long questionId) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Question question = entityManager.getReference(Question.class, questionId);
        entityManager.remove(question);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Question find(long questionId) {
        EntityManager entityManager = getEntityManager();
        Question question = entityManager.find(Question.class, questionId);
        entityManager.close();
        return question;
    }

}
