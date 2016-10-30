package value.set;

/**
 * Created by Alex on 30.10.2016.
 */
public interface ValueSetDao {

    ValueSet getValueSetById(Long id);

    ValueSet getValueSetByName(String valueSetName);

}
