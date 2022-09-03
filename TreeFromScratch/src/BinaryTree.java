import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;


class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int val) {
		data = val;
		left = null;
		right = null;
	}
	
	

	@Override
	public String toString() {
		return "TreeNode [data=" + data + ", left=" + left + ", right=" + right + "]";
	}
	
}


class Values{
	int index;
	TreeNode node;
	public Values(int index, TreeNode node) {
		super();
		this.index = index;
		this.node = node;
	}

	
}


public class BinaryTree {

	static TreeNode prev = null;
	
	static boolean isValidate(TreeNode root) {
		if(root!=null) {
			
			if(!isValidate(root.left)) {
				return false;
			}
			
			if(prev!=null && root.data<=prev.data) {
				return false;
			}
			
			prev = root;
			
			return isValidate(root.right);
		}
		
		return true;
	}
	
	static int heightTree(TreeNode root) {
		
		if(root==null) {
			return 0;
		}
		return Math.max(heightTree(root.left), heightTree(root.right))+1;
		
		
	}
	
	static boolean isBalanced(TreeNode root) {
		if(root==null) {
			return false;
		}
		
		int left = heightTree(root.left);
		int right = heightTree(root.right);
		
		if(Math.abs(left-right)<=1 && isBalanced(root.left) && isBalanced(root.right)) {
			return true;
		}
		
		return false;
	}
	
	static List<Integer> bottomView(TreeNode root){
		List<Integer> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		Queue<Values> queue = new ArrayDeque<>();
		
		queue.add(new Values(0,root));
		
		while(!queue.isEmpty()) {
			
			Values temp = queue.poll();
			
			map.put(temp.index	, temp.node.data);
		
			if(temp.node.left!=null) {
				queue.add(new Values(temp.index-1, temp.node.left));
			}
			
			if(temp.node.right!=null) {
				queue.add(new Values(temp.index+1, temp.node.right));
			}
		}
		
		for(Map.Entry<Integer, Integer> m : map.entrySet()) {
			list.add(m.getValue());
		}
		return list;
	}
	
	static List<Integer> topView(TreeNode root){
		List<Integer> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		Queue<Values> queue = new ArrayDeque<>();
		
		queue.add(new Values(0,root));
		
		while(!queue.isEmpty()) {
			
			Values temp = queue.poll();
			
			if(!map.containsKey(temp.index)) {
				map.put(temp.index	, temp.node.data);
			}
			
			if(temp.node.left!=null) {
				queue.add(new Values(temp.index-1, temp.node.left));
			}
			
			if(temp.node.right!=null) {
				queue.add(new Values(temp.index+1, temp.node.right));
			}
		}
		
		for(Map.Entry<Integer, Integer> m : map.entrySet()) {
			list.add(m.getValue());
		}
		return list;
		
	}
	
	static List<Integer>leftSideView(TreeNode root){
		List<Integer> ans = new ArrayList<>();
		Queue<TreeNode> queue = new ArrayDeque<>();
		
		if(root==null) {
			return ans;
		}
		queue.add(root);
		
		while(true) {
			
			int size = queue.size();
			
			if(size==0) {
				return ans;
			}
			
			int val = 0;
			int count = 0;
			while(size>0) {
				count++;
				TreeNode temp = queue.peek();
				queue.poll();
				
				if(count==1) {
					val = temp.data;
				}
				
				
				if(temp.left!=null) {
					queue.add(temp.left);
				}
				if(temp.right!=null) {
					queue.add(temp.right);
				}
				size--;
			}
			ans.add(val);
		}
	
	}
	
	static List<Integer> rightSideView(TreeNode root){
		
		List<Integer> ans = new ArrayList<>();
		Queue<TreeNode> queue = new ArrayDeque<>();
		
		if(root==null) {
			return ans;
		}
		queue.add(root);
		
		while(true) {
			
			int size = queue.size();
			
			if(size==0) {
				return ans;
			}
			
			int val = 0;
			
			while(size>0) {
				TreeNode temp = queue.peek();
				queue.poll();
				
				val = temp.data;
				
				if(temp.left!=null) {
					queue.add(temp.left);
				}
				if(temp.right!=null) {
					queue.add(temp.right);
				}
				size--;
			}
			ans.add(val);
		}
	
		
	}
	
	static List<List<Integer>> LevelOrderTraversal(TreeNode root){
		List<List<Integer>> ans = new ArrayList<>();
		
		Queue<TreeNode> queue = new ArrayDeque<>();
		
		if(root==null) {
			return ans;
		}
		
		queue.add(root);
		
		while(true) {
			
			int size = queue.size();
			if(size==0) {
				return ans;
			}
			
			List<Integer> list = new ArrayList<>();
			
			while(size>0) {
				TreeNode temp = queue.peek();
				queue.poll();
				
				list.add(temp.data);
				
				if(temp.left!=null) {
					queue.add(temp.left);	
				}
				if(temp.right!=null) {
					queue.add(temp.right);
				}
				size--;
			}
			
			ans.add(list);
		}
		
	}
	
	public static void inOrder(TreeNode root) {
		
		if(root==null) {
			return;
		}
		
		
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
		
		
		
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(40);
		root.left = new TreeNode(30);
		root.right = new TreeNode(50);
		
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(35);
		
		root.right.left = new TreeNode(45);
		root.right.right = new TreeNode(55);
		
		root.right.left.left = new TreeNode(42);
		
		
		int[] arr = {4,7,8,1,3,6,9,12,45};
		
		for(int i = 0 ; i<arr.length ; i++) {
			createTree(arr[i]);
		}
		
		
		
		
		inOrder(root1);
		System.out.println("Level Order : "+LevelOrderTraversal(root));
		System.out.println("Right Side View : "+ rightSideView(root));
		System.out.println( "LeftSide View : "+leftSideView(root));
		System.out.println("TopView : "+topView(root)); 
		System.out.println("Bottom View : "+bottomView(root));
		System.out.println("Height of Tree : " + heightTree(root));
		System.out.println("Is Tree Balanced : " + isBalanced(root));
		System.out.println("Tree is Validate? : " + isValidate(root));
	}
	static TreeNode root1;
	
	private static void createTree(int key) {
		
		root1 = insertRec(root1,key);
		
	}

	private static TreeNode insertRec(TreeNode root1, int key) {
		
		if(root1==null) {
			root1 = new TreeNode(key);
		}
		else if(key<root1.data) {
			root1.left = insertRec(root1.left, key);
		}else if(key>root1.data) {
			root1.right = insertRec(root1.right, key);
		}
		
		return root1;
		
	}
}
