package lambda;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 배열과 컬렉션에서 람다식 활용 예제
 */
public class CollectionLambdaExample {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        System.out.println("=== 배열과 컬렉션에서 람다식 활용 ===\n");
        
        // ============================================
        // 1. List와 람다식
        // ============================================
        System.out.println("1. List와 람다식");
        System.out.println("-----------------------------------");
        
        List<String> fruits = new ArrayList<>(Arrays.asList("사과", "바나나", "오렌지", "포도", "딸기"));
        
        // forEach로 순회
        System.out.print("forEach 순회: ");
        fruits.forEach(fruit -> System.out.print(fruit + " "));
        System.out.println();
        
        // removeIf로 조건에 맞는 요소 제거
        fruits.removeIf(fruit -> fruit.length() > 2);
        System.out.println("길이가 2보다 큰 요소 제거 후: " + fruits);
        
        // replaceAll로 모든 요소 변환
        fruits.replaceAll(fruit -> fruit.toUpperCase());
        System.out.println("대문자로 변환: " + fruits);
        
        // sort와 람다식
        List<Integer> numbers = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6));
        System.out.println("\n정렬 전: " + numbers);
        numbers.sort((a, b) -> a - b);  // 오름차순
        System.out.println("오름차순 정렬: " + numbers);
        numbers.sort((a, b) -> b - a);  // 내림차순
        System.out.println("내림차순 정렬: " + numbers);
        
        // ============================================
        // 2. Map과 람다식
        // ============================================
        System.out.println("\n2. Map과 람다식");
        System.out.println("-----------------------------------");
        
        Map<String, Integer> scores = new HashMap<>();
        scores.put("홍길동", 85);
        scores.put("김철수", 92);
        scores.put("이영희", 78);
        scores.put("박민수", 95);
        
        // forEach로 키-값 쌍 순회
        System.out.println("점수 목록:");
        scores.forEach((name, score) -> 
            System.out.println("  " + name + ": " + score)
        );
        
        // replaceAll로 모든 값 변환
        scores.replaceAll((name, score) -> score + 5);  // 모든 점수에 5점 추가
        System.out.println("\n5점 추가 후:");
        scores.forEach((name, score) -> 
            System.out.println("  " + name + ": " + score)
        );
        
        // compute: 키에 대한 값 계산
        scores.compute("홍길동", (name, score) -> score != null ? score * 2 : 0);
        System.out.println("\n홍길동 점수 2배: " + scores.get("홍길동"));
        
        // computeIfAbsent: 키가 없을 때만 계산
        scores.computeIfAbsent("최지영", name -> 90);
        System.out.println("최지영 추가: " + scores.get("최지영"));
        
        // computeIfPresent: 키가 있을 때만 계산
        scores.computeIfPresent("김철수", (name, score) -> score + 10);
        System.out.println("김철수 점수 +10: " + scores.get("김철수"));
        
        // merge: 두 값 병합
        scores.merge("이영희", 10, (oldValue, newValue) -> oldValue + newValue);
        System.out.println("이영희 점수 병합: " + scores.get("이영희"));
        
        // ============================================
        // 3. Set과 람다식
        // ============================================
        System.out.println("\n3. Set과 람다식");
        System.out.println("-----------------------------------");
        
        Set<String> languages = new HashSet<>(Arrays.asList("Java", "Python", "JavaScript", "C++", "Ruby"));
        
        // forEach로 순회
        System.out.print("언어 목록: ");
        languages.forEach(lang -> System.out.print(lang + " "));
        System.out.println();
        
        // removeIf로 조건에 맞는 요소 제거
        languages.removeIf(lang -> lang.startsWith("J"));
        System.out.println("'J'로 시작하는 언어 제거 후: " + languages);
        
        // ============================================
        // 4. 배열과 람다식
        // ============================================
        System.out.println("\n4. 배열과 람다식");
        System.out.println("-----------------------------------");
        
        int[] numbersArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        // 배열을 Stream으로 변환하여 람다식 사용
        System.out.print("짝수만 필터링: ");
        Arrays.stream(numbersArray)
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // 배열 요소 변환
        System.out.print("제곱으로 변환: ");
        Arrays.stream(numbersArray)
                .map(n -> n * n)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // 배열 정렬 (람다식 사용)
        String[] words = {"banana", "apple", "cherry", "date"};
        System.out.println("정렬 전: " + Arrays.toString(words));
        Arrays.sort(words, (a, b) -> a.compareTo(b));
        System.out.println("정렬 후: " + Arrays.toString(words));
        
        // 길이로 정렬
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        System.out.println("길이 순 정렬: " + Arrays.toString(words));
        
        // ============================================
        // 5. Stream API와 람다식 (List)
        // ============================================
        System.out.println("\n5. Stream API와 람다식 (List)");
        System.out.println("-----------------------------------");
        
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // 필터링
        System.out.print("5보다 큰 수: ");
        nums.stream()
                .filter(n -> n > 5)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // 변환 (map)
        System.out.print("제곱: ");
        nums.stream()
                .map(n -> n * n)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // 조건부 변환
        System.out.print("짝수는 2배, 홀수는 그대로: ");
        nums.stream()
                .map(n -> n % 2 == 0 ? n * 2 : n)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // 정렬
        List<String> names = Arrays.asList("홍길동", "김철수", "이영희", "박민수");
        System.out.print("이름 정렬: ");
        names.stream()
                .sorted((a, b) -> a.compareTo(b))
                .forEach(name -> System.out.print(name + " "));
        System.out.println();
        
        // ============================================
        // 6. Stream API 집계 연산
        // ============================================
        System.out.println("\n6. Stream API 집계 연산");
        System.out.println("-----------------------------------");
        
        List<Integer> values = Arrays.asList(10, 20, 30, 40, 50);
        
        // 합계
        int sum = values.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("합계: " + sum);
        
        // 곱셈
        int product = values.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println("곱셈: " + product);
        
        // 최대값
        Optional<Integer> max = values.stream()
                .reduce((a, b) -> a > b ? a : b);
        System.out.println("최대값: " + max.orElse(0));
        
        // 최소값
        Optional<Integer> min = values.stream()
                .reduce((a, b) -> a < b ? a : b);
        System.out.println("최소값: " + min.orElse(0));
        
        // ============================================
        // 7. Stream API 수집 (Collectors)
        // ============================================
        System.out.println("\n7. Stream API 수집 (Collectors)");
        System.out.println("-----------------------------------");
        
        List<String> items = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        
        // List로 수집
        List<String> filtered = items.stream()
                .filter(s -> s.length() > 5)
                .collect(Collectors.toList());
        System.out.println("길이가 5보다 긴 단어: " + filtered);
        
        // Set으로 수집
        Set<String> upperSet = items.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
        System.out.println("대문자 Set: " + upperSet);
        
        // Map으로 수집
        Map<String, Integer> lengthMap = items.stream()
                .collect(Collectors.toMap(
                        item -> item,
                        item -> item.length()
                ));
        System.out.println("단어-길이 Map: " + lengthMap);
        
        // 그룹화
        Map<Integer, List<String>> groupedByLength = items.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("길이별 그룹화: " + groupedByLength);
        
        // 분할 (조건에 따라 true/false로 분할)
        Map<Boolean, List<String>> partitioned = items.stream()
                .collect(Collectors.partitioningBy(s -> s.length() > 5));
        System.out.println("길이 5 기준 분할:");
        System.out.println("  true: " + partitioned.get(true));
        System.out.println("  false: " + partitioned.get(false));
        
        // ============================================
        // 8. 중첩 컬렉션과 람다식
        // ============================================
        System.out.println("\n8. 중첩 컬렉션과 람다식");
        System.out.println("-----------------------------------");
        
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );
        
        // 평탄화 (flatMap)
        List<Integer> flattened = nestedList.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());
        System.out.println("평탄화: " + flattened);
        
        // 중첩 리스트의 각 요소에 연산 적용
        List<List<Integer>> doubled = nestedList.stream()
                .map(list -> list.stream()
                        .map(n -> n * 2)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
        System.out.println("각 요소 2배: " + doubled);
        
        // ============================================
        // 9. 실전 예제: 학생 데이터 처리
        // ============================================
        System.out.println("\n9. 실전 예제: 학생 데이터 처리");
        System.out.println("-----------------------------------");
        
        List<Student> students = Arrays.asList(
                new Student("홍길동", 85, "컴퓨터공학과"),
                new Student("김철수", 92, "전자공학과"),
                new Student("이영희", 78, "컴퓨터공학과"),
                new Student("박민수", 95, "수학과"),
                new Student("최지영", 88, "전자공학과"),
                new Student("정수진", 82, "수학과")
        );
        
        // 90점 이상 학생 이름
        System.out.println("90점 이상 학생:");
        students.stream()
                .filter(s -> s.getScore() >= 90)
                .map(Student::getName)
                .forEach(name -> System.out.println("  " + name));
        
        // 과별 평균 점수
        System.out.println("\n과별 평균 점수:");
        Map<String, Double> avgByMajor = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getMajor,
                        Collectors.averagingDouble(Student::getScore)
                ));
        avgByMajor.forEach((major, avg) -> 
            System.out.println("  " + major + ": " + String.format("%.2f", avg))
        );
        
        // 과별 학생 수
        System.out.println("\n과별 학생 수:");
        Map<String, Long> countByMajor = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getMajor,
                        Collectors.counting()
                ));
        countByMajor.forEach((major, count) -> 
            System.out.println("  " + major + ": " + count + "명")
        );
        
        // 점수 순으로 정렬
        System.out.println("\n점수 순 정렬 (내림차순):");
        students.stream()
                .sorted((s1, s2) -> s2.getScore() - s1.getScore())
                .forEach(s -> System.out.println("  " + s.getName() + ": " + s.getScore()));
        
        // ============================================
        // 10. 실전 예제: 배열 처리
        // ============================================
        System.out.println("\n10. 실전 예제: 배열 처리");
        System.out.println("-----------------------------------");
        
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        // 짝수의 합
        int evenSum = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .sum();
        System.out.println("짝수의 합: " + evenSum);
        
        // 평균
        double average = Arrays.stream(arr)
                .average()
                .orElse(0.0);
        System.out.println("평균: " + average);
        
        // 최대값, 최소값
        OptionalInt maxValue = Arrays.stream(arr).max();
        OptionalInt minValue = Arrays.stream(arr).min();
        System.out.println("최대값: " + maxValue.orElse(0));
        System.out.println("최소값: " + minValue.orElse(0));
        
        // 조건에 맞는 요소 개수
        long count = Arrays.stream(arr)
                .filter(n -> n > 5)
                .count();
        System.out.println("5보다 큰 수의 개수: " + count);
        
        // ============================================
        // 11. 실전 예제: 문자열 배열 처리
        // ============================================
        System.out.println("\n11. 실전 예제: 문자열 배열 처리");
        System.out.println("-----------------------------------");
        
        String[] textWords = {"  java  ", "  PYTHON  ", "  JavaScript  ", "  c++  ", "  Ruby  "};
        
        // 공백 제거, 소문자 변환, 첫 글자 대문자
        List<String> cleaned = Arrays.stream(textWords)
                .map(String::trim)
                .map(String::toLowerCase)
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .collect(Collectors.toList());
        System.out.println("정제된 문자열: " + cleaned);
        
        // 길이가 5보다 긴 단어만 필터링
        List<String> longWords = Arrays.stream(textWords)
                .map(String::trim)
                .filter(s -> s.length() > 5)
                .collect(Collectors.toList());
        System.out.println("길이가 5보다 긴 단어: " + longWords);
        
        // 단어 길이의 합
        int totalLength = Arrays.stream(textWords)
                .mapToInt(String::length)
                .sum();
        System.out.println("전체 길이 합: " + totalLength);
    }
}

// Student 클래스 (내부 클래스)
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

