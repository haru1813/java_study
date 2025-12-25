package oop;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * static과 final 예제
 */
public class StaticAndFinalExample {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        System.out.println("=== static과 final ===\n");
        
        // static 변수 사용
        System.out.println("1. static 변수");
        System.out.println("-----------------------------------");
        System.out.println("생성된 학생 수: " + StudentCounter.getCount());
        
        StudentCounter student1 = new StudentCounter("홍길동");
        System.out.println("생성된 학생 수: " + StudentCounter.getCount());
        
        StudentCounter student2 = new StudentCounter("김철수");
        System.out.println("생성된 학생 수: " + StudentCounter.getCount());
        
        StudentCounter student3 = new StudentCounter("이영희");
        System.out.println("생성된 학생 수: " + StudentCounter.getCount());
        
        // static 메서드 사용
        System.out.println("\n2. static 메서드");
        System.out.println("-----------------------------------");
        System.out.println("Math.PI: " + Math.PI);
        System.out.println("Math.max(10, 20): " + Math.max(10, 20));
        System.out.println("Math.min(10, 20): " + Math.min(10, 20));
        System.out.println("Math.abs(-5): " + Math.abs(-5));
        
        // final 변수
        System.out.println("\n3. final 변수");
        System.out.println("-----------------------------------");
        FinalExample example = new FinalExample("홍길동");
        System.out.println("이름: " + example.getName());
        // example.name = "김철수";  // 컴파일 에러! final 변수는 재할당 불가
        
        // final 메서드
        System.out.println("\n4. final 메서드");
        System.out.println("-----------------------------------");
        Parent parent = new Parent();
        parent.finalMethod();
        parent.normalMethod();
        
        Child child = new Child();
        child.finalMethod();  // 상속은 되지만 오버라이딩 불가
        child.normalMethod(); // 오버라이딩 가능
        
        // final 클래스
        System.out.println("\n5. final 클래스");
        System.out.println("-----------------------------------");
        FinalClass finalObj = new FinalClass();
        finalObj.display();
        // class ExtendedFinal extends FinalClass {}  // 컴파일 에러! final 클래스는 상속 불가
        
        // 상수 (static final)
        System.out.println("\n6. 상수 (static final)");
        System.out.println("-----------------------------------");
        System.out.println("Constants.PI: " + Constants.PI);
        System.out.println("Constants.MAX_SIZE: " + Constants.MAX_SIZE);
        System.out.println("Constants.APP_NAME: " + Constants.APP_NAME);
        
        // static 초기화 블록
        System.out.println("\n7. static 초기화 블록");
        System.out.println("-----------------------------------");
        System.out.println("StaticBlockExample.value: " + StaticBlockExample.getValue());
    }
}

// static 변수 예제
class StudentCounter {
    private String name;
    private static int count = 0;  // static 변수 (클래스 변수)
    
    public StudentCounter(String name) {
        this.name = name;
        count++;  // 객체 생성 시마다 증가
    }
    
    // static 메서드
    public static int getCount() {
        return count;
    }
    
    public String getName() {
        return name;
    }
}

// final 변수 예제
class FinalExample {
    private final String name;  // final 인스턴스 변수
    private final int age = 25;  // final 변수는 선언 시 또는 생성자에서 초기화
    
    public FinalExample(String name) {
        this.name = name;  // 생성자에서 초기화
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
}

// final 메서드 예제
class Parent {
    // final 메서드 - 오버라이딩 불가
    public final void finalMethod() {
        System.out.println("Parent의 final 메서드 (오버라이딩 불가)");
    }
    
    // 일반 메서드 - 오버라이딩 가능
    public void normalMethod() {
        System.out.println("Parent의 일반 메서드");
    }
}

class Child extends Parent {
    // @Override
    // public void finalMethod() {}  // 컴파일 에러! final 메서드는 오버라이딩 불가
    
    @Override
    public void normalMethod() {
        System.out.println("Child의 일반 메서드 (오버라이딩됨)");
    }
}

// final 클래스 예제
final class FinalClass {
    public void display() {
        System.out.println("FinalClass는 상속할 수 없습니다.");
    }
}

// 상수 예제
class Constants {
    // 상수는 대문자와 언더스코어로 명명
    public static final double PI = 3.14159;
    public static final int MAX_SIZE = 100;
    public static final String APP_NAME = "My Application";
    
    // private 생성자로 인스턴스 생성 방지
    private Constants() {
        // 유틸리티 클래스는 인스턴스화하지 않음
    }
}

// static 초기화 블록 예제
class StaticBlockExample {
    private static int value;
    
    // static 초기화 블록
    static {
        System.out.println("static 초기화 블록 실행됨");
        value = 100;
        // 복잡한 초기화 로직을 여기에 작성
    }
    
    public static int getValue() {
        return value;
    }
}

