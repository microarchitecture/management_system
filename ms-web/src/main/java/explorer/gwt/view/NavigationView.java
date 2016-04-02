package explorer.gwt.view;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.TreeLoader;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.View;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;

import static explorer.gwt.util.NavigationTreePanelGenerator.createLeftMenu;
import static explorer.gwt.util.AppEvents.LEFT_MENU;

public class NavigationView extends View {

    private static final String WEST_PANEL_TITLE = "westPanel";
    private Controller controller;

    public NavigationView(Controller controller) {
        super(controller);
        this.controller = controller;
    }

    @Override
    protected void handleEvent(AppEvent appEvent) {
        if (appEvent.getType().equals(LEFT_MENU)) {
            TreeLoader<BaseTreeModel> loader = appEvent.getData();
            onLeftMenuShown(loader);
        }
    }

    private void onLeftMenuShown(TreeLoader<BaseTreeModel> loader) {
        ContentPanel westPanel = (ContentPanel) Registry.get(WEST_PANEL_TITLE);
        westPanel.setLayout(new FitLayout());
        TreePanel<BaseTreeModel> treePanel = createLeftMenu(loader);
        westPanel.add(treePanel);
        loader.load();
    }
}
