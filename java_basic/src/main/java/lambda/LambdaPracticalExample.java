package lambda;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * 람다식 실전 활용 예제
 */
public class LambdaPracticalExample {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        System.out.println("=== 람다식 실전 활용 예제 ===\n");
        
        // ============================================
        // 1. 학생 성적 처리
        // ============================================
        System.out.println("1. 학생 성적 처리");
        System.out.println("-----------------------------------");
        List<Student> students = Arrays.asList(
                new Student("홍길동", 85, "컴퓨터공학과"),
                new Student("김철수", 92, "전자공학과"),
                new Student("이영희", 78, "컴퓨터공학과"),
                new Student("박민수", 95, "수학과"),
                new Student("최지영", 88, "전자공학과")
        );
        
        // 90점 이상 학생
        System.out.println("90점 이상 학생:");
        students.stream()
                .filter(s -> s.getScore() >= 90)
                .forEach(s -> System.out.println("  " + s.getName() + ": " + s.getScore()));
        
        // 평균 점수
        double avgScore = students.stream()
                .mapToInt(Student::getScore)
                .average()
                .orElse(0.0);
        System.out.println("\n평균 점수: " + avgScore);
        
        // 과별 그룹화
        Map<String, List<Student>> byMajor = students.stream()
                .collect(Collectors.groupingBy(Student::getMajor));
        System.out.println("\n과별 그룹화:");
        byMajor.forEach((major, studentList) -> {
            System.out.println("  " + major + ": " + studentList.size() + "명");
        });
        
        // ============================================
        // 2. 이벤트 처리 (콜백)
        // ============================================
        System.out.println("\n2. 이벤트 처리 (콜백)");
        System.out.println("-----------------------------------");
        
        Button button = new Button("클릭");
        
        // 람다식으로 이벤트 핸들러 등록
        button.setOnClick(() -> System.out.println("버튼이 클릭되었습니다!"));
        button.click();
        
        button.setOnClick(() -> {
            System.out.println("다른 동작을 수행합니다.");
            System.out.println("이벤트 처리 완료!");
        });
        button.click();
        
        // ============================================
        // 3. 스레드 처리
        // ============================================
        System.out.println("\n3. 스레드 처리");
        System.out.println("-----------------------------------");
        
