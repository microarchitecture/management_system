package restriction;

import parentEntity.ParentId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by Alex on 13.11.2016.
 */
@Entity
@Table(name = "TEST_TABLE")
public class TestTable extends ParentId {

    @Column(name = "TEST_VALUE")
    private String testValue;

    public String getTestValue() {
        return testValue;
    }

    public void setTestValue(String testValue) {
        this.testValue = testValue;
    }
}
