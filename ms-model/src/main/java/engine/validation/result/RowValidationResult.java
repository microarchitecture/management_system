package engine.validation.result;

import engine.validation.error.CellValidationError;

import java.util.List;

/**
 * Created by Alex on 11.12.2016.
 */
public final class RowValidationResult extends ValidationResult<CellValidationError> {

    private final int rowNumber;

    public RowValidationResult(List<CellValidationError> validationErrors, int rowNumber) {
        super(validationErrors);
        this.rowNumber = rowNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }
}
