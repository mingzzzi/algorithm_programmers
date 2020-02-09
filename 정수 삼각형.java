/*
 * 2020.02.09
 * https://programmers.co.kr/learn/courses/30/lessons/43105
 * Level3: 정수 삼각형(DP)
 */
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int size=triangle.length;
        int [][]d=new int[size][size];
        
        d[0][0]=triangle[0][0];
        for(int i=1; i<size; i++){
            for(int j=0; j<triangle[i].length; j++){
                if(j==0){
                    d[i][j]= d[i-1][j]+triangle[i][j];
                }
                else if(j==(triangle[i].length-1)){
                    d[i][j]= d[i-1][j-1]+triangle[i][j];
                }
                else{
                 d[i][j]= Math.max(d[i-1][j], d[i-1][j-1])+triangle[i][j];   
                }
            }
        }
        
        for(int i=0; i<size; i++){
            if(answer<d[size-1][i])
                answer=d[size-1][i];
        }
        return answer;
    }
}
