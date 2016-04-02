package explorer;

import abs.AbstractCrudDao;
import abs.AbstractDao;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NavigationTreeDaoImpl extends AbstractCrudDao<NavigationTreeNode> implements NavigationTreeDao {

    @Override
    public Class getClassType() {
        return NavigationTreeNode.class;
    }

    public List<NavigationTreeNode> getNavigationTreeNodes() {
        Criteria criteria = getCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }

}
