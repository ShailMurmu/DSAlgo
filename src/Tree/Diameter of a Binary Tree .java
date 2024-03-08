/*
 * Diameter of a Binary Tree
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
 * This path may or may not pass through the root. 
 */
package Tree;

import structures.TreeNode;

class Diameter_BT_Solution1 {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        
        int l = height(root.left);
        int r = height(root.right);
        
        int ld = diameterOfBinaryTree(root.left);
        int rd = diameterOfBinaryTree(root.right);

        return Math.max(l+r, Math.max(ld, rd));
    }
    public int height(TreeNode root){
        if(root == null) return 0;
        
        return Math.max(height(root.left), height(root.right))+1;
    }
}


/*
 * In the above solution, we are revisting tree node multiple times for calculation of max height as well as diameter of subtree
 * which is Logically the same operation,
 * We can calculate both at the same time.
 */
class Diameter_BT_Solution2 {
    int ans = -1;
    public int diameterOfBinaryTree(TreeNode root) {
        heightUtil(root);
        return ans;
    }
    public int heightUtil(TreeNode root){
        if(root == null) return 0;
        
        //get max height of left subtree
        int l = heightUtil(root.left);
        //get max height of right subtree
        int r = heightUtil(root.right);
        
        // update the result for diameter
        ans = Math.max(ans, l+r);
        
        // return the height of tree
        return 1 + Math.max(l,r); 
    }
}