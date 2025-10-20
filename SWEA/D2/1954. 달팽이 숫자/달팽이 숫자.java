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
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static int[][] table;
    static boolean[][] visited; 
    static int[][] d = {{0,1} , {1,0} , {0,-1}, {-1,0}};
    static int n;
    
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
            table = new int[n][n];
            visited = new boolean[n][n]; 
            visited[0][0] = true;
            dfs(0,0,0,1);
            System.out.printf("#%d " , test_case);
            System.out.println();
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    System.out.print(table[i][j]+" ");
                }
                System.out.println();
            }
		}
	}
    
    public static void dfs(int dir, int x , int y , int num){
        table[x][y] = num;
        int next_dir = (dir+1)%4;
        
        if(x+d[dir][0] < n && y+d[dir][1] < n && 
           x+d[dir][0] >=0 && y+d[dir][1] >= 0 &&
           !visited[x+d[dir][0]][y+d[dir][1]])
        {
            visited[x+d[dir][0]][y+d[dir][1]] = true;
            dfs(dir , x+d[dir][0] , y+d[dir][1] , num+1);
            
        }else if(x+d[next_dir][0] < n && y+d[next_dir][1] < n && 
           x+d[next_dir][0] >=0 && y+d[next_dir][1] >= 0 &&
           !visited[x+d[next_dir][0]][y+d[next_dir][1]])
        {
            visited[x+d[next_dir][0]][y+d[next_dir][1]] = true;
            dfs(next_dir , x+d[next_dir][0] , y+d[next_dir][1] , num+1);
        }
    }
   
    
}