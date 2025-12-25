package operators;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * 자바의 모든 주요 연산자 예제
 * 산술, 비교, 논리, 대입, 삼항, 비트 연산자 등을 다룹니다.
 */
public class AllOperatorsExample {
    public static void main(String[] args) {
        // 콘솔 출력 인코딩을 UTF-8로 설정
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        System.out.println("=== 자바 연산자 예제 ===\n");
        
        // ============================================
        // 1. 산술 연산자 (+, -, *, /, %)
        // ============================================
        System.out.println("1. 산술 연산자 (+, -, *, /, %)");
        System.out.println("-----------------------------------");
        
        int a = 10;
        int b = 3;
        
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("덧셈 (a + b): " + (a + b));
        System.out.println("뺄셈 (a - b): " + (a - b));
        System.out.println("곱셈 (a * b): " + (a * b));
        System.out.println("나눗셈 (a / b): " + (a / b) + " (정수 나눗셈)");
        System.out.println("나머지 (a % b): " + (a % b));
        
        // 실수 나눗셈
        double x = 10.0;
        double y = 3.0;
        System.out.println("\n실수 나눗셈:");
        System.out.println("x = " + x + ", y = " + y);
        System.out.println("나눗셈 (x / y): " + (x / y));
        
        // 0으로 나누기
        System.out.println("\n⚠️ 주의: 0으로 나누기");
        System.out.println("정수 0으로 나누기: 런타임 에러 발생");
        System.out.println("실수 0.0으로 나누기: " + (10.0 / 0.0) + " (Infinity)");
        System.out.println("0.0 / 0.0: " + (0.0 / 0.0) + " (NaN)");
        
        // ============================================
        // 2. 논리 부정 연산자 (!)
        // ============================================
        System.out.println("\n\n2. 논리 부정 연산자 (!)");
        System.out.println("-----------------------------------");
        
        boolean flag1 = true;
        boolean flag2 = false;
        
        System.out.println("flag1 = " + flag1);
        System.out.println("!flag1 = " + !flag1);
        System.out.println("flag2 = " + flag2);
        System.out.println("!flag2 = " + !flag2);
        
        // 조건문에서의 사용
        int age = 20;
        boolean isAdult = age >= 18;
        System.out.println("\nage = " + age);
        System.out.println("isAdult = " + isAdult);
        System.out.println("!isAdult (미성년자): " + !isAdult);
        
        if (!isAdult) {
            System.out.println("미성년자입니다.");
        } else {
            System.out.println("성인입니다.");
        }
        
        // ============================================
        // 3. 비교 연산자 (==, !=, <, <=, >, >=)
        // ============================================
        System.out.println("\n\n3. 비교 연산자 (==, !=, <, <=, >, >=)");
        System.out.println("-----------------------------------");
        
        int num1 = 10;
        int num2 = 20;
        int num3 = 10;
        
        System.out.println("num1 = " + num1 + ", num2 = " + num2 + ", num3 = " + num3);
        System.out.println("num1 == num2: " + (num1 == num2) + " (같은가?)");
        System.out.println("num1 == num3: " + (num1 == num3) + " (같은가?)");
        System.out.println("num1 != num2: " + (num1 != num2) + " (다른가?)");
        System.out.println("num1 < num2: " + (num1 < num2) + " (작은가?)");
        System.out.println("num1 <= num2: " + (num1 <= num2) + " (작거나 같은가?)");
        System.out.println("num1 > num2: " + (num1 > num2) + " (큰가?)");
        System.out.println("num1 >= num3: " + (num1 >= num3) + " (크거나 같은가?)");
        
        // 문자열 비교 주의사항
        System.out.println("\n⚠️ 문자열 비교 주의사항:");
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");
        
        System.out.println("str1 = \"" + str1 + "\"");
        System.out.println("str2 = \"" + str2 + "\"");
        System.out.println("str3 = new String(\"Hello\")");
        System.out.println("str1 == str2: " + (str1 == str2) + " (리터럴은 같은 참조)");
        System.out.println("str1 == str3: " + (str1 == str3) + " (다른 객체이므로 false)");
        System.out.println("str1.equals(str3): " + str1.equals(str3) + " (올바른 문자열 비교)");
        
        // ============================================
        // 4. 복합 대입 연산자 (+=, -=, *=, /=, %=)
        // ============================================
        System.out.println("\n\n4. 복합 대입 연산자 (+=, -=, *=, /=, %=)");
        System.out.println("-----------------------------------");
        
        int result = 10;
        System.out.println("초기값: result = " + result);
        
        result += 5;  // result = result + 5
        System.out.println("result += 5; 실행 후: " + result);
        
        result -= 3;  // result = result - 3
        System.out.println("result -= 3; 실행 후: " + result);
        
        result *= 2;  // result = result * 2
        System.out.println("result *= 2; 실행 후: " + result);
        
        result /= 4;  // result = result / 4
        System.out.println("result /= 4; 실행 후: " + result);
        
        result %= 3;  // result = result % 3
        System.out.println("result %= 3; 실행 후: " + result);
        
        // 문자열 연결에도 사용 가능
        String message = "Hello";
        message += " World";
        message += "!";
        System.out.println("\n문자열 복합 대입:");
        System.out.println("message += \" World\"; message += \"!\";");
        System.out.println("결과: " + message);
        
        // ============================================
        // 5. 삼항 연산자 (조건 ? 값1 : 값2)
        // ============================================
        System.out.println("\n\n5. 삼항 연산자 (조건 ? 값1 : 값2)");
        System.out.println("-----------------------------------");
        
        int score = 85;
        String grade = (score >= 90) ? "A" : (score >= 80) ? "B" : "C";
        System.out.println("score = " + score);
        System.out.println("grade = (score >= 90) ? \"A\" : (score >= 80) ? \"B\" : \"C\"");
        System.out.println("결과: " + score + "점은 " + grade + "등급입니다.");
        
        // 여러 예제
        int max = (10 > 5) ? 10 : 5;
        System.out.println("\nmax = (10 > 5) ? 10 : 5");
        System.out.println("결과: " + max);
        
        boolean isEven = (10 % 2 == 0) ? true : false;
        System.out.println("\nisEven = (10 % 2 == 0) ? true : false");
        System.out.println("결과: " + isEven);
        
        String status = (age >= 18) ? "성인" : "미성년자";
        System.out.println("\nage = " + age);
        System.out.println("status = (age >= 18) ? \"성인\" : \"미성년자\"");
        System.out.println("결과: " + status);
        
        // ============================================
        // 6. 논리 연산자 (&&, ||)
        // ============================================
        System.out.println("\n\n6. 논리 연산자 (&&, ||)");
        System.out.println("-----------------------------------");
        
        boolean condition1 = true;
        boolean condition2 = false;
        
        System.out.println("condition1 = " + condition1 + ", condition2 = " + condition2);
        System.out.println("condition1 && condition2: " + (condition1 && condition2) + " (AND)");
        System.out.println("condition1 || condition2: " + (condition1 || condition2) + " (OR)");
        
        // 단락 평가 (Short-circuit evaluation)
        System.out.println("\n단락 평가 (Short-circuit evaluation):");
        int value = 5;
        System.out.println("value = " + value);
        
        // && 연산자: 첫 번째가 false면 두 번째는 평가하지 않음
        boolean result1 = (value > 10) && (value++ > 0);
        System.out.println("(value > 10) && (value++ > 0): " + result1);
        System.out.println("value = " + value + " (증가하지 않음)");
        
        // || 연산자: 첫 번째가 true면 두 번째는 평가하지 않음
        value = 5;
        boolean result2 = (value < 10) || (value++ > 0);
        System.out.println("(value < 10) || (value++ > 0): " + result2);
        System.out.println("value = " + value + " (증가하지 않음)");
        
        // 실제 사용 예제
        int age2 = 25;
        boolean hasLicense = true;
        System.out.println("\n실제 사용 예제:");
        System.out.println("age = " + age2 + ", hasLicense = " + hasLicense);
        
        if (age2 >= 18 && hasLicense) {
            System.out.println("운전 가능합니다.");
        }
        
        if (age2 < 18 || !hasLicense) {
            System.out.println("운전 불가능합니다.");
        }
        
        // ============================================
        // 7. 비트 연산자 (&, |, ^, ~)
        // ============================================
        System.out.println("\n\n7. 비트 연산자 (&, |, ^, ~)");
        System.out.println("-----------------------------------");
        
        int bit1 = 5;   // 0101 (이진수)
        int bit2 = 3;   // 0011 (이진수)
        
        System.out.println("bit1 = " + bit1 + " (이진수: " + Integer.toBinaryString(bit1) + ")");
        System.out.println("bit2 = " + bit2 + " (이진수: " + Integer.toBinaryString(bit2) + ")");
        
        System.out.println("bit1 & bit2: " + (bit1 & bit2) + " (AND)");
        System.out.println("  " + Integer.toBinaryString(bit1) + " &");
        System.out.println("  " + Integer.toBinaryString(bit2));
        System.out.println("  -----");
        System.out.println("  " + Integer.toBinaryString(bit1 & bit2));
        
        System.out.println("\nbit1 | bit2: " + (bit1 | bit2) + " (OR)");
        System.out.println("  " + Integer.toBinaryString(bit1) + " |");
        System.out.println("  " + Integer.toBinaryString(bit2));
        System.out.println("  -----");
        System.out.println("  " + Integer.toBinaryString(bit1 | bit2));
        
        System.out.println("\nbit1 ^ bit2: " + (bit1 ^ bit2) + " (XOR)");
        System.out.println("  " + Integer.toBinaryString(bit1) + " ^");
        System.out.println("  " + Integer.toBinaryString(bit2));
        System.out.println("  -----");
        System.out.println("  " + Integer.toBinaryString(bit1 ^ bit2));
        
        System.out.println("\n~bit1: " + (~bit1) + " (NOT)");
        System.out.println("  ~" + Integer.toBinaryString(bit1));
        System.out.println("  " + Integer.toBinaryString(~bit1));
        
        // ============================================
        // 8. 시프트 연산자 (<<, >>, >>>)
        // ============================================
        System.out.println("\n\n8. 시프트 연산자 (<<, >>, >>>)");
        System.out.println("-----------------------------------");
        
        int shift = 8;  // 1000 (이진수)
        System.out.println("shift = " + shift + " (이진수: " + Integer.toBinaryString(shift) + ")");
        
        System.out.println("shift << 1: " + (shift << 1) + " (왼쪽으로 1비트 시프트, 2배)");
        System.out.println("  이진수: " + Integer.toBinaryString(shift << 1));
        
        System.out.println("shift >> 1: " + (shift >> 1) + " (오른쪽으로 1비트 시프트, 1/2배)");
        System.out.println("  이진수: " + Integer.toBinaryString(shift >> 1));
        
        System.out.println("shift >>> 1: " + (shift >>> 1) + " (부호 없는 오른쪽 시프트)");
        System.out.println("  이진수: " + Integer.toBinaryString(shift >>> 1));
        
        // 음수 시프트
        int negative = -8;
        System.out.println("\n음수 시프트:");
        System.out.println("negative = " + negative);
        System.out.println("negative >> 1: " + (negative >> 1) + " (부호 유지)");
        System.out.println("negative >>> 1: " + (negative >>> 1) + " (부호 무시)");
        
        // ============================================
        // 9. instanceof 연산자
        // ============================================
        System.out.println("\n\n9. instanceof 연산자");
        System.out.println("-----------------------------------");
        
        String str = "Hello";
        Integer num = 10;
        Object obj = str;
        
        System.out.println("str = \"" + str + "\"");
        System.out.println("num = " + num);
        System.out.println("obj = str");
        
        System.out.println("str instanceof String: " + (str instanceof String));
        System.out.println("num instanceof Integer: " + (num instanceof Integer));
        System.out.println("obj instanceof String: " + (obj instanceof String));
        System.out.println("str instanceof Object: " + (str instanceof Object));
        
        // null 체크
        String nullStr = null;
        System.out.println("\nnullStr = null");
        System.out.println("nullStr instanceof String: " + (nullStr instanceof String));
        
        // ============================================
        // 10. 연산자 우선순위 요약
        // ============================================
        System.out.println("\n\n10. 연산자 우선순위 요약");
        System.out.println("-----------------------------------");
        System.out.println("1. 괄호 ()");
        System.out.println("2. 단항 연산자: !, ~, ++, --, +, -");
        System.out.println("3. 산술 연산자: *, /, %, +, -");
        System.out.println("4. 시프트 연산자: <<, >>, >>>");
        System.out.println("5. 비교 연산자: <, <=, >, >=, instanceof");
        System.out.println("6. 등가 연산자: ==, !=");
        System.out.println("7. 비트 연산자: &, ^, |");
        System.out.println("8. 논리 연산자: &&, ||");
        System.out.println("9. 삼항 연산자: ? :");
        System.out.println("10. 대입 연산자: =, +=, -=, *=, /=, %= 등");
        
        System.out.println("\n예제:");
        int result3 = 2 + 3 * 4;
        System.out.println("2 + 3 * 4 = " + result3 + " (곱셈이 먼저)");
        
        int result4 = (2 + 3) * 4;
        System.out.println("(2 + 3) * 4 = " + result4 + " (괄호가 먼저)");
        
        boolean result5 = 5 > 3 && 10 < 20;
        System.out.println("5 > 3 && 10 < 20 = " + result5 + " (비교 연산자가 먼저)");
        
        System.out.println("\n=== 예제 완료 ===");
    }
}

