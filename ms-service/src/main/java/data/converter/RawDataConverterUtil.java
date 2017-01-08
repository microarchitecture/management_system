package data.converter;

import dto.data.RawData;

import java.util.Collection;

/**
 * Created by Alex on 08.01.2017.
 */
public interface RawDataConverterUtil<T, S extends RawData> {

    T convertHeaderRawData(S rawdata);

    Collection<T> convertBodyRawData(S rawdata);

}