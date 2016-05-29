package explorer;

import abs.AbstractCrudDao;
import abs.AbstractDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NavigationTreeDaoImpl extends AbstractCrudDao<NavigationTreeNode> implements NavigationTreeDao {

    @Override
    public Class getClassType() {
        return NavigationTreeNode.class;
    }

    public List<NavigationTreeNode> getNavigationTreeNodes(NavigationTreeNode.NodeType nodeType) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("nodeType", nodeType));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }

}
