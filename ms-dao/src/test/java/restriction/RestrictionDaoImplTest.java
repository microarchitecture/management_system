package restriction;

import attribute.desc.AttributeDesc;
import org.joda.time.LocalDateTime;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Alex on 13.11.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-integration-dao-context.xml"})
public class RestrictionDaoImplTest {

    @Autowired
    private RestrictionDaoImpl restrictionDao;

    @Test
    @Transactional
    public void testGetRestrictionTypeByName() {
        RestrictionType result = restrictionDao.getRestrictionTypeByName("VaR");
        List<AttributeDesc> attributes = result.getAttributeDescs();
        assertThat(result).isNotNull();
        assertThat(attributes).isNotNull();
    }

    @Test
    @Transactional
    public void testSaveTestTable() {
        TestTable table = new TestTable();
        table.setTestValue("value has ben saved");
        restrictionDao.saveTestTable(table);
    }

    @Ignore
    @Test
    @Transactional
    @Rollback(false)
    public void testSaveRestriction() {
        RestrictionType restrictionType = restrictionDao.getRestrictionTypeByName("VaR");

        RestrictionRef restrictionRef = getRestrictionRef();
        Restriction restrictionToSave = getRestriction();

        restrictionRef.setRestrictionTypeId(restrictionType);
        restrictionRef.setRestrictionId(restrictionToSave);

        restrictionToSave.setRestrictionType(restrictionType);

        restrictionDao.saveRestrictionRef(restrictionRef);
    }

    private Restriction getRestriction() {
        Restriction restriction = new Restriction();
        restriction.setActive(true);
        restriction.setDateFrom(new LocalDateTime());
        restriction.setDateTo(new LocalDateTime(9990, 12, 31, 23, 0));
        restriction.setRestrictionValue(new BigDecimal(10.2));
        restriction.setAttribute1("ATTR_1");
        restriction.setAttribute2("ATTR_2");
        restriction.setAttribute3("ATTR_3");
        return restriction;
    }

    private RestrictionRef getRestrictionRef() {
        RestrictionRef restrictionRef = new RestrictionRef();
        return restrictionRef;
    }

}
