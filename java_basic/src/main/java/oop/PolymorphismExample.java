package oop;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * 다형성 (Polymorphism) 예제
 */
public class PolymorphismExample {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        System.out.println("=== 다형성 (Polymorphism) ===\n");
        
        // 1. 변수의 다형성
        System.out.println("1. 변수의 다형성");
        System.out.println("-----------------------------------");
        Vehicle vehicle1 = new Car("소나타");
        Vehicle vehicle2 = new Motorcycle("할리");
        Vehicle vehicle3 = new Bicycle("자전거");
        
        vehicle1.start();
        vehicle1.stop();
        
        vehicle2.start();
        vehicle2.stop();
        
        vehicle3.start();
        vehicle3.stop();
        
        // 2. 매개변수의 다형성
        System.out.println("\n2. 매개변수의 다형성");
        System.out.println("-----------------------------------");
        Driver driver = new Driver();
        driver.drive(new Car("벤츠"));
        driver.drive(new Motorcycle("야마하"));
        driver.drive(new Bicycle("산악자전거"));
        
        // 3. 배열의 다형성
        System.out.println("\n3. 배열의 다형성");
        System.out.println("-----------------------------------");
        Vehicle[] vehicles = {
            new Car("아반떼"),
            new Motorcycle("스쿠터"),
            new Bicycle("로드바이크"),
            new Car("제네시스")
        };
        
        for (Vehicle v : vehicles) {
            v.start();
            if (v instanceof Car) {
                ((Car) v).openTrunk();  // 타입 캐스팅
            }
        }
        
        // 4. 반환 타입의 다형성
        System.out.println("\n4. 반환 타입의 다형성");
        System.out.println("-----------------------------------");
        VehicleFactory factory = new VehicleFactory();
        Vehicle v1 = factory.createVehicle("car", "BMW");
        Vehicle v2 = factory.createVehicle("motorcycle", "혼다");
        Vehicle v3 = factory.createVehicle("bicycle", "자전거");
        
        v1.start();
        v2.start();
        v3.start();
    }
}

// 부모 클래스
class Vehicle {
    protected String name;
    
    public Vehicle(String name) {
        this.name = name;
    }
    
    public void start() {
        System.out.println(name + "이(가) 출발합니다.");
    }
    
    public void stop() {
        System.out.println(name + "이(가) 정지합니다.");
    }
}

// 자식 클래스 1
class Car extends Vehicle {
    public Car(String name) {
        super(name);
    }
    
    @Override
    public void start() {
        System.out.println(name + "의 엔진이 시동됩니다.");
    }
    
    @Override
    public void stop() {
        System.out.println(name + "의 브레이크를 밟습니다.");
    }
    
    public void openTrunk() {
        System.out.println(name + "의 트렁크를 엽니다.");
    }
}

// 자식 클래스 2
class Motorcycle extends Vehicle {
    public Motorcycle(String name) {
        super(name);
    }
    
    @Override
    public void start() {
        System.out.println(name + "의 엔진을 킵니다.");
    }
    
    @Override
    public void stop() {
        System.out.println(name + "의 브레이크를 잡습니다.");
    }
}

// 자식 클래스 3
class Bicycle extends Vehicle {
    public Bicycle(String name) {
        super(name);
    }
    
    @Override
    public void start() {
        System.out.println(name + "을(를) 페달로 밟기 시작합니다.");
    }
    
    @Override
    public void stop() {
        System.out.println(name + "의 브레이크를 잡습니다.");
    }
}

// Driver 클래스 - 매개변수 다형성 예제
class Driver {
    public void drive(Vehicle vehicle) {
        System.out.println("운전자가 " + vehicle.name + "을(를) 운전합니다.");
        vehicle.start();
        vehicle.stop();
    }
}

// VehicleFactory 클래스 - 반환 타입 다형성 예제
class VehicleFactory {
    public Vehicle createVehicle(String type, String name) {
        switch (type.toLowerCase()) {
            case "car":
                return new Car(name);
            case "motorcycle":
                return new Motorcycle(name);
            case "bicycle":
                return new Bicycle(name);
            default:
                return new Vehicle(name);
        }
    }
}

