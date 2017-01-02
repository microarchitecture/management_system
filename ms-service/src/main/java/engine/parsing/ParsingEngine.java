package engine.parsing;

import engine.ProcessingEngine;
import processor.ProcessingResult;
import processor.parsing.ParsedRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 11.12.2016.
 */
public abstract class ParsingEngine implements ProcessingEngine {

    public List<ParsedRecord> parsedRecords;

    public void setParsedRecords(List<ParsedRecord> parsedRecords) {
        this.parsedRecords = new ArrayList<>(parsedRecords);
    }

    abstract ParsedRecord parse(ProcessingResult processingResult);
}
