package engine.parsing;

import data.converter.RawDataConverter;
import dto.data.MultipartRawData;
import dto.data.RawData;
import engine.ProcessingResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


/**
 * Created by Alex on 07.01.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class HeaderParsingEngineTest {

    @Mock
    private RawDataConverter dataConverter;

    @InjectMocks
    private HeaderParsingEngine parsingEngine = new HeaderParsingEngine();

    @Test
    public void testParseInvokeRawDataConverter() {
        ProcessingResult arg = prepareProcessingResult();

        parsingEngine.parse(arg);

        verify(dataConverter, times(1)).convert(arg.getRawData());
    }

    private ProcessingResult prepareProcessingResult() {
        RawData rawData = new MultipartRawData(null);
        return new ProcessingResult(rawData);
    }
}