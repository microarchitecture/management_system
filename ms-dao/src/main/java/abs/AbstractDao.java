package abs;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

public abstract class AbstractDao<T> {

    private EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    private Session session;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    protected EntityManager getEntityManager() {
        if (entityManager == null) {
            return entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }

    protected Session getSession() {
        if (session == null) {
            session = entityManager.unwrap(Session.class);
        }
        return session;
    }

    public abstract Class<T> getClassType();

    public Criteria getCriteria() {
        Criteria criteria = getSession().createCriteria(getClassType());
        return criteria;
    }

    public Criteria getCriteria(Class<T> entityClass) {
        Criteria criteria = getSession().createCriteria(entityClass);
        return criteria;
    }

    public Query createHqlQuery(String hqlQuery) {
        Query query = getSession().createQuery(hqlQuery);
        return query;
    }

    public SQLQuery createSqlQuery(String sqlQuery) {
        SQLQuery query = getSession().createSQLQuery(sqlQuery);
        return query;
    }

}
