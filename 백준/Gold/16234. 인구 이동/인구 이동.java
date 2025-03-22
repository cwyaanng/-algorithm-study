import java.io.*;
import java.util.*;

public class Main{
  static int N;
  static int L;
  static int R;
  static int[][] array;
  static int[][] dir = {{0,1} , {-1,0} , {0,-1} , {1,0}};

  //같은 연합 내의 나라 인덱스 저장
  static ArrayList<int[]> arr = new ArrayList<>();
  //연합 내의 인구 총합
  static int num_population = 0;

  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    array = new int[N][N];
    visited = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        array[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int move = 0;

    while(true)
    {
      int flag = 0;
      visited = new boolean[N][N];

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if(!visited[i][j])
          {
            visited[i][j] = true;
            //bfs실행하면 인구수 총합과 연합 리스트 갱신 됨
            bfs(i,j);
            int union_size = arr.size();
            //인구 수 갱신
            if(arr.size() > 1)
            {
              for(int[] a : arr)
              {
                array[a[0]][a[1]] = num_population / union_size;
              }
              flag = 1;
            }
            arr = new ArrayList<>();
            num_population = 0;
          }
        }
      }
      if(flag == 0) break;
      move += 1;
    }


    bw.write(move+"");
    bw.flush();

  }



  public static void bfs(int i , int j)
  {
    //시작하는 큐 만들기
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{i,j});
    arr.add(new int[]{i,j});

    //인구 수를 더해주기
    num_population += array[i][j];

    while(!queue.isEmpty())
    {
      int[] t = queue.poll();

      for(int a = 0; a < 4; a++)
      {
        int new_x = t[0] + dir[a][0];
        int new_y = t[1] + dir[a][1];

        if(new_x >= 0 && new_y >= 0 && new_x < N && new_y < N)
        {
          if(!visited[new_x][new_y])
          {
            //인구 차이 계산
            int diff = Math.abs(array[new_x][new_y] - array[t[0]][t[1]]);
            //인구 조건에 맞으면 방문 표시, 큐에 추가, 인구 수 추가
            if(diff >=L && diff <= R)
            {
              visited[new_x][new_y] = true;
              queue.add(new int[]{new_x,new_y});
              arr.add(new int[]{new_x,new_y});
              num_population += array[new_x][new_y];
            }
          }
        }

      }
    }

  }

}