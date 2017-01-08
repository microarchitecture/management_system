package restriction;

/**
 * Created by Alex on 13.11.2016.
 */
public interface RestrictionDao {

    void saveRestrictionRef(RestrictionRef restrictionRef);

    void saveRestriction(Restriction restriction);

    RestrictionType getRestrictionTypeByName(String restrictionTypeName);

    void saveTestTable(TestTable testTable);

}
