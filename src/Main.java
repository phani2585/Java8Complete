import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {


        Calculator addition=(a,b)->a+b; //9
        Calculator subtraction=(a,b)->a-b; //8

        System.out.println(addition.calculate(4,5));
        System.out.println(subtraction.calculate(10,2));

        //predefined functional interfaces --> Predicate<T> ( functional method is test)
        // -->Function<T,R>, Consumer, Supplier
        Predicate<Integer> isEven=x->x%2==0;
        System.out.println(isEven.test(10)); //true

        Predicate<String> startsWithA=x->x.startsWith("A") || x.startsWith("a");
        System.out.println(startsWithA.test("America")); //true
        System.out.println(startsWithA.test("boston")); //false

        Function<Integer,Integer> squared=x->x*x;
        System.out.println(squared.apply(5));

    }
}

//custom functional interface
@FunctionalInterface
interface Calculator{
    int calculate(int a,int b );
}
