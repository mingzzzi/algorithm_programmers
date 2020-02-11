/*
 * 2020.02.11
 * https://programmers.co.kr/learn/courses/30/lessons/42897
 * Level4: 도둑질(DP)
 */
class Solution {
   public static int solution(int[] money) {
		int size= money.length;
		int []d=new int[size];
		
		//대신 처음과 끝 동시에 방문 불가
		//0번 방문 했을 경우
		d[0]=money[0]; d[1]=d[0];
		for(int i=2; i<size-1; i++)
			d[i]=Math.max(d[i-1], d[i-2]+money[i]);
		int result=d[size-2];
		 
		d=new int[size];
		d[0]=0; d[1]=money[1];
		//0번 방문 안했을 경우
		for(int i=2; i<size;i++)
			d[i]=Math.max(d[i-1], d[i-2]+money[i]);
		
		
        int answer = Math.max(result, d[size-1]);
        return answer;
    }
}
