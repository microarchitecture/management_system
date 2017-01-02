package processor.parsing;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 11.12.2016.
 */
public final class ParsedRecord {

    private final int rowCount;

    private final Map<String, String> records;

    public ParsedRecord(Map<String, String> records) {
        this.records = new HashMap<>(records);
        this.rowCount = records.size();
    }

    public Map<String, String> getRecords() {
        return Collections.unmodifiableMap(records);
    }

    public int getRowCount() {
        return rowCount;
    }
}
