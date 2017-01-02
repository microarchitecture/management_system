package value.set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Alex on 30.10.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-integration-dao-context.xml"})
@Transactional
public class ValueSetDaoImplIntTest {

    @Autowired
    private ValueSetDao valueSetDao;

    @Test
    public void testGetValueSetByIdReturnsCorrectResult() {
        ValueSet result = valueSetDao.getValueSetById(10l);
        assertThat(result).isNotNull();
        assertThat(result.getValueSetValues()).isNotEmpty();
        assertThat(result.getValueSetName()).isEqualTo("RISK_CLASS_VALUES");
    }

    @Test
    public void testGetValueSetByNameReturnsCorrectResult() {
        ValueSet result = valueSetDao.getValueSetByName("RISK_CLASS_VALUES");
        assertThat(result).isNotNull();
        assertThat(result.getValueSetValues()).isNotEmpty();
        assertThat(result.getValueSetName()).isEqualTo("RISK_CLASS_VALUES");
    }

}
