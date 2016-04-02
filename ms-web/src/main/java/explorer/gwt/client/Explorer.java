package explorer.gwt.client;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import explorer.gwt.controller.ContentController;
import explorer.gwt.controller.NavigationController;
import explorer.gwt.controller.PageLayoutController;

import static explorer.gwt.util.AppEvents.INIT;

public class Explorer implements EntryPoint {

    private void registerGwtService() {
        Registry.register("GwtNavigationTreeService", GWT.create(GwtNavigationTreeService.class));
    }

    @Override
    public void onModuleLoad() {
        registerGwtService();
        Dispatcher dispatcher = Dispatcher.get();
        dispatcher.addController(new NavigationController());
        dispatcher.addController(new ContentController());
        dispatcher.addController(new PageLayoutController());
        dispatcher.dispatch(INIT);
    }
}
