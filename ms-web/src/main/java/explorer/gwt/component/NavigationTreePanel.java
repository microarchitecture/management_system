package explorer.gwt.component;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;

public class NavigationTreePanel extends TreePanel<BaseTreeModel> {

    public NavigationTreePanel(TreeStore<BaseTreeModel> treeStore) {
        super(treeStore);
    }


}
