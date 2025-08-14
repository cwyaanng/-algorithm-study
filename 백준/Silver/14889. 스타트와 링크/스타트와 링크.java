import java.util.*;
import java.io.*;

public class Main {


    static boolean[] trace;

    static int N;

    static int[][] board;


    static int start_total = 0;

    static int end_total = 0;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        //점수 넣을 배열
        board = new int[N][N];
        //조합용 trace
        trace = new boolean[N];

        //보드 안에 숫자 값 저장
        for(int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++)
            {
                board[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        //여기까지 순열 호출
        comb(0 , 0);


        bw.write(min+"");
        bw.flush();
    }


    public static void comb(int cnt , int prev){
        if(cnt == N/2){

            end_total = 0;
            start_total = 0;
            for(int i = 0; i < N; i++)
            {
                for(int j = 0; j < N; j++)
                {
                    if(trace[i] && trace[j]) start_total += board[i][j];
                    else if (!trace[i] && !trace[j]) {
                        end_total += board[i][j];
                    }
                }
            }
            min = Math.min(min,Math.abs(start_total-end_total));

            return;
        }

        for(int i = prev; i < N; i++)
        {
            if(!trace[i])
            {
                trace[i] = true;
                comb(cnt+1 , i+1);
                trace[i] = false;
            }
        }
    }

}
