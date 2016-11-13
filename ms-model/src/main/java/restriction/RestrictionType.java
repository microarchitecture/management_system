package restriction;

import attribute.desc.AttributeDesc;
import parentEntity.ParentId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Alex on 16.10.2016.
 */
@Entity
@Table(name = "RESTRICTION_TYPE")
public class RestrictionType extends ParentId {

    @Column(name = "RESTRICTION_TYPE_NAME")
    private String restrictionTypeName;

    @OneToMany(mappedBy = "restrictionTypeId")
    private List<RestrictionRef> restrictions;

    @OneToMany(mappedBy = "restrictionTypeId")
    private List<AttributeDesc> attributeDescs;

    public String getRestrictionTypeName() {
        return restrictionTypeName;
    }

    public List<RestrictionRef> getRestrictions() {
        return restrictions;
    }

    public List<AttributeDesc> getAttributeDescs() {
        return attributeDescs;
    }
}
