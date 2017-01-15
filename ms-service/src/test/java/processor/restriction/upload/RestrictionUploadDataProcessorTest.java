package processor.restriction.upload;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by Alex on 15.01.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:processor/restriction/upload/restriction-upload-data-processor-test-config.xml"})
public class RestrictionUploadDataProcessorTest {

    @Resource
    private RestrictionUploadDataProcessor dataProcessor;

    @Test
    public void testProcess() {
        assertThat(dataProcessor).isNotNull();
    }
}