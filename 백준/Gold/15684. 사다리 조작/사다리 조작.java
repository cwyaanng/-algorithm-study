import java.util.*;
import java.io.*;

public class Main{

  static int N,M,H;
  static boolean[][] grid;
  // 사다리 놓을 후보 위치를 저장하는 배열
  static List<int[]> cands = new ArrayList<>();
  static int ans = 4;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());
    grid = new boolean[H+1][N+1];

    for(int i = 0; i < M; i++)
    {
      st = new StringTokenizer(br.readLine()," ");
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      grid[a][b] = true;
    }

    //후보가 될 수 있는 자리 목록을 저장
    for(int r = 1; r <=H; r++)
    {
      for(int c = 1; c < N; c++)
      {
        cands.add(new int[]{r,c});
      }
    }

    if(ok()){
      bw.write("0");
      bw.flush();
      return;
    }

    dfs(0,0);
    if (ans <= 3)
    {
      bw.write(ans+"");
      bw.flush();
    }else{
      bw.write("-1");
      bw.flush();
    }

  }
  /**
   * 가로선을 하나 놓는다.
   * 개수를 센다. => i번째가 i 번 방문이라 정답이면 정답 값을 업데이트
   * dfs 호출한다.
   */
  static void dfs(int idx, int added){
    // 지금 added(사다리 추가한 횟수, dfs의 depth) ans 보다 큼 -> 최솟값 알아내는거니 굳이 탐색할 필요 없음
    // 3보다 크면 실패임
    if(added >= ans || added > 3) return;

    if(ok()){
      ans = Math.min(ans, added);
      return;
    }

    for(int i = idx; i < cands.size(); i++){
      int r = cands.get(i)[0];
      int c = cands.get(i)[1];
      if(canPlace(r,c)){
        grid[r][c] = true;
        dfs(i+1 , added+1);
        grid[r][c] = false;
      }
    }
  }
  static boolean canPlace(int r, int c)
  {
    // 이미 방문이 된 그리드
    if(grid[r][c]) return false;
    // 아래 두개는 가로선이 연속한 사다리는 불가능하니까 그걸 고려한 것
    if(c > 1 && grid[r][c-1]) return false;
    if(c < N - 1 && grid[r][c+1]) return false;
    return true;
  }

  /**
   * 검증용 함수
   */
  static boolean ok(){
    for(int start = 1; start <= N; start++)
    {
      int x = start;
      // 아래로 내려가면서 도착지 숫자를 업데이트
      for(int r = 1; r <= H; r++)
      {
        if(grid[r][x]) x++;
        else if( x > 1 && grid[r][x-1]) x--;
      }
      // 이동 다 끝냈더니 도착지 숫자가 다르면 false 리턴
      if(x != start) return false;
    }
    return true;
  }
}