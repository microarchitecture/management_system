package explorer.gwt.view;

import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.View;

public class NavigationView extends View {

    private Controller controller;

    public NavigationView(Controller controller) {
        super(controller);
        this.controller = controller;
    }

    @Override
    protected void handleEvent(AppEvent appEvent) {
        System.out.println("INIT event received by NavigationView");
    }
}
