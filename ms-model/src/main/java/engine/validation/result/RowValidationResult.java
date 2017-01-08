package engine.validation.result;

import engine.validation.error.CellValidationError;

import java.util.List;

/**
 * Created by Alex on 11.12.2016.
 */
public final class RowValidationResult extends ValidationResult<CellValidationError> {

    private int rowNumber;

    public RowValidationResult(List<CellValidationError> validationErrors) {
        super(validationErrors);
    }

    public int getRowNumber() {
        return rowNumber;
    }
}
