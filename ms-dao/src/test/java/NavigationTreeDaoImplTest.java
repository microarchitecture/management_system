import explorer.NavigationTreeDao;
import explorer.NavigationTreeNode;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/application-datasource-context.xml")
public class NavigationTreeDaoImplTest {

    @Resource(name = "navigationTreeDao")
    private NavigationTreeDao navigationTreeDao;

    @Test
    @Transactional
    public void getNavigationTreeNodes() {
        List<NavigationTreeNode> treeNodeList = navigationTreeDao.getNavigationTreeNodes();
        for (NavigationTreeNode treeNode : treeNodeList) {
            System.out.println(treeNode.getNodeName());
        }
        assertThat(treeNodeList, is(notNullValue()));
    }
}
