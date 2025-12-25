package controlflow;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * 자바 제어문 예제
 * if문, switch문, for문, while문, break문, continue문
 */
public class ControlFlowExamples {
    public static void main(String[] args) {
        // 콘솔 출력 인코딩을 UTF-8로 설정
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        System.out.println("=== 자바 제어문 예제 ===\n");
        
        // ============================================
        // 1. if문
        // ============================================
        System.out.println("1. if문");
        System.out.println("-----------------------------------");
        
        // 단순 if문
        int score = 93;
        System.out.println("점수: " + score);
        if (score >= 90) {
            System.out.println("점수가 90보다 큽니다.");
            System.out.println("등급은 A입니다.");
        }
        
        // if-else문
        System.out.println("\nif-else문:");
        score = 85;
        System.out.println("점수: " + score);
        if (score >= 90) {
            System.out.println("점수가 90보다 큽니다.");
            System.out.println("등급은 A입니다.");
        } else {
            System.out.println("점수가 90보다 작습니다.");
            System.out.println("등급은 B입니다.");
        }
        
        // if-else if-else문
        System.out.println("\nif-else if-else문:");
        score = 75;
        System.out.println("점수: " + score);
        if (score >= 90) {
            System.out.println("점수가 100~90입니다.");
            System.out.println("등급은 A입니다.");
        } else if (score >= 80) {
            System.out.println("점수가 80~89입니다.");
            System.out.println("등급은 B입니다.");
        } else if (score >= 70) {
            System.out.println("점수가 70~79입니다.");
            System.out.println("등급은 C입니다.");
        } else {
            System.out.println("점수가 70 미만입니다.");
            System.out.println("등급은 D입니다.");
        }
        
        // 중첩 if문
        System.out.println("\n중첩 if문:");
        int age = 20;
        boolean hasLicense = true;
        System.out.println("나이: " + age + ", 면허: " + hasLicense);
        if (age >= 18) {
            if (hasLicense) {
                System.out.println("운전 가능합니다.");
            } else {
                System.out.println("면허가 필요합니다.");
            }
        } else {
            System.out.println("미성년자는 운전할 수 없습니다.");
        }
        
        // ============================================
        // 2. switch문
        // ============================================
        System.out.println("\n\n2. switch문");
        System.out.println("-----------------------------------");
        
        // 기본 switch문 (정수)
        System.out.println("기본 switch문 (정수):");
        int num = 2;
        System.out.println("num = " + num);
        switch (num) {
            case 1:
                System.out.println("1번입니다.");
                break;
            case 2:
                System.out.println("2번입니다.");
                break;
            case 3:
                System.out.println("3번입니다.");
                break;
            default:
                System.out.println("1~3이 아닙니다.");
        }
        
        // switch문 (문자)
        System.out.println("\nswitch문 (문자):");
        char grade = 'B';
        System.out.println("grade = '" + grade + "'");
        switch (grade) {
            case 'A':
            case 'a':
                System.out.println("우수 회원입니다.");
                break;
            case 'B':
            case 'b':
                System.out.println("일반 회원입니다.");
                break;
            case 'C':
            case 'c':
                System.out.println("일반 회원입니다.");
                break;
            default:
                System.out.println("손님입니다.");
        }
        
        // switch문 (문자열) - Java 7부터 지원
        System.out.println("\nswitch문 (문자열):");
        String position = "manager";
        System.out.println("position = \"" + position + "\"");
        switch (position) {
            case "ceo":
                System.out.println("CEO입니다.");
                break;
            case "manager":
                System.out.println("매니저입니다.");
                break;
            case "employee":
                System.out.println("직원입니다.");
                break;
            default:
                System.out.println("알 수 없는 직책입니다.");
        }
        
        // switch문 - break 없는 경우 (fall-through)
        System.out.println("\nswitch문 - break 없는 경우 (fall-through):");
        int month = 3;
        System.out.println("month = " + month);
        switch (month) {
            case 12:
            case 1:
            case 2:
                System.out.println("겨울입니다.");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("봄입니다.");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("여름입니다.");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("가을입니다.");
                break;
        }
        
        // Java 14+ switch 표현식 (화살표 문법)
        System.out.println("\nJava 14+ switch 표현식:");
        int day = 3;
        System.out.println("day = " + day);
        String dayName = switch (day) {
            case 1 -> "월요일";
            case 2 -> "화요일";
            case 3 -> "수요일";
            case 4 -> "목요일";
            case 5 -> "금요일";
            case 6 -> "토요일";
            case 7 -> "일요일";
            default -> "알 수 없는 요일";
        };
        System.out.println("결과: " + dayName);
        
        // ============================================
        // 3. for문
        // ============================================
        System.out.println("\n\n3. for문");
        System.out.println("-----------------------------------");
        
        // 기본 for문
        System.out.println("기본 for문 (1부터 5까지):");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // for문으로 합계 구하기
        System.out.println("\nfor문으로 합계 구하기 (1부터 10까지):");
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println("합계: " + sum);
        
        // 감소하는 for문
        System.out.println("\n감소하는 for문 (10부터 1까지):");
        for (int i = 10; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // 2씩 증가하는 for문
        System.out.println("\n2씩 증가하는 for문 (짝수 출력):");
        for (int i = 0; i <= 10; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // 중첩 for문 (구구단)
        System.out.println("\n중첩 for문 (구구단 2단):");
        for (int i = 1; i <= 9; i++) {
            System.out.println("2 × " + i + " = " + (2 * i));
        }
        
        // 중첩 for문 (별 찍기)
        System.out.println("\n중첩 for문 (별 찍기):");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        // 향상된 for문 (for-each)
        System.out.println("\n향상된 for문 (for-each):");
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.print("배열 요소: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
        
        String[] fruits = {"사과", "바나나", "오렌지"};
        System.out.print("과일 배열: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();
        
        // ============================================
        // 4. while문
        // ============================================
        System.out.println("\n\n4. while문");
        System.out.println("-----------------------------------");
        
        // 기본 while문
        System.out.println("기본 while문 (1부터 5까지):");
        int i = 1;
        while (i <= 5) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println();
        
        // while문으로 합계 구하기
        System.out.println("\nwhile문으로 합계 구하기 (1부터 10까지):");
        int sum2 = 0;
        int j = 1;
        while (j <= 10) {
            sum2 += j;
            j++;
        }
        System.out.println("합계: " + sum2);
        
        // 무한 루프 (조건부 종료)
        System.out.println("\n무한 루프 (조건부 종료):");
        int count = 0;
        while (true) {
            count++;
            if (count > 5) {
                break;  // break문으로 종료
            }
            System.out.print(count + " ");
        }
        System.out.println();
        
        // do-while문
        System.out.println("\ndo-while문:");
        int k = 1;
        do {
            System.out.print(k + " ");
            k++;
        } while (k <= 5);
        System.out.println();
        
        // do-while문의 특징 (최소 1번은 실행)
        System.out.println("\ndo-while문의 특징 (조건이 false여도 1번 실행):");
        int m = 10;
        do {
            System.out.println("m = " + m + " (조건이 false여도 실행됨)");
            m++;
        } while (m < 10);
        
        // ============================================
        // 5. break문
        // ============================================
        System.out.println("\n\n5. break문");
        System.out.println("-----------------------------------");
        
        // break문으로 루프 종료
        System.out.println("break문으로 루프 종료:");
        for (int n = 1; n <= 10; n++) {
            if (n == 6) {
                break;  // n이 6이 되면 루프 종료
            }
            System.out.print(n + " ");
        }
        System.out.println(" (6에서 종료)");
        
        // break문으로 무한 루프 종료
        System.out.println("\nbreak문으로 무한 루프 종료:");
        int dice = 0;
        while (true) {
            dice = (int)(Math.random() * 6) + 1;
            System.out.print(dice + " ");
            if (dice == 6) {
                System.out.println("\n6이 나왔습니다! 루프를 종료합니다.");
                break;
            }
        }
        
        // 레이블이 있는 break문 (중첩 루프에서 외부 루프 종료)
        System.out.println("\n레이블이 있는 break문:");
        outer: for (int x = 1; x <= 3; x++) {
            for (int y = 1; y <= 3; y++) {
                if (x == 2 && y == 2) {
                    System.out.println("x=" + x + ", y=" + y + "에서 외부 루프 종료");
                    break outer;  // outer 레이블의 루프 종료
                }
                System.out.print("(" + x + "," + y + ") ");
            }
        }
        System.out.println();
        
        // switch문에서의 break
        System.out.println("\nswitch문에서의 break:");
        int choice = 2;
        switch (choice) {
            case 1:
                System.out.println("선택 1");
                break;
            case 2:
                System.out.println("선택 2");
                break;  // break가 없으면 다음 case도 실행됨
            case 3:
                System.out.println("선택 3");
                break;
        }
        
        // ============================================
        // 6. continue문
        // ============================================
        System.out.println("\n\n6. continue문");
        System.out.println("-----------------------------------");
        
        // continue문으로 특정 조건 건너뛰기
        System.out.println("continue문으로 짝수만 출력 (홀수 건너뛰기):");
        for (int n = 1; n <= 10; n++) {
            if (n % 2 != 0) {
                continue;  // 홀수면 다음 반복으로
            }
            System.out.print(n + " ");
        }
        System.out.println();
        
        // continue문으로 특정 값 건너뛰기
        System.out.println("\ncontinue문으로 5 건너뛰기:");
        for (int n = 1; n <= 10; n++) {
            if (n == 5) {
                continue;  // 5는 건너뛰기
            }
            System.out.print(n + " ");
        }
        System.out.println();
        
        // continue문으로 합계 구하기 (특정 조건 제외)
        System.out.println("\ncontinue문으로 합계 구하기 (3의 배수 제외):");
        int sum3 = 0;
        for (int n = 1; n <= 10; n++) {
            if (n % 3 == 0) {
                continue;  // 3의 배수는 제외
            }
            sum3 += n;
        }
        System.out.println("합계 (3의 배수 제외): " + sum3);
        
        // 레이블이 있는 continue문
        System.out.println("\n레이블이 있는 continue문:");
        outer: for (int x = 1; x <= 3; x++) {
            for (int y = 1; y <= 3; y++) {
                if (x == 2 && y == 2) {
                    System.out.println("x=" + x + ", y=" + y + "에서 외부 루프의 다음 반복으로");
                    continue outer;  // outer 레이블의 다음 반복으로
                }
                System.out.print("(" + x + "," + y + ") ");
            }
        }
        System.out.println();
        
        // while문에서의 continue
        System.out.println("\nwhile문에서의 continue:");
        int num2 = 0;
        while (num2 < 10) {
            num2++;
            if (num2 % 2 == 0) {
                continue;  // 짝수는 건너뛰기
            }
            System.out.print(num2 + " ");
        }
        System.out.println();
        
        // ============================================
        // 7. 실전 예제
        // ============================================
        System.out.println("\n\n7. 실전 예제");
        System.out.println("-----------------------------------");
        
        // 예제 1: 숫자 맞추기 게임
        System.out.println("예제 1: 1부터 100까지의 숫자 중 7의 배수 찾기");
        for (int n = 1; n <= 100; n++) {
            if (n % 7 == 0) {
                System.out.print(n + " ");
            }
        }
        System.out.println();
        
        // 예제 2: 소수 찾기
        System.out.println("\n예제 2: 1부터 20까지의 소수 찾기");
        for (int n = 2; n <= 20; n++) {
            boolean isPrime = true;
            for (int div = 2; div < n; div++) {
                if (n % div == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(n + " ");
            }
        }
        System.out.println();
        
        // 예제 3: 등급 판정
        System.out.println("\n예제 3: 점수에 따른 등급 판정");
        int[] scores = {95, 87, 76, 65, 45};
        for (int s : scores) {
            String grade2;
            if (s >= 90) {
                grade2 = "A";
            } else if (s >= 80) {
                grade2 = "B";
            } else if (s >= 70) {
                grade2 = "C";
            } else if (s >= 60) {
                grade2 = "D";
            } else {
                grade2 = "F";
            }
            System.out.println("점수 " + s + "점: " + grade2 + "등급");
        }
        
        System.out.println("\n=== 예제 완료 ===");
    }
}

