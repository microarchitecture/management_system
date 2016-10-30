package abs;

public abstract class AbstractCrudDao<T> extends AbstractDao {

    public T get(Long id) {
        T entity = (T) getEntityManager().find(getClassType(), id);
        return entity;
    }

}
