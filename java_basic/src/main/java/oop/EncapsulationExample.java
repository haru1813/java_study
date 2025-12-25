package oop;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * 캡슐화 (Encapsulation) 예제
 * 접근 제어자와 Getter/Setter
 */
public class EncapsulationExample {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        System.out.println("=== 캡슐화 (Encapsulation) ===\n");
        
        // 캡슐화된 클래스 사용
        System.out.println("1. BankAccount 객체");
        System.out.println("-----------------------------------");
        BankAccount account = new BankAccount("홍길동", 10000);
        account.displayBalance();
        
        // Getter를 통한 접근
        System.out.println("\n계좌 소유자: " + account.getOwner());
        System.out.println("현재 잔액: " + account.getBalance() + "원");
        
        // Setter를 통한 안전한 수정
        System.out.println("\n2. 입금 및 출금");
        System.out.println("-----------------------------------");
        account.deposit(5000);
        account.displayBalance();
        
        account.withdraw(3000);
        account.displayBalance();
        
        // 잘못된 출금 시도
        account.withdraw(20000);  // 잔액 부족
        account.displayBalance();
        
        // 접근 제어자 예제
        System.out.println("\n3. 접근 제어자 예제");
        System.out.println("-----------------------------------");
        AccessModifierExample example = new AccessModifierExample();
        
        // public - 어디서나 접근 가능
        example.publicField = "Public 필드";
        System.out.println("publicField: " + example.publicField);
        example.publicMethod();
        
        // protected - 같은 패키지 또는 상속 관계에서 접근 가능
        // (현재 같은 패키지이므로 접근 가능)
        example.protectedField = "Protected 필드";
        System.out.println("protectedField: " + example.protectedField);
        example.protectedMethod();
        
        // default (package-private) - 같은 패키지에서만 접근 가능
        example.defaultField = "Default 필드";
        System.out.println("defaultField: " + example.defaultField);
        example.defaultMethod();
        
        // private - 같은 클래스 내에서만 접근 가능
        // example.privateField = "Private 필드";  // 컴파일 에러!
        // example.privateMethod();  // 컴파일 에러!
        example.accessPrivate();  // public 메서드를 통해 간접 접근
    }
}

// 캡슐화 예제 클래스
class BankAccount {
    // private 필드 - 외부에서 직접 접근 불가
    private String owner;
    private double balance;
    
    // 생성자
    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
            System.out.println("잘못된 초기 잔액입니다. 0원으로 설정합니다.");
        }
    }
    
    // Getter 메서드
    public String getOwner() {
        return owner;
    }
    
    public double getBalance() {
        return balance;
    }
    
    // Setter 메서드 (검증 로직 포함)
    public void setOwner(String owner) {
        if (owner != null && !owner.trim().isEmpty()) {
            this.owner = owner;
        } else {
            System.out.println("잘못된 이름입니다.");
        }
    }
    
    // 입금 메서드
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + "원을 입금했습니다.");
        } else {
            System.out.println("입금 금액은 0보다 커야 합니다.");
        }
    }
    
    // 출금 메서드
    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(amount + "원을 출금했습니다.");
            } else {
                System.out.println("잔액이 부족합니다. 현재 잔액: " + balance + "원");
            }
        } else {
            System.out.println("출금 금액은 0보다 커야 합니다.");
        }
    }
    
    // 잔액 조회
    public void displayBalance() {
        System.out.println("계좌 소유자: " + owner);
        System.out.println("현재 잔액: " + balance + "원");
    }
}

// 접근 제어자 예제 클래스
class AccessModifierExample {
    // public - 어디서나 접근 가능
    public String publicField = "public";
    
    // protected - 같은 패키지 또는 상속 관계에서 접근 가능
    protected String protectedField = "protected";
    
    // default (package-private) - 같은 패키지에서만 접근 가능
    String defaultField = "default";
    
    // private - 같은 클래스 내에서만 접근 가능
    private String privateField = "private";
    
    // public 메서드
    public void publicMethod() {
        System.out.println("public 메서드 호출됨");
    }
    
    // protected 메서드
    protected void protectedMethod() {
        System.out.println("protected 메서드 호출됨");
    }
    
    // default 메서드
    void defaultMethod() {
        System.out.println("default 메서드 호출됨");
    }
    
    // private 메서드
    private void privateMethod() {
        System.out.println("private 메서드 호출됨");
    }
    
    // private 멤버에 접근하는 public 메서드
    public void accessPrivate() {
        System.out.println("privateField: " + privateField);
        privateMethod();
    }
}

