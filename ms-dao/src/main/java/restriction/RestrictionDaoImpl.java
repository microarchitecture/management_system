package restriction;

import abs.AbstractCrudDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by Alex on 13.11.2016.
 */
@Repository
public class RestrictionDaoImpl extends AbstractCrudDao<Restriction> implements RestrictionDao {

    @Override
    public Class getClassType() {
        return Restriction.class;
    }

    @Override
    public void saveRestrictionRef(RestrictionRef restrictionRef) {
        getEntityManager().persist(restrictionRef);
    }

    @Override
    public void saveRestriction(Restriction restriction) {
        save(restriction);
    }

    @Override
    public RestrictionType getRestrictionTypeByName(String restrictionTypeName) {
        Criteria criteria = getSession().createCriteria(RestrictionType.class);
        criteria.add(Restrictions.eq("restrictionTypeName", restrictionTypeName));
        return (RestrictionType) criteria.uniqueResult();
    }

    @Override
    public void saveTestTable(TestTable testTable) {
        getEntityManager().persist(testTable);
    }
}
