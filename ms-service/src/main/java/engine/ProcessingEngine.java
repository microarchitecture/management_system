package engine;

/**
 * Created by Alex on 11.12.2016.
 */
public interface ProcessingEngine {

    void setNextProcessingEngine(ProcessingEngine processingEngine);

    ProcessingResult process(ProcessingResult processingResult);

}
