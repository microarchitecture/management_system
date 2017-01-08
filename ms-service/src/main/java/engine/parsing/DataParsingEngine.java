package engine.parsing;

import engine.ProcessingResult;
import java.util.List;

/**
 * Created by Alex on 11.12.2016.
 */
public class DataParsingEngine extends ParsingEngine<List<ParsedRecord>> {

    @Override
    protected List<ParsedRecord> parse(ProcessingResult processingResult) {
        return rawDataConverter.convert(processingResult.getRawData());
    }

    @Override
    public ProcessingResult process(ProcessingResult processingResult) {
        return null;
    }
}
