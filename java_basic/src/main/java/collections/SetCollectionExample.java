package collections;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Set 컬렉션 예제
 * HashSet, LinkedHashSet, TreeSet
 */
public class SetCollectionExample {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        System.out.println("=== Set 컬렉션 예제 ===\n");
        
        // ============================================
        // 1. HashSet
        // ============================================
        System.out.println("1. HashSet (순서 없음, 중복 불가)");
        System.out.println("-----------------------------------");
        Set<String> hashSet = new HashSet<>();
        
        // 요소 추가
        hashSet.add("Java");
        hashSet.add("Python");
        hashSet.add("JavaScript");
        hashSet.add("Java");  // 중복 추가 시도 (무시됨)
        hashSet.add("C++");
        
        System.out.println("HashSet: " + hashSet);
        System.out.println("크기: " + hashSet.size());
        System.out.println("'Java' 포함 여부: " + hashSet.contains("Java"));
        
        // 순회 (순서 보장 안 됨)
        System.out.print("순회: ");
        for (String item : hashSet) {
            System.out.print(item + " ");
        }
        System.out.println();
        
        // 요소 삭제
        hashSet.remove("C++");
        System.out.println("삭제 후: " + hashSet);
        
        // ============================================
        // 2. LinkedHashSet
        // ============================================
        System.out.println("\n2. LinkedHashSet (삽입 순서 유지, 중복 불가)");
        System.out.println("-----------------------------------");
        Set<String> linkedHashSet = new LinkedHashSet<>();
        
        linkedHashSet.add("첫 번째");
        linkedHashSet.add("두 번째");
        linkedHashSet.add("세 번째");
        linkedHashSet.add("첫 번째");  // 중복 (무시됨)
        linkedHashSet.add("네 번째");
        
        System.out.println("LinkedHashSet: " + linkedHashSet);
        System.out.print("순회 (삽입 순서 유지): ");
        for (String item : linkedHashSet) {
            System.out.print(item + " ");
        }
        System.out.println();
        
        // ============================================
        // 3. TreeSet
        // ============================================
        System.out.println("\n3. TreeSet (정렬된 순서, 중복 불가)");
        System.out.println("-----------------------------------");
        Set<String> treeSet = new TreeSet<>();
        
        treeSet.add("사과");
        treeSet.add("바나나");
        treeSet.add("오렌지");
        treeSet.add("포도");
        treeSet.add("사과");  // 중복 (무시됨)
        
        System.out.println("TreeSet: " + treeSet);
        System.out.print("순회 (정렬된 순서): ");
        for (String item : treeSet) {
            System.out.print(item + " ");
        }
        System.out.println();
        
        // TreeSet의 범위 검색 메서드
        TreeSet<Integer> numberSet = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50, 60, 70));
        System.out.println("\nTreeSet 범위 검색:");
        System.out.println("전체: " + numberSet);
        System.out.println("30보다 작은 값들: " + numberSet.headSet(30));
        System.out.println("30보다 큰 값들: " + numberSet.tailSet(30, false));
        System.out.println("30~50 사이: " + numberSet.subSet(30, 50));
        System.out.println("첫 번째 요소: " + numberSet.first());
        System.out.println("마지막 요소: " + numberSet.last());
        
        // ============================================
        // 4. Set 연산 (합집합, 교집합, 차집합)
        // ============================================
        System.out.println("\n4. Set 연산");
        System.out.println("-----------------------------------");
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
        
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        
        // 합집합
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("합집합: " + union);
        
        // 교집합
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("교집합: " + intersection);
        
        // 차집합
        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("차집합 (Set1 - Set2): " + difference);
        
        // ============================================
        // 5. 커스텀 객체를 Set에 저장
        // ============================================
        System.out.println("\n5. 커스텀 객체를 Set에 저장");
        System.out.println("-----------------------------------");
        Set<Student> studentSet = new HashSet<>();
        
        studentSet.add(new Student(1, "홍길동"));
        studentSet.add(new Student(2, "김철수"));
        studentSet.add(new Student(1, "홍길동"));  // 같은 ID (중복)
        studentSet.add(new Student(3, "이영희"));
        
        System.out.println("학생 수: " + studentSet.size());
        for (Student student : studentSet) {
            System.out.println(student);
        }
        
        // TreeSet에 커스텀 객체 저장 (Comparable 구현 필요)
        System.out.println("\nTreeSet에 커스텀 객체 저장:");
        Set<Student> studentTreeSet = new TreeSet<>();
        studentTreeSet.add(new Student(3, "이영희"));
        studentTreeSet.add(new Student(1, "홍길동"));
        studentTreeSet.add(new Student(2, "김철수"));
        
        for (Student student : studentTreeSet) {
            System.out.println(student);
        }
    }
}

// Set에 저장할 커스텀 클래스
class Student implements Comparable<Student> {
    private int id;
    private String name;
    
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    // HashSet에서 중복 판단을 위한 equals와 hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id == student.id;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    // TreeSet에서 정렬을 위한 compareTo
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);
    }
    
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}

