package dto.data;

/**
 * Created by Alex on 07.01.2017.
 */
public abstract class   RawData<T> {

    private T rawData;

    public RawData(T rawData) {
        this.rawData = rawData;
    }

    public T getRawData() {
        return rawData;
    }
}
