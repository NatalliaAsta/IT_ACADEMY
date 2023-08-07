package homeWorkLambda.runner;

import homeWorkLambda.comparator.ProcessorFrequencyComparator;
import homeWorkLambda.comparator.ProcessorNameComparator;
import homeWorkLambda.processor.Processor;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Run {

    public static void run() {
        Comparator<Processor> pcomp = new ProcessorFrequencyComparator().thenComparing(new ProcessorNameComparator());
        Set<Processor> processors = new TreeSet(pcomp);
        processors.add(new Processor("Intel i9-13900K", 5700));
        processors.add(new Processor("Intel i9-13900F", 5700));
        processors.add(new Processor("Intel i9-13900", 5500));
        processors.add(new Processor("Intel i7-13700K", 5400));
        processors.add(new Processor("Intel i7-13700F", 5200));
        processors.add(new Processor("Intel i7-13700", 5200));
        processors.add(new Processor("Intel i5-13400F", 4600));
        processors.add(new Processor("Intel i5-13400K", 4700));
        processors.add(new Processor("Intel i5-13400", 4600));
        processors.add(new Processor("Intel i3-13100", 4500));

        System.out.println("1:");
        processors.stream()
                .forEach(System.out::println)
        ;

        System.out.println("2:");
        processors.stream()
                .skip(1)
                .distinct()
                .filter((p) -> p.getFrequency() > 4600)
                .limit(5)
                .map(p -> p.getModel().toUpperCase())
                .forEach(System.out::println)
        ;

        System.out.println("3:");
        processors.stream()
                .map(p -> p.getModel())
                .peek(s -> System.out.println(s + ", "))
                .collect(Collectors.toList());

        System.out.print("4: ");
        System.out.println(processors.stream()
                .mapToInt(Processor::getFrequency)
                .average()
                .getAsDouble())
        ;

        System.out.print("5: ");
        System.out.println(processors.stream()
                .mapToInt(Processor::getFrequency)
                .max()
                .getAsInt()
        );

        System.out.print("6: ");
        System.out.println(processors.stream()
                .findFirst()
        );

        System.out.print("7: ");
        System.out.println(processors.stream()
                .mapToInt(Processor::getFrequency)
                .findAny()
                .orElse(1)
        );

        System.out.print("8: ");
        System.out.println(processors.stream()
                .map(Processor::getModel)
                .count()
        );

        System.out.print("9: ");
        System.out.println(processors.stream()
                .map(Processor::getModel)
                .anyMatch("Intel i9"::contains)
        );
    }
}
