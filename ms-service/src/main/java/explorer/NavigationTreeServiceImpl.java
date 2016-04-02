package explorer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("navigationTreeServiceImpl")
public class NavigationTreeServiceImpl implements NavigationTreeService<NavigationTreeNode> {

    public NavigationTreeServiceImpl() {
        int x = 1;
    }

    @Resource
    private NavigationTreeDao navigationTreeDaoImpl;

    @Transactional
    public List<NavigationTreeNode> getNavigationTreeNodes() {
        List<NavigationTreeNode> resultList = navigationTreeDaoImpl.getNavigationTreeNodes();
        return resultList;
    }
}
