package explorer.gwt.client;

import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.google.gwt.core.client.EntryPoint;
import explorer.gwt.controller.ContentController;
import explorer.gwt.controller.NavigationController;
import explorer.gwt.controller.PageLayoutController;

import static explorer.gwt.util.AppEvents.INIT;

public class Explorer implements EntryPoint {

    private void registerPageDefinition() {

    }

    private void registerGwtService() {

    }

    public void onModuleLoad() {
        Dispatcher dispatcher = Dispatcher.get();
        dispatcher.addController(new NavigationController());
        dispatcher.addController(new ContentController());
        dispatcher.addController(new PageLayoutController());
        dispatcher.dispatch(INIT);
    }
}
