package explorer.gwt.client;

import com.extjs.gxt.ui.client.mvc.Dispatcher;
import explorer.NavigationTreeNode;
import explorer.gwt.model.PageDefinition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static explorer.gwt.util.AppEvents.SHOW_PAGE;

@Controller
public final class PageManager {

    public static void showPage(PageDefinition pageDefinition) {
        Dispatcher dispatcher = Dispatcher.get();
        dispatcher.dispatch(SHOW_PAGE, pageDefinition);
    }

}
