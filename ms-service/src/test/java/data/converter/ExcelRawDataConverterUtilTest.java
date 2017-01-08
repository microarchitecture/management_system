package data.converter;

import dto.data.MultipartRawData;
import engine.parsing.ParsedRecord;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Alex on 08.01.2017.
 */
public class ExcelRawDataConverterUtilTest {

    private ExcelRawDataConverterUtil converterUtil = ExcelRawDataConverterUtil.getInstance();

    @Test
    public void testGetInstanceReturnsNewInstanceEachCall() {
        ExcelRawDataConverterUtil converterUtilA = ExcelRawDataConverterUtil.getInstance();
        assertThat(converterUtil).isNotEqualTo(converterUtilA);
    }

    @Test(expected = ImproperWorkbookSheetException.class)
    public void testConvertHeaderRawDataWhenRawDataIsIncorrectThenExceptionIsThrown() throws IOException {
        converterUtil.convertHeaderRawData(prepareIncorrectRawData());
    }

    @Test
    public void testConvertHeaderRawDataWhenRawDataIsCorrectThenCorrectParsedRecordIsReturned() throws IOException {
        ParsedRecord parsedRecord = converterUtil.convertHeaderRawData(prepareCorrectRawData());
        assertThat(parsedRecord.getRowNumber()).isEqualTo(1);
        assertThat(parsedRecord.getRecords()).isNotEmpty();
    }

    private MultipartRawData prepareCorrectRawData() throws IOException {
        FileInputStream inputStream = new FileInputStream("src/test/resources/test_restriction_070116.xlsx");
        MultipartFile multipartFile = new MockMultipartFile("test_restriction_070116.xlsx", inputStream);
        return new MultipartRawData(multipartFile);
    }

    private MultipartRawData prepareIncorrectRawData() throws IOException {
        FileInputStream inputStream = new FileInputStream("src/test/resources/test_restriction_no_data_070116.xlsx");
        MultipartFile multipartFile = new MockMultipartFile("test_restriction_no_data_070116.xlsx", inputStream);
        return new MultipartRawData(multipartFile);
    }

}