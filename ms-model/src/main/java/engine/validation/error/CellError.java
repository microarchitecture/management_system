package engine.validation.error;

/**
 * Created by Alex on 11.12.2016.
 */
public final class CellError extends Error {

    private String columnName;

    private CellError() {
    }

    public String getColumnName() {
        return columnName;
    }

    public static CellErrorBuilder getBuilder() {
        return new CellErrorBuilder();
    }

    public static class CellErrorBuilder {
        private CellError instance;

        private CellErrorBuilder() {
            instance = new CellError();
        }

        public CellErrorBuilder setColumnName(String columnName) {
            instance.columnName = columnName;
            return this;
        }

        public CellErrorBuilder setErrorCause(String errorCause) {
            instance.errorCause = errorCause;
            return this;
        }

        public CellError build() {
            return instance;
        }
    }
}
