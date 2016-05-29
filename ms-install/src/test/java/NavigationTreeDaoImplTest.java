import explorer.NavigationTreeDao;
import explorer.NavigationTreeNode;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/application-dao-module-context.xml", "classpath:/application-datasource-context.xml"})
public class NavigationTreeDaoImplTest {

    @Resource
    private NavigationTreeDao navigationTreeDao;

    @Test
    @Transactional
    public void getNavigationTreeNodes() {
        List<NavigationTreeNode> treeNodeList = navigationTreeDao.getNavigationTreeNodes(NavigationTreeNode.NodeType.LEAF);
        for (NavigationTreeNode treeNode : treeNodeList) {
            System.out.println(treeNode.getNodeName());
        }
        assertThat(treeNodeList, is(notNullValue()));
    }
}
