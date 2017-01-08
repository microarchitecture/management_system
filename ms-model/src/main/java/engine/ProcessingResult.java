package engine;

import dto.data.RawData;
import engine.parsing.ParsedRecord;
import engine.validation.result.ValidationResult;

import java.util.List;

/**
 * Created by Alex on 11.12.2016.
 */
public class ProcessingResult {

    private boolean headerValid;
    private boolean dataValid;
    private RawData rawData;
    private List<ValidationResult> validationResults;
    private List<String> parsedHeader;
    private List<ParsedRecord> parsedRecords;

    public ProcessingResult(RawData rawData) {
        this.rawData = rawData;
    }

    public boolean isHeaderValid() {
        return headerValid;
    }

    public void setHeaderValid(boolean headerValid) {
        this.headerValid = headerValid;
    }

    public boolean isDataValid() {
        return dataValid;
    }

    public void setDataValid(boolean dataValid) {
        this.dataValid = dataValid;
    }

    public RawData getRawData() {
        return rawData;
    }

    public void setRawData(RawData rawData) {
        this.rawData = rawData;
    }

    public List<ValidationResult> getValidationResults() {
        return validationResults;
    }

    public void setValidationResults(List<ValidationResult> validationResults) {
        this.validationResults = validationResults;
    }

    public List<String> getParsedHeader() {
        return parsedHeader;
    }

    public void setParsedHeader(List<String> parsedHeader) {
        this.parsedHeader = parsedHeader;
    }

    public List<ParsedRecord> getParsedRecords() {
        return parsedRecords;
    }

    public void setParsedRecords(List<ParsedRecord> parsedRecords) {
        this.parsedRecords = parsedRecords;
    }
}
