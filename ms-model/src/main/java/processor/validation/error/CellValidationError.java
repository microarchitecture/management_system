package processor.validation.error;

import java.util.List;

/**
 * Created by Alex on 11.12.2016.
 */
public class CellValidationError extends ValidationError<CellError> {

    public CellValidationError(List<CellError> validationErrors) {
        super(validationErrors);
    }

}
