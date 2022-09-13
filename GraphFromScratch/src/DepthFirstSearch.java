import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {
	
	
	public static void DFS(HashMap<Integer,List<Integer>> map,int s,int n) {
		
		boolean[] visited = new boolean[n];
		Arrays.fill(visited, false);
		List<Integer> ans = new ArrayList<>();
		
		Stack<Integer> stk = new Stack<>();
		stk.push(s);
		
		while(!stk.isEmpty()) {
			int temp = stk.pop();
			
			List<Integer> list = map.get(temp);
			
			for(Integer i :list) {
				if(visited[i-1]==false) stk.push(i);
			}
			ans.add(temp);
			visited[temp-1] = true;
		}
		
		System.out.println(ans);
	}
	
	public static void createGraph(HashMap<Integer,List<Integer>> map,int n) {
		
		for(int i = 1 ; i<=n ; i++) {
			map.put(i, new ArrayList<>());
		}
		
		return;
	}
	
	public static void main(String[] args) {
		int[][] mat = {
				{1,2},{1,3},{1,4},{2,3},{4,5},{5,6},{6,7},{6,8}
		};
		
		int m = mat.length;
		
		HashMap<Integer,List<Integer>> map = new HashMap<>();
		createGraph(map,8);
		
		for(int i = 0 ; i<mat.length ; i++) {
			int x = mat[i][0];
			int y = mat[i][1];
			
			map.get(x).add(y);
			map.get(y).add(x);
		}
		
		DFS(map,3,m+2);
		System.out.println(map);
	}
}
