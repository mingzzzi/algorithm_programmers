/*
 * 2020.02.05
 * https://programmers.co.kr/learn/courses/30/lessons/43164
 * Level3: 여행경로
 */
import java.util.*;

class Solution {
    static List<String> list = new ArrayList<>();
    static boolean [] check;
    static int count=0;
    static String route="";
	public String[] solution(String[][] tickets) {
        
		check=new boolean[tickets.length];
        
        for(int i=0; i<tickets.length; i++){
            String dep=tickets[i][0];
            String dest=tickets[i][1];
            
            if(dep.equals("ICN")){
                route= dep+",";
                check[i]=true;
                count=1;
                dfs(tickets, dest, count, route);
                check[i]=false;
            }
            
        }
        
        Collections.sort(list);
		String[] answer = list.get(0).split(",");
		return answer;
	}
    
    public static void dfs(String[][]tickets, String dest, int count, String route){
        route+=dest+",";
        
        if(count==tickets.length){
            list.add(route);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(dest.equals(tickets[i][0]) && !check[i]){
                check[i]=true;
                dfs(tickets, tickets[i][1],count+1, route);
                check[i]=false;
            }
        }
    }
}
