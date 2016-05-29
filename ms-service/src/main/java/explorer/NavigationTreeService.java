package explorer;

import java.util.List;

public interface NavigationTreeService<T> {

    List<T> getNavigationTreeNodes(NavigationTreeNode.NodeType nodeType);

}
