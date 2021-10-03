package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 이진 검색 트리
 * https://www.acmicpc.net/problem/5639
 */
public class baek5639 {
	static class TreeNode {
		int data;
		TreeNode left, right;

		
		public TreeNode() {
		
		}
		
		public TreeNode(int data) {
			this.data = data;
		}

	}

	static class MyTree {
		private TreeNode root;
		
		public void insert(int data) {			
			if(this.root == null) {
				this.root = new TreeNode(data);
			}else {
				TreeNode head = this.root;
				TreeNode cur;
				while (true) {
					cur = head;
	                if (head.data > data) {
	                    head = head.left;
	                    
	                    if (head == null) {
	                        cur.left = new TreeNode(data);
	                        break;
	                    }
	                } else {	                    
	                    head = head.right;
	                    if (head == null) {
	                        cur.right = new TreeNode(data);
	                        break;
	                    }
	                }
	            }
	        }			
		}		
		public void postorder(TreeNode root) {
			if(root != null) {
				postorder(root.left);
				postorder(root.right);
				answer.append(root.data).append("\n");				
			}
		}
	}
	static StringBuilder answer = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		MyTree tree = new MyTree();
		
		while((input = br.readLine()) != null) {
			input = input.trim();
			if(input == "" || input.length()==0) {
				break;
			}
			int data = Integer.parseInt(input);
			tree.insert(data);
		}
		
		tree.postorder(tree.root);
		System.out.println(answer.toString());
	}
}
