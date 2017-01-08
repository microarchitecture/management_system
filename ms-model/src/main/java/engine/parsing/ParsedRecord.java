package engine.parsing;

import java.util.Collections;
import java.util.Map;

/**
 * Created by Alex on 11.12.2016.
 */
public final class ParsedRecord {
    private int rowNumber;
    private Map<String, String> records;

    private ParsedRecord() {
    }

    public Map<String, String> getRecords() {
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

        public Builder setRecords(Map<String, String> records) {
            this.instance.records = records;
            return this;
        }

        public ParsedRecord build() {
            return instance;
        }

    }
}
