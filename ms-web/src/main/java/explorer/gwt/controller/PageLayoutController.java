package explorer.gwt.controller;

import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import explorer.gwt.view.PageLayoutView;
import static explorer.gwt.util.AppEvents.INIT;

public class PageLayoutController extends Controller {

    private PageLayoutView pageLayoutView;

    public PageLayoutController() {
        pageLayoutView = new PageLayoutView(this);
        registerEventTypes(INIT);
    }

    @Override
    public void handleEvent(AppEvent appEvent) {
        if (appEvent.getType().equals(INIT)) {
            pageLayoutView = new PageLayoutView(this);
            forwardToView(pageLayoutView, appEvent);
        }
    }

}
