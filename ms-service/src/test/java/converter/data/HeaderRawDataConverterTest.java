package converter.data;

import dto.data.MultipartRawData;
import dto.data.RawData;
import engine.parsing.ParsedRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Alex on 07.01.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class HeaderRawDataConverterTest {

    @Mock
    private RawDataConverterUtil converterUtil;

    @InjectMocks
    private HeaderRawDataConverter converter = new HeaderRawDataConverter();

    @Test(expected = NullPointerException.class)
    public void testConvertWhenArgumentIsNullThenExceptionIsThrown() {
        converter.convert(null);
    }

    @Test(expected = NullPointerException.class)
    public void testConvertWhenArgumentContainsNullThenExceptionIsThrown() {
        RawData rawData = new MultipartRawData(null);
        converter.convert(rawData);
    }

    @Test
    public void testConvertWhenRawDataContainsOneRowThenParsedRecordIsRetrieved() throws IOException {
        RawData rawData = prepareRawData();
        when(converterUtil.convertHeaderRawData(rawData)).thenReturn(any(ParsedRecord.class));

        converter.convert(rawData);

        verify(converterUtil, times(1)).convertHeaderRawData(rawData);
    }

    private RawData prepareRawData() throws IOException {
        MockMultipartFile rawData = new MockMultipartFile("test_data", new byte[]{});
        return new MultipartRawData(rawData);
    }
}