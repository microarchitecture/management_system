package engine.parsing;

import data.converter.RawDataConverter;
import engine.ProcessingEngine;
import engine.ProcessingResult;
import org.springframework.beans.factory.annotation.Required;

/**
 * Created by Alex on 11.12.2016.
 */
public abstract class ParsingEngine<T> implements ProcessingEngine {

    protected RawDataConverter<T> rawDataConverter;

    protected abstract T parse(ProcessingResult processingResult);

    @Required
    public void setRawDataConverter(RawDataConverter<T> rawDataConverter) {
        this.rawDataConverter = rawDataConverter;
    }
}
