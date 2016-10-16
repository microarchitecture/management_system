package restriction;

import parentEntity.ParentId;

import javax.lang.model.type.ReferenceType;
import javax.persistence.*;
import java.util.List;

/**
 * Created by Alex on 16.10.2016.
 */
@Entity
@Table(name = "RESTRICTION_REF")
public class RestrictionRef extends ParentId {

    @OneToOne(mappedBy = "restrictionRefId")
    private Restriction restriction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESTRICTION_TYPE_ID")
    private RestrictionType restrictionTypeId;

    public RestrictionType getReferenceTypeId() {
        return restrictionTypeId;
    }

}
