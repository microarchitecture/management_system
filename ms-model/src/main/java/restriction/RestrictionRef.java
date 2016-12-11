package restriction;

import parentEntity.ParentId;

import javax.persistence.*;

/**
 * Created by Alex on 16.10.2016.
 */
@Entity
@Table(name = "RESTRICTION_REF")
public class RestrictionRef extends ParentId {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RESTRICTION_ID", nullable = false)
    private Restriction restrictionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESTRICTION_TYPE_ID")
    private RestrictionType restrictionTypeId;

    public RestrictionType getRestrictionTypeId() {
        return restrictionTypeId;
    }

    public Restriction getRestrictionId() {
        return restrictionId;
    }

    public void setRestrictionTypeId(RestrictionType restrictionTypeId) {
        this.restrictionTypeId = restrictionTypeId;
    }

    public void setRestrictionId(Restriction restrictionId) {
        this.restrictionId = restrictionId;
    }
}
