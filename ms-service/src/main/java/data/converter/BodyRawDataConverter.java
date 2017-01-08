package data.converter;

import dto.data.MultipartRawData;
import dto.data.RawData;
import engine.parsing.ParsedRecord;

import java.util.List;

/**
 * Created by Alex on 08.01.2017.
 */
public class BodyRawDataConverter implements RawDataConverter<List<ParsedRecord>> {

    private RawDataConverterUtil<List<ParsedRecord>, MultipartRawData> converterUtil;

    @Override
    public List<ParsedRecord> convert(RawData rawData) {
        return null;
    }
}
