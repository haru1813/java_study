package operators;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * 증감 연산자 (++, --) 예제
 * 전위 연산자와 후위 연산자의 차이를 설명합니다.
 */
public class IncrementDecrementExample {
    public static void main(String[] args) {
        // 콘솔 출력 인코딩을 UTF-8로 설정
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        System.out.println("=== 증감 연산자 (++, --) 예제 ===\n");
        
        // ============================================
        // 1. 후위 증가 연산자 (x++)
        // ============================================
        System.out.println("1. 후위 증가 연산자 (x++)");
        System.out.println("-----------------------------------");
        System.out.println("후위 연산자는 값을 먼저 사용한 후 증가시킵니다.");
        
        int x = 10;
        System.out.println("초기값: x = " + x);
        
        int result1 = x++;  // x의 현재 값(10)을 result1에 할당한 후, x를 1 증가
        System.out.println("result1 = x++; 실행 후");
        System.out.println("  result1 = " + result1 + " (x의 이전 값)");
        System.out.println("  x = " + x + " (증가된 값)");
        
        // ============================================
        // 2. 전위 증가 연산자 (++x)
        // ============================================
        System.out.println("\n\n2. 전위 증가 연산자 (++x)");
        System.out.println("-----------------------------------");
        System.out.println("전위 연산자는 값을 먼저 증가시킨 후 사용합니다.");
        
        int y = 10;
        System.out.println("초기값: y = " + y);
        
        int result2 = ++y;  // y를 먼저 1 증가시킨 후, 증가된 값을 result2에 할당
        System.out.println("result2 = ++y; 실행 후");
        System.out.println("  result2 = " + result2 + " (증가된 값)");
        System.out.println("  y = " + y + " (증가된 값)");
        
        // ============================================
        // 3. 후위 감소 연산자 (x--)
        // ============================================
        System.out.println("\n\n3. 후위 감소 연산자 (x--)");
        System.out.println("-----------------------------------");
        System.out.println("후위 연산자는 값을 먼저 사용한 후 감소시킵니다.");
        
        int a = 10;
        System.out.println("초기값: a = " + a);
        
        int result3 = a--;  // a의 현재 값(10)을 result3에 할당한 후, a를 1 감소
        System.out.println("result3 = a--; 실행 후");
        System.out.println("  result3 = " + result3 + " (a의 이전 값)");
        System.out.println("  a = " + a + " (감소된 값)");
        
        // ============================================
        // 4. 전위 감소 연산자 (--x)
        // ============================================
        System.out.println("\n\n4. 전위 감소 연산자 (--x)");
        System.out.println("-----------------------------------");
        System.out.println("전위 연산자는 값을 먼저 감소시킨 후 사용합니다.");
        
        int b = 10;
        System.out.println("초기값: b = " + b);
        
        int result4 = --b;  // b를 먼저 1 감소시킨 후, 감소된 값을 result4에 할당
        System.out.println("result4 = --b; 실행 후");
        System.out.println("  result4 = " + result4 + " (감소된 값)");
        System.out.println("  b = " + b + " (감소된 값)");
        
        // ============================================
        // 5. 전위와 후위 연산자 비교
        // ============================================
        System.out.println("\n\n5. 전위와 후위 연산자 비교");
        System.out.println("-----------------------------------");
        
        int num1 = 5;
        int num2 = 5;
        
        System.out.println("초기값: num1 = " + num1 + ", num2 = " + num2);
        
        // 후위 연산자
        int postResult = num1++ * 2;
        System.out.println("\n후위 연산자: postResult = num1++ * 2");
        System.out.println("  계산: postResult = " + num1 + " * 2 = " + (num1 * 2) + " (잘못된 이해)");
        System.out.println("  실제: postResult = " + postResult + " (5 * 2 = 10, num1은 나중에 증가)");
        System.out.println("  num1 = " + num1);
        
        // 전위 연산자
        int preResult = ++num2 * 2;
        System.out.println("\n전위 연산자: preResult = ++num2 * 2");
        System.out.println("  계산: preResult = " + preResult + " (6 * 2 = 12, num2는 먼저 증가)");
        System.out.println("  num2 = " + num2);
        
        // ============================================
        // 6. 복합 연산 예제
        // ============================================
        System.out.println("\n\n6. 복합 연산 예제");
        System.out.println("-----------------------------------");
        
        int m = 10;
        int n = 10;
        int z;
        
        System.out.println("초기값: m = " + m + ", n = " + n);
        
        // 여러 번 증가/감소
        m++;
        ++m;
        System.out.println("\nm++; ++m; 실행 후");
        System.out.println("  m = " + m + " (10 -> 11 -> 12)");
        
        n--;
        --n;
        System.out.println("\nn--; --n; 실행 후");
        System.out.println("  n = " + n + " (10 -> 9 -> 8)");
        
        // 복합 표현식
        z = ++m + n++;
        System.out.println("\nz = ++m + n++; 실행");
        System.out.println("  계산 과정:");
        System.out.println("    1. ++m 실행: m = " + (m - 1) + " -> " + m);
        System.out.println("    2. n++ 실행: n의 현재 값(" + (n - 1) + ") 사용, 이후 n 증가");
        System.out.println("    3. z = " + m + " + " + (n - 1) + " = " + z);
        System.out.println("  최종값: z = " + z + ", m = " + m + ", n = " + n);
        
        // ============================================
        // 7. 반복문에서의 사용
        // ============================================
        System.out.println("\n\n7. 반복문에서의 사용");
        System.out.println("-----------------------------------");
        
        System.out.println("for 루프에서 후위 증가 연산자 사용:");
        for (int i = 0; i < 5; i++) {  // i++는 루프 끝에서 실행
            System.out.print(i + " ");
        }
        System.out.println();
        
        System.out.println("\nwhile 루프에서 전위 증가 연산자 사용:");
        int count = 0;
        while (++count < 5) {  // ++count는 조건 확인 전에 실행
            System.out.print(count + " ");
        }
        System.out.println();
        
        // ============================================
        // 8. 주의사항
        // ============================================
        System.out.println("\n\n8. 주의사항");
        System.out.println("-----------------------------------");
        System.out.println("같은 변수에 여러 번 증감 연산자를 사용하는 것은 권장하지 않습니다.");
        
        int confusing = 5;
        System.out.println("초기값: confusing = " + confusing);
        
        // 혼란스러운 코드 (실제로는 잘 사용하지 않음)
        int result = confusing++ + ++confusing;
        System.out.println("result = confusing++ + ++confusing;");
        System.out.println("  계산 과정:");
        System.out.println("    1. confusing++: 5 사용, confusing = 6");
        System.out.println("    2. ++confusing: confusing = 7, 7 사용");
        System.out.println("    3. result = 5 + 7 = " + result);
        System.out.println("  최종값: result = " + result + ", confusing = " + confusing);
        System.out.println("\n  ⚠️ 이런 코드는 가독성이 떨어지므로 피하는 것이 좋습니다!");
        
        System.out.println("\n=== 예제 완료 ===");
    }
}

