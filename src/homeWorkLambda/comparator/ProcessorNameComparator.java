package homeWorkLambda.comparator;

import homeWorkLambda.processor.Processor;

import java.util.Comparator;

public class ProcessorNameComparator implements Comparator<Processor> {

    @Override
    public int compare(Processor a, Processor b) {
        return a.getModel().compareTo(b.getModel());
    }
}
