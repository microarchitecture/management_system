package converter.data;

import dto.data.RawData;
import engine.parsing.ParsedRecord;
import org.springframework.beans.factory.annotation.Required;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Alex on 07.01.2017.
 */
public class HeaderRawDataConverter implements RawDataConverter<ParsedRecord> {

    private RawDataConverterUtil<RawData, ParsedRecord> converterUtil;

    @Required
    @Override
    public void setConverterUtil(RawDataConverterUtil<RawData, ParsedRecord> converterUtil) {
        this.converterUtil = converterUtil;
    }

    @Override
    public ParsedRecord convert(RawData rawData) {
        checkDataNotNull(rawData);
        return converterUtil.convertHeaderRawData(rawData);
    }

    private void checkDataNotNull(RawData rawData) {
        checkNotNull(rawData);
        checkNotNull(rawData.getRawData());
    }
}
