package data.converter;

import dto.data.RawData;
import engine.parsing.ParsedRecord;
import org.springframework.beans.factory.annotation.Required;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Alex on 07.01.2017.
 */
public class HeaderRawDataConverter implements RawDataConverter<ParsedRecord> {

    private RawDataConverterUtil<ParsedRecord, RawData> converterUtil;

    @Override
    public ParsedRecord convert(RawData rawData) {
        checkDataNotNull(rawData);
        return converterUtil.convertHeaderRawData(rawData);
    }

    private void checkDataNotNull(RawData rawData) {
        checkNotNull(rawData);
        checkNotNull(rawData.getRawData());
    }

    @Required
    public void setConverterUtil(RawDataConverterUtil<ParsedRecord, RawData> converterUtil) {
        this.converterUtil = converterUtil;
    }
}
