package engine.parsing;

import converter.data.RawDataConverter;
import dto.data.MultipartRawData;
import dto.data.RawData;
import engine.ProcessingResult;
import engine.validation.ValidationEngine;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


/**
 * Created by Alex on 07.01.2017.
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:engine/parsing/header-parsing-engine-test-config.xml"})
public class HeaderParsingEngineTest {

    @Resource
    private HeaderParsingEngine headerParsingEngine;
    @Resource
    private RawDataConverter headerRawDataConverter;
    @Resource
    private ValidationEngine headerValidationEngine;
    @Resource
    private ParsingEngine dataParsingEngine;
    @Resource
    private RawDataConverter bodyRawDataConverter;
    @Resource
    private ValidationEngine dataValidationEngine;

    @Test
    public void testParseInvokeRawDataConverter() {
        ProcessingResult arg = prepareProcessingResult();
        headerParsingEngine.parse(arg);

        verify(headerRawDataConverter, times(1)).convert(arg.getRawData());
    }

    //TODO The one is passed successfully when implementation of all injected beans are done
    @Test
    public void testProcessWhenParsingEngineHasNextNextParsingEngineThenProcessMethodOfEachEngineIsInvoked() {
        ProcessingResult arg = prepareProcessingResult();
        headerParsingEngine.process(arg);

        verify(dataValidationEngine, times(1)).process(arg);
    }

    private ProcessingResult prepareProcessingResult() {
        RawData rawData = new MultipartRawData(null);
        return new ProcessingResult(rawData);
    }
}