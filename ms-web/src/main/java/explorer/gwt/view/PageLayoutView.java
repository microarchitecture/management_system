package explorer.gwt.view;

import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.View;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.user.client.ui.RootPanel;

import static com.extjs.gxt.ui.client.Style.LayoutRegion.CENTER;
import static com.extjs.gxt.ui.client.Style.LayoutRegion.WEST;

public class PageLayoutView extends View {

    private static final String WEST_PANEL_TITLE = "westPanel";
    private static final String EAST_PANEL_TITLE = "eastPanel";
    private static final String MENU_TAG = "MENU";

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
        System.out.println("INIT event received by PageLayoutView");
    }

    @Override
    protected void initialize() {
        //does it needed?
        super.initialize();

        createMainLayout();
        createWestContainer();
        createEastContainer();
        finishContainerCreation();
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
    }

    private void createEastContainer() {
        eastPanel = new ContentPanel();
        eastPanel.setTitle(EAST_PANEL_TITLE);
        eastPanel.setCollapsible(false);

        BorderLayoutData layoutData = new BorderLayoutData(CENTER);
        viewport.add(eastPanel, layoutData);
    }

    private void finishContainerCreation() {
        RootPanel.get().add(viewport);
    }
}
