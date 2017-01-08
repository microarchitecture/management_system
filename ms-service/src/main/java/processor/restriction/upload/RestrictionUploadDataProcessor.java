package processor.restriction.upload;

import dto.data.RawData;
import dto.processing.ProcessingMessage;
import processor.DataProcessor;

/**
 * Created by Alex on 07.01.2017.
 */
public class RestrictionUploadDataProcessor implements DataProcessor<ProcessingMessage, RawData> {

    @Override
    public ProcessingMessage process(RawData data) {
        //1. File validation (size, name, type)
        //2. RawData to Framework specific RawData converting
        //3. Data parsing /validation
        //4. ProcessingResult to ProcessingMessage converting
        return null;
    }
}
