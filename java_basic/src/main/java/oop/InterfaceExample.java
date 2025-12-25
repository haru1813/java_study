package oop;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * 인터페이스 (Interface) 예제
 */
public class InterfaceExample {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        System.out.println("=== 인터페이스 (Interface) ===\n");
        
        // 인터페이스 구현 클래스 사용
        System.out.println("1. Television 객체");
        System.out.println("-----------------------------------");
        RemoteControl tv = new Television();
        tv.turnOn();
        tv.setVolume(15);
        tv.setMute(true);
        tv.setMute(false);
        tv.turnOff();
        RemoteControl.changeBattery();  // 정적 메서드 호출
        
        System.out.println("\n2. Audio 객체");
        System.out.println("-----------------------------------");
        RemoteControl audio = new Audio();
        audio.turnOn();
        audio.setVolume(20);
        audio.setMute(true);
        audio.turnOff();
        
        // 다형성 활용
        System.out.println("\n3. 다형성 활용");
        System.out.println("-----------------------------------");
        RemoteControl[] devices = {
            new Television(),
            new Audio(),
            new SmartTV()
        };
        
        for (RemoteControl device : devices) {
            device.turnOn();
            device.setVolume(10);
            device.turnOff();
            System.out.println();
        }
        
        // 다중 인터페이스 구현
        System.out.println("4. 다중 인터페이스 구현");
        System.out.println("-----------------------------------");
        SmartTV smartTV = new SmartTV();
        smartTV.turnOn();           // RemoteControl 인터페이스
        smartTV.search("자바");     // Searchable 인터페이스
        smartTV.turnOff();
    }
}

// 인터페이스 1
interface RemoteControl {
    // 상수 (public static final 자동)
    int MAX_VOLUME = 100;
    int MIN_VOLUME = 0;
    
    // 추상 메서드 (public abstract 자동)
    void turnOn();
    void turnOff();
    void setVolume(int volume);
    
    // 디폴트 메서드 (Java 8+)
    default void setMute(boolean mute) {
        if (mute) {
            System.out.println("무음 처리합니다.");
            setVolume(MIN_VOLUME);
        } else {
            System.out.println("무음 해제합니다.");
        }
    }
    
    // 정적 메서드 (Java 8+)
    static void changeBattery() {
        System.out.println("건전지를 교환합니다.");
    }
}

// 인터페이스 2
interface Searchable {
    void search(String url);
}

// 인터페이스 구현 클래스 1
class Television implements RemoteControl {
    private int volume;
    
    @Override
    public void turnOn() {
        System.out.println("TV를 켭니다.");
    }
    
    @Override
    public void turnOff() {
        System.out.println("TV를 끕니다.");
    }
    
    @Override
    public void setVolume(int volume) {
        if (volume > RemoteControl.MAX_VOLUME) {
            this.volume = RemoteControl.MAX_VOLUME;
        } else if (volume < RemoteControl.MIN_VOLUME) {
            this.volume = RemoteControl.MIN_VOLUME;
        } else {
            this.volume = volume;
        }
        System.out.println("TV 볼륨: " + this.volume);
    }
}

// 인터페이스 구현 클래스 2
class Audio implements RemoteControl {
    private int volume;
    
    @Override
    public void turnOn() {
        System.out.println("Audio를 켭니다.");
    }
    
    @Override
    public void turnOff() {
        System.out.println("Audio를 끕니다.");
    }
    
    @Override
    public void setVolume(int volume) {
        if (volume > RemoteControl.MAX_VOLUME) {
            this.volume = RemoteControl.MAX_VOLUME;
        } else if (volume < RemoteControl.MIN_VOLUME) {
            this.volume = RemoteControl.MIN_VOLUME;
        } else {
            this.volume = volume;
        }
        System.out.println("Audio 볼륨: " + this.volume);
    }
}

// 다중 인터페이스 구현
class SmartTV implements RemoteControl, Searchable {
    private int volume;
    
    @Override
    public void turnOn() {
        System.out.println("SmartTV를 켭니다.");
    }
    
    @Override
    public void turnOff() {
        System.out.println("SmartTV를 끕니다.");
    }
    
    @Override
    public void setVolume(int volume) {
        if (volume > RemoteControl.MAX_VOLUME) {
            this.volume = RemoteControl.MAX_VOLUME;
        } else if (volume < RemoteControl.MIN_VOLUME) {
            this.volume = RemoteControl.MIN_VOLUME;
        } else {
            this.volume = volume;
        }
        System.out.println("SmartTV 볼륨: " + this.volume);
    }
    
    @Override
    public void search(String url) {
        System.out.println(url + "을(를) 검색합니다.");
    }
}

