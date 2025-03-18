import java.util.*;
import java.io.*;


public class Main{
  static int[][] board;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    board = new int[N][N];
    visited = new boolean[N][N];
    int[] shark = new int[2];
    int[][] dir = {{-1,0},{0,-1},{0,1},{1,0}};
    /*
    입력 파트
     */
    for(int i = 0; i < N; i++)
    {
      StringTokenizer st = new StringTokenizer(br.readLine() , " ");
      for(int j = 0; j < N; j++)
      {
        board[i][j] = Integer.parseInt(st.nextToken());
        //상어 위치는 저장해 두기
        if(board[i][j] == 9){
          shark[0] = i;
          shark[1] = j;
          board[i][j] = 0;
        }
      }
    }

    int size = 2;
    //먹은 물고기 수
    int eat = 0;
    // 움직인 총 거리
    int move = 0;

    while(true)
    {
      PriorityQueue<int[]> queue = new PriorityQueue<>((o1 , o2)
          -> o1[2] != o2[2] ? Integer.compare(o1[2],o2[2])
          : (o1[0] != o2[0]) ? Integer.compare(o1[0] , o2[0]) : Integer.compare(o1[1], o2[1]));

      boolean[][] visit = new boolean[N][N];

      //상어의 위치, 초기 이동 거리 0 대입
      queue.add(new int[]{shark[0] , shark[1], 0});
      visit[shark[0]][shark[1]] = true;

      //상어가 물고기 먹었는지 체크
      boolean eaten = false;

      while(!queue.isEmpty())
      {
        shark = queue.poll();
        //만약 현재 상어 위치의 값이 0이 아니고, 그 칸의 값이 상어 사이즈 보다 작다면
        if(board[shark[0]][shark[1]] != 0 && board[shark[0]][shark[1]] < size)
        {
          //물고기 먹어
          board[shark[0]][shark[1]] = 0;
          eat++;
          move += shark[2]; // 움직인 거리를 총 이동거리에 추가
          eaten = true; // 상어 밥먹었음 체크
          break; //먹었으니 while문 밖으로 나가 -> 현재 위치서부터 다시 bfs 시작
        }

        //물고기 있는 칸이 아니면 4방향으로 탐색
        for(int k = 0; k < 4; k++)
        {
          int nx = shark[0] + dir[k][0];
          int ny = shark[1] + dir[k][1];

          //만약 인덱스 기준 충족
          if(nx >= 0 && ny >= 0 && nx < N && ny < N)
          {
            //아직 방문 안하고, 갔더니 일단 상어보다 큰 숫자가 아님
            if(!visit[nx][ny] && board[nx][ny] <= size)
            {
              //방문해주기
              queue.add(new int[]{nx,ny,shark[2]+1});
              visit[nx][ny] = true;
            }
          }
        }
      }
      if(!eaten) break;
      if(size == eat) {
        size++;
        eat = 0;
      }
    }

    bw.write(move+"\n");
    bw.flush();
  }
}