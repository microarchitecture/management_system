package explorer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("navigationTreeServiceImpl")
public class NavigationTreeServiceImpl implements NavigationTreeService<NavigationTreeNode> {

    @Resource
    private NavigationTreeDao navigationTreeDaoImpl;

    @Transactional(readOnly = true)
    public List<NavigationTreeNode> getNavigationTreeNodes(NavigationTreeNode.NodeType nodeType) {
        List<NavigationTreeNode> resultList = navigationTreeDaoImpl.getNavigationTreeNodes(nodeType);
        return resultList;
    }

}
