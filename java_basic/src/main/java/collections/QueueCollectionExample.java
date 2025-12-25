package collections;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Queue 컬렉션 예제
 * PriorityQueue, ArrayDeque
 */
public class QueueCollectionExample {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        System.out.println("=== Queue 컬렉션 예제 ===\n");
        
        // ============================================
        // 1. Queue 인터페이스 (LinkedList 구현)
        // ============================================
        System.out.println("1. Queue (FIFO - First In First Out)");
        System.out.println("-----------------------------------");
        Queue<String> queue = new LinkedList<>();
        
        // offer: 요소 추가
        queue.offer("첫 번째");
        queue.offer("두 번째");
        queue.offer("세 번째");
        System.out.println("Queue: " + queue);
        
        // peek: 맨 앞 요소 확인 (제거하지 않음)
        System.out.println("맨 앞 요소 (peek): " + queue.peek());
        System.out.println("Queue: " + queue);
        
        // poll: 맨 앞 요소 제거
        System.out.println("맨 앞 요소 제거 (poll): " + queue.poll());
        System.out.println("Queue: " + queue);
        
        // element: peek와 같지만 큐가 비어있으면 예외 발생
        System.out.println("맨 앞 요소 (element): " + queue.element());
        
        // remove: poll과 같지만 큐가 비어있으면 예외 발생
        System.out.println("맨 앞 요소 제거 (remove): " + queue.remove());
        System.out.println("Queue: " + queue);
        
        // ============================================
        // 2. PriorityQueue
        // ============================================
        System.out.println("\n2. PriorityQueue (우선순위 큐)");
        System.out.println("-----------------------------------");
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        
        priorityQueue.offer(30);
        priorityQueue.offer(10);
        priorityQueue.offer(50);
        priorityQueue.offer(20);
        priorityQueue.offer(40);
        
        System.out.println("PriorityQueue: " + priorityQueue);
        System.out.print("우선순위 순서로 제거: ");
        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.poll() + " ");
        }
        System.out.println();
        
        // 내림차순 우선순위 큐
        System.out.println("\n내림차순 PriorityQueue:");
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(30);
        maxHeap.offer(10);
        maxHeap.offer(50);
        maxHeap.offer(20);
        
        System.out.print("내림차순 제거: ");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
        System.out.println();
        
        // 커스텀 객체를 우선순위 큐에 저장
        System.out.println("\n커스텀 객체 PriorityQueue:");
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();
        taskQueue.offer(new Task("낮은 우선순위", 3));
        taskQueue.offer(new Task("높은 우선순위", 1));
        taskQueue.offer(new Task("중간 우선순위", 2));
        
        System.out.print("우선순위 순서: ");
        while (!taskQueue.isEmpty()) {
            System.out.print(taskQueue.poll() + " ");
        }
        System.out.println();
        
        // ============================================
        // 3. ArrayDeque (양방향 큐)
        // ============================================
        System.out.println("\n3. ArrayDeque (양방향 큐)");
        System.out.println("-----------------------------------");
        Deque<String> deque = new ArrayDeque<>();
        
        // 앞에 추가
        deque.addFirst("앞1");
        deque.addFirst("앞2");
        System.out.println("앞에 추가 후: " + deque);
        
        // 뒤에 추가
        deque.addLast("뒤1");
        deque.addLast("뒤2");
        System.out.println("뒤에 추가 후: " + deque);
        
        // 앞에서 제거
        System.out.println("앞에서 제거: " + deque.removeFirst());
        System.out.println("현재 상태: " + deque);
        
        // 뒤에서 제거
        System.out.println("뒤에서 제거: " + deque.removeLast());
        System.out.println("현재 상태: " + deque);
        
        // 앞/뒤 확인
        System.out.println("맨 앞: " + deque.peekFirst());
        System.out.println("맨 뒤: " + deque.peekLast());
        
        // ============================================
        // 4. Stack으로 사용 (ArrayDeque)
        // ============================================
        System.out.println("\n4. ArrayDeque를 Stack으로 사용");
        System.out.println("-----------------------------------");
        Deque<String> stack = new ArrayDeque<>();
        
        stack.push("첫 번째");
        stack.push("두 번째");
        stack.push("세 번째");
        System.out.println("Stack: " + stack);
        
        System.out.print("LIFO 순서로 제거: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
        
        // ============================================
        // 5. 실전 예제: 프린터 큐
        // ============================================
        System.out.println("\n5. 실전 예제: 프린터 큐");
        System.out.println("-----------------------------------");
        Queue<PrintJob> printQueue = new LinkedList<>();
        
        printQueue.offer(new PrintJob("문서1.pdf", 5));
        printQueue.offer(new PrintJob("문서2.pdf", 3));
        printQueue.offer(new PrintJob("문서3.pdf", 8));
        
        System.out.println("인쇄 대기열:");
        while (!printQueue.isEmpty()) {
            PrintJob job = printQueue.poll();
            System.out.println("  인쇄 중: " + job);
        }
        
        // ============================================
        // 6. 실전 예제: BFS (너비 우선 탐색) 시뮬레이션
        // ============================================
        System.out.println("\n6. 실전 예제: BFS 시뮬레이션");
        System.out.println("-----------------------------------");
        Queue<Integer> bfsQueue = new LinkedList<>();
        boolean[] visited = new boolean[6];
        
        // 그래프: 0-1-2, 0-3, 3-4-5
        int[][] graph = {
            {1, 3},      // 0번 노드
            {0, 2},      // 1번 노드
            {1},         // 2번 노드
            {0, 4},      // 3번 노드
            {3, 5},      // 4번 노드
            {4}          // 5번 노드
        };
        
        bfsQueue.offer(0);
        visited[0] = true;
        
        System.out.print("BFS 순서: ");
        while (!bfsQueue.isEmpty()) {
            int node = bfsQueue.poll();
            System.out.print(node + " ");
            
            for (int neighbor : graph[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    bfsQueue.offer(neighbor);
                }
            }
        }
        System.out.println();
    }
}

// 우선순위 큐에 저장할 커스텀 클래스
class Task implements Comparable<Task> {
    private String name;
    private int priority;  // 1이 가장 높은 우선순위
    
    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
    
    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }
    
    @Override
    public String toString() {
        return name + "(" + priority + ")";
    }
}

// 프린터 작업 클래스
class PrintJob {
    private String fileName;
    private int pages;
    
    public PrintJob(String fileName, int pages) {
        this.fileName = fileName;
        this.pages = pages;
    }
    
    @Override
    public String toString() {
        return fileName + " (" + pages + "페이지)";
    }
}

