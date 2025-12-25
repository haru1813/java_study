package datatypes;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * 자바의 다양한 데이터 타입 예제
 * 기본 타입(Primitive Types)과 참조 타입(Reference Types)
 */
public class DataTypeExamples {
    public static void main(String[] args) {
        // 콘솔 출력 인코딩을 UTF-8로 설정
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        System.out.println("=== 자바 데이터 타입 예제 ===\n");
        
        // ============================================
        // 1. 정수형 (Integer Types)
        // ============================================
        System.out.println("1. 정수형 데이터 타입");
        System.out.println("-----------------------------------");
        
        // byte: -128 ~ 127 (1 byte)
        byte byteValue = 127;
        System.out.println("byte 값: " + byteValue);
        System.out.println("byte 범위: " + Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);
        
        // short: -32,768 ~ 32,767 (2 bytes)
        short shortValue = 32767;
        System.out.println("short 값: " + shortValue);
        System.out.println("short 범위: " + Short.MIN_VALUE + " ~ " + Short.MAX_VALUE);
        
        // int: -2,147,483,648 ~ 2,147,483,647 (4 bytes) - 기본 정수형
        int intValue = 2147483647;
        System.out.println("int 값: " + intValue);
        System.out.println("int 범위: " + Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
        
        // long: -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807 (8 bytes)
        long longValue = 9223372036854775807L; // L 또는 l 접미사 필요
        System.out.println("long 값: " + longValue);
        System.out.println("long 범위: " + Long.MIN_VALUE + " ~ " + Long.MAX_VALUE);
        
        // 진수 표현
        System.out.println("\n진수 표현:");
        int binary = 0b1010;      // 2진수 (0b 접두사) = 10
        int octal = 012;          // 8진수 (0 접두사) = 10
        int hex = 0xA;            // 16진수 (0x 접두사) = 10
        System.out.println("2진수 0b1010 = " + binary);
        System.out.println("8진수 012 = " + octal);
        System.out.println("16진수 0xA = " + hex);
        
        // ============================================
        // 2. 실수형 (Floating Point Types)
        // ============================================
        System.out.println("\n\n2. 실수형 데이터 타입");
        System.out.println("-----------------------------------");
        
        // float: 4 bytes, 약 7자리 정밀도
        float floatValue1 = 3.14f;  // f 또는 F 접미사 필요
        float floatValue2 = 3.141592653589793f;
        System.out.println("float 값1: " + floatValue1);
        System.out.println("float 값2: " + floatValue2);
        System.out.println("float 범위: " + Float.MIN_VALUE + " ~ " + Float.MAX_VALUE);
        
        // double: 8 bytes, 약 15자리 정밀도 (기본 실수형)
        double doubleValue1 = 3.14;
        double doubleValue2 = 3.141592653589793;
        System.out.println("double 값1: " + doubleValue1);
        System.out.println("double 값2: " + doubleValue2);
        System.out.println("double 범위: " + Double.MIN_VALUE + " ~ " + Double.MAX_VALUE);
        
        // 과학적 표기법
        System.out.println("\n과학적 표기법:");
        double scientific1 = 1.5e3;   // 1.5 × 10³ = 1500.0
        double scientific2 = 1.5e-3; // 1.5 × 10⁻³ = 0.0015
        System.out.println("1.5e3 = " + scientific1);
        System.out.println("1.5e-3 = " + scientific2);
        
        // 부동소수점 연산 주의사항
        System.out.println("\n부동소수점 연산 주의사항:");
        double a = 0.1;
        double b = 0.2;
        double sum = a + b;
        System.out.println("0.1 + 0.2 = " + sum);
        System.out.println("정확한 비교 (sum == 0.3): " + (sum == 0.3)); // false일 수 있음
        // 정밀한 비교를 위한 방법
        double epsilon = 0.0001;
        System.out.println("오차 범위 내 비교: " + (Math.abs(sum - 0.3) < epsilon));
        
        // ============================================
        // 3. 문자형 (Character Type)
        // ============================================
        System.out.println("\n\n3. 문자형 데이터 타입");
        System.out.println("-----------------------------------");
        
        // char: 2 bytes, 유니코드 문자 (0 ~ 65,535)
        char charValue1 = 'A';
        char charValue2 = '한';
        char charValue3 = 65;  // 유니코드 값으로 직접 할당
        char charValue4 = '\u0041'; // 유니코드 이스케이프 시퀀스
        
        System.out.println("char 값1: " + charValue1);
        System.out.println("char 값2: " + charValue2);
        System.out.println("char 값3 (유니코드 65): " + charValue3);
        System.out.println("char 값4 (\\u0041): " + charValue4);
        System.out.println("char 범위: " + (int)Character.MIN_VALUE + " ~ " + (int)Character.MAX_VALUE);
        
        // 이스케이프 문자
        System.out.println("\n이스케이프 문자:");
        System.out.println("탭: \t여기");
        System.out.println("줄바꿈:\n새 줄");
        System.out.println("작은따옴표: \'");
        System.out.println("큰따옴표: \"");
        System.out.println("백슬래시: \\");
        
        // ============================================
        // 4. 논리형 (Boolean Type)
        // ============================================
        System.out.println("\n\n4. 논리형 데이터 타입");
        System.out.println("-----------------------------------");
        
        boolean boolValue1 = true;
        boolean boolValue2 = false;
        boolean boolValue3 = (10 > 5);  // 비교 연산 결과
        
        System.out.println("boolean 값1: " + boolValue1);
        System.out.println("boolean 값2: " + boolValue2);
        System.out.println("boolean 값3 (10 > 5): " + boolValue3);
        
        // 조건문에서의 사용
        if (boolValue1) {
            System.out.println("조건이 true입니다.");
        }
        
        // ============================================
        // 5. 문자열 (String - 참조 타입)
        // ============================================
        System.out.println("\n\n5. 문자열 데이터 타입 (String)");
        System.out.println("-----------------------------------");
        
        String str1 = "Hello";
        String str2 = "World";
        String str3 = new String("Java");
        
        System.out.println("String 값1: " + str1);
        System.out.println("String 값2: " + str2);
        System.out.println("String 값3: " + str3);
        
        // 문자열 연결
        String concatenated = str1 + " " + str2;
        System.out.println("문자열 연결: " + concatenated);
        
        // 문자열 메서드
        System.out.println("문자열 길이: " + str1.length());
        System.out.println("대문자 변환: " + str1.toUpperCase());
        System.out.println("소문자 변환: " + str1.toLowerCase());
        System.out.println("문자열 비교: " + str1.equals("Hello"));
        
        // ============================================
        // 6. 배열 (Array - 참조 타입)
        // ============================================
        System.out.println("\n\n6. 배열 데이터 타입");
        System.out.println("-----------------------------------");
        
        // 정수 배열
        int[] intArray = {1, 2, 3, 4, 5};
        System.out.print("int 배열: ");
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }
        System.out.println();
        
        // 문자열 배열
        String[] strArray = {"사과", "바나나", "오렌지"};
        System.out.print("String 배열: ");
        for (String fruit : strArray) {
            System.out.print(fruit + " ");
        }
        System.out.println();
        
        // 다차원 배열
        int[][] multiArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("2차원 배열:");
        for (int i = 0; i < multiArray.length; i++) {
            for (int j = 0; j < multiArray[i].length; j++) {
                System.out.print(multiArray[i][j] + " ");
            }
            System.out.println();
        }
        
        // ============================================
        // 7. 타입 변환 (Type Conversion)
        // ============================================
        System.out.println("\n\n7. 타입 변환");
        System.out.println("-----------------------------------");
        
        // 자동 타입 변환 (묵시적 변환)
        int intNum = 100;
        long longNum = intNum;  // int -> long 자동 변환
        float floatNum = intNum; // int -> float 자동 변환
        double doubleNum = floatNum; // float -> double 자동 변환
        
        System.out.println("int -> long: " + longNum);
        System.out.println("int -> float: " + floatNum);
        System.out.println("float -> double: " + doubleNum);
        
        // 강제 타입 변환 (명시적 변환)
        double doubleValue = 3.14;
        int intValue2 = (int) doubleValue;  // double -> int 강제 변환
        System.out.println("double -> int: " + intValue2); // 소수점 이하 손실
        
        // char와 int 간 변환
        char ch = 'A';
        int charToInt = ch;
        char intToChar = (char) 66;
        System.out.println("char 'A' -> int: " + charToInt);
        System.out.println("int 66 -> char: " + intToChar);
        
        // ============================================
        // 8. 상수 (Constants)
        // ============================================
        System.out.println("\n\n8. 상수");
        System.out.println("-----------------------------------");
        
        final int MAX_SIZE = 100;
        final double PI = 3.14159;
        final String COMPANY_NAME = "Java Study";
        
        System.out.println("final int MAX_SIZE: " + MAX_SIZE);
        System.out.println("final double PI: " + PI);
        System.out.println("final String COMPANY_NAME: " + COMPANY_NAME);
        
        // MAX_SIZE = 200; // 컴파일 에러: final 변수는 재할당 불가
        
        System.out.println("\n=== 예제 완료 ===");
    }
}

