package engine.validation;

import engine.ProcessingEngine;
import processor.ProcessingResult;
import validator.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 11.12.2016.
 */
public abstract class ValidationEngine implements ProcessingEngine {

    private List<Validator> validators;

    public void setValidators(List<Validator> validators) {
        validators = new ArrayList<>(validators);
    }

    abstract ProcessingResult validate(ProcessingResult precessingResult);

}
