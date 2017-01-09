package engine.parsing;

import java.util.Collections;
import java.util.Map;

/**
 * Created by Alex on 11.12.2016.
 */
//TODO Check if there is a sense to implement generic HeaderParsedRecord and BodyParsedRecord
public final class ParsedRecord {
    private int rowNumber;
    private Map<String, Object> records;

    private ParsedRecord() {
    }

    public Map<String, Object> getRecords() {
        return Collections.unmodifiableMap(records);
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public static Builder getBulider() {
        return new Builder();
    }

    public static class Builder {
        private ParsedRecord instance;

        private Builder() {
            instance = new ParsedRecord();
        }

        public Builder setRowNumber(int rowNumber) {
            this.instance.rowNumber = rowNumber;
            return this;
        }

        public Builder setRecords(Map<String, Object> records) {
            this.instance.records = records;
            return this;
        }

        public ParsedRecord build() {
            return instance;
        }

    }
}
