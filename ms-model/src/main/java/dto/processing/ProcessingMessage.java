package dto.processing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Alex on 07.01.2017.
 */
public abstract class ProcessingMessage<T extends ValidationResultMessage> {

    private List<T> validationResultMessages = new ArrayList<>();

    public ProcessingMessage(List<T> validationMessages) {
        this.validationResultMessages.addAll(validationMessages);
    }

    public List<T> getValidationResultMessages() {
        return Collections.unmodifiableList(validationResultMessages);
    }
}
