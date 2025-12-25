package collections;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * List 컬렉션 예제
 * ArrayList, LinkedList, Vector, Stack
 */
public class ListCollectionExample {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        System.out.println("=== List 컬렉션 예제 ===\n");
        
        // ============================================
        // 1. ArrayList
        // ============================================
        System.out.println("1. ArrayList");
        System.out.println("-----------------------------------");
        List<String> arrayList = new ArrayList<>();
        
        // 요소 추가
        arrayList.add("Java");
        arrayList.add("Python");
        arrayList.add("JavaScript");
        arrayList.add(1, "C++");  // 특정 인덱스에 추가
        System.out.println("초기 리스트: " + arrayList);
        
        // 요소 접근
        System.out.println("인덱스 0: " + arrayList.get(0));
        System.out.println("리스트 크기: " + arrayList.size());
        
        // 요소 수정
        arrayList.set(2, "C#");
        System.out.println("수정 후: " + arrayList);
        
        // 요소 검색
        System.out.println("'Java' 포함 여부: " + arrayList.contains("Java"));
        System.out.println("'Java' 인덱스: " + arrayList.indexOf("Java"));
        
        // 요소 삭제
        arrayList.remove("C++");
        arrayList.remove(0);
        System.out.println("삭제 후: " + arrayList);
        
        // 반복문으로 순회
        System.out.print("for-each: ");
        for (String item : arrayList) {
            System.out.print(item + " ");
        }
        System.out.println();
        
        // Iterator 사용
        System.out.print("Iterator: ");
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        
        // 정렬
        Collections.sort(arrayList);
        System.out.println("정렬 후: " + arrayList);
        
        // ============================================
        // 2. LinkedList
        // ============================================
        System.out.println("\n2. LinkedList");
        System.out.println("-----------------------------------");
        List<String> linkedList = new LinkedList<>();
        
        linkedList.add("첫 번째");
        linkedList.add("두 번째");
        linkedList.add("세 번째");
        System.out.println("LinkedList: " + linkedList);
        
        // LinkedList는 양방향 접근 가능
        LinkedList<String> linkedList2 = new LinkedList<>();
        linkedList2.addFirst("맨 앞");
        linkedList2.addLast("맨 뒤");
        linkedList2.add("중간");
        System.out.println("LinkedList (양방향): " + linkedList2);
        System.out.println("첫 번째 요소: " + linkedList2.getFirst());
        System.out.println("마지막 요소: " + linkedList2.getLast());
        
        // ArrayList vs LinkedList 성능 비교
        System.out.println("\n성능 비교 (앞에 추가):");
        long startTime = System.nanoTime();
        List<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            arrList.add(0, i);
        }
        long endTime = System.nanoTime();
        System.out.println("ArrayList: " + (endTime - startTime) + " ns");
        
        startTime = System.nanoTime();
        List<Integer> linkList = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            linkList.add(0, i);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList: " + (endTime - startTime) + " ns");
        
        // ============================================
        // 3. Vector
        // ============================================
        System.out.println("\n3. Vector (동기화된 ArrayList)");
        System.out.println("-----------------------------------");
        Vector<String> vector = new Vector<>();
        
        vector.add("요소1");
        vector.add("요소2");
        vector.add("요소3");
        System.out.println("Vector: " + vector);
        System.out.println("Vector 크기: " + vector.size());
        System.out.println("Vector 용량: " + vector.capacity());
        
        // 용량 설정
        Vector<String> vector2 = new Vector<>(5, 3);  // 초기 용량 5, 증가량 3
        for (int i = 0; i < 10; i++) {
            vector2.add("요소" + i);
        }
        System.out.println("Vector2 크기: " + vector2.size());
        System.out.println("Vector2 용량: " + vector2.capacity());
        
        // ============================================
        // 4. Stack
        // ============================================
        System.out.println("\n4. Stack (LIFO - Last In First Out)");
        System.out.println("-----------------------------------");
        Stack<String> stack = new Stack<>();
        
        // push: 요소 추가
        stack.push("첫 번째");
        stack.push("두 번째");
        stack.push("세 번째");
        System.out.println("Stack: " + stack);
        
        // peek: 맨 위 요소 확인 (제거하지 않음)
        System.out.println("맨 위 요소 (peek): " + stack.peek());
        System.out.println("Stack: " + stack);
        
        // pop: 맨 위 요소 제거
        System.out.println("맨 위 요소 제거 (pop): " + stack.pop());
        System.out.println("Stack: " + stack);
        
        // empty: 스택이 비어있는지 확인
        System.out.println("비어있나? " + stack.empty());
        
        // search: 요소의 위치 찾기 (1부터 시작, 맨 위가 1)
        System.out.println("'첫 번째' 위치: " + stack.search("첫 번째"));
        
        // 스택 활용 예제: 괄호 매칭
        System.out.println("\n스택 활용 예제: 괄호 매칭");
        System.out.println("-----------------------------------");
        System.out.println("(()): " + isValidParentheses("(())"));
        System.out.println("(()): " + isValidParentheses("(()"));
        System.out.println("()(): " + isValidParentheses("()()"));
        
        // ============================================
        // 5. List 유틸리티 메서드
        // ============================================
        System.out.println("\n5. List 유틸리티 메서드");
        System.out.println("-----------------------------------");
        List<Integer> numbers = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6));
        System.out.println("원본: " + numbers);
        
        // 최대값, 최소값
        System.out.println("최대값: " + Collections.max(numbers));
        System.out.println("최소값: " + Collections.min(numbers));
        
        // 섞기
        Collections.shuffle(numbers);
        System.out.println("섞은 후: " + numbers);
        
        // 역순 정렬
        Collections.sort(numbers);
        Collections.reverse(numbers);
        System.out.println("역순 정렬: " + numbers);
        
        // 부분 리스트
        List<Integer> subList = numbers.subList(2, 5);
        System.out.println("부분 리스트 (2~4): " + subList);
        
        // 리스트를 배열로 변환
        String[] array = arrayList.toArray(new String[0]);
        System.out.println("배열로 변환: " + Arrays.toString(array));
        
        // 배열을 리스트로 변환
        List<String> listFromArray = Arrays.asList("가", "나", "다");
        System.out.println("배열에서 리스트: " + listFromArray);
    }
    
    // 괄호 매칭 검사 메서드
    private static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}

