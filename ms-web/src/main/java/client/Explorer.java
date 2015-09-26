package client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;

/**
 * Created by Alex on 24.09.2015.
 */
public class Explorer implements EntryPoint {
    public void onModuleLoad() {
        Button button = new Button("WoW");
        RootPanel.get().add(button);
    }
}
