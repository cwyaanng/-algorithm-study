/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       			 // double 변수 1개 출력하는 예제
//System.out.println(g);		       			 // char 변수 1개 출력하는 예제
//System.out.println(var);		       		   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       		     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
import java.io.*;

class Solution {
    public static char[] arr;
    public static String answer = "";
	public static int count;
    
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();
            arr = s.toCharArray();
            
            count = Integer.parseInt(st.nextToken());
            
            if(count > arr.length) count = arr.length;
            
            answer = "";
            back(0,0);
            System.out.println("#" + test_case + " " + answer);
        }
    }

    public static void back(int n, int depth) {
        if (n == count) {
            String current = new String(arr);
            if (current.compareTo(answer) > 0) {
                answer = current;
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                swap(i, j);
                back(n+1, i);
                swap(i, j);
            }
        }
    }

    public static void swap(int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
