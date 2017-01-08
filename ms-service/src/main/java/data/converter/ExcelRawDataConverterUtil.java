package data.converter;

import dto.data.MultipartRawData;
import engine.parsing.ParsedRecord;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by Alex on 08.01.2017.
 */
public final class ExcelRawDataConverterUtil implements RawDataConverterUtil<ParsedRecord, MultipartRawData> {

    //TODO Temporary solution. Should be removed when ParsedRecord is refactored to support separate data classes for both Header and Body parsing
    private static final String EMPTY_STRING = "";

    private ExcelRawDataConverterUtil() {
    }

    static ExcelRawDataConverterUtil getInstance() {
        return new ExcelRawDataConverterUtil();
    }

    @Override
    public ParsedRecord convertHeaderRawData(MultipartRawData rawData) throws ImproperWorkbookSheetException{
        XSSFWorkbook workBook = getWorkBook(rawData);
        XSSFSheet workSheet = getWorkSheet(workBook);
        XSSFRow workSheetRow = getWorkSheetRow(workSheet);
        ParsedRecord parsedResult = extractRowData(workSheetRow);
        return parsedResult;
    }

    @Override
    public Collection<ParsedRecord> convertBodyRawData(MultipartRawData rawData) {
        return null;
    }

    private XSSFWorkbook getWorkBook(MultipartRawData rawData) {
        MultipartFile multipartFile = rawData.getRawData();
        XSSFWorkbook workBook = null;
        try (InputStream inputStream = multipartFile.getInputStream()){
            workBook = new XSSFWorkbook(inputStream);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return workBook;
    }

    private XSSFSheet getWorkSheet(XSSFWorkbook workBook) {
        XSSFSheet workSheet = workBook.getSheetAt(0);
        if (workSheet == null) {
            throw new ImproperWorkbookSheetException("No sheets were found in .xlsx-file");
        }
        return workSheet;
    }

    private XSSFRow getWorkSheetRow(XSSFSheet workSheet) {
        XSSFRow workSheetRow = workSheet.getRow(0);
        if (workSheetRow == null) {
            throw new ImproperWorkbookSheetException("No rows of data were found in .xlsx-file");
        }
        return workSheetRow;
    }

    private ParsedRecord extractRowData(XSSFRow workSheetRow) {
        Map<String, String> cellValues = extractCellValues(workSheetRow);
        return ParsedRecord.getBulider()
                .setRowNumber(1)
                .setRecords(cellValues)
                .build();
    }

    private Map<String, String> extractCellValues(XSSFRow workSheetRow) {
        final Iterable<Cell> iterable = () -> workSheetRow.cellIterator();
        return StreamSupport
                .stream(iterable.spliterator(), false)
                .collect(Collectors.toMap(cell -> cell.getStringCellValue(), cell -> EMPTY_STRING));
    }

}
