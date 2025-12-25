package arrays;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;

/**
 * 자바 배열 예제
 * 1차원 배열, 2차원 배열, 배열 유틸리티 함수들
 */
public class ArrayExamples {
    public static void main(String[] args) {
        // 콘솔 출력 인코딩을 UTF-8로 설정
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        System.out.println("=== 자바 배열 예제 ===\n");
        
        // ============================================
        // 1. 1차원 배열
        // ============================================
        System.out.println("1. 1차원 배열");
        System.out.println("-----------------------------------");
        
        // 배열 선언 방법 1: 값 목록으로 초기화
        System.out.println("방법 1: 값 목록으로 초기화");
        int[] scores1 = {83, 90, 87, 95, 78};
        System.out.println("int[] scores1 = {83, 90, 87, 95, 78};");
        for (int i = 0; i < scores1.length; i++) {
            System.out.println("scores1[" + i + "] = " + scores1[i]);
        }
        
        // 배열 선언 방법 2: new 연산자로 생성
        System.out.println("\n방법 2: new 연산자로 생성");
        int[] scores2 = new int[5];
        System.out.println("int[] scores2 = new int[5]; (기본값 0으로 초기화)");
        for (int i = 0; i < scores2.length; i++) {
            System.out.println("scores2[" + i + "] = " + scores2[i]);
        }
        
        // 값 할당
        scores2[0] = 90;
        scores2[1] = 85;
        scores2[2] = 92;
        scores2[3] = 88;
        scores2[4] = 95;
        System.out.println("\n값 할당 후:");
        for (int i = 0; i < scores2.length; i++) {
            System.out.println("scores2[" + i + "] = " + scores2[i]);
        }
        
        // 배열 선언 방법 3: 선언과 생성 분리
        System.out.println("\n방법 3: 선언과 생성 분리");
        int[] scores3;
        scores3 = new int[]{100, 95, 90};
        System.out.println("int[] scores3;");
        System.out.println("scores3 = new int[]{100, 95, 90};");
        for (int i = 0; i < scores3.length; i++) {
            System.out.println("scores3[" + i + "] = " + scores3[i]);
        }
        
        // 다양한 타입의 배열
        System.out.println("\n다양한 타입의 배열:");
        
        // double 배열
        double[] prices = {10.5, 20.3, 15.7};
        System.out.print("double[] prices: ");
        for (double price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
        
        // String 배열
        String[] fruits = {"사과", "바나나", "오렌지", "포도"};
        System.out.print("String[] fruits: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();
        
        // boolean 배열
        boolean[] flags = {true, false, true};
        System.out.print("boolean[] flags: ");
        for (boolean flag : flags) {
            System.out.print(flag + " ");
        }
        System.out.println();
        
        // char 배열
        char[] letters = {'A', 'B', 'C', 'D'};
        System.out.print("char[] letters: ");
        for (char letter : letters) {
            System.out.print(letter + " ");
        }
        System.out.println();
        
        // 배열의 기본값
        System.out.println("\n배열의 기본값:");
        int[] intArr = new int[3];
        double[] doubleArr = new double[3];
        boolean[] boolArr = new boolean[3];
        String[] strArr = new String[3];
        System.out.println("int 배열 기본값: " + Arrays.toString(intArr));
        System.out.println("double 배열 기본값: " + Arrays.toString(doubleArr));
        System.out.println("boolean 배열 기본값: " + Arrays.toString(boolArr));
        System.out.println("String 배열 기본값: " + Arrays.toString(strArr));
        
        // 배열 길이
        System.out.println("\n배열 길이:");
        System.out.println("scores1.length = " + scores1.length);
        System.out.println("fruits.length = " + fruits.length);
        
        // ============================================
        // 2. 2차원 배열
        // ============================================
        System.out.println("\n\n2. 2차원 배열");
        System.out.println("-----------------------------------");
        
        // 2차원 배열 선언 방법 1: 값 목록으로 초기화
        System.out.println("방법 1: 값 목록으로 초기화");
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("int[][] matrix1 = {{1,2,3}, {4,5,6}, {7,8,9}};");
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }
        
        // 2차원 배열 선언 방법 2: new 연산자로 생성 (고정 크기)
        System.out.println("\n방법 2: new 연산자로 생성 (고정 크기)");
        int[][] matrix2 = new int[3][4];
        System.out.println("int[][] matrix2 = new int[3][4];");
        System.out.println("행 개수: " + matrix2.length);
        System.out.println("첫 번째 행의 열 개수: " + matrix2[0].length);
        
        // 값 할당
        int value = 1;
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix2[i][j] = value++;
            }
        }
        System.out.println("값 할당 후:");
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                System.out.print(matrix2[i][j] + "\t");
            }
            System.out.println();
        }
        
        // 2차원 배열 선언 방법 3: 가변 길이 배열 (비정형 배열)
        System.out.println("\n방법 3: 가변 길이 배열 (비정형 배열)");
        int[][] jagged = new int[3][];
        jagged[0] = new int[2];
        jagged[1] = new int[4];
        jagged[2] = new int[3];
        
        System.out.println("int[][] jagged = new int[3][];");
        System.out.println("jagged[0] = new int[2];");
        System.out.println("jagged[1] = new int[4];");
        System.out.println("jagged[2] = new int[3];");
        
        // 값 할당
        int val = 1;
        for (int i = 0; i < jagged.length; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                jagged[i][j] = val++;
            }
        }
        
        System.out.println("값 할당 후:");
        for (int i = 0; i < jagged.length; i++) {
            System.out.print("행 " + i + ": ");
            for (int j = 0; j < jagged[i].length; j++) {
                System.out.print(jagged[i][j] + " ");
            }
            System.out.println(" (길이: " + jagged[i].length + ")");
        }
        
        // 2차원 배열 선언 방법 4: 값 목록으로 가변 길이 초기화
        System.out.println("\n방법 4: 값 목록으로 가변 길이 초기화");
        int[][] matrix3 = {
            {1, 2},
            {3, 4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("int[][] matrix3 = {{1,2}, {3,4,5,6}, {7,8,9}};");
        for (int i = 0; i < matrix3.length; i++) {
            System.out.print("행 " + i + ": ");
            for (int j = 0; j < matrix3[i].length; j++) {
                System.out.print(matrix3[i][j] + " ");
            }
            System.out.println();
        }
        
        // 3차원 배열 예제
        System.out.println("\n3차원 배열 예제:");
        int[][][] cube = new int[2][3][4];
        System.out.println("int[][][] cube = new int[2][3][4];");
        System.out.println("첫 번째 차원 길이: " + cube.length);
        System.out.println("두 번째 차원 길이: " + cube[0].length);
        System.out.println("세 번째 차원 길이: " + cube[0][0].length);
        
        // ============================================
        // 3. 배열 유틸리티 함수 (Arrays 클래스)
        // ============================================
        System.out.println("\n\n3. 배열 유틸리티 함수 (Arrays 클래스)");
        System.out.println("-----------------------------------");
        
        int[] arr1 = {3, 1, 4, 1, 5, 9, 2, 6};
        int[] arr2 = {3, 1, 4, 1, 5, 9, 2, 6};
        int[] arr3 = {1, 2, 3, 4, 5};
        
        // Arrays.toString() - 배열을 문자열로 변환
        System.out.println("Arrays.toString():");
        System.out.println("arr1: " + Arrays.toString(arr1));
        
        // Arrays.deepToString() - 다차원 배열을 문자열로 변환
        System.out.println("\nArrays.deepToString():");
        int[][] deepArr = {{1, 2}, {3, 4}};
        System.out.println("deepArr: " + Arrays.deepToString(deepArr));
        
        // Arrays.equals() - 배열 내용 비교
        System.out.println("\nArrays.equals():");
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
        System.out.println("arr1.equals(arr2): " + arr1.equals(arr2) + " (참조 비교)");
        System.out.println("Arrays.equals(arr1, arr2): " + Arrays.equals(arr1, arr2) + " (내용 비교)");
        
        // Arrays.deepEquals() - 다차원 배열 내용 비교
        System.out.println("\nArrays.deepEquals():");
        int[][] arr2d1 = {{1, 2}, {3, 4}};
        int[][] arr2d2 = {{1, 2}, {3, 4}};
        System.out.println("Arrays.deepEquals(arr2d1, arr2d2): " + Arrays.deepEquals(arr2d1, arr2d2));
        
        // Arrays.fill() - 배열을 특정 값으로 채우기
        System.out.println("\nArrays.fill():");
        int[] fillArr = new int[5];
        System.out.println("초기값: " + Arrays.toString(fillArr));
        Arrays.fill(fillArr, 7);
        System.out.println("Arrays.fill(fillArr, 7): " + Arrays.toString(fillArr));
        
        // 특정 범위만 채우기
        int[] fillRange = new int[10];
        Arrays.fill(fillRange, 2, 7, 5);  // 인덱스 2부터 6까지(7 미만) 5로 채우기
        System.out.println("Arrays.fill(fillRange, 2, 7, 5): " + Arrays.toString(fillRange));
        
        // Arrays.sort() - 배열 정렬
        System.out.println("\nArrays.sort():");
        int[] sortArr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("정렬 전: " + Arrays.toString(sortArr));
        Arrays.sort(sortArr);
        System.out.println("정렬 후: " + Arrays.toString(sortArr));
        
        // 내림차순 정렬 (Integer 배열 사용)
        Integer[] sortArrDesc = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("정렬 전: " + Arrays.toString(sortArrDesc));
        Arrays.sort(sortArrDesc, Collections.reverseOrder());
        System.out.println("내림차순 정렬 후: " + Arrays.toString(sortArrDesc));
        
        // Arrays.binarySearch() - 이진 탐색 (정렬된 배열에서만 사용)
        System.out.println("\nArrays.binarySearch():");
        int[] searchArr = {11, 22, 25, 34, 64, 90};
        System.out.println("배열: " + Arrays.toString(searchArr));
        int index = Arrays.binarySearch(searchArr, 25);
        System.out.println("Arrays.binarySearch(searchArr, 25): " + index);
        index = Arrays.binarySearch(searchArr, 50);
        System.out.println("Arrays.binarySearch(searchArr, 50): " + index + " (없으면 음수 반환)");
        
        // Arrays.copyOf() - 배열 복사 (새 배열 생성)
        System.out.println("\nArrays.copyOf():");
        int[] original = {1, 2, 3, 4, 5};
        System.out.println("original: " + Arrays.toString(original));
        int[] copied = Arrays.copyOf(original, original.length);
        System.out.println("copied: " + Arrays.toString(copied));
        System.out.println("original == copied: " + (original == copied) + " (다른 객체)");
        
        // 길이를 다르게 복사
        int[] copiedLonger = Arrays.copyOf(original, 8);
        System.out.println("Arrays.copyOf(original, 8): " + Arrays.toString(copiedLonger));
        int[] copiedShorter = Arrays.copyOf(original, 3);
        System.out.println("Arrays.copyOf(original, 3): " + Arrays.toString(copiedShorter));
        
        // Arrays.copyOfRange() - 배열의 특정 범위 복사
        System.out.println("\nArrays.copyOfRange():");
        int[] range = Arrays.copyOfRange(original, 1, 4);  // 인덱스 1부터 3까지(4 미만)
        System.out.println("Arrays.copyOfRange(original, 1, 4): " + Arrays.toString(range));
        
        // System.arraycopy() - 배열 복사 (기존 배열에 복사)
        System.out.println("\nSystem.arraycopy():");
        int[] source = {1, 2, 3, 4, 5};
        int[] dest = new int[5];
        System.arraycopy(source, 0, dest, 0, source.length);
        System.out.println("source: " + Arrays.toString(source));
        System.out.println("dest: " + Arrays.toString(dest));
        
        // 부분 복사
        int[] dest2 = new int[5];
        System.arraycopy(source, 1, dest2, 0, 3);  // source의 1~3을 dest2의 0~2에 복사
        System.out.println("System.arraycopy(source, 1, dest2, 0, 3): " + Arrays.toString(dest2));
        
        // Arrays.asList() - 배열을 List로 변환
        System.out.println("\nArrays.asList():");
        String[] strArray = {"사과", "바나나", "오렌지"};
        System.out.println("배열: " + Arrays.toString(strArray));
        System.out.println("List로 변환: " + Arrays.asList(strArray));
        
        // ============================================
        // 4. 배열 실전 예제
        // ============================================
        System.out.println("\n\n4. 배열 실전 예제");
        System.out.println("-----------------------------------");
        
        // 예제 1: 배열의 최대값, 최소값 찾기
        System.out.println("예제 1: 배열의 최대값, 최소값 찾기");
        int[] numbers = {45, 12, 89, 34, 67, 23, 91, 5};
        System.out.println("배열: " + Arrays.toString(numbers));
        
        int max = numbers[0];
        int min = numbers[0];
        for (int num : numbers) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        System.out.println("최대값: " + max);
        System.out.println("최소값: " + min);
        
        // Arrays.stream() 사용 (Java 8+)
        max = Arrays.stream(numbers).max().orElse(0);
        min = Arrays.stream(numbers).min().orElse(0);
        System.out.println("(Stream 사용) 최대값: " + max + ", 최소값: " + min);
        
        // 예제 2: 배열의 평균값 계산
        System.out.println("\n예제 2: 배열의 평균값 계산");
        int[] scores = {85, 90, 78, 92, 88};
        System.out.println("점수 배열: " + Arrays.toString(scores));
        
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        double average = (double) sum / scores.length;
        System.out.println("평균: " + average);
        
        // 예제 3: 배열에서 특정 값 찾기
        System.out.println("\n예제 3: 배열에서 특정 값 찾기");
        int[] searchArray = {10, 20, 30, 40, 50};
        int target = 30;
        System.out.println("배열: " + Arrays.toString(searchArray));
        System.out.println("찾는 값: " + target);
        
        boolean found = false;
        int foundIndex = -1;
        for (int i = 0; i < searchArray.length; i++) {
            if (searchArray[i] == target) {
                found = true;
                foundIndex = i;
                break;
            }
        }
        if (found) {
            System.out.println("값을 찾았습니다! 인덱스: " + foundIndex);
        } else {
            System.out.println("값을 찾을 수 없습니다.");
        }
        
        // 예제 4: 배열 역순으로 만들기
        System.out.println("\n예제 4: 배열 역순으로 만들기");
        int[] reverseArr = {1, 2, 3, 4, 5};
        System.out.println("원본: " + Arrays.toString(reverseArr));
        
        for (int i = 0; i < reverseArr.length / 2; i++) {
            int temp = reverseArr[i];
            reverseArr[i] = reverseArr[reverseArr.length - 1 - i];
            reverseArr[reverseArr.length - 1 - i] = temp;
        }
        System.out.println("역순: " + Arrays.toString(reverseArr));
        
        // 예제 5: 2차원 배열의 합계
        System.out.println("\n예제 5: 2차원 배열의 합계");
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("2차원 배열:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        
        int totalSum = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                totalSum += num;
            }
        }
        System.out.println("전체 합계: " + totalSum);
        
        // 각 행의 합계
        System.out.println("각 행의 합계:");
        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                rowSum += matrix[i][j];
            }
            System.out.println("행 " + i + ": " + rowSum);
        }
        
        System.out.println("\n=== 예제 완료 ===");
    }
}

