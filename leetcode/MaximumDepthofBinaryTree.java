package leetcode;

/*
 * 104. Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthofBinaryTree {
	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.left.left = null;
		root.left.right = null;
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);				
		
		System.out.println(dfs(root));
	}
    public static int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        return Math.max(left,right)+1;
    }
}

