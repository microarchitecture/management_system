package processor;

import processor.parsing.ParsedRecord;
import processor.validation.result.ValidationResult;

import java.util.List;

/**
 * Created by Alex on 11.12.2016.
 */
public class ProcessingResult<T> {

    private boolean headerValid;
    private boolean dataValid;
    private T rawData;
    private List<ValidationResult> validationResults;
    private List<ParsedRecord> parsedRecords;

    public ProcessingResult(T rawData) {
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

    public List<ValidationResult> getValidationResults() {
        return validationResults;
    }

    public void setValidationResults(List<ValidationResult> validationResults) {
        this.validationResults = validationResults;
    }

    public List<ParsedRecord> getParsedRecords() {
        return parsedRecords;
    }

    public void setParsedRecords(List<ParsedRecord> parsedRecords) {
        this.parsedRecords = parsedRecords;
    }

    public T getRawData() {
        return rawData;
    }
}
