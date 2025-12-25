package collections;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Map 컬렉션 예제
 * HashMap, LinkedHashMap, TreeMap, Hashtable
 */
public class MapCollectionExample {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        System.out.println("=== Map 컬렉션 예제 ===\n");
        
        // ============================================
        // 1. HashMap
        // ============================================
        System.out.println("1. HashMap (순서 없음, 키 중복 불가)");
        System.out.println("-----------------------------------");
        Map<String, Integer> hashMap = new HashMap<>();
        
        // 요소 추가
        hashMap.put("홍길동", 85);
        hashMap.put("김철수", 90);
        hashMap.put("이영희", 92);
        hashMap.put("홍길동", 88);  // 같은 키로 덮어쓰기
        
        System.out.println("HashMap: " + hashMap);
        System.out.println("크기: " + hashMap.size());
        
        // 요소 접근
        System.out.println("홍길동의 점수: " + hashMap.get("홍길동"));
        System.out.println("존재하지 않는 키: " + hashMap.get("박민수"));
        System.out.println("기본값 반환: " + hashMap.getOrDefault("박민수", 0));
        
        // 키 존재 여부 확인
        System.out.println("'김철수' 키 존재: " + hashMap.containsKey("김철수"));
        System.out.println("값 90 존재: " + hashMap.containsValue(90));
        
        // 모든 키 순회
        System.out.print("모든 키: ");
        for (String key : hashMap.keySet()) {
            System.out.print(key + " ");
        }
        System.out.println();
        
        // 모든 값 순회
        System.out.print("모든 값: ");
        for (Integer value : hashMap.values()) {
            System.out.print(value + " ");
        }
        System.out.println();
        
        // 키-값 쌍 순회
        System.out.println("키-값 쌍:");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println("  " + entry.getKey() + " : " + entry.getValue());
        }
        
        // 요소 삭제
        hashMap.remove("이영희");
        System.out.println("삭제 후: " + hashMap);
        
        // ============================================
        // 2. LinkedHashMap
        // ============================================
        System.out.println("\n2. LinkedHashMap (삽입 순서 유지)");
        System.out.println("-----------------------------------");
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        
        linkedHashMap.put("첫 번째", "값1");
        linkedHashMap.put("두 번째", "값2");
        linkedHashMap.put("세 번째", "값3");
        linkedHashMap.put("네 번째", "값4");
        
        System.out.println("LinkedHashMap: " + linkedHashMap);
        System.out.print("순회 (삽입 순서 유지): ");
        for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
            System.out.print(entry.getKey() + "=" + entry.getValue() + " ");
        }
        System.out.println();
        
        // ============================================
        // 3. TreeMap
        // ============================================
        System.out.println("\n3. TreeMap (키 정렬, 키 중복 불가)");
        System.out.println("-----------------------------------");
        Map<String, Integer> treeMap = new TreeMap<>();
        
        treeMap.put("사과", 1000);
        treeMap.put("바나나", 2000);
        treeMap.put("오렌지", 1500);
        treeMap.put("포도", 3000);
        
        System.out.println("TreeMap: " + treeMap);
        System.out.print("순회 (키 정렬된 순서): ");
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.print(entry.getKey() + "=" + entry.getValue() + " ");
        }
        System.out.println();
        
        // TreeMap의 범위 검색
        TreeMap<Integer, String> numberMap = new TreeMap<>();
        numberMap.put(10, "십");
        numberMap.put(20, "이십");
        numberMap.put(30, "삼십");
        numberMap.put(40, "사십");
        numberMap.put(50, "오십");
        
        System.out.println("\nTreeMap 범위 검색:");
        System.out.println("전체: " + numberMap);
        System.out.println("30보다 작은 키들: " + numberMap.headMap(30));
        System.out.println("30 이상의 키들: " + numberMap.tailMap(30));
        System.out.println("20~40 사이: " + numberMap.subMap(20, 40));
        System.out.println("첫 번째 키: " + numberMap.firstKey());
        System.out.println("마지막 키: " + numberMap.lastKey());
        
        // ============================================
        // 4. Hashtable
        // ============================================
        System.out.println("\n4. Hashtable (동기화된 HashMap)");
        System.out.println("-----------------------------------");
        Hashtable<String, String> hashtable = new Hashtable<>();
        
        hashtable.put("key1", "value1");
        hashtable.put("key2", "value2");
        hashtable.put("key3", "value3");
        
        System.out.println("Hashtable: " + hashtable);
        System.out.println("크기: " + hashtable.size());
        
        // null 키나 값 허용 안 함 (HashMap은 허용)
        // hashtable.put(null, "value");  // NullPointerException 발생
        
        // ============================================
        // 5. Map 유틸리티 메서드
        // ============================================
        System.out.println("\n5. Map 유틸리티 메서드");
        System.out.println("-----------------------------------");
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        
        // putIfAbsent: 키가 없을 때만 추가
        map.putIfAbsent("D", 4);
        map.putIfAbsent("A", 10);  // 이미 존재하므로 추가 안 됨
        System.out.println("putIfAbsent 후: " + map);
        
        // replace: 값 교체
        map.replace("B", 20);
        System.out.println("replace 후: " + map);
        
        // replaceAll: 모든 값 변환
        map.replaceAll((key, value) -> value * 10);
        System.out.println("replaceAll 후: " + map);
        
        // compute: 키에 대한 값 계산
        map.compute("A", (key, value) -> value + 100);
        System.out.println("compute 후: " + map);
        
        // merge: 두 값 병합
        map.merge("B", 5, (oldValue, newValue) -> oldValue + newValue);
        System.out.println("merge 후: " + map);
        
        // ============================================
        // 6. 중첩 Map
        // ============================================
        System.out.println("\n6. 중첩 Map");
        System.out.println("-----------------------------------");
        Map<String, Map<String, Integer>> nestedMap = new HashMap<>();
        
        Map<String, Integer> scores1 = new HashMap<>();
        scores1.put("수학", 90);
        scores1.put("영어", 85);
        nestedMap.put("홍길동", scores1);
        
        Map<String, Integer> scores2 = new HashMap<>();
        scores2.put("수학", 95);
        scores2.put("영어", 92);
        nestedMap.put("김철수", scores2);
        
        System.out.println("중첩 Map:");
        for (Map.Entry<String, Map<String, Integer>> entry : nestedMap.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
        
        // ============================================
        // 7. 실전 예제: 단어 빈도수 계산
        // ============================================
        System.out.println("\n7. 실전 예제: 단어 빈도수 계산");
        System.out.println("-----------------------------------");
        String text = "java is great java is fun java is powerful";
        String[] words = text.split(" ");
        
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        System.out.println("단어 빈도수:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
    }
}

