package explorer.gwt.server;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import explorer.NavigationTreeNode;
import explorer.NavigationTreeService;
import explorer.NavigationTreeServiceImpl;
import explorer.gwt.client.GwtNavigationTreeService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.persistence.Query;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import static explorer.gwt.util.NavigationTreeModelDataConverter.convertToBaseTreeModelList;

import java.util.List;

@Component
public class GwtNavigationTreeServiceImpl extends RemoteServiceServlet implements GwtNavigationTreeService {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        WebApplicationContextUtils
                .getWebApplicationContext(config.getServletContext())
                .getAutowireCapableBeanFactory()
                .autowireBean(this);
    }

    @Autowired
    private ServletContext servletContext;

    @Resource(name = "navigationTreeServiceImpl")
    private NavigationTreeService navigationTreeServiceImpl;

    public List<BaseTreeModel> getNavigationTreeNodes() {
        List<NavigationTreeNode> nodesList = navigationTreeServiceImpl.getNavigationTreeNodes();
        List<BaseTreeModel> convertedNodesList = convertToBaseTreeModelList(nodesList);
        return convertedNodesList;
    }

}