package value.set;

import attribute.desc.AttributeDesc;
import parentEntity.ParentId;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "VALUE_SET")
public class ValueSet extends ParentId {

    @Column(name = "VALUE_SET_NAME")
    private String valueSetName;

    @OneToMany(mappedBy = "valueSetId")
    private List<ValueSetValue> valueSetValues;

    @OneToMany(mappedBy = "valueSetId", fetch = FetchType.LAZY)
    private List<ValueSetValueColumn> valueSetValueColumns;

//    @OneToMany(mappedBy = "valueSetId", fetch = FetchType.LAZY)
//    private List<AttributeDesc> attributeDescs;


    public void setValueSetName(String valueSetName) {
        this.valueSetName = valueSetName;
    }

    public void setValueSetValues(List<ValueSetValue> valueSetValues) {
        this.valueSetValues = valueSetValues;
    }

    public void setValueSetValueColumns(List<ValueSetValueColumn> valueSetValueColumns) {
        this.valueSetValueColumns = valueSetValueColumns;
    }

    public String getValueSetName() {
        return valueSetName;
    }

    public List<ValueSetValue> getValueSetValues() {
        return valueSetValues;
    }

    public List<ValueSetValueColumn> getValueSetValueColumns() {
        return valueSetValueColumns;
    }
}
