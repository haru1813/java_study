package oop;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * 클래스와 객체, 생성자, 메서드 오버로딩 예제
 */
public class ClassAndObjectExample {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        System.out.println("=== 클래스와 객체, 생성자, 메서드 오버로딩 ===\n");
        
        // 객체 생성
        System.out.println("1. 객체 생성");
        System.out.println("-----------------------------------");
        Student student1 = new Student();
        System.out.println("student1 객체 생성 완료");
        
        // 생성자를 통한 초기화
        System.out.println("\n2. 생성자를 통한 초기화");
        System.out.println("-----------------------------------");
        Student student2 = new Student("홍길동", 20, "컴퓨터공학과");
        student2.displayInfo();
        
        // 기본 생성자 사용
        System.out.println("\n3. 기본 생성자 사용");
        System.out.println("-----------------------------------");
        Student student3 = new Student();
        student3.setName("김철수");
        student3.setAge(22);
        student3.setMajor("전자공학과");
        student3.displayInfo();
        
        // 메서드 오버로딩
        System.out.println("\n4. 메서드 오버로딩");
        System.out.println("-----------------------------------");
        Calculator calc = new Calculator();
        System.out.println("calc.add(10, 20): " + calc.add(10, 20));
        System.out.println("calc.add(10, 20, 30): " + calc.add(10, 20, 30));
        System.out.println("calc.add(10.5, 20.3): " + calc.add(10.5, 20.3));
        System.out.println("calc.add(\"Hello\", \" World\"): " + calc.add("Hello", " World"));
        
        // 여러 객체 생성
        System.out.println("\n5. 여러 객체 생성");
        System.out.println("-----------------------------------");
        Student[] students = {
            new Student("이영희", 21, "수학과"),
            new Student("박민수", 19, "물리학과"),
            new Student("최지영", 20, "화학과")
        };
        
        for (Student student : students) {
            student.displayInfo();
        }
    }
}

// Student 클래스
class Student {
    // 필드 (멤버 변수)
    private String name;
    private int age;
    private String major;
    
    // 기본 생성자
    public Student() {
        this.name = "이름 없음";
        this.age = 0;
        this.major = "전공 없음";
        System.out.println("기본 생성자 호출됨");
    }
    
    // 매개변수가 있는 생성자
    public Student(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
        System.out.println("매개변수 생성자 호출됨: " + name);
    }
    
    // Getter 메서드
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getMajor() {
        return major;
    }
    
    // Setter 메서드
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }
    
    // 일반 메서드
    public void displayInfo() {
        System.out.println("이름: " + name + ", 나이: " + age + ", 전공: " + major);
    }
}

// Calculator 클래스 - 메서드 오버로딩 예제
class Calculator {
    // 정수 두 개를 더하는 메서드
    public int add(int a, int b) {
        return a + b;
    }
    
    // 정수 세 개를 더하는 메서드 (오버로딩)
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    
    // 실수 두 개를 더하는 메서드 (오버로딩)
    public double add(double a, double b) {
        return a + b;
    }
    
    // 문자열을 연결하는 메서드 (오버로딩)
    public String add(String a, String b) {
        return a + b;
    }
}

