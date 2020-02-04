/*
*2020.02.04.
*https://programmers.co.kr/learn/courses/30/lessons/43162
*Level3: 네트워크
*/
import java.util.*;
class Solution {
	static Queue<Integer> q = new LinkedList<>();
	static boolean[] check;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	public int solution(int n, int[][] computers) {
		int answer = 0;
		check = new boolean[n]; 
        
		// bfs 탐색
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
                if(computers[i][j]==1 && check[i]==false){        
                    bfs(i, n, computers);
                    answer++;
                }
			}
		}
		return answer;
	}

	public static void bfs(int x, int n, int[][] computers) {
        q.add(x);
        check[x]=true;
		while (!q.isEmpty()) {
            int point = q.remove();
            for(int i=0; i<n; i++){
                if(computers[point][i]==1 && check[i]==false) {
                    q.add(i);
                    check[i]=true;
                } 
            }
		}
	}
}
