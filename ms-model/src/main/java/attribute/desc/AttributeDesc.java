package attribute.desc;

import org.hibernate.annotations.Type;
import parentEntity.ParentId;
import restriction.RestrictionType;
import value.set.ValueSet;

import javax.persistence.*;

/**
 * Created by Alex on 16.10.2016.
 */
@Entity
@Table(name = "ATTRIBUTE_DESC")
public class AttributeDesc extends ParentId {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESTRICTION_TYPE_ID")
    private RestrictionType restrictionTypeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VALUE_SET_ID")
    private ValueSet valueSetId;

    @Column(name = "TABLE_COLUMN")
    private String tableColumn;

    @Column(name = "ATTRIBUTE_NAME")
    private String attributeName;

    @Column(name = "ATTRIBUTE_TYPE")
    @Type(type = "yes_no")
    private Boolean attributeType;

    @Column(name = "IS_MANDATORY")
    @Type(type = "yes_no")
    private Boolean isMandatory;

    @Column(name = "IS_MATCHING")
    @Type(type = "yes_no")
    private Boolean isMatching;

    @Column(name = "IS_IN_RESTRICTION")
    @Type(type = "yes_no")
    private Boolean isInRestriction;

    @Column(name = "IS_IN_INVESTMENT")
    @Type(type = "yes_no")
    private Boolean isInInvestment;

    @Column(name = "ATTRIBUTE_DESC")
    private String attributeDescription;

    public RestrictionType getRestrictionTypeId() {
        return restrictionTypeId;
    }

    public ValueSet getValueSetId() {
        return valueSetId;
    }

    public String getTableColumn() {
        return tableColumn;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public Boolean getAttributeType() {
        return attributeType;
    }

    public Boolean getMandatory() {
        return isMandatory;
    }

    public Boolean getMatching() {
        return isMatching;
    }

    public Boolean getInRestriction() {
        return isInRestriction;
    }

    public Boolean getInInvestment() {
        return isInInvestment;
    }

    public String getAttributeDescription() {
        return attributeDescription;
    }
}
