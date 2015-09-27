package explorer.gwt.controller;

import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import explorer.gwt.view.NavigationView;
import static explorer.gwt.util.AppEvents.INIT;

public class NavigationController extends Controller {

    private NavigationView navigationView;

    public NavigationController() {
        navigationView = new NavigationView(this);
        registerEventTypes(INIT);
    }

    @Override
    public void handleEvent(AppEvent appEvent) {
        if (appEvent.getType().equals(INIT)) {
            forwardToView(navigationView, appEvent);
        }
    }
}
