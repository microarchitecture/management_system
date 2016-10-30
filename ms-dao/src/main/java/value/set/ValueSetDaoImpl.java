package value.set;

import abs.AbstractCrudDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by Alex on 30.10.2016.
 */
@Repository
public class ValueSetDaoImpl extends AbstractCrudDao<ValueSet> implements ValueSetDao {

    @Override
    public Class getClassType() {
        return ValueSet.class;
    }

    @Override
    public ValueSet getValueSetById(Long id) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("id", id));
        return (ValueSet) criteria.uniqueResult();

//        return get(id);
    }

    @Override
    public ValueSet getValueSetByName(String valueSetName) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("valueSetName", valueSetName));
        return (ValueSet) criteria.uniqueResult();
    }
}
