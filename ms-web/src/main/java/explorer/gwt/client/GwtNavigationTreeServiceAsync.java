package explorer.gwt.client;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

public interface GwtNavigationTreeServiceAsync  {

    void getNavigationTreeNodes(AsyncCallback<List<BaseTreeModel>> callback);

}
