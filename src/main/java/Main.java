import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Stream<Integer> stream = new ArrayList<>(Arrays.asList(5, 9, -7, 21)).stream();
        findMinMax(stream, (x, y) -> x.compareTo(y), (x, y) -> System.out.println("min - " + x + ", max - " + y));
        stream.close();
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer
    ) {
        List<T> tList = stream.sorted(order).collect(Collectors.toList());
        Optional.ofNullable(minMaxConsumer);
        minMaxConsumer.accept(tList.get(0), tList.get(tList.size() - 1));
    }
}
