package homeWorkLambda.comparator;

import homeWorkLambda.processor.Processor;

import java.util.Comparator;

public class ProcessorFrequencyComparator implements Comparator<Processor> {

    @Override
    public int compare(Processor a, Processor b) {
        if(a.getFrequency()> b.getFrequency())
            return 1;
        else if(a.getFrequency()< b.getFrequency())
            return -1;
        else
            return 0;
    }
}
