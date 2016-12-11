package value.set;

import attribute.desc.AttributeDesc;
import parentEntity.ParentId;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "VALUE_SET")
public class ValueSet extends ParentId {

    @Column(name = "VALUE_SET_NAME")
    private String valueSetName;

    @OneToMany(mappedBy = "valueSetId")
    private List<ValueSetValue> valueSetValues;

    @OneToMany(mappedBy = "valueSetId")
    private List<ValueSetValueColumn> valueSetValueColumns;

//    @OneToMany(mappedBy = "valueSetId")
//    private List<AttributeDesc> attributeDescs;

    public String getValueSetName() {
        return valueSetName;
    }

    public List<ValueSetValue> getValueSetValues() {
        return valueSetValues;
    }

    public List<ValueSetValueColumn> getValueSetValueColumns() {
        return valueSetValueColumns;
    }

//    public List<AttributeDesc> getAttributeDescs() {
//        return attributeDescs;
//    }
}
