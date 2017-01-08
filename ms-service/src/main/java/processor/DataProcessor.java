package processor;

/**
 * Created by Alex on 07.01.2017.
 */
public interface DataProcessor<T, S> {

    T process(S data);

}
