package engine.parsing;

import engine.ProcessingResult;

/**
 * Created by Alex on 11.12.2016.
 */
public class HeaderParsingEngine extends ParsingEngine<ParsedRecord> {

    @Override
    protected ParsedRecord parse(ProcessingResult processingResult) {
        return rawDataConverter.convert(processingResult.getRawData());
    }

    @Override
    public ProcessingResult process(ProcessingResult processingResult) {
        return null;
    }
}
