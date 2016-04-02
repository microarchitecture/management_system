package explorer.gwt.view;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.mvc.View;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.user.client.ui.RootPanel;

import static com.extjs.gxt.ui.client.Style.LayoutRegion.CENTER;
import static com.extjs.gxt.ui.client.Style.LayoutRegion.WEST;

import static explorer.gwt.util.AppEvents.LEFT_MENU;

public class PageLayoutView extends View {

    private static final String WEST_PANEL_TITLE = "westPanel";
    private static final String EAST_PANEL_TITLE = "eastPanel";
    private static final String MENU_TAG = "Menu";

    private Controller controller;

    private ContentPanel westPanel;
    private ContentPanel eastPanel;

    private Viewport viewport;

    public PageLayoutView(Controller controller) {
        super(controller);
        this.controller = controller;
    }

    @Override
    protected void handleEvent(AppEvent appEvent) {
        //switch initialize() on onInit()
    }

    @Override
    protected void initialize() {
        //does it needed?
        super.initialize();

        createMainLayout();
        createWestContainer();
        createEastContainer();
        finishContainerCreation();

        Dispatcher dispatcher = Dispatcher.get();
        dispatcher.dispatch(LEFT_MENU, null);
    }

    private void createMainLayout() {
        BorderLayout borderLayout = new BorderLayout();
        viewport = new Viewport();

        viewport.setLayout(borderLayout);
    }

    private void createWestContainer() {
        westPanel = new ContentPanel();
        westPanel.setTitle(WEST_PANEL_TITLE);
        westPanel.setHeadingText(MENU_TAG);
        westPanel.setCollapsible(false);

        BorderLayoutData layoutData = new BorderLayoutData(WEST, 200);
        viewport.add(westPanel, layoutData);
        Registry.register(WEST_PANEL_TITLE, westPanel);
    }

    private void createEastContainer() {
        eastPanel = new ContentPanel();
        eastPanel.setTitle(EAST_PANEL_TITLE);
        eastPanel.setCollapsible(false);

        BorderLayoutData layoutData = new BorderLayoutData(CENTER);
        viewport.add(eastPanel, layoutData);
        Registry.register(EAST_PANEL_TITLE, eastPanel);
    }

    private void finishContainerCreation() {
        RootPanel.get().add(viewport);
    }
}
