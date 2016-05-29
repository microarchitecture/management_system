package explorer;

import abs.AbstractDao;

import java.util.List;

public interface NavigationTreeDao {

    List<NavigationTreeNode> getNavigationTreeNodes(NavigationTreeNode.NodeType nodeType);

}
