package explorer.gwt.client;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RemoteServiceRelativePath(value = "gwtNavigationTreeService")
public interface GwtNavigationTreeService extends RemoteService {

    public List<BaseTreeModel> getNavigationTreeNodes();

}
