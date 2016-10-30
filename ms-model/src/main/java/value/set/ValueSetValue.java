package value.set;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Type;
import parentEntity.ParentId;

import javax.persistence.*;

/**
 * Created by Alex on 16.10.2016.
 */
@Entity
@Table(name = "VALUE_SET_VALUE")
public class ValueSetValue extends ParentId {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "VALUE_SET_ID")
    private ValueSet valueSetId;

    @Column(name = "VALUE")
    private String value;

    @Column(name = "IS_ACTIVE")
    @Type(type = "yes_no")
    private Boolean isActive;

    public ValueSet getValueSetId() {
        return valueSetId;
    }

    public String getValue() {
        return value;
    }

    public Boolean getActive() {
        return isActive;
    }
}
