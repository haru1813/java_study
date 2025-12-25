package collections;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Iterator와 Stream API 예제
 */
public class IteratorAndStreamExample {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        System.out.println("=== Iterator와 Stream API 예제 ===\n");
        
        // ============================================
        // 1. Iterator
        // ============================================
        System.out.println("1. Iterator");
        System.out.println("-----------------------------------");
        List<String> list = Arrays.asList("Java", "Python", "JavaScript", "C++");
        
        // Iterator 사용
        Iterator<String> iterator = list.iterator();
        System.out.print("Iterator 순회: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        
        // ListIterator (양방향 순회)
        System.out.println("\nListIterator (양방향 순회):");
        ListIterator<String> listIterator = list.listIterator();
        
        System.out.print("정방향: ");
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();
        
        System.out.print("역방향: ");
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
        System.out.println();
        
        // Iterator로 요소 제거
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("\nIterator로 요소 제거:");
        System.out.println("제거 전: " + numbers);
        Iterator<Integer> it = numbers.iterator();
        while (it.hasNext()) {
            int num = it.next();
            if (num % 2 == 0) {
                it.remove();  // 안전한 제거
            }
        }
        System.out.println("제거 후: " + numbers);
        
        // ============================================
        // 2. Stream API 기본
        // ============================================
        System.out.println("\n2. Stream API 기본");
        System.out.println("-----------------------------------");
        List<String> languages = Arrays.asList("Java", "Python", "JavaScript", "C++", "C#", "Ruby");
        
        // 필터링
        System.out.println("'J'로 시작하는 언어:");
        languages.stream()
                .filter(lang -> lang.startsWith("J"))
                .forEach(System.out::println);
        
        // 변환 (map)
        System.out.println("\n대문자로 변환:");
        languages.stream()
                .map(String::toUpperCase)
                .forEach(lang -> System.out.print(lang + " "));
        System.out.println();
        
        // 정렬
        System.out.println("\n정렬된 언어:");
        languages.stream()
                .sorted()
                .forEach(lang -> System.out.print(lang + " "));
        System.out.println();
        
        // 개수 세기
        long count = languages.stream()
                .filter(lang -> lang.length() > 4)
                .count();
        System.out.println("\n길이가 4보다 긴 언어 개수: " + count);
        
        // ============================================
        // 3. Stream 수집 (Collectors)
        // ============================================
        System.out.println("\n3. Stream 수집");
        System.out.println("-----------------------------------");
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // List로 수집
        List<Integer> evenNumbers = nums.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("짝수 리스트: " + evenNumbers);
        
        // Set으로 수집
        Set<Integer> numberSet = nums.stream()
                .filter(n -> n > 5)
                .collect(Collectors.toSet());
        System.out.println("5보다 큰 수 Set: " + numberSet);
        
        // Map으로 수집
        Map<String, Integer> lengthMap = languages.stream()
                .collect(Collectors.toMap(
                        lang -> lang,
                        String::length
                ));
        System.out.println("언어-길이 Map: " + lengthMap);
        
        // 그룹화
        Map<Integer, List<String>> groupedByLength = languages.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("길이별 그룹화: " + groupedByLength);
        
        // ============================================
        // 4. Stream 집계 연산
        // ============================================
        System.out.println("\n4. Stream 집계 연산");
        System.out.println("-----------------------------------");
        List<Integer> numbers2 = Arrays.asList(10, 20, 30, 40, 50);
        
        // 합계
        int sum = numbers2.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("합계: " + sum);
        
        // 평균
        double average = numbers2.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("평균: " + average);
        
        // 최대값, 최소값
        Optional<Integer> max = numbers2.stream().max(Integer::compare);
        Optional<Integer> min = numbers2.stream().min(Integer::compare);
        System.out.println("최대값: " + max.orElse(0));
        System.out.println("최소값: " + min.orElse(0));
        
        // ============================================
        // 5. Stream 중간 연산
        // ============================================
        System.out.println("\n5. Stream 중간 연산");
        System.out.println("-----------------------------------");
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        
        // distinct: 중복 제거
        List<String> distinct = words.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("중복 제거: " + distinct);
        
        // limit: 개수 제한
        List<String> limited = words.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("처음 3개: " + limited);
        
        // skip: 건너뛰기
        List<String> skipped = words.stream()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println("처음 2개 건너뛰기: " + skipped);
        
        // flatMap: 평탄화
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );
        List<Integer> flattened = nestedList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("평탄화: " + flattened);
        
        // ============================================
        // 6. Stream 최종 연산
        // ============================================
        System.out.println("\n6. Stream 최종 연산");
        System.out.println("-----------------------------------");
        List<String> items = Arrays.asList("apple", "banana", "cherry");
        
        // anyMatch: 하나라도 조건 만족
        boolean hasA = items.stream().anyMatch(s -> s.startsWith("a"));
        System.out.println("'a'로 시작하는 요소 있음: " + hasA);
        
        // allMatch: 모두 조건 만족
        boolean allLong = items.stream().allMatch(s -> s.length() > 3);
        System.out.println("모두 길이 3보다 김: " + allLong);
        
        // noneMatch: 모두 조건 불만족
        boolean noneZ = items.stream().noneMatch(s -> s.contains("z"));
        System.out.println("'z' 포함하는 요소 없음: " + noneZ);
        
        // findFirst: 첫 번째 요소
        Optional<String> first = items.stream().findFirst();
        System.out.println("첫 번째 요소: " + first.orElse("없음"));
        
        // ============================================
        // 7. 실전 예제: 학생 성적 처리
        // ============================================
        System.out.println("\n7. 실전 예제: 학생 성적 처리");
        System.out.println("-----------------------------------");
        List<StudentScore> scores = Arrays.asList(
                new StudentScore("홍길동", 85),
                new StudentScore("김철수", 92),
                new StudentScore("이영희", 78),
                new StudentScore("박민수", 95),
                new StudentScore("최지영", 88)
        );
        
        // 평균 점수
        double avgScore = scores.stream()
                .mapToInt(StudentScore::getScore)
                .average()
                .orElse(0.0);
        System.out.println("평균 점수: " + avgScore);
        
        // 90점 이상 학생
        List<String> topStudents = scores.stream()
                .filter(s -> s.getScore() >= 90)
                .map(StudentScore::getName)
                .collect(Collectors.toList());
        System.out.println("90점 이상 학생: " + topStudents);
        
        // 점수 순으로 정렬
        List<StudentScore> sorted = scores.stream()
                .sorted(Comparator.comparing(StudentScore::getScore).reversed())
                .collect(Collectors.toList());
        System.out.println("점수 순 정렬:");
        sorted.forEach(s -> System.out.println("  " + s.getName() + ": " + s.getScore()));
    }
}

// 학생 성적 클래스
class StudentScore {
    private String name;
    private int score;
    
    public StudentScore(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    public String getName() {
        return name;
    }
    
    public int getScore() {
        return score;
    }
}

