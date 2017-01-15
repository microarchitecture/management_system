package data.converter;

import dto.data.RawData;
import engine.parsing.ParsedRecord;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Alex on 08.01.2017.
 */
public class BodyRawDataConverter implements RawDataConverter<List<ParsedRecord>> {

    private RawDataConverterUtil<RawData, List<ParsedRecord>> converterUtil;

    @Required
    @Override
    public void setConverterUtil(RawDataConverterUtil<RawData, List<ParsedRecord>> converterUtil) {
        this.converterUtil = converterUtil;
    }

    @Override
    public List<ParsedRecord> convert(RawData rawData) {
        checkDataNotNull(rawData);
        return  (List) converterUtil.convertBodyRawData(rawData);
    }

    private void checkDataNotNull(RawData rawData) {
        checkNotNull(rawData);
        checkNotNull(rawData.getRawData());
    }
}
