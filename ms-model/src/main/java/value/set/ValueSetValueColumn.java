package value.set;

import parentEntity.ParentId;

import javax.persistence.*;

/**
 * Created by Alex on 16.10.2016.
 */
@Entity
@Table(name = "VALUE_SET_VALUE_COLUMN")
public class ValueSetValueColumn extends ParentId {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "VALUE_SET_ID")
    private ValueSet valueSetId;

    @Column(name = "COLUMN_NAME")
    private String columnName;

    @Column(name = "COLUMN_DESC")
    private String columnDesc;

    public ValueSet getValueSetId() {
        return valueSetId;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getColumnDesc() {
        return columnDesc;
    }
}