        // 람다식으로 스레드 생성
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("스레드 1: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("스레드 2: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // ============================================
        // 4. 정렬과 비교
        // ============================================
        System.out.println("\n4. 정렬과 비교");
        System.out.println("-----------------------------------");
        
        List<Product> products = Arrays.asList(
                new Product("노트북", 1000000),
                new Product("마우스", 30000),
                new Product("키보드", 50000),
                new Product("모니터", 200000)
        );
        
        // 가격 오름차순 정렬
        System.out.println("가격 오름차순:");
        products.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .forEach(p -> System.out.println("  " + p));
        
        // 가격 내림차순 정렬
        System.out.println("\n가격 내림차순:");
        products.stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .forEach(p -> System.out.println("  " + p));
        
        // 이름으로 정렬
        System.out.println("\n이름 순 정렬:");
        products.stream()
                .sorted(Comparator.comparing(Product::getName))
                .forEach(p -> System.out.println("  " + p));
        
        // ============================================
        // 5. 조건부 처리와 변환
        // ============================================
        System.out.println("\n5. 조건부 처리와 변환");
        System.out.println("-----------------------------------");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // 짝수만 제곱
        System.out.print("짝수만 제곱: ");
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // 5보다 큰 수만 2배
        System.out.print("5보다 큰 수만 2배: ");
        numbers.stream()
                .filter(n -> n > 5)
                .map(n -> n * 2)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // ============================================
        // 6. Optional과 람다식
        // ============================================
        System.out.println("\n6. Optional과 람다식");
        System.out.println("-----------------------------------");
        
        Optional<String> optional1 = Optional.of("Hello");
        Optional<String> optional2 = Optional.empty();
        
        // ifPresent: 값이 있으면 실행
        optional1.ifPresent(s -> System.out.println("값 있음: " + s));
        optional2.ifPresent(s -> System.out.println("값 있음: " + s));
        
        // orElse: 값이 없으면 기본값 반환
        String result1 = optional1.orElse("기본값");
        String result2 = optional2.orElse("기본값");
        System.out.println("optional1: " + result1);
        System.out.println("optional2: " + result2);
        
        // map: 값 변환
        Optional<Integer> length = optional1.map(String::length);
        length.ifPresent(l -> System.out.println("길이: " + l));
        
        // ============================================
        // 7. 함수 조합
        // ============================================
        System.out.println("\n7. 함수 조합");
        System.out.println("-----------------------------------");
        
        Function<Integer, Integer> addOne = x -> x + 1;
        Function<Integer, Integer> multiplyTwo = x -> x * 2;
        Function<Integer, Integer> square = x -> x * x;
        
        // 함수 합성
        Function<Integer, Integer> composed1 = addOne.andThen(multiplyTwo).andThen(square);
        System.out.println("((5 + 1) * 2)² = " + composed1.apply(5));
        
        Function<Integer, Integer> composed2 = square.compose(multiplyTwo).compose(addOne);
        System.out.println("((5 + 1) * 2)² = " + composed2.apply(5));
        
        // ============================================
        // 8. 커스텀 함수형 인터페이스 활용
        // ============================================
        System.out.println("\n8. 커스텀 함수형 인터페이스 활용");
        System.out.println("-----------------------------------");
        
        // 문자열 처리 함수
        StringProcessor toUpper = s -> s.toUpperCase();
        StringProcessor addExclamation = s -> s + "!";
        StringProcessor addPrefix = s -> ">> " + s;
        
        String result = processString("hello", toUpper.andThen(addExclamation).andThen(addPrefix));
        System.out.println("처리 결과: " + result);
        
        // ============================================
        // 9. 실전 예제: 데이터 변환 파이프라인
        // ============================================
        System.out.println("\n9. 실전 예제: 데이터 변환 파이프라인");
        System.out.println("-----------------------------------");
        
        List<String> data = Arrays.asList("  java  ", "  PYTHON  ", "  JavaScript  ", "  c++  ");
        
        // 데이터 정제 파이프라인
        List<String> cleaned = data.stream()
                .map(String::trim)              // 공백 제거
                .map(String::toLowerCase)       // 소문자 변환
                .filter(s -> s.length() > 3)    // 길이 필터링
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))  // 첫 글자 대문자
                .collect(Collectors.toList());
        
        System.out.println("원본: " + data);
        System.out.println("정제 후: " + cleaned);
    }
    
    // 문자열 처리 헬퍼 메서드
    private static String processString(String input, StringProcessor processor) {
        return processor.process(input);
    }
}

// 학생 클래스
class Student {
    private String name;
    private int score;
    private String major;
    
    public Student(String name, int score, String major) {
        this.name = name;
        this.score = score;
        this.major = major;
    }
    
    public String getName() { return name; }
    public int getScore() { return score; }
    public String getMajor() { return major; }
    
    @Override
    public String toString() {
        return name + " (" + score + "점, " + major + ")";
    }
}

// 제품 클래스
class Product {
    private String name;
    private int price;
    
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() { return name; }
    public int getPrice() { return price; }
    
    @Override
    public String toString() {
        return name + ": " + price + "원";
    }
}

// 버튼 클래스
class Button {
    private String label;
    private Runnable onClickHandler;
    
    public Button(String label) {
        this.label = label;
    }
    
    public void setOnClick(Runnable handler) {
        this.onClickHandler = handler;
    }
    
    public void click() {
        if (onClickHandler != null) {
            onClickHandler.run();
        }
    }
}

// 커스텀 함수형 인터페이스
@FunctionalInterface
interface StringProcessor {
    String process(String input);
    
    default StringProcessor andThen(StringProcessor after) {
        return s -> after.process(this.process(s));
    }
}

