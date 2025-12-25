package oop;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * 상속과 메서드 오버라이딩 예제
 */
public class InheritanceExample {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        System.out.println("=== 상속과 메서드 오버라이딩 ===\n");
        
        // 부모 클래스 사용
        System.out.println("1. 부모 클래스 (Animal)");
        System.out.println("-----------------------------------");
        Animal animal = new Animal("동물");
        animal.eat();
        animal.sleep();
        animal.makeSound();
        
        // 자식 클래스 사용
        System.out.println("\n2. 자식 클래스 (Dog)");
        System.out.println("-----------------------------------");
        Dog dog = new Dog("뽀삐");
        dog.eat();        // 상속받은 메서드
        dog.sleep();      // 상속받은 메서드
        dog.makeSound();  // 오버라이딩된 메서드
        dog.bark();       // 자식 클래스만의 메서드
        
        // 자식 클래스 사용
        System.out.println("\n3. 자식 클래스 (Cat)");
        System.out.println("-----------------------------------");
        Cat cat = new Cat("야옹이");
        cat.eat();
        cat.sleep();
        cat.makeSound();  // 오버라이딩된 메서드
        cat.meow();       // 자식 클래스만의 메서드
        
        // 부모 타입으로 자식 객체 참조
        System.out.println("\n4. 부모 타입으로 자식 객체 참조");
        System.out.println("-----------------------------------");
        Animal myDog = new Dog("멍멍이");
        Animal myCat = new Cat("냥냥이");
        
        myDog.makeSound();  // 오버라이딩된 메서드 호출
        myCat.makeSound();  // 오버라이딩된 메서드 호출
        
        // instanceof 연산자
        System.out.println("\n5. instanceof 연산자");
        System.out.println("-----------------------------------");
        System.out.println("myDog instanceof Animal: " + (myDog instanceof Animal));
        System.out.println("myDog instanceof Dog: " + (myDog instanceof Dog));
        System.out.println("myDog instanceof Cat: " + (myDog instanceof Cat));
        
        // super 키워드 사용
        System.out.println("\n6. super 키워드 사용");
        System.out.println("-----------------------------------");
        Dog dog2 = new Dog("강아지");
        dog2.showInfo();
    }
}

// 부모 클래스
class Animal {
    protected String name;
    
    public Animal(String name) {
        this.name = name;
        System.out.println("Animal 생성자 호출: " + name);
    }
    
    public void eat() {
        System.out.println(name + "이(가) 먹이를 먹습니다.");
    }
    
    public void sleep() {
        System.out.println(name + "이(가) 잠을 잡니다.");
    }
    
    public void makeSound() {
        System.out.println(name + "이(가) 소리를 냅니다.");
    }
}

// 자식 클래스 1
class Dog extends Animal {
    public Dog(String name) {
        super(name);  // 부모 클래스 생성자 호출
        System.out.println("Dog 생성자 호출: " + name);
    }
    
    // 메서드 오버라이딩
    @Override
    public void makeSound() {
        System.out.println(name + "이(가) 멍멍 짖습니다.");
    }
    
    // 자식 클래스만의 메서드
    public void bark() {
        System.out.println(name + "이(가) 크게 짖습니다!");
    }
    
    // super 키워드 사용 예제
    public void showInfo() {
        System.out.println("=== " + name + "의 정보 ===");
        super.eat();      // 부모 클래스의 메서드 호출
        super.sleep();    // 부모 클래스의 메서드 호출
        this.makeSound(); // 현재 클래스의 메서드 호출
    }
}

// 자식 클래스 2
class Cat extends Animal {
    public Cat(String name) {
        super(name);  // 부모 클래스 생성자 호출
        System.out.println("Cat 생성자 호출: " + name);
    }
    
    // 메서드 오버라이딩
    @Override
    public void makeSound() {
        System.out.println(name + "이(가) 야옹 소리를 냅니다.");
    }
    
    // 자식 클래스만의 메서드
    public void meow() {
        System.out.println(name + "이(가) 귀여운 소리를 냅니다!");
    }
}

