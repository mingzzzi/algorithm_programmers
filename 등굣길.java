/*
 * 2020.02.09
 * https://programmers.co.kr/learn/courses/30/lessons/42898
 * level3: 등굣길(DP)
 */
class Solution {
     public static int solution(int m, int n, int[][] puddles) {
		int[][] d = new int[n + 1][m + 1];
		boolean[][] isPuddles = new boolean[n + 1][m + 1];

		for (int i = 0; i < puddles.length; i++)
			isPuddles[puddles[i][1]][puddles[i][0]] = true;

		boolean flag = true;
		for (int i = 2; i < m + 1; i++) {
			// 웅덩이 이후에는 다 0으로 초기화
			if (isPuddles[1][i])
				flag = false;
			if (flag)
				d[1][i] = 1;
		}
		flag = true;
		for (int i = 2; i < n + 1; i++) {
			// 웅덩이 이후에는 다 0으로 초기화
			if (isPuddles[i][1])
				flag = false;
			if (flag)
				d[i][1] = 1;
		}
		System.out.println(d[2][1]);
		for (int i = 2; i < n + 1; i++) {
			for (int j = 2; j < m + 1; j++) {
				if (!isPuddles[i][j]) {
					d[i][j] = (d[i - 1][j] + d[i][j - 1]) % 1000000007;
				}
			}
		}

		int answer = d[n][m] % 1000000007;
		return answer;
	}
}
