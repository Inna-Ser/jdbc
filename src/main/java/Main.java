import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
//      Task 1

        Stream<Integer> stream = new ArrayList<>(Arrays.asList(0)).stream();
        findMinMax(stream, (x, y) -> x.compareTo(y), (x, y) -> System.out.println("min - " + x + ", max - " + y));
        stream.close();


//      Task 2
        List<Integer> integers = new ArrayList<>(List.of(3, 6, 4, -2, 0, -5, 8));
        findEvenNumbers(integers);
    }

    //      Method task1
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer
    ) {
        List<? extends T> tList = stream.sorted(order)
                .collect(Collectors.toList());
        if (tList.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(tList.get(0), tList.get(tList.size() - 1));
        }
    }
    //      Method task 2
    public static void findEvenNumbers(List<Integer> integers) {
        System.out.println(integers.stream()
                .filter(n -> n % 2 == 0)
                .count());
    }
}
