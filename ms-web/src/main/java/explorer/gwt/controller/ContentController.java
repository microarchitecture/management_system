package explorer.gwt.controller;

import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import explorer.gwt.view.ContentView;
import static explorer.gwt.util.AppEvents.INIT;

public class ContentController extends Controller{

    private ContentView contentView;

    public ContentController() {
        contentView = new ContentView(this);
        registerEventTypes(INIT);
    }

    @Override
    public void handleEvent(AppEvent appEvent) {
        if (appEvent.getType().equals(INIT)) {
            forwardToView(contentView, appEvent);
        }
    }
}
