package Tree;

import structures.TreeNode;

class Subtree_of_Another_Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(isSameTree(root, subRoot)) return true;
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.data != q.data) return false;
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
