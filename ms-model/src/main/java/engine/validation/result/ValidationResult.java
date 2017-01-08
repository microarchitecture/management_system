package engine.validation.result;

import engine.validation.error.ValidationError;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Alex on 11.12.2016.
 */
public abstract class ValidationResult<T extends ValidationError> {

    private final List<T> validationErrors;

    public ValidationResult(List<T> validationErrors) {
        this.validationErrors = new ArrayList<>(validationErrors);
    }

    public List<T> getValidationErrors() {
        return Collections.unmodifiableList(validationErrors);
    }
}
