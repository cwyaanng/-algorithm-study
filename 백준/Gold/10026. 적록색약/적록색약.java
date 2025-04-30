import java.io.*;
import java.util.*;

public class Main{


  static int[][] arr;
  static boolean[][] visited;
  static boolean[][] visited_no;
  static int[][] arr2;

  static int N;

  static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

  static int red = 0;
  static int green = 0;
  static int blue = 0;
  static int no = 0;

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());

    // red = 0 , green = 1 , blue = 2
    arr = new int[N][N];
    arr2 = new int[N][N];

    visited = new boolean[N][N];
    visited_no = new boolean[N][N];


    for(int i = 0; i < N; i++)
    {
      String s = br.readLine();
      for(int j = 0; j < N; j++)
      {
        if(s.charAt(j) == 'R')
        {
          arr[i][j] = 0;
          arr2[i][j] = 0;
        }
        else if(s.charAt(j) == 'G')
        {
          arr[i][j] = 1;
          arr2[i][j] = 0;
        }
        else
        {
          arr[i][j] = 2;
          arr2[i][j] = 2;
        }
      }
    }

    for(int i = 0; i< N; i++)
    {
      for(int j = 0; j < N; j++)
      {
        if(!visited[i][j] && arr[i][j] == 0)
        {
          bfs(visited,0 , i , j , arr);
          red +=1;
        }
        if(!visited[i][j] && arr[i][j] == 1)
        {
          bfs(visited,1 , i , j , arr);
          green+=1;
        }
        if(!visited[i][j] && arr[i][j] == 2)
        {
          bfs(visited,2 , i , j , arr) ;
          blue += 1;
        }
        if(!visited_no[i][j] && arr2[i][j] == 0)
        {
          bfs(visited_no,0 , i , j , arr2);
          no += 1;
        }
      }
    }

    int result1 = red+green+blue;
    int result2 = no+blue;

    bw.write(result1+" "+result2);
    bw.flush();

  }

  //bfs로 탐색하기
  // arr이랑, target 숫자가 주어지면 , 그룹의 수 세어서 리턴


  public static void bfs(boolean[][] visited, int t, int i , int j , int[][] arr)
  {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{i,j});
    visited[i][j] = true;


    while(!queue.isEmpty())
    {
      //하나를 뽑고 방문 표시 해주기
      int[] pos = queue.poll();

      for(int a = 0; a < 4; a++)
      {
        //새로 이동할 지점
        int nx = pos[0] + dir[a][0];
        int ny = pos[1] + dir[a][1];

        //인덱스가 밖으로 나가지 않았고 아직 방문이 안된 경우
        // 그리고 현재 찾으려는 그룹과 같은 색상인 경우 큐에 넣기
        if(nx < N && ny < N && nx >= 0 && ny >= 0 && !visited[nx][ny] && arr[nx][ny] == t)
        {
          queue.add(new int[]{nx,ny});
          visited[nx][ny] = true;
        }
      }
    }
  }
}