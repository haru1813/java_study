package lambda;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.function.*;

/**
 * 메서드 참조 (Method Reference) 예제
 */
public class MethodReferenceExample {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        System.out.println("=== 메서드 참조 (Method Reference) 예제 ===\n");
        
        // ============================================
        // 1. 정적 메서드 참조 (Static Method Reference)
        // ============================================
        System.out.println("1. 정적 메서드 참조");
        System.out.println("-----------------------------------");
        
        // 람다식
        Function<String, Integer> lambda1 = s -> Integer.parseInt(s);
        System.out.println("람다식: " + lambda1.apply("123"));
        
        // 메서드 참조
        Function<String, Integer> methodRef1 = Integer::parseInt;
        System.out.println("메서드 참조: " + methodRef1.apply("456"));
        
        // 다른 예제
        Function<Double, Double> sqrt1 = x -> Math.sqrt(x);
        Function<Double, Double> sqrt2 = Math::sqrt;
        System.out.println("제곱근 (람다식): " + sqrt1.apply(16.0));
        System.out.println("제곱근 (메서드 참조): " + sqrt2.apply(25.0));
        
        // ============================================
        // 2. 인스턴스 메서드 참조 (Instance Method Reference)
        // ============================================
        System.out.println("\n2. 인스턴스 메서드 참조");
        System.out.println("-----------------------------------");
        
        String str = "Hello, World!";
        
        // 람다식
        Function<String, Integer> lambda2 = s -> s.length();
        System.out.println("람다식: " + lambda2.apply(str));
        
        // 메서드 참조
        Function<String, Integer> methodRef2 = String::length;
        System.out.println("메서드 참조: " + methodRef2.apply(str));
        
        // 다른 예제
        Function<String, String> upper1 = s -> s.toUpperCase();
        Function<String, String> upper2 = String::toUpperCase;
        System.out.println("대문자 (람다식): " + upper1.apply("hello"));
        System.out.println("대문자 (메서드 참조): " + upper2.apply("hello"));
        
        // ============================================
        // 3. 특정 객체의 인스턴스 메서드 참조
        // ============================================
        System.out.println("\n3. 특정 객체의 인스턴스 메서드 참조");
        System.out.println("-----------------------------------");
        
        StringBuilder sb = new StringBuilder();
        
        // 람다식
        Consumer<String> lambda3 = s -> sb.append(s);
        lambda3.accept("Hello");
        System.out.println("람다식 결과: " + sb.toString());
        
        sb.setLength(0);  // 초기화
        
        // 메서드 참조
        Consumer<String> methodRef3 = sb::append;
        methodRef3.accept("World");
        System.out.println("메서드 참조 결과: " + sb.toString());
        
        // ============================================
        // 4. 생성자 참조 (Constructor Reference)
        // ============================================
        System.out.println("\n4. 생성자 참조");
        System.out.println("-----------------------------------");
        
        // 람다식
        Supplier<List<String>> lambda4 = () -> new ArrayList<>();
        List<String> list1 = lambda4.get();
        System.out.println("람다식으로 생성: " + list1.getClass().getSimpleName());
        
        // 생성자 참조
        Supplier<List<String>> methodRef4 = ArrayList::new;
        List<String> list2 = methodRef4.get();
        System.out.println("생성자 참조로 생성: " + list2.getClass().getSimpleName());
        
        // 매개변수가 있는 생성자
        Function<String, StringBuilder> lambda5 = s -> new StringBuilder(s);
        Function<String, StringBuilder> methodRef5 = StringBuilder::new;
        StringBuilder sb1 = lambda5.apply("Hello");
        StringBuilder sb2 = methodRef5.apply("World");
        System.out.println("람다식: " + sb1.toString());
        System.out.println("생성자 참조: " + sb2.toString());
        
        // ============================================
        // 5. 배열 생성자 참조
        // ============================================
        System.out.println("\n5. 배열 생성자 참조");
        System.out.println("-----------------------------------");
        
        // 람다식
        IntFunction<int[]> lambda6 = size -> new int[size];
        int[] arr1 = lambda6.apply(5);
        System.out.println("람다식 배열 길이: " + arr1.length);
        
        // 배열 생성자 참조
        IntFunction<int[]> methodRef6 = int[]::new;
        int[] arr2 = methodRef6.apply(10);
        System.out.println("생성자 참조 배열 길이: " + arr2.length);
        
        // ============================================
        // 6. 컬렉션에서의 메서드 참조 활용
        // ============================================
        System.out.println("\n6. 컬렉션에서의 메서드 참조 활용");
        System.out.println("-----------------------------------");
        
        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date");
        
        // forEach와 메서드 참조
        System.out.print("forEach + 메서드 참조: ");
        fruits.forEach(System.out::print);
        System.out.println();
        
        // map과 메서드 참조
        System.out.print("대문자 변환: ");
        fruits.stream()
                .map(String::toUpperCase)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        
        // 정렬과 메서드 참조
        System.out.print("정렬: ");
        fruits.stream()
                .sorted(String::compareToIgnoreCase)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        
        // ============================================
        // 7. 복잡한 메서드 참조 예제
        // ============================================
        System.out.println("\n7. 복잡한 메서드 참조 예제");
        System.out.println("-----------------------------------");
        
        List<Person> people = Arrays.asList(
                new Person("홍길동", 25),
                new Person("김철수", 30),
                new Person("이영희", 28)
        );
        
        // 이름으로 정렬
        System.out.println("이름으로 정렬:");
        people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(p -> System.out.println("  " + p));
        
        // 나이로 정렬
        System.out.println("\n나이로 정렬:");
        people.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .forEach(p -> System.out.println("  " + p));
        
        // 이름 추출
        System.out.println("\n이름만 추출:");
        people.stream()
                .map(Person::getName)
                .forEach(name -> System.out.print(name + " "));
        System.out.println();
        
        // ============================================
        // 8. 메서드 참조 vs 람다식 비교
        // ============================================
        System.out.println("\n8. 메서드 참조 vs 람다식 비교");
        System.out.println("-----------------------------------");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        // 람다식
        System.out.print("람다식 (제곱): ");
        numbers.stream()
                .map(n -> n * n)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // 메서드 참조 (정적 메서드)
        System.out.print("메서드 참조 (절댓값): ");
        numbers.stream()
                .map(Math::abs)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // ============================================
        // 9. 실전 예제: 문자열 처리
        // ============================================
        System.out.println("\n9. 실전 예제: 문자열 처리");
        System.out.println("-----------------------------------");
        
        List<String> words = Arrays.asList("  java  ", "  python  ", "  javascript  ");
        
        // 공백 제거 및 대문자 변환
        System.out.println("공백 제거 및 대문자 변환:");
        words.stream()
                .map(String::trim)
                .map(String::toUpperCase)
                .forEach(s -> System.out.println("  " + s));
        
        // 필터링 (길이가 5보다 큰 것)
        System.out.println("\n길이가 5보다 큰 단어:");
        words.stream()
                .map(String::trim)
                .filter(s -> s.length() > 5)
                .forEach(s -> System.out.println("  " + s));
    }
}

// Person 클래스
class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    @Override
    public String toString() {
        return name + " (" + age + "세)";
    }
}

