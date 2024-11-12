public class Main {
    public static void main(String[] args) {


        Calculator addition=(a,b)->a+b;
        Calculator subtraction=(a,b)->a-b;

        System.out.println(addition.calculate(4,5));
        System.out.println(subtraction.calculate(10,2));

    }
}

//custom functional interface
@FunctionalInterface
interface Calculator{
    int calculate(int a,int b );
}