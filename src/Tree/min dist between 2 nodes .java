package Tree;

import structures.TreeNode;

class Minimum_Dist {
    public static int ans;
    int findDist(TreeNode root, int a, int b) {
        // Your code here
        // 1. find LCA
        // 2. find left and right descendent and sum it up.
        // Node LCANode = findLCA(root, a, b);
        // return distFromNode(LCANode.left, a, b) + distFromNode(LCANode.right, a, b);
        
        // Alternate and better solution
        ans = 0;
        minDistNodes(root, a, b);
        return ans;
    }

    TreeNode findLCA(TreeNode root, int a, int b){
        if(root == null) return null;
        
        if(root.data == a || root.data == b) return root;

        TreeNode left = findLCA(root.left, a, b);
        TreeNode right = findLCA(root.right, a, b);
        
        if(left != null && right != null) return root;
        return (left != null ? left : right);
    }
    
    int distFromNode(TreeNode node, int a, int b){
        if(node == null) return 0;
        if(node.data == a || node.data == b) return 1;
        
        int left = distFromNode(node.left, a, b);
        int right = distFromNode(node.right, a, b);
        
        if(left != 0 || right != 0) return Math.max(left , right) + 1;
        else return 0;
    }
    



    // Single pass recursive solution
    int minDistNodes(TreeNode node, int a, int b){
        if(node == null) return 0;
        
        int left = minDistNodes(node.left, a, b);
        int right = minDistNodes(node.right, a, b);
        
        
        if(node.data == a || node.data == b){
            // if descendent exists
            if(left != 0 || right != 0) {
                ans = Math.max(left, right);
                return 0;
            }
            return 1;
            
        }else if(left != 0 && right != 0){
            // current node is LCA
            ans = left + right;
            return 0;
            
        }else if(left != 0 || right != 0){
            // current node is not LCA and has descendent
            return Math.max(left, right) + 1;
        }
        
        return 0;
    }
     
}

