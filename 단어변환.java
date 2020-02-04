/*
 * 2020.02.04
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 * Level3: 단어변환(BFS)
 */
import java.util.*;
class Solution {
    static Queue<Integer> q= new LinkedList<Integer>();
    static int[] dist;
    static String[] words2;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        dist=new int[words.length+1];
        for(int i=0; i<words.length+1;i++)dist[i]=-1;
        
        //편의를 위해 begin을 합친 words 배열 생성
        words2=new String[words.length+1];
        words2[0]=begin;
        for(int i=1; i<words2.length; i++)
            words2[i]=words[i-1];
        
        answer = bfs(begin, target, words2);
        
        return answer;
    }
    
    public static int bfs(String begin, String target, String[] words2){
        int answer=0;
        //큐에 words2의 인덱스 저장
        q.add(0);
        dist[0]=0;
        while(!q.isEmpty()){
            int index=q.remove();
            if(words2[index].equals(target)){
                answer=dist[index];
                break;
            }
            
            String [] curs=words2[index].split("");
            for(int i=0; i<words2.length; i++){
                if(dist[i]==-1){
                    int count=0;
                    String [] temp= words2[i].split("");
                    for(int j=0; j<begin.length(); j++){
                        if(curs[j].equals(temp[j])){
                            count++;
                        }
                    }
                    if(count==begin.length()-1){
                        q.add(i);
                        dist[i]=dist[index]+1;
                    }
                }
            }
        }
        return answer;
    }
}
