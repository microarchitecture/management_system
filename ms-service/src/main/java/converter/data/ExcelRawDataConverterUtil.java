package converter.data;

import dto.data.MultipartRawData;
import engine.parsing.ParsedRecord;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by Alex on 08.01.2017.
 */
public final class ExcelRawDataConverterUtil implements RawDataConverterUtil<MultipartRawData, ParsedRecord> {

    private ExcelRawDataConverterUtil() {
    }

    static ExcelRawDataConverterUtil getInstance() {
        return new ExcelRawDataConverterUtil();
    }

    @Override
    public ParsedRecord convertHeaderRawData(MultipartRawData rawData) throws ImproperWorkbookSheetException{
        XSSFWorkbook workBook = getWorkBook(rawData);
        XSSFSheet workSheet = getWorkSheet(workBook);
        XSSFRow workSheetRow = getHeaderRow(workSheet);
        ParsedRecord parsedResult = convertHeaderRowData(workSheetRow, 1);
        return parsedResult;
    }

    @Override
    public Collection<ParsedRecord> convertBodyRawData(MultipartRawData rawData) {
        XSSFWorkbook workBook = getWorkBook(rawData);
        XSSFSheet workSheet = getWorkSheet(workBook);
        List<Map<Integer, String>> extractedBody= extractBodyCellValues(workSheet);
        Collection<ParsedRecord> result = getBodyData(extractedBody);
        return result;
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
        } else if (workSheet.getLastRowNum() < 1) {
            throw new ImproperWorkbookSheetException("No rows of data were found in .xlsx-file");
        }
        return workSheet;
    }

    private XSSFRow getHeaderRow(XSSFSheet workSheet) {
        XSSFRow workSheetRow = workSheet.getRow(0);
        if (workSheetRow == null) {
            throw new ImproperWorkbookSheetException("No rows of data were found in .xlsx-file");
        }
        return workSheetRow;
    }

    private ParsedRecord convertHeaderRowData(Row workSheetRow, int rowNumber) {
        Map<String, Object> cellValues = extractHeaderCellValues(workSheetRow);
        return ParsedRecord.getBulider()
                .setRowNumber(rowNumber)
                .setRecords(cellValues)
                .build();
    }

    private Map<String, Object> extractHeaderCellValues(Row workSheetRow) {
        return StreamSupport
                .stream(workSheetRow.spliterator(), false)
                .collect(Collectors.toMap(cell -> cell.getStringCellValue(), cell -> cell.getColumnIndex()));
    }

    private List<Map<Integer, String>> extractBodyCellValues(XSSFSheet workSheet) {
        return StreamSupport
                .stream(workSheet.spliterator(), false)
                .map(this::extractCellValuesForMatching)
                .collect(Collectors.toList());
    }

    private Map<Integer, String> extractCellValuesForMatching(Row workSheetRow) {
        return StreamSupport
                .stream(workSheetRow.spliterator(), false)
                .collect(Collectors.toMap(cell -> cell.getColumnIndex(), getCellValue()));
    }

    private Function<Cell, String> getCellValue() {
        return (Cell cell) -> {
                String value = null;
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING :
                        value = cell.getStringCellValue().trim(); break;
                    case Cell.CELL_TYPE_NUMERIC :
                        value = String.valueOf(cell.getNumericCellValue()); break;
                    default:
                        value = cell.getStringCellValue();
                }
                return value;
        };
    }

    //TODO Should be refactored using Streams
    Collection<ParsedRecord> getBodyData(List<Map<Integer, String>> extractedBodyValues) {
        Collection<ParsedRecord> resultCollection = new ArrayList<>();
        Map<Integer, String> header = new LinkedHashMap<>();
        ListIterator<Map<Integer, String>> bodyValuesIterator = extractedBodyValues.listIterator();
        while(bodyValuesIterator.hasNext()) {
            Map<Integer, String> currentRow = bodyValuesIterator.next();
            if (bodyValuesIterator.previousIndex() == 0) {
                header.putAll(currentRow);
                continue;
            }
            Map<String, Object> rowMappedValues = matchHeaderWithValues(header, currentRow);
            ParsedRecord resultRecord = getBodyParsedRecord(rowMappedValues, bodyValuesIterator.previousIndex() + 1);
            resultCollection.add(resultRecord);
        }
        return resultCollection;
    }

    private Map<String, Object> matchHeaderWithValues(Map<Integer, String> header, Map<Integer, String> body) {
        return header.entrySet()
                .stream()
                .collect(Collectors.toMap(
                                headerEntry -> headerEntry.getValue(),
                                headerEntry -> body.get(headerEntry.getKey())
                        )
                );
    }

    private ParsedRecord getBodyParsedRecord(Map<String, Object> bodyValues, int rowNum) {
        return ParsedRecord.getBulider()
                .setRowNumber(rowNum)
                .setRecords(bodyValues)
                .build();
    }

}
