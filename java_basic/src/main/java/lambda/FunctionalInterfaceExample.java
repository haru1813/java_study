package lambda;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.function.*;

/**
 * 함수형 인터페이스 예제
 */
public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        System.out.println("=== 함수형 인터페이스 예제 ===\n");
        
        // ============================================
        // 1. Supplier<T> - 공급자 (매개변수 없음, 반환값 있음)
        // ============================================
        System.out.println("1. Supplier<T> - 공급자");
        System.out.println("-----------------------------------");
        
        Supplier<String> stringSupplier = () -> "Hello, World!";
        System.out.println("문자열 공급: " + stringSupplier.get());
        
        Supplier<Integer> randomSupplier = () -> new Random().nextInt(100);
        System.out.println("랜덤 숫자: " + randomSupplier.get());
        System.out.println("랜덤 숫자: " + randomSupplier.get());
        
        Supplier<Double> piSupplier = () -> Math.PI;
        System.out.println("PI 값: " + piSupplier.get());
        
        // ============================================
        // 2. Consumer<T> - 소비자 (매개변수 있음, 반환값 없음)
        // ============================================
        System.out.println("\n2. Consumer<T> - 소비자");
        System.out.println("-----------------------------------");
        
        Consumer<String> printer = s -> System.out.println("출력: " + s);
        printer.accept("안녕하세요");
        
        Consumer<Integer> squarePrinter = n -> {
            int result = n * n;
            System.out.println(n + "의 제곱: " + result);
        };
        squarePrinter.accept(5);
        
        // andThen: 연속 실행
        Consumer<String> upperCase = s -> System.out.print(s.toUpperCase());
        Consumer<String> addExclamation = s -> System.out.println(s + "!");
        upperCase.andThen(addExclamation).accept("hello");
        
        // ============================================
        // 3. Function<T, R> - 함수 (매개변수 있음, 반환값 있음)
        // ============================================
        System.out.println("\n3. Function<T, R> - 함수");
        System.out.println("-----------------------------------");
        
        Function<String, Integer> lengthFunction = s -> s.length();
        System.out.println("'Java'의 길이: " + lengthFunction.apply("Java"));
        
        Function<Integer, Integer> squareFunction = x -> x * x;
        System.out.println("5의 제곱: " + squareFunction.apply(5));
        
        Function<String, String> upperCaseFunction = s -> s.toUpperCase();
        System.out.println("대문자 변환: " + upperCaseFunction.apply("hello"));
        
        // compose: 함수 합성 (뒤에서 앞으로)
        Function<Integer, Integer> addOne = x -> x + 1;
        Function<Integer, Integer> multiplyTwo = x -> x * 2;
        Function<Integer, Integer> composed = multiplyTwo.compose(addOne);
        System.out.println("(5 + 1) * 2 = " + composed.apply(5));
        
        // andThen: 함수 합성 (앞에서 뒤로)
        Function<Integer, Integer> andThenComposed = addOne.andThen(multiplyTwo);
        System.out.println("(5 + 1) * 2 = " + andThenComposed.apply(5));
        
        // ============================================
        // 4. Predicate<T> - 조건식 (매개변수 있음, boolean 반환)
        // ============================================
        System.out.println("\n4. Predicate<T> - 조건식");
        System.out.println("-----------------------------------");
        
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("4는 짝수? " + isEven.test(4));
        System.out.println("5는 짝수? " + isEven.test(5));
        
        Predicate<String> isLong = s -> s.length() > 5;
        System.out.println("'Java'는 길이가 5보다 큰가? " + isLong.test("Java"));
        System.out.println("'JavaScript'는 길이가 5보다 큰가? " + isLong.test("JavaScript"));
        
        // and: 논리 AND
        Predicate<Integer> isPositive = n -> n > 0;
        Predicate<Integer> isLessThanTen = n -> n < 10;
        Predicate<Integer> isPositiveAndLessThanTen = isPositive.and(isLessThanTen);
        System.out.println("5는 양수이고 10보다 작은가? " + isPositiveAndLessThanTen.test(5));
        System.out.println("15는 양수이고 10보다 작은가? " + isPositiveAndLessThanTen.test(15));
        
        // or: 논리 OR
        Predicate<String> startsWithJ = s -> s.startsWith("J");
        Predicate<String> startsWithP = s -> s.startsWith("P");
        Predicate<String> startsWithJOrP = startsWithJ.or(startsWithP);
        System.out.println("'Java'는 J 또는 P로 시작? " + startsWithJOrP.test("Java"));
        System.out.println("'Python'는 J 또는 P로 시작? " + startsWithJOrP.test("Python"));
        
        // negate: 논리 NOT
        Predicate<Integer> isOdd = isEven.negate();
        System.out.println("5는 홀수? " + isOdd.test(5));
        
        // ============================================
        // 5. BiFunction<T, U, R> - 두 매개변수 함수
        // ============================================
        System.out.println("\n5. BiFunction<T, U, R> - 두 매개변수 함수");
        System.out.println("-----------------------------------");
        
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("10 + 20 = " + add.apply(10, 20));
        
        BiFunction<String, String, String> concat = (a, b) -> a + " " + b;
        System.out.println("문자열 연결: " + concat.apply("Hello", "World"));
        
        BiFunction<Integer, Integer, Integer> max = (a, b) -> a > b ? a : b;
        System.out.println("max(15, 25) = " + max.apply(15, 25));
        
        // ============================================
        // 6. UnaryOperator<T> - 단항 연산자
        // ============================================
        System.out.println("\n6. UnaryOperator<T> - 단항 연산자");
        System.out.println("-----------------------------------");
        
        UnaryOperator<Integer> increment = x -> x + 1;
        System.out.println("5 + 1 = " + increment.apply(5));
        
        UnaryOperator<String> reverse = s -> new StringBuilder(s).reverse().toString();
        System.out.println("'Java' 뒤집기: " + reverse.apply("Java"));
        
        // ============================================
        // 7. BinaryOperator<T> - 이항 연산자
        // ============================================
        System.out.println("\n7. BinaryOperator<T> - 이항 연산자");
        System.out.println("-----------------------------------");
        
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        System.out.println("5 * 6 = " + multiply.apply(5, 6));
        
        BinaryOperator<String> longer = (a, b) -> a.length() > b.length() ? a : b;
        System.out.println("더 긴 문자열: " + longer.apply("Java", "Python"));
        
        // ============================================
        // 8. 커스텀 함수형 인터페이스
        // ============================================
        System.out.println("\n8. 커스텀 함수형 인터페이스");
        System.out.println("-----------------------------------");
        
        Calculator addCalculator = (a, b) -> a + b;
        Calculator multiplyCalculator = (a, b) -> a * b;
        
        System.out.println("덧셈: " + addCalculator.calculate(10, 20));
        System.out.println("곱셈: " + multiplyCalculator.calculate(5, 6));
        
        // ============================================
        // 9. 실전 예제: 컬렉션 필터링과 변환
        // ============================================
        System.out.println("\n9. 실전 예제: 컬렉션 필터링과 변환");
        System.out.println("-----------------------------------");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // 짝수만 필터링
        Predicate<Integer> even = n -> n % 2 == 0;
        List<Integer> evens = numbers.stream()
                .filter(even)
                .collect(java.util.stream.Collectors.toList());
        System.out.println("짝수: " + evens);
        
        // 제곱으로 변환
        Function<Integer, Integer> square = n -> n * n;
        List<Integer> squares = numbers.stream()
                .map(square)
                .collect(java.util.stream.Collectors.toList());
        System.out.println("제곱: " + squares);
        
        // 조건부 변환
        Function<Integer, String> evenOdd = n -> n % 2 == 0 ? "짝수" : "홀수";
        List<String> evenOddList = numbers.stream()
                .map(evenOdd)
                .collect(java.util.stream.Collectors.toList());
        System.out.println("짝수/홀수: " + evenOddList);
    }
}

// 커스텀 함수형 인터페이스
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
    
    // 함수형 인터페이스는 하나의 추상 메서드만 가질 수 있음
    // default 메서드는 가능
    default int add(int a, int b) {
        return a + b;
    }
    
    // static 메서드도 가능
    static void printResult(int result) {
        System.out.println("결과: " + result);
    }
}

