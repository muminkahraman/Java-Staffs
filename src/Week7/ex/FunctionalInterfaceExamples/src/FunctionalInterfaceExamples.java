
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *
 * @author gdm1
 */
public class FunctionalInterfaceExamples
{

    public static void main(String[] args)
    {
        functionDemonstration1();
        functionDemonstration2();
        functionDemonstration3();
        predicateDemonstration1();
        predicateDemonstration2();
        predicateDemonstration3();
        predicateDemonstration4();
        supplierDemonstration1();
        supplierDemonstration2();
        consumerDemonstration1();
        consumerDemonstration2();
        consumerDemonstration3();
    }

    private static void functionDemonstration1()
    {
        Function<Integer, Integer> factorial = new Function<Integer, Integer>()
        {
            @Override
            public Integer apply(Integer t)
            {
                int sum = t;
                for (int i = t - 1; i > 1; i--)
                {
                    sum *= i;
                }
                return sum;
            }
        };

        System.out.println("\nFunction demonstration 1");
        System.out.println("\t4! = " + factorial.apply(4));
    }

    private static void functionDemonstration2()
    {
        Function<Integer, Integer> factorial = (Integer t) ->
        {
            int sum = t;
            for (int i = t - 1; i > 1; i--)
            {
                sum *= i;
            }
            return sum;
        };

        Function<Integer, Integer> multiplyByTwo = (Integer t) -> t * 2;

        System.out.println("\nFunction demonstration 2");
        System.out.println("\t4! = " + factorial.apply(4));
        System.out.println(
                "\t4! x 2 = "
                + factorial
                        .andThen(multiplyByTwo)
                        .apply(4));
    }

    private static void functionDemonstration3()
    {
        Function<Integer, Integer> factorial = new Factorial();

        Function<Integer, Integer> multiplyByTwo = (Integer t) -> t * 2;

        System.out.println("\nFunction demonstration 3");
        System.out.println("\t4! = " + factorial.apply(4));
        System.out.println(
                "\t(4 x 2)! = "
                + factorial
                        .compose(multiplyByTwo)
                        .apply(4));
    }

    private static void predicateDemonstration1()
    {
        Predicate<Integer> lessThanThree = new Predicate<Integer>()
        {
            @Override
            public boolean test(Integer t)
            {
                return t < 3;
            }
        };

        System.out.println("\nPredicate demonstration 1");
        System.out.println("\t6 < 3 = " + lessThanThree.test(6));
        System.out.println("\t-4 < 3 = " + lessThanThree.test(-4));
    }

    private static void predicateDemonstration2()
    {
        Predicate<Integer> lessThanThree = (t) -> t < 3;
        Predicate<Integer> greaterThanTen = (t) -> t > 10;

        System.out.println("\nPredicate demonstration 2");
        System.out.println(
                "\t2 < 3 || 2 > 10 = "
                + lessThanThree
                        .or(greaterThanTen)
                        .test(2));
        System.out.println(
                "\t12 < 3 || 12 > 10 = "
                + lessThanThree
                        .or(greaterThanTen)
                        .test(12));
        System.out.println(
                "\t5 < 3 || 5 > 10 = "
                + lessThanThree
                        .or(greaterThanTen)
                        .test(5));
    }

    private static void predicateDemonstration3()
    {
        Predicate<Integer> greaterThanThree = (t) -> t > 3;
        Predicate<Integer> lessThanTen = (t) -> t < 10;

        System.out.println("\nPredicate demonstration 3");

        System.out.println(
                "\t2 > 3 && 2 < 10 = "
                + greaterThanThree
                        .and(lessThanTen)
                        .test(2));

        System.out.println(
                "\t12 > 3 && 12 < 10 = "
                + greaterThanThree
                        .and(lessThanTen)
                        .test(12));

        System.out.printf(
                "\t5 > 3 && 5 < 10 = %s\n",
                greaterThanThree
                        .and(lessThanTen)
                        .test(5));

        System.out.printf(
                "\t!(5 > 3 && 5 < 10) = %b\n",
                greaterThanThree
                        .and(lessThanTen)
                        .negate()
                        .test(5));
    }

