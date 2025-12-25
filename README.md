# Java Basic Study

자바 프로그래밍의 기초부터 고급 개념까지 학습할 수 있는 예제 코드 모음입니다.

## 📚 프로젝트 소개

이 프로젝트는 자바의 다양한 개념을 학습하기 위한 실습 예제 코드들을 포함하고 있습니다. 각 패키지별로 주제를 나누어 체계적으로 학습할 수 있도록 구성되어 있습니다.

## 🛠️ 기술 스택

- **Java** (JDK 8 이상)
- **Gradle** (빌드 도구)
- **JUnit 5** (테스트 프레임워크)

## 📁 프로젝트 구조

```
java_basic/
├── src/
│   └── main/
│       └── java/
│           ├── datatypes/          # 데이터 타입 예제
│           ├── operators/           # 연산자 예제
│           ├── controlflow/         # 제어문 예제
│           ├── arrays/              # 배열 예제
│           ├── collections/         # 컬렉션 예제
│           ├── oop/                 # 객체지향 프로그래밍 예제
│           └── lambda/              # 람다식 예제
└── build.gradle
```

## 📖 학습 내용

### 1. 데이터 타입 (datatypes)
- 기본 데이터 타입 (정수형, 실수형, 문자형, 논리형)
- 참조 타입 (String, 배열)
- 타입 변환
- 상수

**예제 파일:** `DataTypeExamples.java`

### 2. 연산자 (operators)
- 산술 연산자 (+, -, *, /, %)
- 증감 연산자 (++, --)
- 비교 연산자 (==, !=, <, <=, >, >=)
- 논리 연산자 (&&, ||, !)
- 복합 대입 연산자 (+=, -=, *=, /=, %=)
- 삼항 연산자 (? :)
- 비트 연산자 (&, |, ^, ~)
- 시프트 연산자 (<<, >>, >>>)
- instanceof 연산자

**예제 파일:**
- `IncrementDecrementExample.java` - 증감 연산자
- `AllOperatorsExample.java` - 모든 연산자

### 3. 제어문 (controlflow)
- if문 (단순 if, if-else, if-else if-else, 중첩 if)
- switch문 (정수형, 문자형, 문자열, Java 14+ 표현식)
- for문 (기본 for, 향상된 for, 중첩 for)
- while문 (while, do-while)
- break문 (일반 break, 레이블 break)
- continue문 (일반 continue, 레이블 continue)

**예제 파일:** `ControlFlowExamples.java`

### 4. 배열 (arrays)
- 1차원 배열 (선언, 초기화, 접근)
- 2차원 배열 (고정 크기, 가변 길이)
- 3차원 배열
- Arrays 유틸리티 클래스
- 실전 예제 (최대값/최소값, 평균, 검색, 역순)

**예제 파일:** `ArrayExamples.java`

### 5. 컬렉션 (collections)
- List (ArrayList, LinkedList, Vector, Stack)
- Set (HashSet, LinkedHashSet, TreeSet)
- Map (HashMap, LinkedHashMap, TreeMap, Hashtable)
- Queue (PriorityQueue, ArrayDeque)
- Iterator와 Stream API

**예제 파일:**
- `ListCollectionExample.java` - List 컬렉션
- `SetCollectionExample.java` - Set 컬렉션
- `MapCollectionExample.java` - Map 컬렉션
- `QueueCollectionExample.java` - Queue 컬렉션
- `IteratorAndStreamExample.java` - Iterator와 Stream API

### 6. 객체지향 프로그래밍 (oop)
- 클래스와 객체
- 생성자와 메서드 오버로딩
- 상속과 메서드 오버라이딩
- 다형성
- 추상 클래스
- 인터페이스
- 캡슐화 (접근 제어자, Getter/Setter)
- static과 final

**예제 파일:**
- `ClassAndObjectExample.java` - 클래스와 객체, 생성자, 메서드 오버로딩
- `InheritanceExample.java` - 상속과 메서드 오버라이딩
- `PolymorphismExample.java` - 다형성
- `AbstractClassExample.java` - 추상 클래스
- `InterfaceExample.java` - 인터페이스
- `EncapsulationExample.java` - 캡슐화
- `StaticAndFinalExample.java` - static과 final

### 7. 람다식 (lambda)
- 람다식 기본 문법
- 함수형 인터페이스 (Supplier, Consumer, Function, Predicate 등)
- 메서드 참조 (정적 메서드, 인스턴스 메서드, 생성자)
- 람다식 실전 활용
- 배열과 컬렉션에서의 람다식 활용

**예제 파일:**
- `LambdaBasicExample.java` - 람다식 기본
- `FunctionalInterfaceExample.java` - 함수형 인터페이스
- `MethodReferenceExample.java` - 메서드 참조
- `LambdaPracticalExample.java` - 람다식 실전 활용
- `CollectionLambdaExample.java` - 배열과 컬렉션에서의 람다식

## 🚀 시작하기

### 사전 요구사항
- JDK 8 이상
- Gradle (또는 Gradle Wrapper)

### 실행 방법

1. **프로젝트 클론**
```bash
git clone https://github.com/your-username/java_study.git
cd java_study/java_basic
```

2. **Gradle 빌드**
```bash
./gradlew build
```

3. **예제 실행**
```bash
# 예: 데이터 타입 예제 실행
./gradlew run --main datatypes.DataTypeExamples

# 예: 람다식 예제 실행
./gradlew run --main lambda.LambdaBasicExample
```

또는 IDE에서 각 예제 클래스의 `main` 메서드를 직접 실행할 수 있습니다.

## 📝 예제 실행 예시

### 데이터 타입 예제
```java
java datatypes.DataTypeExamples
```

### 람다식 예제
```java
java lambda.LambdaBasicExample
```

### 컬렉션 예제
```java
java collections.ListCollectionExample
```

## 🔧 빌드 설정

프로젝트는 Gradle을 사용하며, `build.gradle` 파일에서 다음을 설정합니다:
- Java 소스 인코딩: UTF-8
- JUnit 5 테스트 프레임워크

## 📌 주요 특징

- ✅ **체계적인 구성**: 주제별로 패키지를 나누어 학습하기 쉽게 구성
- ✅ **실전 예제**: 이론뿐만 아니라 실용적인 예제 포함
- ✅ **한글 주석**: 모든 예제에 한글 설명 포함
- ✅ **독립 실행**: 각 예제 파일이 독립적으로 실행 가능
- ✅ **UTF-8 인코딩**: 한글 출력을 위한 인코딩 설정

## 📚 학습 순서 추천

1. **기초 단계**
   - 데이터 타입 → 연산자 → 제어문

2. **중급 단계**
   - 배열 → 컬렉션

3. **고급 단계**
   - 객체지향 프로그래밍 → 람다식

## 🤝 기여하기

이슈나 개선 사항이 있으시면 언제든지 Pull Request를 보내주세요!

## 📄 라이선스

이 프로젝트는 학습 목적으로 자유롭게 사용할 수 있습니다.

## 👨‍💻 작성자

- **haru.park**

## 📞 문의

프로젝트에 대한 질문이나 제안사항이 있으시면 이슈를 등록해주세요.

---

**Happy Coding! 🎉**

