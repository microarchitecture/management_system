package converter.data;

import dto.data.MultipartRawData;
import dto.data.RawData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;


/**
 * Created by Alex on 15.01.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class BodyRawDataConverterTest {

    @Mock
    private RawDataConverterUtil converterUtil;

    @InjectMocks
    private BodyRawDataConverter converter = new BodyRawDataConverter();

    @Test(expected = NullPointerException.class)
    public void testConvertWhenArgumentIsNullThenExceptionIsThrown() {
        converter.convert(null);
    }

    @Test(expected = NullPointerException.class)
    public void testConvertWhenArgumentContainsNullDataThenExceptionIsThrown() {
        RawData rawData = new MultipartRawData(null);
        converter.convert(rawData);
    }

    @Test
    public void testConvertWhenRawDataContainsOneRowThenParsedRecordIsRetrieved() throws IOException {
        RawData rawData = prepareRawData();
        when(converterUtil.convertBodyRawData(rawData)).thenReturn(any(List.class));

        converter.convert(rawData);

        verify(converterUtil, times(1)).convertBodyRawData(rawData);
    }

    private RawData prepareRawData() throws IOException {
        MockMultipartFile rawData = new MockMultipartFile("test_data", new byte[]{});
        return new MultipartRawData(rawData);
    }
}