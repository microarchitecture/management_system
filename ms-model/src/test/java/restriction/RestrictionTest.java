package restriction;

/**
 * Created by Alex on 16.10.2016.
 */

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RestrictionTest {

    private Restriction restriction = new Restriction();

    @Test
    public void testGet() throws Exception {
        restriction.setAttribute1("ATTRIBUTE1_TEST_VALUE");
        restriction.setAttribute2("ATTRIBUTE2_TEST_VALUE");
        restriction.setAttribute3("ATTRIBUTE3_TEST_VALUE");

        String attribute1Value = restriction.get("ATTRIBUTE1");
        String attribute2Value = restriction.get("ATTRIBUTE2");
        String attribute3Value = restriction.get("ATTRIBUTE3");

        assertThat(attribute1Value).isEqualTo("ATTRIBUTE1_TEST_VALUE");
        assertThat(attribute2Value).isEqualTo("ATTRIBUTE2_TEST_VALUE");
        assertThat(attribute3Value).isEqualTo("ATTRIBUTE3_TEST_VALUE");
    }
}
