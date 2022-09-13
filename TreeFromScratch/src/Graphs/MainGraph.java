package Graphs;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;



public class MainGraph {
	int V;
	LinkedList[] adj;
	
	
	MainGraph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; i++)
            adj[i] = new LinkedList<Integer>();
    }
	
	void addEdge(int v, int u) {
		adj[v].add(u);
	}
	
	void BFS(int s) {
		boolean[] visited = new boolean[V];
		
		Queue<Integer> queue = new ArrayDeque<>();
		visited[s] = true;
		queue.add(s);
		
		while(queue.size()!=0) {
			s = queue.poll();
			System.out.print(s+" ");
			
			Iterator<Integer> i = adj[s].listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		MainGraph mg = new MainGraph(10);
		
		mg.addEdge(0, 1);
		mg.addEdge(0, 2);
		mg.addEdge(1, 2);
        mg.addEdge(2, 0);
        mg.addEdge(2, 3);
        mg.addEdge(3, 3);
        mg.addEdge(3, 1);
        mg.addEdge(3, 2);
        mg.addEdge(3, 0);
        
        mg.BFS(2);
	}
}
