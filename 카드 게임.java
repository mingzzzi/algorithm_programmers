/*
 * 2020.02.11
 * https://programmers.co.kr/learn/courses/30/lessons/42896
 * Level4: 카드 게임(DP)
 */
class Solution {
   static int[][] d;
   public static int solution(int[] left, int[] right) {
		int size = left.length;
		d = new int[size][size]; // d[i][j]: 왼쪽이 i이고 오른쪽이 j일 때 최댓값
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				d[i][j] = -1; // memorization을 위해 -1로 초기화
			}
		}

		int answer = go(0, 0, left, right);
		System.out.println(answer);
		return answer;
	}

	public static int go(int i, int j, int[] left, int[] right) {
		if (i == left.length || j == left.length)
			return 0;
		
		if (d[i][j] != -1)
			return d[i][j];

		if (right[j] < left[i]) {
			d[i][j] = go(i,j+1,left,right) + right[j];
		} else {
			int value = Math.max(go(i + 1, j, left, right), go(i + 1, j + 1, left, right));
			d[i][j] = value;
		}

		return d[i][j];
	}
}
