package module11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Module11 {
    public static void main(String[] args) throws FileNotFoundException {

        //Task1Test
        //Make List of names

        System.out.println("Task 1 Test_________________________________");

        Scanner scanner = new Scanner(new FileInputStream("src/main/java/module11/namelistTask1.txt"));
        List<String> nameList = new ArrayList<>();
        while (scanner.hasNext()) {
            nameList.add(scanner.nextLine());
        }

        System.out.println("Name list task1 = " + nameList);

        // Task1Test solution

        System.out.println("Results task 1 = " + fixlist(nameList) + "\n");

        // Task2Test
        // Make List of words

        System.out.println("Task 2 Test_________________________________");

        Scanner scanner1 = new Scanner(new FileInputStream("src/main/java/module11/nameTask2.txt"));
        List<String> words = new LinkedList<>();
        while (scanner1.hasNext()) {
            words.add(scanner1.next());
        }
        System.out.println("Name task 2 = " + words);

        //Task2Test solution

        System.out.println("Result task 2 = " + toUpperReversSort(words) + "\n");

        //Task3

        System.out.println("Task 3 Test_________________________________");

        String[] array = {"1,2,0", "4,5"};
        System.out.println("Start array = " + Arrays.toString(array));
        System.out.println("Result task 3 " + sortArray(array) + "\n");

        //Task4

        System.out.println("Task 4 Test_________________________________");

        MyRandom random = new MyRandom(25214903917L, 11L, (long) Math.pow(2, 48));
        Stream longStream = Stream.iterate(0L, (seed) -> (random.seed(seed).next()));
        longStream.limit(10)
                .peek(System.out::println)
                .collect(Collectors.toList());

        //Task5

        System.out.println("\nTask 5 Test_________________________________");

        //generate some objects

        Stream<For5Task> stream10 = Stream.of(
                new For5Task(1, "qqqqq"),
                new For5Task(2, "wwwww"),
                new For5Task(3, "eeeee"),
                new For5Task(4, "rrrrr")
        );
        Stream<For5Task> stream20 = Stream.of(
                new For5Task(10, "qqq"),
                new For5Task(20, "www"),
                new For5Task(30, "eee"),
                new For5Task(40, "rrr"),
                new For5Task(50, "ttt")
        );

        zip(stream10, stream20)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    //Implements methods:

    public static String fixlist(List<String> nameList) {
        return nameList.stream()
                .filter(name -> nameList.indexOf(name) % 2 == 0)
                .collect(Collectors.joining(", "));
    }

    public static List<String> toUpperReversSort(List<String> words) {
        return words.stream()
                .map(s -> s.toUpperCase())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static List<Integer> sortArray(String[] array) {
        return Arrays.stream(array)
                .map(elem -> Arrays.asList(elem.split(",")))
                .flatMap(Collection::stream)
                .sorted()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {

        Iterator<T> iterator = second.iterator();

        return first.
                flatMap(a -> iterator.hasNext() ? (Stream.concat(Stream.of(a), Stream.of(
                        (iterator.next())))) : null);
    }
}