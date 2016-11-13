package value.set;

import java.util.List;

/**
 * Created by Alex on 30.10.2016.
 */
public interface ValueSetDao {

    List<ValueSet> getAllValueSets();

    ValueSet getValueSetById(Long id);

    ValueSet getValueSetByName(String valueSetName);

}
