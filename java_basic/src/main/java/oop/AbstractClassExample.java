package oop;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * 추상 클래스 (Abstract Class) 예제
 */
public class AbstractClassExample {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        System.out.println("=== 추상 클래스 (Abstract Class) ===\n");
        
        // 추상 클래스는 직접 인스턴스화할 수 없음
        // Shape shape = new Shape();  // 컴파일 에러!
        
        // 추상 클래스를 상속받은 구체 클래스 사용
        System.out.println("1. Circle 객체");
        System.out.println("-----------------------------------");
        Circle circle = new Circle(5.0);
        circle.displayInfo();
        System.out.println("면적: " + circle.calculateArea());
        System.out.println("둘레: " + circle.calculatePerimeter());
        
        System.out.println("\n2. Rectangle 객체");
        System.out.println("-----------------------------------");
        Rectangle rectangle = new Rectangle(4.0, 6.0);
        rectangle.displayInfo();
        System.out.println("면적: " + rectangle.calculateArea());
        System.out.println("둘레: " + rectangle.calculatePerimeter());
        
        System.out.println("\n3. Triangle 객체");
        System.out.println("-----------------------------------");
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        triangle.displayInfo();
        System.out.println("면적: " + triangle.calculateArea());
        System.out.println("둘레: " + triangle.calculatePerimeter());
        
        // 다형성 활용
        System.out.println("\n4. 다형성 활용");
        System.out.println("-----------------------------------");
        Shape[] shapes = {
            new Circle(3.0),
            new Rectangle(5.0, 4.0),
            new Triangle(6.0, 8.0, 10.0)
        };
        
        for (Shape shape : shapes) {
            shape.displayInfo();
            System.out.println("면적: " + shape.calculateArea());
            System.out.println("둘레: " + shape.calculatePerimeter());
            System.out.println();
        }
    }
}

// 추상 클래스
abstract class Shape {
    protected String name;
    
    public Shape(String name) {
        this.name = name;
    }
    
    // 일반 메서드 (구현된 메서드)
    public void displayInfo() {
        System.out.println("도형 이름: " + name);
    }
    
    // 추상 메서드 (구현되지 않은 메서드)
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    
    // 추상 클래스는 일반 메서드도 가질 수 있음
    public String getName() {
        return name;
    }
}

// 추상 클래스를 상속받은 구체 클래스 1
class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        super("원");
        this.radius = radius;
    }
    
    // 추상 메서드 구현
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("반지름: " + radius);
    }
}

// 추상 클래스를 상속받은 구체 클래스 2
class Rectangle extends Shape {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        super("사각형");
        this.width = width;
        this.height = height;
    }
    
    // 추상 메서드 구현
    @Override
    public double calculateArea() {
        return width * height;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("가로: " + width + ", 세로: " + height);
    }
}

// 추상 클래스를 상속받은 구체 클래스 3
class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;
    
    public Triangle(double side1, double side2, double side3) {
        super("삼각형");
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    // 추상 메서드 구현
    @Override
    public double calculateArea() {
        // 헤론의 공식 사용
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    
    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("변1: " + side1 + ", 변2: " + side2 + ", 변3: " + side3);
    }
}

