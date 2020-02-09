/*
 * 2020.02.09
 * https://programmers.co.kr/learn/courses/30/lessons/43104
 * Level3: 타일 장식물(DP)
 */
import java.util.*;
class Solution {
    public long solution(int n) {
        long answer = 0;
        long []d= new long[n+1];
        d[1]=4; d[2]=6;
        for(int i=3; i<n+1;i++)
            d[i]=d[i-1]+d[i-2];
        answer=d[n];
        return answer;
    }
}
