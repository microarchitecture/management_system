package restriction;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;
import parentEntity.ParentId;

import javax.persistence.*;
import java.lang.reflect.Field;

/**
 * Created by Alex on 16.10.2016.
 */
@Entity
@Table(name = "RESTRICTION")
public class Restriction extends ParentId {

    @OneToOne
    @JoinColumn(name = "RESTRICTION_REF_ID")
    private RestrictionRef restrictionRefId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESTRICTION_TYPE_ID")
    private RestrictionType restrictionType;

    @Column(name = "IS_ACTIVE")
    @Type(type = "yes_no")
    private Boolean isActive;

    @Column(name = "DATE_FROM")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime dateFrom;

    @Column(name = "DATE_TO")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime dateTo;

    @Column(name = "RESTRICTION_VALUE")
    private Long restrictionValue;

    @Column(name = "ATTRIBUTE1")
    private String attribute1;

    @Column(name = "ATTRIBUTE2")
    private String attribute2;

    @Column(name = "ATTRIBUTE3")
    private String attribute3;

    @Column(name = "ATTRIBUTE4")
    private String attribute4;

    @Column(name = "ATTRIBUTE5")
    private String attribute5;

    @Column(name = "ATTRIBUTE6")
    private String attribute6;

    @Column(name = "ATTRIBUTE7")
    private String attribute7;

    @Column(name = "ATTRIBUTE8")
    private String attribute8;

    @Column(name = "ATTRIBUTE9")
    private String attribute9;

    @Column(name = "ATTRIBUTE10")
    private String attribute10;

    @Column(name = "ATTRIBUTE11")
    private String attribute11;

    @Column(name = "ATTRIBUTE12")
    private String attribute12;

    @Column(name = "ATTRIBUTE13")
    private String attribute13;

    @Column(name = "ATTRIBUTE14")
    private String attribute14;

    @Column(name = "ATTRIBUTE15")
    private String attribute15;

    @Column(name = "ATTRIBUTE16")
    private String attribute16;

    @Column(name = "ATTRIBUTE17")
    private String attribute17;

    @Column(name = "ATTRIBUTE18")
    private String attribute18;

    @Column(name = "ATTRIBUTE19")
    private String attribute19;

    @Column(name = "ATTRIBUTE20")
    private String attribute20;

    public String get(String columnName) {
        try {
            Field field = Restriction.class.getDeclaredField(columnName.toLowerCase());
            field.setAccessible(true);
            return (String) field.get(this);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public RestrictionRef getRestrictionRefId() {
        return restrictionRefId;
    }

    public RestrictionType getRestrictionType() {
        return restrictionType;
    }

    public Boolean getActive() {
        return isActive;
    }

    public LocalDateTime getDateFrom() {
        return dateFrom;
    }

    public LocalDateTime getDateTo() {
        return dateTo;
    }

    public Long getRestrictionValue() {
        return restrictionValue;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public String getAttribute3() {
        return attribute3;
    }

    public String getAttribute4() {
        return attribute4;
    }

    public String getAttribute5() {
        return attribute5;
    }

    public String getAttribute6() {
        return attribute6;
    }

    public String getAttribute7() {
        return attribute7;
    }

    public String getAttribute8() {
        return attribute8;
    }

    public String getAttribute9() {
        return attribute9;
    }

    public String getAttribute10() {
        return attribute10;
    }

    public String getAttribute11() {
        return attribute11;
    }

    public String getAttribute12() {
        return attribute12;
    }

    public String getAttribute13() {
        return attribute13;
    }

    public String getAttribute14() {
        return attribute14;
    }

    public String getAttribute15() {
        return attribute15;
    }

    public String getAttribute16() {
        return attribute16;
    }

    public String getAttribute17() {
        return attribute17;
    }

    public String getAttribute18() {
        return attribute18;
    }

    public String getAttribute19() {
        return attribute19;
    }

    public String getAttribute20() {
        return attribute20;
    }

    public void setRestrictionRefId(RestrictionRef restrictionRefId) {
        this.restrictionRefId = restrictionRefId;
    }

    public void setRestrictionType(RestrictionType restrictionType) {
        this.restrictionType = restrictionType;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void setDateFrom(LocalDateTime dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(LocalDateTime dateTo) {
        this.dateTo = dateTo;
    }

    public void setRestrictionValue(Long restrictionValue) {
        this.restrictionValue = restrictionValue;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
    }

    public void setAttribute6(String attribute6) {
        this.attribute6 = attribute6;
    }

    public void setAttribute7(String attribute7) {
        this.attribute7 = attribute7;
    }

    public void setAttribute8(String attribute8) {
        this.attribute8 = attribute8;
    }

    public void setAttribute9(String attribute9) {
        this.attribute9 = attribute9;
    }

    public void setAttribute10(String attribute10) {
        this.attribute10 = attribute10;
    }

    public void setAttribute11(String attribute11) {
        this.attribute11 = attribute11;
    }

    public void setAttribute12(String attribute12) {
        this.attribute12 = attribute12;
    }

    public void setAttribute13(String attribute13) {
        this.attribute13 = attribute13;
    }

    public void setAttribute14(String attribute14) {
        this.attribute14 = attribute14;
    }

    public void setAttribute15(String attribute15) {
        this.attribute15 = attribute15;
    }

    public void setAttribute16(String attribute16) {
        this.attribute16 = attribute16;
    }

    public void setAttribute17(String attribute17) {
        this.attribute17 = attribute17;
    }

    public void setAttribute18(String attribute18) {
        this.attribute18 = attribute18;
    }

    public void setAttribute19(String attribute19) {
        this.attribute19 = attribute19;
    }

    public void setAttribute20(String attribute20) {
        this.attribute20 = attribute20;
    }
}
