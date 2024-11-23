import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.swap;

public class ArraysJava8Complete {

    public static <R> void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        List<Integer> nos = Arrays.asList(1, 2, 3, 4, 5, 6);
//        Arrays.stream(nums).forEach(System.out::println);
//        Arrays.stream(nums).filter(n->n%2==0).forEach(System.out::println);
//        Arrays.stream(nums).filter(n->n%2!=0).forEach(System.out::print);
//        Arrays.stream(nums).filter(n -> n % 2 == 0).map(n -> n * 2).forEach(System.out::println);
//        int op = Arrays.stream(nums).filter(n -> n % 2 == 0).map(n -> n * 2).reduce(0, (a, b) -> a + b);
//        System.out.println(op);
//        String output = Arrays.stream(nums).filter(n -> n % 2 == 0).mapToObj(Integer::toString).collect(Collectors.joining(" "));
//        System.out.println(output);
        //count, sum, avg, max
//        long count = Arrays.stream(nums).count();
//        System.out.println(count);
//        int sum = Arrays.stream(nums).sum();
//        System.out.println(sum);
//        int evensum = Arrays.stream(nums).filter(n -> n % 2 == 0).sum();
//        System.out.println(evensum);
//        int newsum = Arrays.stream(nums).filter(n -> n % 2 == 0).map(n -> n * 2).sum();
//        System.out.println(newsum);
//        int product = Arrays.stream(nums).reduce(1, (a, b) -> a * b);
//        System.out.println(product);
//        double average = Arrays.stream(nums).summaryStatistics().getAverage();
//        System.out.println(average);
//        int max = Arrays.stream(nums).summaryStatistics().getMax();
//        System.out.println(max);
//        int min = Arrays.stream(nums).summaryStatistics().getMin();
//        System.out.println(min);
//        OptionalDouble average = Arrays.stream(nums).average();
//        System.out.println(average.orElse(0));
//sorted
        int[] numbers = {2, 1, 5, 3, 7, 9, 4};
        int[] array = Arrays.stream(numbers).sorted().toArray();
//        System.out.println(Arrays.toString(array));
//        convert an int[] array (primitive int) to an Integer[] array (wrapper class Integer)
//        Integer[] array = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
//        System.out.println(Arrays.toString(array));
//reverseorder
//        Arrays.sort(array, Collections.reverseOrder());
//        System.out.println(Arrays.toString(array));

//       // 2nd smallest element
//        int ans = Arrays.stream(numbers).distinct().
//                sorted().
//                skip(1).
//                findAny().
//                orElseThrow(() -> new IllegalArgumentException("2nd smallest doesnt exist"));
//        System.out.println("2nd smallest ::"+ ans);
//
//        //2nd largest element
//        int ans1 = Arrays.stream(numbers)
//                .distinct()
//                .sorted()
//                .skip(numbers.length - 2)
//                .findAny()
//                .orElseThrow(() -> new IllegalArgumentException("2nd largest doesnt exist"));
//        System.out.println("2nd largest :: "+ans1);

//        Other approach

//        3rd smallest
//        Integer[] boxedIntArray = Arrays.stream(numbers)
//                .boxed()
//                .toArray(Integer[]::new);
//        Arrays.sort(boxedIntArray,Collections.reverseOrder());
//        Integer small3 = Arrays.stream(boxedIntArray)
//                .distinct()
//                .skip(boxedIntArray.length - 3)
//                .findAny()
//                .orElseThrow(() -> new IllegalArgumentException("3rd smallest doesnt exist"));
//        System.out.println("3rd smallest :: "+small3);
//
//        Integer large3 = Arrays.stream(boxedIntArray)
//                .distinct()
//                .skip(2)
//                .findAny()
//                .orElseThrow(() -> new IllegalArgumentException("3rd largest doesnt exist"));
//        System.out.println("3rd largest :: "+large3);

        // in place array reversal
        int[] myarr = {3, 6, 4, 9, 7, 10};
        IntStream.range(0, myarr.length / 2).forEach(j -> swap1(myarr, j, myarr.length - 1 - j));
//        System.out.println(Arrays.toString(myarr));

//array reversal integer wrapper classes
        Integer[] arr2 = {4, 5, 6, 3, 8};

        IntStream.range(0, arr2.length / 2)
                .forEach(i -> swap(arr2, i, arr2.length - 1 - i));

//        System.out.println(Arrays.toString(arr2));


        //rotate array by N positions --clockwise or anti --check edge cases like rotate by 0 or by N> arr.length times
        int[] arr3 = {5, 2, 7, 9, 4};
        int N = 2;
        int[] rotatedArray = IntStream.concat(
                Arrays.stream(arr3).skip(N),          // Skip the first N elements
                Arrays.stream(arr3).limit(N)         // Add the first N elements to the end
        ).toArray();
        System.out.println(Arrays.toString(rotatedArray));


    }


    private static void swap(Integer[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }


    public static void swap1(int[] arr, int i, int j) {
// a=5,  b= 10
        //a=a+b  --> 15
        //b=a-b  --> 5
        //a=a-b  -->15-5 =10 --> a=10, b=5
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }
}


