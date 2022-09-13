import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
	
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
		
		System.out.println(map);
	}
}
