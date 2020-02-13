/*
 * 2020.02.13
 * https://programmers.co.kr/learn/courses/30/lessons/42899
 * Level4: 서울에서 경산까지(DP)
 */
class Solution {
    public static int solution(int K, int[][] travel) {
		int answer = 0;
		int size = travel.length;
		int[][] d = new int[size+1][K+1];
		
		d[0][travel[0][0]] = travel[0][1];
		d[0][travel[0][2]] = travel[0][3];
		for (int i = 1; i < size; i++) {
			for (int j = 0; j < K + 1; j++) {
				if (d[i - 1][j] == 0)
					continue; // 전 단계에서 지나지 않은 거리
         
				if (j + travel[i][0] <= K) {
					d[i][j+travel[i][0]]=Math.max(d[i][j+travel[i][0]], d[i-1][j]+travel[i][1]);
					answer=Math.max(answer,d[i][j+travel[i][0]]);
				}
				if (j + travel[i][2] <= K) {
					d[i][j+travel[i][2]]=Math.max(d[i][j+travel[i][2]], d[i-1][j]+travel[i][3]);
					answer=Math.max(answer,d[i][j+travel[i][2]]);
				}
			}
		}
		System.out.println(answer);
		return answer;
	}
}
