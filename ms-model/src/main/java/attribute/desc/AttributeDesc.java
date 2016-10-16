package attribute.desc;

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
    private Boolean attributeType;

    @Column(name = "IS_MANDATORY")
    private Boolean isMandatory;

    @Column(name = "IS_MATCHING")
    private Boolean isMatching;

    @Column(name = "IS_IN_RESTRICTION")
    private Boolean isInRestriction;

    @Column(name = "IS_IN_INVESTMENT")
    private Boolean isInInvestment;

    @Column(name = "ATTRIBUTE_DESC")
    private String attributeDescription;

}
