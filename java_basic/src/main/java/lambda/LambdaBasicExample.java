package lambda;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 람다식 기본 문법 예제
 */
public class LambdaBasicExample {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        System.out.println("=== 람다식 기본 문법 ===\n");
        
        // ============================================
        // 1. 람다식 기본 문법
        // ============================================
        System.out.println("1. 람다식 기본 문법");
        System.out.println("-----------------------------------");
        
        // 기존 방식: 익명 클래스
        Runnable oldWay = new Runnable() {
            @Override
            public void run() {
                System.out.println("익명 클래스 방식");
            }
        };
        oldWay.run();
        
        // 람다식 방식
        Runnable lambdaWay = () -> System.out.println("람다식 방식");
        lambdaWay.run();
        
        // ============================================
        // 2. 다양한 람다식 문법
        // ============================================
        System.out.println("\n2. 다양한 람다식 문법");
        System.out.println("-----------------------------------");
        
        // 매개변수가 없는 경우
        Runnable noParam = () -> System.out.println("매개변수 없음");
        noParam.run();
        
        // 매개변수가 하나인 경우 (괄호 생략 가능)
        java.util.function.Consumer<String> oneParam1 = (s) -> System.out.println(s);
        java.util.function.Consumer<String> oneParam2 = s -> System.out.println(s);  // 괄호 생략
        oneParam1.accept("매개변수 하나 (괄호 있음)");
        oneParam2.accept("매개변수 하나 (괄호 없음)");
        
        // 매개변수가 여러 개인 경우
        java.util.function.BiFunction<Integer, Integer, Integer> twoParams = (a, b) -> a + b;
        System.out.println("두 매개변수 합: " + twoParams.apply(10, 20));
        
        // 타입 명시 (일반적으로 생략 가능)
        java.util.function.BinaryOperator<Integer> withType = (Integer a, Integer b) -> a * b;
        System.out.println("타입 명시: " + withType.apply(5, 6));
        
        // ============================================
        // 3. 람다식 본문 형태
        // ============================================
        System.out.println("\n3. 람다식 본문 형태");
        System.out.println("-----------------------------------");
        
        // 단일 표현식 (중괄호 생략, return 생략)
        java.util.function.Function<Integer, Integer> square1 = x -> x * x;
        System.out.println("제곱 (단일 표현식): " + square1.apply(5));
        
        // 복합 문장 (중괄호 필요, return 필요)
        java.util.function.Function<Integer, Integer> square2 = x -> {
            int result = x * x;
            return result;
        };
        System.out.println("제곱 (복합 문장): " + square2.apply(6));
        
        // 여러 줄 람다식
        java.util.function.Consumer<Integer> multiLine = n -> {
            System.out.print("숫자 " + n + "의 ");
            if (n % 2 == 0) {
                System.out.println("짝수입니다.");
            } else {
                System.out.println("홀수입니다.");
            }
        };
        multiLine.accept(7);
        multiLine.accept(8);
        
        // ============================================
        // 4. 변수 캡처 (Variable Capture)
        // ============================================
        System.out.println("\n4. 변수 캡처");
        System.out.println("-----------------------------------");
        
        int localVar = 100;  // 로컬 변수
        final int finalVar = 200;  // final 변수
        
        // 로컬 변수 캡처 (effectively final)
        java.util.function.Supplier<Integer> captureLocal = () -> localVar + 10;
        System.out.println("로컬 변수 캡처: " + captureLocal.get());
        
        // final 변수 캡처
        java.util.function.Supplier<Integer> captureFinal = () -> finalVar + 20;
        System.out.println("final 변수 캡처: " + captureFinal.get());
        
        // 인스턴스 변수 캡처
        LambdaBasicExample example = new LambdaBasicExample();
        example.instanceVar = 300;
        java.util.function.Supplier<Integer> captureInstance = () -> example.instanceVar + 30;
        System.out.println("인스턴스 변수 캡처: " + captureInstance.get());
        
        // ============================================
        // 5. 람다식과 익명 클래스 비교
        // ============================================
        System.out.println("\n5. 람다식과 익명 클래스 비교");
        System.out.println("-----------------------------------");
        
        // 익명 클래스: this는 익명 클래스 자신
        Runnable anonymous = new Runnable() {
            @Override
            public void run() {
                System.out.println("익명 클래스: " + this.getClass().getName());
            }
        };
        anonymous.run();
        
        // 람다식: this는 람다식을 포함하는 클래스
        // 주의: static 메서드에서는 this를 사용할 수 없으므로 클래스 이름을 직접 사용
        Runnable lambda = () -> {
            System.out.println("람다식: " + LambdaBasicExample.class.getName());
        };
        lambda.run();
        
        // ============================================
        // 6. 람다식 활용: 컬렉션 순회
        // ============================================
        System.out.println("\n6. 람다식 활용: 컬렉션 순회");
        System.out.println("-----------------------------------");
        
        List<String> fruits = Arrays.asList("사과", "바나나", "오렌지", "포도");
        
        // 기존 방식
        System.out.print("기존 방식: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();
        
        // forEach와 람다식
        System.out.print("forEach + 람다식: ");
        fruits.forEach(fruit -> System.out.print(fruit + " "));
        System.out.println();
        
        // 메서드 참조
        System.out.print("메서드 참조: ");
        fruits.forEach(System.out::print);
        System.out.println();
        
        // ============================================
        // 7. 람다식 활용: 조건부 처리
        // ============================================
        System.out.println("\n7. 람다식 활용: 조건부 처리");
        System.out.println("-----------------------------------");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // 짝수만 필터링
        System.out.print("짝수만: ");
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // 5보다 큰 수만 필터링
        System.out.print("5보다 큰 수: ");
        numbers.stream()
                .filter(n -> n > 5)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // ============================================
        // 8. 람다식 활용: 변환 (map)
        // ============================================
        System.out.println("\n8. 람다식 활용: 변환");
        System.out.println("-----------------------------------");
        
        List<String> words = Arrays.asList("java", "python", "javascript");
        
        // 대문자로 변환
        System.out.print("대문자 변환: ");
        words.stream()
                .map(s -> s.toUpperCase())
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        
        // 길이로 변환
        System.out.print("길이 변환: ");
        words.stream()
                .map(s -> s.length())
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // 제곱 변환
        System.out.print("제곱 변환: ");
        numbers.stream()
                .map(n -> n * n)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
    
    private int instanceVar = 0;
}

