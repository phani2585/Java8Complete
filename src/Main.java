import java.util.function.*;

public class Main {
    public static void main(String[] args) {


        Calculator addition=(a,b)->a+b; //9
        Calculator subtraction=(a,b)->a-b; //8

        System.out.println(addition.calculate(4,5));
        System.out.println(subtraction.calculate(10,2));

        //predefined functional interfaces --> Predicate<T> ( functional method is test)
        // -->Function<T,R> (apply), Consumer<T> (accept), Supplier
        Predicate<Integer> isNoEven=x->x%2==0;
        System.out.println(isNoEven.test(10)); //true

        Predicate<String> startsWithA=x->x.startsWith("A") || x.startsWith("a");
        System.out.println(startsWithA.test("America")); //true
        System.out.println(startsWithA.test("boston")); //false

        Function<Integer,Integer> squared=x->x*x;
        System.out.println(squared.apply(5)); //25

        Consumer<String> print=x-> System.out.println("Hello "+x);
        print.accept("World"); // Hello World

        Supplier<Integer> doubled=()->2*4;
        System.out.println(doubled.get()); //8

        Supplier<String> message=()->"Hello Java";
        System.out.println(message.get()); //Hello Java

        // Example of BiConsumer: Takes a key-value pair and prints them
        BiConsumer<String, Integer> keyValue = (k, v) -> System.out.println("Country: " + k + ", Population: " + v);
        keyValue.accept("India", 1393409038);  // Expected output: Country: India, Population: 1393409038

        // Example of BiFunction: Adds two integers and returns the result
        BiFunction<Integer, Integer, Integer> sumit = (x, y) -> x + y;
        System.out.println(sumit.apply(10, 20));  // Expected output: 30

        // Example of BiPredicate: Checks if the first string starts with the second string
        BiPredicate<String, String> startsWith = String::startsWith;
        boolean result = startsWith.test("Java Programming", "Java");
        System.out.println(result);  // Expected output: true

        // Example of Predicate joining with and, or, and negate:
        Predicate<Integer> isEven = n -> n % 2 == 0;          // Predicate to check if number is even
        Predicate<Integer> isGreaterThan5 = n -> n > 5;        // Predicate to check if number is greater than 5
        Predicate<Integer> isBoth = isEven.and(isGreaterThan5); // Check if number is even and greater than 5
        System.out.println(isBoth.test(8));  // Expected output: true (8 is even and greater than 5)

        // Example with or operator, checking if number is even or greater than 10
        Predicate<Integer> isEvenOrGreaterThan10 = isEven.or(n -> n > 10);
        System.out.println(isEvenOrGreaterThan10.test(4));  // Expected output: true (4 is even)

        // Example with negate operator, checking if number is not even
        Predicate<Integer> isNotEven = isEven.negate();
        System.out.println(isNotEven.test(7));  // Expected output: true (7 is not even)

        // Example of Consumer chaining with andThen
        Consumer<String> addPrefix = (x) -> System.out.println("Prefix: " + x);
        Consumer<String> addSuffix = (x) -> System.out.println(x + " :Suffix");
        Consumer<String> addBoth = addPrefix.andThen(addSuffix);  // Combine prefix and suffix actions
        addBoth.accept("Hello");  // Expected output: Prefix: Hello, Hello :Suffix

        // Example of Consumer chaining with compose (the order of operations is reversed)
//        Consumer<String> addPrefixFirst = addPrefix.compose(addSuffix);  // Apply suffix first, then prefix
//        addPrefixFirst.accept("Goodbye");  // Expected output: Goodbye :Suffix, Prefix: Goodbye

        //Arrays

    }
}

//custom functional interface
@FunctionalInterface
interface Calculator{
    int calculate(int a,int b );
}
