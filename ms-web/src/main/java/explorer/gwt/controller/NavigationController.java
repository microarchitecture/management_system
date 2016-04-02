package explorer.gwt.controller;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.TreeLoader;
import com.extjs.gxt.ui.client.data.BaseTreeLoader;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.google.gwt.user.client.rpc.AsyncCallback;
import explorer.gwt.client.GwtNavigationTreeServiceAsync;
import explorer.gwt.view.NavigationView;

import java.util.List;

import static explorer.gwt.util.AppEvents.INIT;
import static explorer.gwt.util.AppEvents.LEFT_MENU;

public class NavigationController extends Controller {

    private NavigationView navigationView;

    private GwtNavigationTreeServiceAsync service;

    public NavigationController() {
        registerEventTypes(INIT);
        registerEventTypes(LEFT_MENU);
    }

    @Override
    public void handleEvent(AppEvent appEvent) {
        if (appEvent.getType().equals(INIT)) {
            onInit();
            forwardToView(navigationView, appEvent);
        }
        if (appEvent.getType().equals(LEFT_MENU)) {
            TreeLoader<BaseTreeModel> loader = getNavigationTreePanelLoader();
            appEvent.setData(loader);
            forwardToView(navigationView, appEvent);
        }
    }

    private void onInit() {
        navigationView = new NavigationView(this);
        service = (GwtNavigationTreeServiceAsync) Registry.get("GwtNavigationTreeService");
    }

    private TreeLoader<BaseTreeModel> getNavigationTreePanelLoader() {
        RpcProxy<List<BaseTreeModel>> proxy = new RpcProxy<List<BaseTreeModel>>() {
            @Override
            protected void load(Object o, AsyncCallback<List<BaseTreeModel>> asyncCallback) {
                service.getNavigationTreeNodes(asyncCallback);
            }
        };
        TreeLoader<BaseTreeModel> loader = new BaseTreeLoader<BaseTreeModel>(proxy);
        return loader;
    }
}
