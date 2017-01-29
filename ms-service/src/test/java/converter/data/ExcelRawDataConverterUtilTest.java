package converter.data;

import com.google.common.collect.Lists;
import dto.data.MultipartRawData;
import engine.parsing.ParsedRecord;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

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

    @Test(expected = ImproperWorkbookSheetException.class)
    public void testConvertBodyRawDataWhenRawDataIsIncorrectThenExceptionIsThrown() throws IOException {
        converterUtil.convertBodyRawData(prepareIncorrectRawData());
    }

    @Test
    public void testConvertBodyRawDataWhenRawDataIsCorrectThenCorrectParsedRecordIsReturned() throws IOException {
        Collection<ParsedRecord> parsedRecords = converterUtil.convertBodyRawData(prepareCorrectRawData());
        assertThat(parsedRecords).hasSize(2);
        assertThat(parsedRecords)
                .extracting("records")
                .extracting("ID")
                .contains("1.0", "2.0");
    }

    @Test
    public void testGetBodyDataWhenArgumentIsCorrectThenMethodReturnsCorrectResult() {
        Collection<ParsedRecord> resultBody = converterUtil.getBodyData(prepareBodyRawData());
        assertThat(resultBody).hasSize(2);
        assertThat(resultBody).extracting("records")
                .extracting("ID", "Attribute 1", "Attribute 2", "Attribute 3")
                .contains(tuple("1", "value_1", "value_2", "value_3"),
                        tuple("2", "value_2_1", "value_2_2", "value_2_3"));
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

    private List<Map<Integer, String>> prepareBodyRawData() {
        Map<Integer, String> headerData = new HashMap<>();
        headerData.put(1, "ID");
        headerData.put(2, "Attribute 1");
        headerData.put(3, "Attribute 2");
        headerData.put(4, "Attribute 3");

        Map<Integer, String> bodyDataA = new HashMap<>();
        bodyDataA .put(1, "1");
        bodyDataA .put(2, "value_1");
        bodyDataA .put(3, "value_2");
        bodyDataA .put(4, "value_3");

        Map<Integer, String> bodyDataB = new HashMap<>();
        bodyDataB .put(1, "2");
        bodyDataB .put(2, "value_2_1");
        bodyDataB .put(3, "value_2_2");
        bodyDataB .put(4, "value_2_3");

        return Lists.newArrayList(headerData, bodyDataA, bodyDataB);
    }

}