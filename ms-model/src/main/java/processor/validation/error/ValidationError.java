package processor.validation.error;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Alex on 11.12.2016.
 */
public abstract class ValidationError<T extends Error> {

    private final List<T> validationErrors;

    public ValidationError(List<T> validationErrors) {
        this.validationErrors = new ArrayList<>(validationErrors);
    }

    public List<T> getValidationErrors() {
        return Collections.unmodifiableList(validationErrors);
    }
}
