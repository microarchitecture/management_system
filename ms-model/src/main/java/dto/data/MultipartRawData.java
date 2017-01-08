package dto.data;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Alex on 07.01.2017.
 */
public final class MultipartRawData extends RawData<MultipartFile> {

    public MultipartRawData(MultipartFile rawData) {
        super(rawData);
    }
}