    private static void predicateDemonstration4()
    {
        Predicate<Integer> greaterThanThree = (t) -> t > 3;
        Predicate<Integer> lessThanTen = (t) -> t < 10;

        System.out.println("\nPredicate demonstration 4");

        System.out.printf(
                "\t5 > 3 == 7 < 10 = %b\n",
                Predicate
                        .isEqual(greaterThanThree.test(5))
                        .test(lessThanTen.test(7)));

        System.out.printf(
                "\t-5 > 3 == 17 < 10 = %b\n",
                Predicate
                        .isEqual(greaterThanThree.test(-5))
                        .test(lessThanTen.test(17)));

        System.out.printf(
                "\t5 > 3 == 17 < 10 = %b\n",
                Predicate
                        .isEqual(greaterThanThree.test(5))
                        .test(lessThanTen.test(17)));
    }

    private static void supplierDemonstration1()
    {
        Supplier<Integer> randomInteger = new Supplier<Integer>()
        {
            @Override
            public Integer get()
            {
                return (int) (Math.random() * 99);
            }
        };

        System.out.println("\nSupplier demonstration 1");
        System.out.println("\tRandom integer: " + randomInteger.get());
        System.out.println("\tRandom integer: " + randomInteger.get());
    }

    private static void supplierDemonstration2()
    {
        Supplier<Integer[]> randomIntegerArray = () ->
        {
            int arrayLength = (int) (Math.random() * (10) + 1);
            Integer[] array = new Integer[arrayLength];
            for (int i = 0; i < arrayLength; i++)
            {
                array[i] = (int) (Math.random() * (99 - 50 + 1) + 50);
            }
            return array;
        };

        System.out.println("\nSupplier demonstration 2");
        Integer[] numbers = randomIntegerArray.get();
        System.out.print("\tArray: ");
        for (Integer number : numbers)
        {
            System.out.print(number + "  ");
        }
        System.out.println();

        numbers = randomIntegerArray.get();
        System.out.print("\tArray: ");
        for (Integer number : numbers)
        {
            System.out.print(number + "  ");
        }
        System.out.println();
    }

    private static void consumerDemonstration1()
    {
        Supplier<Integer> randomInteger = new Supplier<Integer>()
        {
            @Override
            public Integer get()
            {
                return (int) (Math.random() * 99);
            }
        };

        Consumer<Integer> integerPrinter
                = (t) -> System.out.println("\tInteger: " + t);

        System.out.println("\nConsumer demonstration 1");
        integerPrinter.accept(randomInteger.get());
        integerPrinter.accept(randomInteger.get());
    }

    private static void consumerDemonstration2()
    {
        Supplier<Integer[]> randomIntegerArray
                = new IntegerArraySupplier(2, 8, -5, 14);

        Consumer<Integer[]> arrayPrinter = new Consumer<Integer[]>()
        {
            @Override
            public void accept(Integer[] t)
            {
                System.out.print("\tArray: ");
                for (Integer number : t)
                {
                    System.out.print(number + "  ");
                }
                System.out.println();
            }
        };

        System.out.println("\nConsumer demonstration 2");
        arrayPrinter.accept(randomIntegerArray.get());
        arrayPrinter.accept(randomIntegerArray.get());
    }

    private static void consumerDemonstration3()
    {
        Supplier<Integer[]> randomIntegerArray
                = new IntegerArraySupplier(2, 8, -5, 14);

        Consumer<Integer[]> printArray = (Integer[] t) ->
        {
            System.out.print("\n\tArray: ");
            for (Integer number : t)
            {
                System.out.print(number + "  ");
            }
            System.out.println();
        };

        Consumer<Integer[]> printTotal = (t) ->
        {
            int sum = 0;
            for (Integer i : t)
            {
                sum += i;
            }
            System.out.println("\tSum of integers: " + sum);
        };

        System.out.println("\nConsumer demonstration 3");
        printArray.andThen(printTotal).accept(randomIntegerArray.get());
        printArray.andThen(printTotal).accept(randomIntegerArray.get());
    }

}
