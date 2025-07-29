import java.util.*;
import java.io.*;

public class Main{


  static int[][] board;
  static List<Cctv> visited = new ArrayList<>();
  // 0: 상, 1: 하, 2: 좌, 3: 우
  static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  static int min = Integer.MAX_VALUE;
  static int[][][] cctvDir = {
      {}, // 0번은 없음
      {{0}, {1}, {2}, {3}},                   // 1번: 한 방향
      {{0, 1}, {2, 3}},                       // 2번: 양 방향
      {{0, 3}, {1, 3}, {1, 2}, {0, 2}},       // 3번: 직각
      {{0, 2, 3}, {0, 1, 3}, {1, 2, 3}, {0, 1, 2}},
      {{0, 1, 2, 3}}};                         // 5번: 네 방향


  static int N;
  static int M;

  public static class Cctv{
    int v;
    int x;
    int y;
    boolean b = false;

    public Cctv(int v, int x, int y){
      this.v = v;
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    //숫자들의 위치를 기억해두기
    StringTokenizer st = new StringTokenizer(br.readLine() , " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    // 숫자들에 대해서 모든 조합을 해봐야 함 , visited 체크하면서 해봐야함
    board = new int[N][M];

    for(int i = 0; i <N; i++)
    {
      st = new StringTokenizer(br.readLine(), " ");
      for(int j = 0; j < M; j++)
      {
        board[i][j] = Integer.parseInt(st.nextToken());
        //cctv를 cctv 배열에 저장
        if(board[i][j] != 0 && board[i][j] != 6)
        {
          visited.add(new Cctv(board[i][j] , i , j));
        }
      }
    }


    dfs(0,board);
    System.out.println(min);

  }


  public static void dfs(int depth, int[][] map)
  {
    if(depth == visited.size()){
      int count = countBlindSpots(map);
      min = Math.min(min,count);
      return;
    }

    Cctv now = visited.get(depth);
    int type = now.v;

    for(int[] directions : cctvDir[type])
    {
      //배열 복사하고
      int[][] temp = copyMap(map);
      //cctv 유형에 맞게 관찰
      watch(temp,now.x,now.y,directions);
      //재귀호출
      dfs(depth+1,temp);
    }
  }

  //cctv 유형에 맞게 돌려가며 탐색
  public static void watch(int[][] map, int x, int y, int[] directions)
  {
    for(int d : directions)
    {
      int nx = x;
      int ny = y;

      while(true)
      {
        nx += dir[d][0];
        ny += dir[d][1];

        if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 6) break;

        if (map[nx][ny] == 0) map[nx][ny] = -1; // 감시 대상인 0만 -1로
      }
    }
  }

  //사각지대 찾기

  public static int countBlindSpots(int[][] map)
  {
    int count = 0;
    for(int[] row : map)
    {
      for(int c : row) {
        if(c ==0) count++;
      }
    }
    return count;
  }

  //지금 보드 복사
  public static int[][] copyMap(int[][] map) {
    int[][] newMap = new int[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        newMap[i][j] = map[i][j];
      }
    }
    return newMap;
  }



}