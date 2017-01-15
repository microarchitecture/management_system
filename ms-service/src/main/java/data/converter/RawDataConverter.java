package data.converter;

import dto.data.RawData;

/**
 * Created by Alex on 07.01.2017.
 */
public interface RawDataConverter<T> {

    void setConverterUtil(RawDataConverterUtil<RawData, T> converterUtil);

    T convert(RawData rawData);

}
