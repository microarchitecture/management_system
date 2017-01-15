package engine.validation;

import engine.ProcessingEngine;
import engine.ProcessingResult;
import validator.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 11.12.2016.
 */
public abstract class ValidationEngine implements ProcessingEngine {

    private ProcessingEngine nextProcessingEngine;
    private List<Validator> validators;

    @Override
    public void setNextProcessingEngine(ProcessingEngine processingEngine) {
        nextProcessingEngine = processingEngine;
    }

    public void setValidators(List<Validator> validators) {
        this.validators = new ArrayList<>(validators);
    }

    abstract ProcessingResult validate(ProcessingResult precessingResult);

}
