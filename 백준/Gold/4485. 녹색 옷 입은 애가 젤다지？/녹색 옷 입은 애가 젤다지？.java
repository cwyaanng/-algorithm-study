import java.util.*;
import java.io.*;

public class Main{

  static int[][] arr;
  static int[] dx = {1,0,-1,0};
  static int[] dy = {0,-1,0,1};
  static int N;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int a = 1;
    while(true)
    {
      N = Integer.parseInt(br.readLine());
      if(N == 0) break;
      arr = new int[N][N];
      for(int i = 0; i < N; i++)
      {
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        for(int j = 0; j < N; j++)
        {
          arr[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      bw.write("Problem "+a+": "+dijkstra()+"\n");
      a++;
    }
    bw.flush();
  }

  public static int dijkstra(){
    // BFS 처럼 탐색함. 가중치 배열도 추가해야함
    // priority Queue에 방문할 노드를 저장함
    // 가중치 배열을 추가함
    // 상하좌우로 돌아
    // 현재 가중치가 새로운 가중치보다 클 경우에 - 더 작은거로 교체해야 함

    PriorityQueue<int[]> pr = new PriorityQueue<>((o1,o2) -> o1[2] - o2[2]);

    int[][] weight = new int[N][N];
    for(int i = 0; i < N; i++)
    {
      Arrays.fill(weight[i], Integer.MAX_VALUE);
    }

    pr.add(new int[]{0,0,arr[0][0]});

    // 왜 추가??
    weight[0][0] = arr[0][0];

    while(!pr.isEmpty()){
      int[] node = pr.poll();

      int x = node[0];
      int y = node[1];
      int score = node[2];

      for(int i = 0; i < 4; i++)
      {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if( nx >=0 && nx < N && ny >= 0 && ny < N ){
          if(weight[nx][ny] > weight[x][y] + arr[nx][ny])
          {
            weight[nx][ny] = weight[x][y] + arr[nx][ny];
            pr.add(new int[]{nx,ny,arr[nx][ny]});
          }
        }
      }
    }
    return weight[N-1][N-1];
  }
}