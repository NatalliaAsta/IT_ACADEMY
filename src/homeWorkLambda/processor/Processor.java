package homeWorkLambda.processor;

import java.util.Objects;

public class Processor {

    private String model;
    private int frequency;

    public Processor(String model, int frequency) {
        this.model = model;
        this.frequency = frequency;
    }

    public String getModel() {
        return model;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Processor)) return false;
        Processor processor = (Processor) o;
        return Double.compare(processor.frequency, frequency) == 0 && model.equals(processor.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, frequency);
    }

    @Override
    public String toString() {
        return "Processor{" +
                "model='" + model + '\'' +
                ", frequency=" + frequency +
                '}';
    }


}
