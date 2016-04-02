package explorer.gwt.util;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.TreeLoader;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import explorer.gwt.component.NavigationTreePanel;

public class NavigationTreePanelGenerator {

    public static TreePanel<BaseTreeModel> createLeftMenu(TreeLoader<BaseTreeModel> treeLoader) {
        TreeStore<BaseTreeModel> treeStore = new TreeStore<BaseTreeModel>(treeLoader);
        NavigationTreePanel treePanel = new NavigationTreePanel(treeStore);
        return treePanel;
    }
}
